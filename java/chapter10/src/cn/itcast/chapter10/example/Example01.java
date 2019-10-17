package cn.itcast.chapter10.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//ʹ��dbcp2��Ҫ����commens-pool����commens-logging��
//ʹ��BasicDataSourceֱ�Ӵ�������Դ����
public class Example01 {
public static DataSource ds=null;
static {
	//��ȡDBCP����Դʵ�������
	BasicDataSource bds=new BasicDataSource();
	bds.setDriverClassName("com.mysql.cj.jdbc.Driver");//�����������ݿ����������
	bds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");//�����������ݿ��·��
	bds.setUsername("root");//�������ݿ�ĵ�¼�˺�
	bds.setPassword("123");//�������ݿ�ĵ�¼����
	bds.setInitialSize(5);//�������ݿ����ӳس�ʼ����������Ŀ
	bds.setMaxTotal(5);//�������ݿ����ӳ�����Ծ��������Ŀ,dbcp2��ʹ��setMaxTotal,dbcp��ʹ��setMaxActive
	ds=bds;
}
public static void main(String[] args) throws SQLException {
	//��ȡ���ݿ����Ӷ���
	Connection conn=ds.getConnection();
	//��ȡ���ݿ�������Ϣ
	DatabaseMetaData metaData=conn.getMetaData();
	//��ӡ���ݿ�������Ϣ
	System.out.println(metaData.getURL()+",UserName="+metaData.getUserName()+","+metaData.getDriverName());
	
}
}
