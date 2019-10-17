package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//���ݿ����ӹ���
public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8";
	private static String username = "root";
	private static String password = "123";
	static Connection conn = null;  //�������Ӷ���
	static ResultSet rs = null;  //�����ѯ
	static PreparedStatement ps = null;  //PreparedStatement��Statement�����࣬
	//������Ԥ����sql��䣬Ԥ������sql��䴢����PreparedStatement�����У�Ȼ��ʹ��
	//PreparedStatement������Զ�θ�Ч��ִ��sql���
	
	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){  //���ݿ���ɾ��
		
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();  //executeUpdate��������
		} catch (SQLException e) {
			System.out.println("sql���ݿ���ɾ���쳣");
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
			System.out.println("��ɾ���쳣");
		}

		return a;

	}
	
	
	public static ResultSet selectSql(String sql){  //���ݿ��ѯ
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);  //���ڲ����������������䣬������ִ��SELECT���
		} catch (SQLException e) {
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	
	// ��ѯ
		public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//��Ԥ��������е�δ֪����ֵ,����values(?,?,?)�е�ÿһ��?��ֵ
					}
				}		
				rs = ps.executeQuery();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;         
		}
	

	public static void closeConn() {  //���ݿ�ر�
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
 
}
