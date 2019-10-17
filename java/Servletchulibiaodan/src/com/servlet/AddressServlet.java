package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgh.UserBean;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")//����ע�͵ķ�������servlet
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//����request�ı����ʽ
		
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String address=request.getParameter("add");
		
		UserBean user=new UserBean();
		user.setName(name);
		user.setSex(sex);
		user.setAddress(address);
		
		ServletContext application=getServletContext();//��ȡServletContext����
		
		List<UserBean> list=(List<UserBean>)application.getAttribute("users");//��ServletContext�л�ȡusers
		if(list==null) {
			list=new ArrayList<UserBean>();
		}
		list.add(user);
		application.setAttribute("users",list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("manager.jsp");
		dispatcher.forward(request,response);
		
	}

}
