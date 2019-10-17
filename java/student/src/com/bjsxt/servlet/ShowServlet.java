package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService stuService=new StudentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String tname = request.getParameter("tname");
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		PageInfo pi = stuService.showPage(sname, tname, pageSize, pageNumber);
		request.setAttribute("pageinfo", pi);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
}
