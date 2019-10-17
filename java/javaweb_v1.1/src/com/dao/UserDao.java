package com.dao;

import java.util.Set;

/**
 * 使用接口规范开发
 *
 *
 */
public interface UserDao {  //User的一些方法
	public boolean login(String name,String pwd);//登录
	public boolean update(int id) ;//更新用户信息
	public int findID(String name,String pwd);
	public Set<String> findEmail();  //读出Email地址（泛型）
	public StringBuffer PassValue(Set<String> em);  //泛型集合转到StringBuffer里面
}