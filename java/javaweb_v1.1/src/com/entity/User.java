package com.entity;

public class User {
	/*Excel��������*/
	private int id;
    private String name;
	private String pwd;
	private String email;
    public User(int id, String name, String pwd, String email, int is_push) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.is_push = is_push;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private int is_push;
    
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	/*���ݿ���е�������*/
	
    public User() {
		super();
	}
	public User(int id, String name, String pwd, int is_push) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.is_push = is_push;
	}
	
    
    public int getIs_push() {
		return is_push;
	}
	public void setIs_push(int is_push) {
		this.is_push = is_push;
	}
	public int getId() { //��ȡ
		return id;
	}
	public void setId(int id) { //���н���
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
