package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
//�󲿷�ע�ⶼ��Ĭ�����ԣ����ע����ֻ��Ĭ�����Ը�ֵ������ʡ��������
//����ʹ��ע���(������=����ֵ)��ʽ
//���һ���������������͸�ʽ��������={ֵ��ֵ��������}�����������ֻ��һ��ֵ������ʡ�Դ�����
//����಻�ǻ����������ͻ�Srting������һ�������ͣ��﷨��������=@����
//ע����@��ʾ����ע������
@WebServlet(value= {"/ShowServlet"})
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PeopleService peopleService=new PeopleServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<People> list = peopleService.show();
		request.setAttribute("list", list);
		//���·��
		//ֻҪ·������/��ͷ�Ķ�����ȫ·��������Ŀ��Ŀ¼(WebContent)�����ҵ�������Դ�Ĺ���
		//ֻҪ����/��ͷ�������·�������·���Ǵӵ�ǰ��Դ�����ҵ�������Դ�Ĺ���
		//�������ת��/��ʾWebContentĿ¼
		//������ض��򣬾�̬��Դ���ã�����<img src=""/> <a href=""> <script src=""/>����ʱ������/����ʾtomcat��webapps�ļ��и�Ŀ¼
		//��������ת����������/���Ƿ�������Ŀ¼
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
