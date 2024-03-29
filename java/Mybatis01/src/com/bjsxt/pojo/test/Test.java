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
		// 使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// 生成SqlSession
		SqlSession session = factory.openSession();
		
		
		
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		
		int count = session.selectOne("a.b.selById");//返回值就是一个变量或一个对象值
		System.out.println(count);
		
		//mapkey把数据库中哪个列的值当作map的key
		Map<Object, Object> map = session.selectMap("a.b.c", "name");
		System.out.println(map);
		
		session.close();
	}

}
