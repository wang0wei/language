package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LogService logService=new LogServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pageSize=2;
		String pageSizeStr=request.getParameter("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		int pageNumber =1;
		String pageNumberStr=request.getParameter("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		request.setAttribute("pageinfo", logService.showPage(pageSize, pageNumber));
		request.getRequestDispatcher("/log.jsp").forward(request, response);
    }
    
	

}
