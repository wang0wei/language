package cn.itcast.chapter08.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterFilter
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		//�������е�����  ���ȫվ��������
		//ָ��request��response�ı���
		req.setCharacterEncoding("utf-8");//ֻ����Ϣ����Ч
		resp.setContentType("text/html;charset=utf-8");
		//��request���а�װ
		CharacterRequest characterRequest=new CharacterRequest(req);

		// pass the request along the filter chain
		chain.doFilter(characterRequest, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

//�̳� Ĭ�ϰ�װ��HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	//����̳и���һ���ḲдһЩ����,�˴�������дgetParameter()����
	public String getParameter(String name) {
		String value=super.getParameter(name);
		if(value==null)
			return null;
		//�ж����󷽷�
		String method=super.getMethod();
		if("get".equalsIgnoreCase(method)) {
			try {
				value=new String(value.getBytes("utf-8"),"utf-8");
			}catch(UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		//�������󷵻ؽ��
		return value;
	}
}