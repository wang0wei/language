package com.bjsxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice {
	 public void afterThrowing(Exception ex) throws Throwable {
	       System.out.println("ִ���쳣֪ͨ-schema-based��ʽ");
	    }
	 public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
	       System.out.println("ִ���쳣֪ͨ");
	    }
}
