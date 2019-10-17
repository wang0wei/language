package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Message;
import com.entity.Pinglun;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/tieba?serverTimezone=GMT%2B8";//数据库路径,配置时区,北京东八区
	private static String username = "root";//数据库用户名
	private static String password = "123";//数据库密码
	
	//Connection接口代表java程序和数据库的连接,只有获得该连接对象后才能访问数据库,并操作数据表
	static Connection conn = null;
	
	//ResultSet接口用于保存JDBC执行查询时返回的结果集,该结果集封装在一个逻辑表格中
	static ResultSet rs = null;
	
	//PreparedStatement是Statement的子接口，
    //他可以执行预编译SQL语句,预编译后的SQL语句储存在PreparedStatement对象中，
	//该接口扩展了带有参数SQL语句的执行操作,应用该接口中的SQL语句可以使用占位符?来代替其参数
	//然后通过setXXX()方法为SQL语句的参数赋值
	static PreparedStatement ps = null;
	
	public static void Connect() {
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载JDBC驱动
			
			//DriverManager类用于加载JDBC驱动并创建与数据库的连接
			//调用DriverManager类的getConnection(String url,String user,String pwd)方法,
			//建立和数据库的连接,并返回表示连接的Connection对象
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			System.out.println("[SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	
	//断开数据库
	 public static void closeConn() {
 
		 if(rs!=null) {
			 try {
				 rs.close();
			 }catch(SQLException e){
				 e.printStackTrace();
			 }
			 rs=null;
		 }
		 if(ps!=null) {
			 try {
				 ps.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 ps=null;
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
	 

		public static ResultSet selectSql(String sql){  //数据库查询
			try {
				//调用Connection接口的prepareStatement(String sql)方法
				//用于创建一个prepareStatement对象并将参数化得SQL语句发送到数据库
				ps =  conn.prepareStatement(sql);
				
				//调用prepareStatement的父类Statement接口的executeQuery(String sql)方法
				//用于执行SQL中的SELECT语句,该方法返回一个表示查询结果的ResultSet对象
				rs =  ps.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("sql数据库查询异常");
				e.printStackTrace();
			}
			return rs;//返回结果集
		}
	 
		
	 public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//给预处理语句中的未知数赋值,即给values(?,?,?)中的每一个?赋值
					}
				}		
				rs = ps.executeQuery();	//executeQuery只能用于查询，execute方法才可以执行insert，update，delete操作
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;         
		}
	 
	 public static int addP(String sql){ 
			
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
	 
	 public static int addUser(String sql, String str[]) {
			int a = 0;
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//setString()从1开始
					}
				}
				a = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("增删改异常");
			}

			return a;
		}
	 
	 //将数据库里面的帖子信息放到list中
	 public static ArrayList<Message> getMessageList(String sql){

			ArrayList<Message> list = new ArrayList<Message>();//创建一个储存Message的集合
			try {
			Connect();//连接数据库
			ps =  conn.prepareStatement(sql);//预处理
			rs =  ps.executeQuery(sql);//返回结果集
			while(rs.next()) {//当结果集下一条信息存在
				//获取帖子的id,并转化成int类型
				int id=rs.getInt(1);
				//获取帖子的作者姓名
				String name=rs.getString(2);
				//获取帖子的标题
				String title=rs.getString(3);
				//获取帖子的内容
				String message=rs.getString(4);
				//获取帖子的发布时间
				String time=rs.getString(5);
				//新建一个帖子Message的对象
				Message msg=new Message();
				
				//将id存入其中
				msg.setId(id);
				//将name存入其中
				msg.setName(name);
				//将title存入其中
				msg.setTitle(title);
				//将message存入其中
				msg.setMessage(message);
				//将time存入其中
				msg.setTime(time);
				
				//将此Message对象存到ArrayList集合中
				list.add(msg);
			}			
			closeConn();//关闭数据库
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return list;//返回存放Message对象的集合		
	 }
	 
	 //将数据库里面的评论信息放到list中
	 public static ArrayList<Pinglun> getPinglunList(String sql){
		 ArrayList<Pinglun> list = new ArrayList<Pinglun>(); 
			try {
			Connect();//连接数据库
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
			while(rs.next()) {
				int whos=rs.getInt(2);//获取数据库里的whos存到whos里面
				String name=rs.getString(3);//获取数据库里面的pname存到name中
				String time=rs.getString(4);//获取数据库里的ptime存到time中
				String message=rs.getString(5);//获取数据库里的pmessage存到message中
				
				Pinglun msg=new Pinglun();//创建Pinglun对象
				
				msg.setWhos(whos);//将whos存到msg对象中
				msg.setPname(name);//将name存到msg对象中
				msg.setPtime(time);//将time存到msg对象中
				msg.setPmessage(message);//将message存到msg对象中
				
				
				list.add(msg);//将msg对象存到ArrayList数组中
			}
			closeConn();//关闭数据库
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return list;
	 }
	 
}
