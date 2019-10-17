package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class CharactorFilter
 */
@WebFilter(
    filterName="CharactorFilter",
	urlPatterns= {"/*"},//所有路径都匹配
	initParams= {@WebInitParam(name="encoding",value="UTF-8")}//初始化encoding参数为UTF-8
)
public class CharactorFilter implements Filter {
	String encoding=null;

    /**
     * Default constructor. 
     */
    public CharactorFilter() {
        // TODO Auto-generated constructor stub	
    }
    
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=fConfig.getInitParameter("encoding");//获取初始化参数encoding的值
		System.out.println("编码 格式过滤器启动");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("编码 格式过滤器关闭");
		encoding=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(encoding!=null) {//判断字符编码是否为空
			//设置请求的编码格式
			request.setCharacterEncoding(encoding);
			//设置response字符编码
			response.setContentType("text/html;charset="+encoding);
			response.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);//他的作用是将请求转发给过滤器链上下一个对象。这里的下一个指的是下一个filter，如果没有filter那就是你请求的资源。
	}
}
