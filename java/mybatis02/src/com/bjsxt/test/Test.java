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
		
		//控制台输出的是程序运行调用的SQL，如果不调用，则控制台不输出
//		session.selectList("a.b.c");
//		session.selectList("a.b.d");
//		session.selectList("a.j.c");
//		session.selectList("a.j.d");
		
		//如果希望传递多个参数，可以使用对象或map
//		Map<String,Object>map=new HashMap<>();
//		map.put("id", 1);
//		map.put("name", "张三");	
//		People p = session.selectOne("a.b.selById",map);
//		System.out.println(p);
//		session.close();
		
//		int pageSize=2;
//		int pageNumber=2;		
//		Map<String,Object>map=new HashMap<>();
//		//pageSize表示显示几个，pageNumber表示第几页
//		map.put("pageSize", pageSize);
//		map.put("pageStart", pageSize*(pageNumber-1));		
//		List<People> p = session.selectList("a.b.page",map);
//		System.out.println(p);
		
		People p= new People();
		p.setName("新增name1");
		p.setAge(88);
		
		try {
			int index = session.insert("a.b.ins",p);
			if(index>0) {
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		} catch (Exception e1) {
			//e.printStackTrace();
			session.rollback();//事务回滚
		}
		
		
	
		p.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");	
		try {
			int index1 = session.insert("a.b.ins",p);
			if(index1>0) {
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			session.rollback();//事务回滚
		}	
		session.commit();
		session.close();
		System.out.println("程序执行结束");
		}
}
