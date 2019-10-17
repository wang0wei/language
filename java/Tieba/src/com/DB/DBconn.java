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
	static String url = "jdbc:mysql://localhost:3306/tieba?serverTimezone=GMT%2B8";//���ݿ�·��,����ʱ��,����������
	private static String username = "root";//���ݿ��û���
	private static String password = "123";//���ݿ�����
	
	//Connection�ӿڴ���java��������ݿ������,ֻ�л�ø����Ӷ������ܷ������ݿ�,���������ݱ�
	static Connection conn = null;
	
	//ResultSet�ӿ����ڱ���JDBCִ�в�ѯʱ���صĽ����,�ý������װ��һ���߼������
	static ResultSet rs = null;
	
	//PreparedStatement��Statement���ӽӿڣ�
    //������ִ��Ԥ����SQL���,Ԥ������SQL��䴢����PreparedStatement�����У�
	//�ýӿ���չ�˴��в���SQL����ִ�в���,Ӧ�øýӿ��е�SQL������ʹ��ռλ��?�����������
	//Ȼ��ͨ��setXXX()����ΪSQL���Ĳ�����ֵ
	static PreparedStatement ps = null;
	
	public static void Connect() {
		try {
			//����������
			Class.forName("com.mysql.cj.jdbc.Driver");//����JDBC����
			
			//DriverManager�����ڼ���JDBC���������������ݿ������
			//����DriverManager���getConnection(String url,String user,String pwd)����,
			//���������ݿ������,�����ر�ʾ���ӵ�Connection����
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			System.out.println("[SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	
	//�Ͽ����ݿ�
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
	 

		public static ResultSet selectSql(String sql){  //���ݿ��ѯ
			try {
				//����Connection�ӿڵ�prepareStatement(String sql)����
				//���ڴ���һ��prepareStatement���󲢽���������SQL��䷢�͵����ݿ�
				ps =  conn.prepareStatement(sql);
				
				//����prepareStatement�ĸ���Statement�ӿڵ�executeQuery(String sql)����
				//����ִ��SQL�е�SELECT���,�÷�������һ����ʾ��ѯ�����ResultSet����
				rs =  ps.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("sql���ݿ��ѯ�쳣");
				e.printStackTrace();
			}
			return rs;//���ؽ����
		}
	 
		
	 public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//��Ԥ��������е�δ֪����ֵ,����values(?,?,?)�е�ÿһ��?��ֵ
					}
				}		
				rs = ps.executeQuery();	//executeQueryֻ�����ڲ�ѯ��execute�����ſ���ִ��insert��update��delete����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;         
		}
	 
	 public static int addP(String sql){ 
			
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
	 
	 public static int addUser(String sql, String str[]) {
			int a = 0;
			try {
				ps = conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//setString()��1��ʼ
					}
				}
				a = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("��ɾ���쳣");
			}

			return a;
		}
	 
	 //�����ݿ������������Ϣ�ŵ�list��
	 public static ArrayList<Message> getMessageList(String sql){

			ArrayList<Message> list = new ArrayList<Message>();//����һ������Message�ļ���
			try {
			Connect();//�������ݿ�
			ps =  conn.prepareStatement(sql);//Ԥ����
			rs =  ps.executeQuery(sql);//���ؽ����
			while(rs.next()) {//���������һ����Ϣ����
				//��ȡ���ӵ�id,��ת����int����
				int id=rs.getInt(1);
				//��ȡ���ӵ���������
				String name=rs.getString(2);
				//��ȡ���ӵı���
				String title=rs.getString(3);
				//��ȡ���ӵ�����
				String message=rs.getString(4);
				//��ȡ���ӵķ���ʱ��
				String time=rs.getString(5);
				//�½�һ������Message�Ķ���
				Message msg=new Message();
				
				//��id��������
				msg.setId(id);
				//��name��������
				msg.setName(name);
				//��title��������
				msg.setTitle(title);
				//��message��������
				msg.setMessage(message);
				//��time��������
				msg.setTime(time);
				
				//����Message����浽ArrayList������
				list.add(msg);
			}			
			closeConn();//�ر����ݿ�
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return list;//���ش��Message����ļ���		
	 }
	 
	 //�����ݿ������������Ϣ�ŵ�list��
	 public static ArrayList<Pinglun> getPinglunList(String sql){
		 ArrayList<Pinglun> list = new ArrayList<Pinglun>(); 
			try {
			Connect();//�������ݿ�
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
			while(rs.next()) {
				int whos=rs.getInt(2);//��ȡ���ݿ����whos�浽whos����
				String name=rs.getString(3);//��ȡ���ݿ������pname�浽name��
				String time=rs.getString(4);//��ȡ���ݿ����ptime�浽time��
				String message=rs.getString(5);//��ȡ���ݿ����pmessage�浽message��
				
				Pinglun msg=new Pinglun();//����Pinglun����
				
				msg.setWhos(whos);//��whos�浽msg������
				msg.setPname(name);//��name�浽msg������
				msg.setPtime(time);//��time�浽msg������
				msg.setPmessage(message);//��message�浽msg������
				
				
				list.add(msg);//��msg����浽ArrayList������
			}
			closeConn();//�ر����ݿ�
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return list;
	 }
	 
}
