package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class DemoInterceptor implements HandlerInterceptor{
	//在进入控制器controller之前执行
	//如果返回值为false，阻止进入控制器
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler:"+handler);
		System.out.println("preHandle");
		return true;
	}
	
	//控制器执行完成，进入到jsp之前执行
	//敏感词过滤、日志记录
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("往"+modelAndView.getViewName()+"跳转");
		System.out.println("model的值"+modelAndView.getModel().get("model"));
		String word = modelAndView.getModel().get("model").toString();
		String newword = word.replace("祖国", "**");
		modelAndView.getModel().put("model", newword);		
		//modelAndView.getModel().put("model", "修改后的内容");
		System.out.println("postHandle");
		
	}
	
	//JSP执行完成后执行
	//记录执行过程中出现的异常
	//可以把异常记录到日志中
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion"+ex.getMessage());
	}

}
