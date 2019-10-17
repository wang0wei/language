package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class DemoInterceptor implements HandlerInterceptor{
	//�ڽ��������controller֮ǰִ��
	//�������ֵΪfalse����ֹ���������
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler:"+handler);
		System.out.println("preHandle");
		return true;
	}
	
	//������ִ����ɣ����뵽jsp֮ǰִ��
	//���дʹ��ˡ���־��¼
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("��"+modelAndView.getViewName()+"��ת");
		System.out.println("model��ֵ"+modelAndView.getModel().get("model"));
		String word = modelAndView.getModel().get("model").toString();
		String newword = word.replace("���", "**");
		modelAndView.getModel().put("model", newword);		
		//modelAndView.getModel().put("model", "�޸ĺ������");
		System.out.println("postHandle");
		
	}
	
	//JSPִ����ɺ�ִ��
	//��¼ִ�й����г��ֵ��쳣
	//���԰��쳣��¼����־��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion"+ex.getMessage());
	}

}
