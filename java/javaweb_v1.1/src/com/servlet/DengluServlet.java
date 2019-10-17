package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;


public class DengluServlet extends HttpServlet {  ////需要继承HttpServlet  并重写doGet  doPost方法
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
		doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		
		
		UserDao ud = new UserDaoImpl();  //接口建对象，可以实现
		
		if(ud.login(name, pwd)){

			request.setAttribute("name",name);
			int id=ud.findID(name,pwd);  //查询对应的ID
			request.setAttribute("id",id+"");
			request.getRequestDispatcher("/form.jsp").forward(request, response); //url转发，可以携带参数转到jsp
		}else{
			response.sendRedirect("index.jsp"); //重定向到首页
		}
	}
}

