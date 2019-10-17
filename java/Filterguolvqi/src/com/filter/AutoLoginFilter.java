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

		//ת����httpservletrequest
        HttpServletRequest req=(HttpServletRequest)request;
		//���һ����Ϊautologin��cookie
		Cookie[] cookies=req.getCookies();
		String autologin=null;
		for(int i=0;cookies!=null&&i<cookies.length;i++) {
			if("autologin".equals(cookies[i].getName())) {//�ҵ���ָ����cookie
				autologin=cookies[i].getValue();
				break;
			}
		}
		if(autologin!=null) {
			//���Զ���¼
			String[] parts=autologin.split("-");
			String username=parts[0];
			String password=parts[1];
			//����û���������
			if("itcast".equals(username)&&("123456").equals(password)) {
				//��¼�ɹ�,���û�״̬user�������session��
				User user =new User();
				user.setUsername(username);
				user.setPassword(password);
				req.getSession().setAttribute("user",user);
			}
		}
		// pass the request along the filter chain
		//����
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
