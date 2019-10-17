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
		
		//拦截所有的请求  解决全站中文乱码
		//指定request和response的编码
		req.setCharacterEncoding("utf-8");//只对消息体有效
		resp.setContentType("text/html;charset=utf-8");
		//对request进行包装
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

//继承 默认包装类HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	//子类继承父类一定会覆写一些方法,此处用于重写getParameter()方法
	public String getParameter(String name) {
		String value=super.getParameter(name);
		if(value==null)
			return null;
		//判断请求方法
		String method=super.getMethod();
		if("get".equalsIgnoreCase(method)) {
			try {
				value=new String(value.getBytes("utf-8"),"utf-8");
			}catch(UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		//解决乱码后返回结果
		return value;
	}
}