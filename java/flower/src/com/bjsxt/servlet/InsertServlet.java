package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.FlowerServiceImpl;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService=new FlowerServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String production=request.getParameter("production");
		Flower flower=new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setProduction(production);
		int index=flowerService.add(flower);
		if(index>0) 
			//response.sendRedirect("ShowServlet");
			request.getRequestDispatcher("ShowServlet").forward(request, response);
		else
			//response.sendRedirect("add.jsp");
			request.getRequestDispatcher("add.jsp").forward(request, response);
    }
	

}
