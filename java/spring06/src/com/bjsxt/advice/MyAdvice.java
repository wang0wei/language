package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void mybefore(String name1,int age1) {
		System.out.println("ǰ��"+name1+"   "+age1);
	}
	public void mybefore1(String name1) {
		System.out.println("ǰ��"+name1);
	}
	public void myaftering() {
		System.out.println("����2");
	}
	public void myafter() {
		System.out.println("����1");
	}	
	public void mythrow() {
		System.out.println("�쳣");
	}
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("ִ�л���");
		System.out.println("����-ǰ��");
		Object result = p.proceed();
		System.out.println("����-����");
		return result;
		
	}
}
