package com.bjsxt.pojo;

public class MiShu implements Gongneng{
	private Laozong laozong=new Laozong("����");

	@Override
	public void zhidingxiaomubiao() {
		System.out.println("������Ҫ��������");
		laozong.zhidingxiaomubiao();
		System.out.println("�ѷÿ���Ϣ��ע");
		
	}

	@Override
	public void chifan() {
		System.out.println("Լ��ʱ��");
		laozong.chifan();
		System.out.println("�ѷÿ���Ϣ��ע");
	}
	
}
