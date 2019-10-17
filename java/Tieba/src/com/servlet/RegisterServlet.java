package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Userdao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet") // ͨ��ע�͵ķ�ʽ����web.xml
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		String tel = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserDao user = new UserDao();

		if (user.insertUser(tel, name, password)) {// ע��ɹ����ֻ���,����,�������user���ݿ�\
			response.sendRedirect("login.jsp");// Я�������ض��򵽵�¼ҳ��
		}

	}

}