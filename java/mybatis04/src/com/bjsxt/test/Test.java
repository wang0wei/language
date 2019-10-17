package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.LogMapper;



public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		Scanner input=new Scanner(System.in);
		System.out.println("«Î ‰»Î◊™’À’À∫≈£∫");
		String accout=input.nextLine();
		System.out.println("«Î ‰»Î ’øÓ’À∫≈£∫");
		String accin=input.nextLine();
		
		LogMapper mapper=session.getMapper(LogMapper.class);
//		List<Log> list=mapper.selByAccinAccount(accout, accin);
//		System.out.println(list);
		
//		Log log=new Log();
//		log.setId(1);
//		log.setAccOut(accout);
//		log.setAccIn(accin);
//		int index=mapper.upd(log);
//		System.out.println(index);
		
		
//		mapper.selByLog(new Log());
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		mapper.selIn(list);
		
		
		
		session.commit();
		session.close();	
	}
}
