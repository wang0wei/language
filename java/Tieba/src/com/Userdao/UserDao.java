package com.Userdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBconn;

public class UserDao {

	// �ж��û����Ƿ��Ѿ�����
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

	// �ܷ��½�ɹ�
	public boolean login(String name, String pwd) {

		boolean flag = false;
		try {
			DBconn.Connect(); // ��ʼ���������ݿ⣨��ͬ��
			ResultSet rs = DBconn.selectSql("select * from user where name='" + name + "' and password='" + pwd + "'"); // ��ȡ���ݿ�����
			while (rs.next()) { // ֱ�����ݵ���һ������Ϊ��������
				if (rs.getString("name").equals(name) && rs.getString("password").equals(pwd)) { // ����û�����������Ƿ������ݿ�ƥ��
					flag = true;
				}
			}
			DBconn.closeConn(); // �ر����ݿ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// �û�ע��
	public boolean insertUser(String id, String name, String password) {
		try {
			DBconn.Connect();
			String sql = "insert into user(id,name,password) values(?,?,?)";
			String str[] = { id, name, password };
			DBconn.addUser(sql, str);
			DBconn.closeConn(); // �ر����ݿ�
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// �������
	// ����name,title,message,time����,����Щ���ݴ������ݿ�
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
	
	//�������
	//����whos��pname��ptime��pmessage����������Щ���ݴ��뵽���ݿ�
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
