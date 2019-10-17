package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;


//�����ݷ��ʲ㴦���쳣���ڿ������д����쳣��service��ֻ���쳣
public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//ǰ���ǹ���  ʵ������������ʱʹ�õ���  ���������ģʽ    ���Ʊ�־��������Builder
		//���������ģʽ���ڵ����壺��ʵ��������
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//���h�Ĳ鶼���b��session����
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.bjsxt.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}
	
}
