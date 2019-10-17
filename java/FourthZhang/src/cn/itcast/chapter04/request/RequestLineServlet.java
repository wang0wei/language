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
		out.println("����ʽgetMethod:"+request.getMethod()+"<br>");
		out.println("����������Դ���Ʋ���getRequestURL:"+request.getRequestURL()+"<br>");
		out.println("��ȡ�������еĲ�������getQueryString:"+request.getQueryString()+"<br>");
		out.println("��ȡ�������е�Э�����Ͱ汾getProtocol:"+request.getProtocol()+"<br>");
		out.println("��ȡ����URL������webӦ�ó����·��getContextPath:"+request.getContextPath()+"<br>");
		out.println("getPathInfo:"+request.getPathInfo()+"<br>");
		out.println("getPathTranslated:"+request.getPathTranslated()+"<br>");
		out.println("��ȡservlet�����ƻ�servlet��ӳ���·��getServletPath:"+request.getServletPath()+"<br>");
		out.println("��ȡ����ͻ��˵�IP��ַgetRemoteAddr:"+request.getRemoteAddr()+"<br>");
		out.println("��ȡ����ͻ��˵������� getRemoteHost:"+request.getRemoteHost()+"<br>");
		out.println("��ȡ����ͻ����������ӵĶ˿ں�getRemotePort:"+request.getRemotePort()+"<br>");
		out.println("��ȡweb�������Ͻ��յ�ǰ�����������ӵ�IP��ַgetLocalAddr:"+request.getLocalAddr()+"<br>");
		out.println("��ȡweb�������Ͻ��յ�ǰ�������ӵĶ˿ں�getLocalName"+request.getLocalName()+"<br>");
		out.println("��ȡweb�������ǽ��յ�ǰ�������ӵĶ˿ں�getLocalPort:"+request.getLocalPort()+"<br>");
		out.println("��ȡ��ǰ������ָ���������getServerName:"+request.getServerName()+"<br>");
		out.println("��ȡ��ǰ���������ӵķ������˿ں�getServerPort:"+request.getServerPort()+"<br>");
		out.println("��ȡ�����Э����getScheme:"+request.getScheme()+"<br>");
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
