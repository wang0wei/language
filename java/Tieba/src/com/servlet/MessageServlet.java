package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Userdao.UserDao;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		// ��ȡ��ǰʱ��
		long l = System.currentTimeMillis();
		Date time = new Date(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ���ó�mysql��ʶ���datetime��ʽ
		String time1 = sdf.format(time);
		// ��ȡ���Ա���
		String title = request.getParameter("title");
		// ��ȡ��������
		String message = request.getParameter("message");

		UserDao user = new UserDao();
		if (user.insertMessage(name, title, message, time1)) {
			// ���Գɹ�
			response.sendRedirect("index.jsp");
		} else {
			// ����ʧ��
			response.sendRedirect("liuyanfalse.jsp");
		}
	}

}
