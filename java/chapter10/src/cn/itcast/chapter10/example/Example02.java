package cn.itcast.chapter10.example;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Example02 {

	public static DataSource ds = null;
	static {
		// �½�һ�������ļ�����
		Properties prop = new Properties();
		try {
			// ͨ����������ҵ��ļ�·������ȡ�����ļ�
			InputStream in = new Example02().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
	      
	       // ���ļ�������������ʽ���ص����ö�����
           //���������ж�ȡ�����б�����Ԫ�ضԣ���ͨ����ָ�����ļ�������˵����� test.properties �ļ���
           //����װ������ȡ���ļ��е����м� - ֵ���Թ� getProperty ( String key) ��������
			prop.load(in);
		
			// ��������Դ����
			//ͨ����ȡ�����ļ�����Ϣ��������Դ���󲢷��ظ�������
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		// ��ȡ�������Ӷ���
		Connection conn = ds.getConnection();
		// ��ȡ���ݿ�������Ϣ
		DatabaseMetaData metaData = conn.getMetaData();
		// ��ӡ���ݿ�������Ϣ
		System.out.println(metaData.getURL() + "\nUserName=" + metaData.getUserName() + "\n" + metaData.getDriverName()+"\n"+metaData.getMaxIndexLength()
		+"\n"+metaData.getDriverVersion()+"\n"+metaData.getJDBCMajorVersion()+"\n"+metaData.getMaxConnections()+"\n"+metaData.getSQLKeywords());
	}
}
