package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.People;
import com.bjsxt.pojo.PeopleFactory;

public class Test {
	public static void main(String[] args) {
		//People peo=new People();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = ac.getBean("peo2",People.class);
		System.out.println(people);
		
//		String[] names = ac.getBeanDefinitionNames();
//		for(String string:names) {
//			System.out.println(string);
//		}
		
		
		//ʵ���������Դ���
		//��ξ���ʵ���������ͱ�֪ʶ���޹�
//		PeopleFactory factory=new PeopleFactory();
//		People people = factory.newInstance();
		
		//��̬����
//		People peo=PeopleFactory.newInstance();		
	}
}
