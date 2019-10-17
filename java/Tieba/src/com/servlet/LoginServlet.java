package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Userdao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");//������ⲻ���ñ����ʽ,�˻�����Ϊ�������޷�ƥ��	
		String name = request.getParameter("name"); //�õ�jspҳ�洫�����Ĳ���
		String pwd = request.getParameter("password");	
		UserDao ud = new UserDao();  	
		if(ud.login(name, pwd)){//�����ݿ��������,���Ƿ���ڸ��û�,�������ִ������Ĵ���
			HttpSession session=request.getSession(); 
			session.setAttribute("name",name);//��¼�ɹ���name����session���ö�����,�Ա�֮�������Ե�ʱ�����name������
			//request.getRequestDispatcher("/index.jsp").forward(request, response); //urlת��������Я������ת��jsp
            response.sendRedirect("index.jsp");//ת����ҳ��
			
		}else{
			response.sendRedirect("false.jsp"); //�ض�����ҳ,���¿�ʼһ��request
		}
	}
	
}


