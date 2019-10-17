package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersService usersService;   
  
    @Override
    public void init() throws ServletException {
    	ApplicationContext ac=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    	usersService=ac.getBean("usersService",UsersServiceImpl.class);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		String codeSession = request.getSession().getAttribute("code").toString();
		if(codeSession.equals(code)) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Users users=new Users();
			users.setPassword(password);
			users.setUsername(username);
			Users user = usersService.login(users);
			if(user!=null) {
				response.sendRedirect("main.jsp");
			}else {
				request.setAttribute("error", "用户名密码不正确");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("error", "验证码不正确");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
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
