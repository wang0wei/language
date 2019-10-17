package com.bjsxt.advice;


public class MyThrowAdvice {
	public void myexception(Exception e) {
		System.out.println("执行异常通知,异常message："+e.getMessage());
	}
}
