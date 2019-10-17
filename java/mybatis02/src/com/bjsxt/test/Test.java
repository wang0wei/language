package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.People;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		//����̨������ǳ������е��õ�SQL����������ã������̨�����
//		session.selectList("a.b.c");
//		session.selectList("a.b.d");
//		session.selectList("a.j.c");
//		session.selectList("a.j.d");
		
		//���ϣ�����ݶ������������ʹ�ö����map
//		Map<String,Object>map=new HashMap<>();
//		map.put("id", 1);
//		map.put("name", "����");	
//		People p = session.selectOne("a.b.selById",map);
//		System.out.println(p);
//		session.close();
		
//		int pageSize=2;
//		int pageNumber=2;		
//		Map<String,Object>map=new HashMap<>();
//		//pageSize��ʾ��ʾ������pageNumber��ʾ�ڼ�ҳ
//		map.put("pageSize", pageSize);
//		map.put("pageStart", pageSize*(pageNumber-1));		
//		List<People> p = session.selectList("a.b.page",map);
//		System.out.println(p);
		
		People p= new People();
		p.setName("����name1");
		p.setAge(88);
		
		try {
			int index = session.insert("a.b.ins",p);
			if(index>0) {
				System.out.println("�ɹ�");
			}else {
				System.out.println("ʧ��");
			}
		} catch (Exception e1) {
			//e.printStackTrace();
			session.rollback();//����ع�
		}
		
		
	
		p.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");	
		try {
			int index1 = session.insert("a.b.ins",p);
			if(index1>0) {
				System.out.println("�ɹ�");
			}else {
				System.out.println("ʧ��");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			session.rollback();//����ع�
		}	
		session.commit();
		session.close();
		System.out.println("����ִ�н���");
		}
}
