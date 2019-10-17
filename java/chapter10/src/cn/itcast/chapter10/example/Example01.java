package cn.itcast.chapter10.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//使用dbcp2需要引入commens-pool包和commens-logging包
//使用BasicDataSource直接创建数据源对象
public class Example01 {
public static DataSource ds=null;
static {
	//获取DBCP数据源实现类对象
	BasicDataSource bds=new BasicDataSource();
	bds.setDriverClassName("com.mysql.cj.jdbc.Driver");//设置连接数据库的驱动名称
	bds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");//设置连接数据库的路径
	bds.setUsername("root");//设置数据库的登录账号
	bds.setPassword("123");//设置数据库的登录密码
	bds.setInitialSize(5);//设置数据库连接池初始化的连接数目
	bds.setMaxTotal(5);//设置数据库连接池最大活跃的连接数目,dbcp2中使用setMaxTotal,dbcp中使用setMaxActive
	ds=bds;
}
public static void main(String[] args) throws SQLException {
	//获取数据库连接对象
	Connection conn=ds.getConnection();
	//获取数据库连接信息
	DatabaseMetaData metaData=conn.getMetaData();
	//打印数据库连接信息
	System.out.println(metaData.getURL()+",UserName="+metaData.getUserName()+","+metaData.getDriverName());
	
}
}
