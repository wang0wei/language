package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.LogMapper;
import com.bjsxt.pojo.Log;



public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		//�ӿ�Ϊʲô��ʵ������
		
		//��Ҫ���ӿ�һ��ʵ��������
		
		//ʹ�õ�JDK��̬����
		//����ӿڵĴ������ģʽ(�����нӿ�)
//		LogMapper logMapper = session.getMapper(LogMapper.class);
//		List<Log> list = logMapper.selAll();
//		for(Log log:list) {
//			System.out.println(log);
//		}
		
		LogMapper logMapper=session.getMapper(LogMapper.class);
		List<Log> list=logMapper.selByAccInAccount("3", "1");
		for(Log log:list) {
			System.out.println(log);
		}
			
	}
}
