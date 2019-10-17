package cn.itcast.chapter05.cookie.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessServlet
 */
@WebServlet("/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LastAccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	String lastAccessTime=null;
	Cookie [] cookies=request.getCookies();
	for(int i=0;cookies!=null&&i<cookies.length;i++) {
		if("lastAccess".equals(cookies[i].getName())) {
			lastAccessTime=cookies[i].getValue();
			break;
		}
	}
	
	if(lastAccessTime==null) {
		response.getWriter().print("您是首次访问本站!!!");
	}else {
		response.getWriter().print("您上次访问的时间是:"+lastAccessTime);
	}
	
	String currentTime=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());//dd和hh中间不能有空格,否则会报错
	Cookie cookie=new Cookie("lastAccess",currentTime);
	response.addCookie(cookie);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
