package DBdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhelp {
	static String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8";
	static String user = "root";
	static String pwd = "123";
	static Connection conn = null;
	static ResultSet rs = null;//�����

	public static void  DataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("װ��JDBC ��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�޷��������ݿ�");
			e.printStackTrace();
		}
	}
	
	// ���ݿ�ر�
	public static void close() { 
		try {
			
			conn.close();// �ر�
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
	// ��ѯ
	public static ResultSet Search(String sql, String str[]) {
		DataBase();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);//��Ԥ��������е�δ֪����ֵ,����values(?,?,?)�е�ÿһ��?��ֵ
				}

			}
			
			rs = pst.executeQuery();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
         
	}
	// ��ɾ�޸�

	public static int AddU(String sql, String str[]) {
		int a = 0;
		DataBase();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			a = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("��ɾ���쳣");
		}

		return a;

	}

}
