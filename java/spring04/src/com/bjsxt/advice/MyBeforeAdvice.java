package com.bjsxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("�е㷽������"+arg0+",������"+arg0.getName());
		if(arg1!=null&&arg1.length>0) {
			System.out.println("�е㷽��������"+arg1[0]);
		}else {
			System.out.println("�е�û�в���");
		}
		
		System.out.println("����"+arg2);
		System.out.println("ִ��ǰ��֪ͨ");	
	}
}
