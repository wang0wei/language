package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
//	@Before("com.bjsxt.test.Demo.demo1()")
//	public void mybefore() {
//		System.out.println("ǰ��");
//	}
//	@After("com.bjsxt.test.Demo.demo1()")
//	public void myafter() {
//		System.out.println("����");
//	}
	@AfterThrowing("com.bjsxt.test.Demo.demo1()")
	public void mythrow() {
		System.out.println("�쳣֪ͨ");
	}
	@Around("com.bjsxt.test.Demo.demo1()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("����-ǰ��");
		Object result = p.proceed();
		System.out.println("����-����");
		return result;
		
	}
}
