package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.util.DBconn;

//���ݲ�����
/**
 * ʵ��user�ķ���
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String name, String pwd) {  //�ܷ��½�ɹ�
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			    DBconn.init();  //��ʼ���������ݿ⣨��ͬ��

				ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'"); //��ȡ���ݿ�����
				while(rs.next()){  //ֱ�����ݵ���һ������Ϊ��������
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){  //����û�����������Ƿ������ݿ�ƥ��
						flag = true;
					}
				}
				DBconn.closeConn();  //�ر����ݿ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean update(int id) {  //�����û���Ϣ
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		String sql ="update user set is_push='1' where id='"+id+"'";
		int i =DBconn.addUpdDel(sql);  //ͨ����ɾ�Ĵ���i
		if(i>0){  //������޸ģ���ı�flag
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public int findID(String name, String pwd) {
		Object id = null;
		try {
			    DBconn.init();  //��ʼ���������ݿ⣨��ͬ��

				ResultSet rs = DBconn.selectSql("select id from user where name='"+name+"' and pwd='"+pwd+"'"); //��ȡ���ݿ�����
				while(rs.next()){  //ֱ�����ݵ���һ������Ϊ��������
					id = rs.getInt("id");
				}
				DBconn.closeConn();  //�ر����ݿ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int) id; 
	}

	public Set<String> findEmail() {  //�������ݿ���is_pushֵΪ0��email
		// TODO Auto-generated method stub
		Set<String> emailSet = new HashSet<String>();
		try {
			    DBconn.init(); 
				ResultSet rs = DBconn.selectSql("select email from user where is_push='0'"); //��ȡ���ݿ�����
				while(rs.next()){  //ֱ�����ݵ���һ������Ϊ��������
					/*if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){  //����û�����������Ƿ������ݿ�ƥ��
						flag = true;
					}*/
					emailSet.add(rs.getString("email"));
				}
				DBconn.closeConn();  //�ر����ݿ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailSet;
	}
	
	public StringBuffer PassValue(Set<String> em) {  //����StringBuffer�̲߳���ȫ������Ŀ�ɺ��ԣ���Ч�ʸߣ�������
		StringBuffer wt = new StringBuffer();  //����StringBuffer����
		Iterator<String> it = em.iterator();  //����������
		while(it.hasNext()) {  //���е���
			wt.append(it.next());  //append��������StringBuffer�������
			wt.append(",");  //��������Ӷ���
		}
		if(wt.length()!=0) {
			wt.deleteCharAt(wt.length() - 1);  //ɾ�����һ������
		}
		return wt;
	}
	
}
