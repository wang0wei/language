package com.Userdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBconn;

public class UserDao {

	// 判断用户名是否已经存在
	public boolean isExistName(String name) {
		boolean flag = false;
		try {
			DBconn.Connect();
			String sql = "select * from user where name='" + name + "'";
			ResultSet rs = DBconn.selectSql(sql);
			if (rs.getString("name").equals(name)) {
				flag = true;
			}
			DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 能否登陆成功
	public boolean login(String name, String pwd) {

		boolean flag = false;
		try {
			DBconn.Connect(); // 初始化连接数据库（下同）
			ResultSet rs = DBconn.selectSql("select * from user where name='" + name + "' and password='" + pwd + "'"); // 读取数据库数据
			while (rs.next()) { // 直到数据的下一条数据为空则跳出
				if (rs.getString("name").equals(name) && rs.getString("password").equals(pwd)) { // 检测用户输入的数据是否与数据库匹配
					flag = true;
				}
			}
			DBconn.closeConn(); // 关闭数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 用户注册
	public boolean insertUser(String id, String name, String password) {
		try {
			DBconn.Connect();
			String sql = "insert into user(id,name,password) values(?,?,?)";
			String str[] = { id, name, password };
			DBconn.addUser(sql, str);
			DBconn.closeConn(); // 关闭数据库
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 添加留言
	// 传入name,title,message,time参数,将这些数据存入数据库
	public boolean insertMessage(String name, String title, String message, String time) {
		boolean flag;
		try {
			DBconn.Connect();
			String sql = "insert into message (name,title,message,time) values(?,?,?,?)";
			String[] str = { name, title, message, time };
			DBconn.addUser(sql, str);
			DBconn.closeConn();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	//添加评论
	//传入whos、pname、ptime、pmessage参数，将这些数据存入到数据库
	public boolean insertPinglun(int whos,String pname,String ptime,String pmessage) {
		boolean flag;
		try {
			DBconn.Connect();
			String sql="insert into pinglun(whos,pname,ptime,pmessage) values('"+whos+"','"+pname+"','"+ptime+"','"+pmessage+"')";
			DBconn.addP(sql);
			DBconn.closeConn();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
}
