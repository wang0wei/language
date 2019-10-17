package com.bjsxt.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidCodeServlet
 */
@WebServlet("/ValidCodeServlet")
public class ValidCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����һ��ͼƬ
		BufferedImage image =new BufferedImage(200,100,BufferedImage.TYPE_INT_BGR);
		
		//͸���Ĳ���
		//�򻭰��ϻ�����֮ǰ�������û���
		Graphics2D gra = image.createGraphics();
		gra.setColor(Color.white);
		//���ĸ����꿪ʼ��䣬��������������������
		gra.fillRect(0, 0, 200, 100);
		
		//���������
		List<Integer> randList=new ArrayList<Integer>();
		Random random=new Random();
		for(int i=0;i<4;i++) {
			randList.add(random.nextInt(10));
		}
		gra.setColor(Color.black);
		//��������
		gra.setFont(new Font("����",Font.ITALIC|Font.BOLD,40));
		Color[] colors=new Color[] {Color.red,Color.green,Color.blue,Color.yellow,Color.pink};
		//�����ɫ
		for(int i=0;i<randList.size();i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(randList.get(i)+"", i*40, 70+(random.nextInt(21)-10));
		}
		
		
		for(int i=0;i<2;i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			//������
			gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
		}
		
	
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		//������
		ImageIO.write(image, "jpg", outputStream);
		
		//����֤����뵽session��
		HttpSession session = request.getSession();
		session.setAttribute("code", ""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
