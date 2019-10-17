package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */

/*
 * 不过滤jsp
 * 
 * front设计模式，前端设计模式
 * */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("control");
		System.out.println(result);
		if(result.equals("demo1")) {
			demo1(request,response);
		}
		if(result.equals("demo2")) {
			demo2();
		}
		if(result.equals("demo3")) {
			demo3();
		}
		System.out.println("执行控制器");
	}
	
	public void demo1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("demo1被调用");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	public void demo2() {
		System.out.println("demo2被调用");
	}
	public void demo3() {
		System.out.println("demo3被调用");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
