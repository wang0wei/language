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
	urlPatterns= {"/*"},//����·����ƥ��
	initParams= {@WebInitParam(name="encoding",value="UTF-8")}//��ʼ��encoding����ΪUTF-8
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
		encoding=fConfig.getInitParameter("encoding");//��ȡ��ʼ������encoding��ֵ
		System.out.println("���� ��ʽ����������");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("���� ��ʽ�������ر�");
		encoding=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(encoding!=null) {//�ж��ַ������Ƿ�Ϊ��
			//��������ı����ʽ
			request.setCharacterEncoding(encoding);
			//����response�ַ�����
			response.setContentType("text/html;charset="+encoding);
			response.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);//���������ǽ�����ת����������������һ�������������һ��ָ������һ��filter�����û��filter�Ǿ������������Դ��
	}
}
