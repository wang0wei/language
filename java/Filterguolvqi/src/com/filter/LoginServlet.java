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
		 //获取用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//检查用户名和密码
		if("itcast".equals(username)&&"123456".equals(password)) {
			//登录成功		
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			//将用户状态user对象存入session域
			request.getSession().setAttribute("user",user);
			//获取自动登录的时间
			String autoLogin=request.getParameter("autologin");
			if(autoLogin!=null) {
				//cookie中的密码要加密,新建cookie存入username和password
				Cookie cookie=new Cookie("autologin",username+"-"+password);
				//设置cookie在浏览器客户机上保持有效的秒数
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				//设置cookie项的有效目录路径
				cookie.setPath(request.getContextPath());
				//添加cookie
				response.addCookie(cookie);
				//response.addCookie(c);添加cookie到服务器端。可以使用抓包工具查看到；
				//response.addCookie(c)一旦执行，服务器端会自动发回消息头set-cookie给浏览器，
				//set-cookie是会携带cookie键值对的，uname=kitty。
				//创建的cookie就会保存在浏览器。所以创建的cookie是会保存在浏览器上的
			}
			//跳转至首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("errerMsg","用户名或密码错误");
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
