package com.bjsxt;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Mishu implements MethodInterceptor{

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("ԤԼʱ��");
		//invoke()����������д�ķ���
		//arg1.invoke(arg0, arg2);
		//arg3.invokeSuper(arg0, arg2);
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("��ע");
		return result;
	}
	
}