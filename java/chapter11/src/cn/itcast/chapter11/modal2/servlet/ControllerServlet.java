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
		//��ȡ�û�ע��ʱ���ύ�Ĳ�����Ϣ
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		
		//����ȡ�Ĳ�����װ��ע�����ص�RegisterFormBeean����
		RegisterFormBean formBean=new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setPassword2(password2);
		formBean.setEmail(email);
		
		//��֤������д�Ƿ����Ҫ��,���������,ת����register.jsp������д
		if(!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		    return;
		}
		
		//������д����Ҫ��,�����ݷ�װ��UserBean����
		UserBean userBean=new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		//����DBUtil��insertUser()����ִ����Ӳ���,������һ��boolean���͵ı�־
		boolean b=DBUtil.getInstance().insertUser(userBean);
		//�������Ϊfalse,��ʾע����û��Ѵ���,���ض���register.jsp������д
		if(!b) {
			request.setAttribute("DBMes", "��ע����û��Ѵ���");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		
		}
		response.getWriter().print("��ϲ��ע��ɹ�,3����Զ���ת");
		//���ɹ�ע����û���Ϣ��ӵ�session��
		request.getSession().setAttribute("userBean", userBean);
		//ע��ɹ���,3����ת����¼�ɹ�ҳ��loginSucccess.jsp
		response.setHeader("refresh", "3;url=loginSuccess.jsp");
	}

}
