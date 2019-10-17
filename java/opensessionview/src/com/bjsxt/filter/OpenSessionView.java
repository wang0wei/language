package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.util.MyBatisUtil;

/**
 * �ʼ��Spring�������ģ�����Hibernate�����ʹ�õ���OpenSessionInView
 * 
 */
@WebFilter("/*")
public class OpenSessionView implements Filter {

    /**
     * Default constructor. 
     */
    public OpenSessionView() {
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
//		InputStream is = Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
		
		SqlSession session=MyBatisUtil.getSession();
		try {
			chain.doFilter(request, response);
			session.commit();
		} catch (Exception e) {
		    session.rollback();
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
