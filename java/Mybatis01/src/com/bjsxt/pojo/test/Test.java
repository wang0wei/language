package com.bjsxt.pojo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Flower;


public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		// ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// ����SqlSession
		SqlSession session = factory.openSession();
		
		
		
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		
		int count = session.selectOne("a.b.selById");//����ֵ����һ��������һ������ֵ
		System.out.println(count);
		
		//mapkey�����ݿ����ĸ��е�ֵ����map��key
		Map<Object, Object> map = session.selectMap("a.b.c", "name");
		System.out.println(map);
		
		session.close();
	}

}
