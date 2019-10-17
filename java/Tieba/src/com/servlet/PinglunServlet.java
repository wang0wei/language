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
		
		// 如果session里面没有name,说明没有登录,那么需要跳转到登录页面
		if ((String) session.getAttribute("name") == null) {
			response.sendRedirect("login.jsp");// 重定向到login.jsp

		} else {
			// 获取评论人的姓名
			
			String pname = (String) session.getAttribute("name");
			// 获取该篇帖子的id
			int whos = Integer.valueOf((String) session.getAttribute("id")).intValue();
			// 获取评论的时间
			long l = System.currentTimeMillis();
			Date time = new Date(l);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置成mysql能识别的datetime形式
			String time1 = sdf.format(time);
			// 获取评论的内容
			String pinglun = request.getParameter("pinglun");

			UserDao user = new UserDao();
			if (user.insertPinglun(whos, pname, time1, pinglun)) {
				// 评论成功
				//response.sendRedirect("pinglun.jsp");
				
				request.getRequestDispatcher("/pinglun.jsp").forward(request, response);
			} else {
				// 评论失败
				response.sendRedirect("pfalse.jsp");
			}
		}
	}

}
