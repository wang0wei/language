package com.connection;

import java.sql.*;

/**
 * ��������ݿ�����Ӳ���
 * 
 * @author hasee
 *
 */
public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	private static String username = "root";
	private static String password = "123";
	static Connection conn = null; // �������Ӷ���
	static ResultSet rs = null; // �����ѯ
	static PreparedStatement ps = null; // PreparedStatement��Statement�����࣬
	// ������Ԥ����sql��䣬Ԥ������sql��䴢����PreparedStatement�����У�Ȼ��ʹ��
	// PreparedStatement������Զ�θ�Ч��ִ��sql���

	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}

	public static void closeConn() { // ���ݿ�ر�
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}

	}

}
