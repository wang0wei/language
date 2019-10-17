package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
//大部分注解都有默认属性，如果注解中只给默认属性赋值，可以省略属性名
//否则使用注解的(属性名=属性值)格式
//如果一个属性是数组类型格式：属性名={值，值，。。。}，如果该数组只有一个值，可以省略大括号
//如果类不是基本数据类型或Srting，而是一个类类型，语法：属性名=@类型
//注解中@表示引用注解声明
@WebServlet(value= {"/ShowServlet"})
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PeopleService peopleService=new PeopleServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<People> list = peopleService.show();
		request.setAttribute("list", list);
		//相对路径
		//只要路径中以/开头的都叫做全路径，从项目根目录(WebContent)出发找到其他资源的过程
		//只要不以/开头都是相对路径，相对路径是从当前资源出发找到其他资源的过程
		//如果请求转发/表示WebContent目录
		//如果是重定向，静态资源引用，必须<img src=""/> <a href=""> <script src=""/>引用时，其中/都表示tomcat的webapps文件夹根目录
		//除了请求转发，其他的/都是服务器根目录
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
