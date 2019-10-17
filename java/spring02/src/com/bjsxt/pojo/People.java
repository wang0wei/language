package com.bjsxt.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
	private int id;
	private String name;
	private Set<String> sets;
	private List<String> list;
	private String[] strs;
	private Map<String,String> map;
	
	private Desk desk;
	
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getSets() {
		return sets;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public People() {
		super();
		System.out.println("ִ�й��췽��");
	}
	public People(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("ִ���вι��췽��");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("ִ��setId����");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("ִ��setName����");
		this.name = name;
	}
	public String[] getStrs() {
		return strs;
	}
	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", sets=" + sets + ", list=" + list + ", strs="
				+ Arrays.toString(strs) + ", map=" + map + ", desk=" + desk + "]";
	}

	
	
	
	
	
	
}
