package cn.itcast.chapter04.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestLineServlet
 */
@WebServlet("/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("请求方式getMethod:"+request.getMethod()+"<br>");
		out.println("请求行中资源名称部分getRequestURL:"+request.getRequestURL()+"<br>");
		out.println("获取请求行中的参数部分getQueryString:"+request.getQueryString()+"<br>");
		out.println("获取请求行中的协议名和版本getProtocol:"+request.getProtocol()+"<br>");
		out.println("获取请求URL中属于web应用程序的路径getContextPath:"+request.getContextPath()+"<br>");
		out.println("getPathInfo:"+request.getPathInfo()+"<br>");
		out.println("getPathTranslated:"+request.getPathTranslated()+"<br>");
		out.println("获取servlet的名称或servlet所映射的路径getServletPath:"+request.getServletPath()+"<br>");
		out.println("获取请求客户端的IP地址getRemoteAddr:"+request.getRemoteAddr()+"<br>");
		out.println("获取请求客户端的主机名 getRemoteHost:"+request.getRemoteHost()+"<br>");
		out.println("获取请求客户端网络连接的端口号getRemotePort:"+request.getRemotePort()+"<br>");
		out.println("获取web服务器上接收当前请求网络连接的IP地址getLocalAddr:"+request.getLocalAddr()+"<br>");
		out.println("获取web服务器上接收当前网络连接的端口号getLocalName"+request.getLocalName()+"<br>");
		out.println("获取web服务器是接收当前网络连接的端口号getLocalPort:"+request.getLocalPort()+"<br>");
		out.println("获取当前请求所指向的主机名getServerName:"+request.getServerName()+"<br>");
		out.println("获取当前请求所连接的服务器端口号getServerPort:"+request.getServerPort()+"<br>");
		out.println("获取请求的协议名getScheme:"+request.getScheme()+"<br>");
		out.println("getRequestURL:"+request.getRequestURL()+"<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
