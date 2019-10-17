package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.chapter08.entity.User;



/**
 * Servlet Filter implementation class AutoLoginFilter
 */

public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
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

		//转化成httpservletrequest
        HttpServletRequest req=(HttpServletRequest)request;
		//获得一个名为autologin的cookie
		Cookie[] cookies=req.getCookies();
		String autologin=null;
		for(int i=0;cookies!=null&&i<cookies.length;i++) {
			if("autologin".equals(cookies[i].getName())) {//找到了指定的cookie
				autologin=cookies[i].getValue();
				break;
			}
		}
		if(autologin!=null) {
			//做自动登录
			String[] parts=autologin.split("-");
			String username=parts[0];
			String password=parts[1];
			//检查用户名和密码
			if("itcast".equals(username)&&("123456").equals(password)) {
				//登录成功,将用户状态user对象存入session域
				User user =new User();
				user.setUsername(username);
				user.setPassword(password);
				req.getSession().setAttribute("user",user);
			}
		}
		// pass the request along the filter chain
		//放行
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
