package cn.itcast.chapter11.modal2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.chapter11.model2.domain.DBUtil;
import cn.itcast.chapter11.model2.domain.RegisterFormBean;
import cn.itcast.chapter11.model2.domain.UserBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;chaeset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取用户注册时表单提交的参数消息
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		
		//将获取的参数封装到注册表单相关的RegisterFormBeean类中
		RegisterFormBean formBean=new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setPassword2(password2);
		formBean.setEmail(email);
		
		//验证参数填写是否符合要求,如果不符合,转发到register.jsp重新填写
		if(!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		    return;
		}
		
		//参数填写符合要求,则将数据封装到UserBean类中
		UserBean userBean=new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		//调用DBUtil的insertUser()方法执行添加操作,并返回一个boolean类型的标志
		boolean b=DBUtil.getInstance().insertUser(userBean);
		//如果返回为false,表示注册的用户已存在,则重定向到register.jsp重新填写
		if(!b) {
			request.setAttribute("DBMes", "你注册的用户已存在");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		
		}
		response.getWriter().print("恭喜你注册成功,3秒后自动跳转");
		//将成功注册的用户信息添加到session中
		request.getSession().setAttribute("userBean", userBean);
		//注册成功后,3秒跳转到登录成功页面loginSucccess.jsp
		response.setHeader("refresh", "3;url=loginSuccess.jsp");
	}

}
