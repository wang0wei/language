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
 * Servlet implementation class PinglunServlet
 */
@WebServlet("/PinglunServlet")
public class PinglunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PinglunServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// ���session����û��name,˵��û�е�¼,��ô��Ҫ��ת����¼ҳ��
		if ((String) session.getAttribute("name") == null) {
			response.sendRedirect("login.jsp");// �ض���login.jsp

		} else {
			// ��ȡ�����˵�����
			
			String pname = (String) session.getAttribute("name");
			// ��ȡ��ƪ���ӵ�id
			int whos = Integer.valueOf((String) session.getAttribute("id")).intValue();
			// ��ȡ���۵�ʱ��
			long l = System.currentTimeMillis();
			Date time = new Date(l);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ���ó�mysql��ʶ���datetime��ʽ
			String time1 = sdf.format(time);
			// ��ȡ���۵�����
			String pinglun = request.getParameter("pinglun");

			UserDao user = new UserDao();
			if (user.insertPinglun(whos, pname, time1, pinglun)) {
				// ���۳ɹ�
				//response.sendRedirect("pinglun.jsp");
				
				request.getRequestDispatcher("/pinglun.jsp").forward(request, response);
			} else {
				// ����ʧ��
				response.sendRedirect("pfalse.jsp");
			}
		}
	}

}
