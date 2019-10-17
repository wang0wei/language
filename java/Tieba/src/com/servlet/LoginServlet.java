package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Userdao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");//如果在这不设置编码格式,账户名若为汉字则无法匹配	
		String name = request.getParameter("name"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("password");	
		UserDao ud = new UserDao();  	
		if(ud.login(name, pwd)){//在数据库里面查找,看是否存在该用户,如果存在执行下面的代码
			HttpSession session=request.getSession(); 
			session.setAttribute("name",name);//登录成功后将name放入session内置对象中,以便之后在留言的时候根据name存数据
			//request.getRequestDispatcher("/index.jsp").forward(request, response); //url转发，可以携带参数转到jsp
            response.sendRedirect("index.jsp");//转到主页面
			
		}else{
			response.sendRedirect("false.jsp"); //重定向到首页,重新开始一个request
		}
	}
	
}


