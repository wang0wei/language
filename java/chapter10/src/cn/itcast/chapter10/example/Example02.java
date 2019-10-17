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
		// 新建一个配置文件对象
		Properties prop = new Properties();
		try {
			// 通过类加载器找到文件路径，读取配置文件
			InputStream in = new Example02().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
	      
	       // 把文件以输入流的形式加载到配置对象中
           //从输入流中读取属性列表（键和元素对）。通过对指定的文件（比如说上面的 test.properties 文件）
           //进行装载来获取该文件中的所有键 - 值对以供 getProperty ( String key) 来搜索。
			prop.load(in);
		
			// 创建数据源对象
			//通过读取配置文件的信息生成数据源对象并返回给调用者
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		// 获取数控连接对象
		Connection conn = ds.getConnection();
		// 获取数据库连接信息
		DatabaseMetaData metaData = conn.getMetaData();
		// 打印数据库连接信息
		System.out.println(metaData.getURL() + "\nUserName=" + metaData.getUserName() + "\n" + metaData.getDriverName()+"\n"+metaData.getMaxIndexLength()
		+"\n"+metaData.getDriverVersion()+"\n"+metaData.getJDBCMajorVersion()+"\n"+metaData.getMaxConnections()+"\n"+metaData.getSQLKeywords());
	}
}
