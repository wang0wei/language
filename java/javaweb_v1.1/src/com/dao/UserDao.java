package com.dao;

import java.util.Set;

/**
 * ʹ�ýӿڹ淶����
 *
 *
 */
public interface UserDao {  //User��һЩ����
	public boolean login(String name,String pwd);//��¼
	public boolean update(int id) ;//�����û���Ϣ
	public int findID(String name,String pwd);
	public Set<String> findEmail();  //����Email��ַ�����ͣ�
	public StringBuffer PassValue(Set<String> em);  //���ͼ���ת��StringBuffer����
}