package com.bjsxt;

public class Singleton {
	//���ڶ�����Ҫ����̬�������ã��ѷ�������Ϊstatic
	//���ڶ�����static���������÷���Ȩ�����η�Ϊprivate�������public����ֱ�ӵ��ö��󣬲�ִ�з������
	private static Singleton singleton;
	/*
	 * ��������������ͬ
	 * �޷���ֵ
	 * 
	 * �����಻��ʵ������������
	 * 
	 * �����ṩ�������
	 * */
	private Singleton() {
		
	}
	
	/*
	 * ʵ��������ʵ����������ͨ���������
	 * 
	 * ���÷���Ϊ��̬����
	 * 
	 * */
	public static Singleton getInstance() {
		//����߼������ʵ��������ֱ�ӷ���
		if(singleton==null) {
			//���̷߳����£����ܳ���ifͬʱ����������������
			synchronized (Singleton.class) {
				//˫����֤
				if(singleton==null) {
					singleton=new Singleton();
				}
			}
			
		}
		return singleton;
	}
}
