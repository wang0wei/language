package com.filter;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.chapter08.entity.User;

/**
 * Servlet implementation class LoginServlet
 */

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
		 //��ȡ�û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//����û���������
		if("itcast".equals(username)&&"123456".equals(password)) {
			//��¼�ɹ�		
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			//���û�״̬user�������session��
			request.getSession().setAttribute("user",user);
			//��ȡ�Զ���¼��ʱ��
			String autoLogin=request.getParameter("autologin");
			if(autoLogin!=null) {
				//cookie�е�����Ҫ����,�½�cookie����username��password
				Cookie cookie=new Cookie("autologin",username+"-"+password);
				//����cookie��������ͻ����ϱ�����Ч������
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				//����cookie�����ЧĿ¼·��
				cookie.setPath(request.getContextPath());
				//���cookie
				response.addCookie(cookie);
				//response.addCookie(c);���cookie���������ˡ�����ʹ��ץ�����߲鿴����
				//response.addCookie(c)һ��ִ�У��������˻��Զ�������Ϣͷset-cookie���������
				//set-cookie�ǻ�Я��cookie��ֵ�Եģ�uname=kitty��
				//������cookie�ͻᱣ��������������Դ�����cookie�ǻᱣ����������ϵ�
			}
			//��ת����ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("errerMsg","�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
