package com.bjsxt.test;

import com.bjsxt.Singleton;

public class Test {
	public static void main(String[] args) {
		Singleton singleton=Singleton.getInstance();
		Singleton singleton1=Singleton.getInstance();
		
		System.out.println(singleton==singleton1);
	}
}
