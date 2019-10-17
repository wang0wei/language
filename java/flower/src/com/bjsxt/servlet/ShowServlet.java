package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.FlowerServiceImpl;


@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService=new FlowerServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Flower>list=flowerService.show();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
    }
   

}
