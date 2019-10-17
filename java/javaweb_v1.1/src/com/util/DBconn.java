package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库连接工具
public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8";
	private static String username = "root";
	private static String password = "123";
	static Connection conn = null;  //建立连接对象
	static ResultSet rs = null;  //结果查询
	static PreparedStatement ps = null;  //PreparedStatement是Statement的子类，
	//他可以预编译sql语句，预编译后的sql语句储存在PreparedStatement对象中，然后使用
	//PreparedStatement对象可以多次高效的执行sql语句
	
	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){  //数据库增删改
		
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();  //executeUpdate返回整数
		} catch (SQLException e) {
			System.out.println("sql数据库增删改异常");
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static int AddU(String sql, String str[]) {
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			a = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("增删改异常");
		}

		return a;

	}
	
	
	public static ResultSet selectSql(String sql){  //数据库查询
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);  //用于产生单个结果集的语句，多用于执行SELECT语句
		} catch (SQLException e) {
			System.out.println("sql数据库查询异常");
			e.printStackTrace();
		}
		return rs;
	}
	
	// 查询
		public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//给预处理语句中的未知数赋值,即给values(?,?,?)中的每一个?赋值
					}
				}		
				rs = ps.executeQuery();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;         
		}
	

	public static void closeConn() {  //数据库关闭
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}
	}
 
}
