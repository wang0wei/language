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
	static ResultSet rs = null;//结果集

	public static void  DataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("装载JDBC 驱动程序失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("无法连接数据库");
			e.printStackTrace();
		}
	}
	
	// 数据库关闭
	public static void close() { 
		try {
			
			conn.close();// 关闭
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}
	}
	// 查询
	public static ResultSet Search(String sql, String str[]) {
		DataBase();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);//给预处理语句中的未知数赋值,即给values(?,?,?)中的每一个?赋值
				}

			}
			
			rs = pst.executeQuery();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
         
	}
	// 增删修改

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
			System.out.println("增删改异常");
		}

		return a;

	}

}
