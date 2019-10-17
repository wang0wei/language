package com.bjsxt.test;

public class Test {
	public static void main(String[] args) {
		final ThreadLocal<String> threadLocal=new ThreadLocal<>();
		threadLocal.set("≤‚ ‘");
		
		new Thread() {
			public void run() {
				String result=threadLocal.get();
				System.out.println(result);
			};
		}.start();
	}
}
