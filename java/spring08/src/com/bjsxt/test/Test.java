package com.bjsxt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		People peo=ac.getBean("people",People.class);
		System.out.println(peo);
		People peo1=ac.getBean("people1",People.class);
		System.out.println(peo1);
		
	}
}
