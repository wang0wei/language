package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.service.AirportService;
import com.bjsxt.service.impl.AirportServiceImpl;

/**
 * Servlet implementation class AirportServlet
 */
@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
    private AirportService airportService;
  
    @Override
	public void init() throws ServletException {
		//对service实例化
    	//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	//spring和web整合后所有信息都放在webApplication
    	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    	airportService = ac.getBean("airportService",AirportServiceImpl.class);

	}
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", airportService.show());
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}

	
}
