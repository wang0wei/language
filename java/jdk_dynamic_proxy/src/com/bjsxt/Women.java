package com.bjsxt;

import java.lang.reflect.Proxy;

public class Women {
	public static void main(String[] args) {
		System.out.println(Women.class.getClassLoader()==Laozong.class.getClassLoader());
		Mishu mishu=new Mishu();
		//��һ������:����ʱʹ�õ��������
		//�ڶ�������:Proxy��Ҫʵ��ʲô�ӿ�
		//������������ͨ���ӿڶ�����÷���ʱ,��Ҫ�����ĸ����invoke����
		Gongneng gongneng = (Gongneng)Proxy.newProxyInstance(Women.class.getClassLoader(), new Class[] {Gongneng.class},mishu);
		gongneng.chifan();
	}
}
