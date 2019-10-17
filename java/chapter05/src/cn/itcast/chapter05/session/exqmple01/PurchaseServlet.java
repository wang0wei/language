package cn.itcast.chapter05.session.exqmple01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����û��������Ʒ
		String id=request.getParameter("id");
		if(id==null) {
			String url="/chapter05/ListBookServlet";
			response.sendRedirect(url);
			return;
		}
		Book book =BookDB.getBook(id);
		//�������߻���û���session����
		HttpSession session=request.getSession();
		//��session�����л���û��Ĺ��ﳵ
		
		List<Book> cart=(List)session.getAttribute("cart");
		if(cart==null) {
			//�״ι���,�û�����һ�����ﳵ(List����ģ�⹺�ﳵ)
			cart=new ArrayList<Book>();
			//�����ﳵ����session����
			session.setAttribute("cart",cart);
		}
		//����Ʒ���빺�ﳵ
		cart.add(book);
		//����cookie���session�ı�ʶ��
		Cookie cookie=new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/chapter05");
		response.addCookie(cookie);
		//�ض��򵽹��ﳵҳ��
		String url="/chapter05/CartServlet";
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
