package com.bjsxt.pojo;

public class Laozong implements Gongneng{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laozong() {
		super();
	}

	public Laozong(String name) {
		super();
		this.name = name;
	}

	public void zhidingxiaomubiao() {
		System.out.println("�ƶ�СĿ��");
	}

	@Override
	public void chifan() {
		System.out.println("�Է�");
	}
}
