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
		//创建一张图片
		BufferedImage image =new BufferedImage(200,100,BufferedImage.TYPE_INT_BGR);
		
		//透明的玻璃
		//向画板上画内容之前必须设置画笔
		Graphics2D gra = image.createGraphics();
		gra.setColor(Color.white);
		//从哪个坐标开始填充，后两个参数，矩形区域
		gra.fillRect(0, 0, 200, 100);
		
		//生成随机数
		List<Integer> randList=new ArrayList<Integer>();
		Random random=new Random();
		for(int i=0;i<4;i++) {
			randList.add(random.nextInt(10));
		}
		gra.setColor(Color.black);
		//设置字体
		gra.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,40));
		Color[] colors=new Color[] {Color.red,Color.green,Color.blue,Color.yellow,Color.pink};
		//随机颜色
		for(int i=0;i<randList.size();i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(randList.get(i)+"", i*40, 70+(random.nextInt(21)-10));
		}
		
		
		for(int i=0;i<2;i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			//画横线
			gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
		}
		
	
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		//工具类
		ImageIO.write(image, "jpg", outputStream);
		
		//把验证码放入到session中
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
