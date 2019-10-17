package com.connection;

import java.sql.*;

/**
 * 处理对数据库的连接操作
 * 
 * @author hasee
 *
 */
public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	private static String username = "root";
	private static String password = "123";
	static Connection conn = null; // 建立连接对象
	static ResultSet rs = null; // 结果查询
	static PreparedStatement ps = null; // PreparedStatement是Statement的子类，
	// 他可以预编译sql语句，预编译后的sql语句储存在PreparedStatement对象中，然后使用
	// PreparedStatement对象可以多次高效的执行sql语句

	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}

	public static void closeConn() { // 数据库关闭
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}

	}

}
