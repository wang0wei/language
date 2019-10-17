package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;


public class DengluServlet extends HttpServlet {  ////��Ҫ�̳�HttpServlet  ����дdoGet  doPost����
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DengluServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //�õ�jspҳ�洫�����Ĳ���
		String pwd = request.getParameter("pwd");
		
		
		UserDao ud = new UserDaoImpl();  //�ӿڽ����󣬿���ʵ��
		
		if(ud.login(name, pwd)){

			request.setAttribute("name",name);
			int id=ud.findID(name,pwd);  //��ѯ��Ӧ��ID
			request.setAttribute("id",id+"");
			request.getRequestDispatcher("/form.jsp").forward(request, response); //urlת��������Я������ת��jsp
		}else{
			response.sendRedirect("index.jsp"); //�ض�����ҳ
		}
	}
}

