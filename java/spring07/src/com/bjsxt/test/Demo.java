package com.bjsxt.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Pointcut("execution(* com.bjsxt.test.Demo.demo1())")
	public void demo1() throws Exception{
		//int i=5/0;
		System.out.println("demo1");
	}

}
