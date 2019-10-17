package cn.itcast.chapter10.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//��������,���������ݿ�����
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tieba?serverTimezone=GMT%2B8";//���ݿ�·��,����ʱ��,����������
		String username = "root";//���ݿ��û���
		String password = "123";//���ݿ�����
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	//�ر����ݿ�����,�ͷ���Դ
	public static void release(Statement stmt,Connection conn) {
	
		 if(stmt!=null) {
			 try {
				 stmt.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 stmt=null;
		 }
		 if(conn!=null) {
			 try {
				conn.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 conn=null;
		 }
	}
	
	public static void release(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
		release(stmt,conn);
	}
	
	
}
