package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import com.bjsxt.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AccountService accService=new AccountServiceImpl();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Account accOut=new Account();
		accOut.setAccNo(request.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(request.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(request.getParameter("accOutBalance")));
		Account accIn=new Account();
		accIn.setAccNo(request.getParameter("accInAccNo"));
		accIn.setName(request.getParameter("accInName"));
		int index = accService.transfer(accIn, accOut);
		if(index==AccountService.SUCCESS) {
			
			response.sendRedirect("/bank/ShowServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("code", index);
			response.sendRedirect("/bank/error/error.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
