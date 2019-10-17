package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

/**
 * Servlet implementation class ShowPageServlet
 */
@WebServlet("/page")
public class ShowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PeopleService peopleService=new PeopleServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��һ�η��ʵ���֤,���û�д��ݲ���,����Ĭ��ֵ
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr = request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		
		PageInfo pi = peopleService.showPage(pageSize, pageNumber);
		request.setAttribute("PageInfo", pi);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
