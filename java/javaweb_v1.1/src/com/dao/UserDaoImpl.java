package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.util.DBconn;

//数据操作类
/**
 * 实现user的方法
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String name, String pwd) {  //能否登陆成功
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			    DBconn.init();  //初始化连接数据库（下同）

				ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'"); //读取数据库数据
				while(rs.next()){  //直到数据的下一条数据为空则跳出
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){  //检测用户输入的数据是否与数据库匹配
						flag = true;
					}
				}
				DBconn.closeConn();  //关闭数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean update(int id) {  //更新用户信息
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		String sql ="update user set is_push='1' where id='"+id+"'";
		int i =DBconn.addUpdDel(sql);  //通过增删改传到i
		if(i>0){  //如果有修改，则改变flag
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public int findID(String name, String pwd) {
		Object id = null;
		try {
			    DBconn.init();  //初始化连接数据库（下同）

				ResultSet rs = DBconn.selectSql("select id from user where name='"+name+"' and pwd='"+pwd+"'"); //读取数据库数据
				while(rs.next()){  //直到数据的下一条数据为空则跳出
					id = rs.getInt("id");
				}
				DBconn.closeConn();  //关闭数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int) id; 
	}

	public Set<String> findEmail() {  //返回数据库中is_push值为0的email
		// TODO Auto-generated method stub
		Set<String> emailSet = new HashSet<String>();
		try {
			    DBconn.init(); 
				ResultSet rs = DBconn.selectSql("select email from user where is_push='0'"); //读取数据库数据
				while(rs.next()){  //直到数据的下一条数据为空则跳出
					/*if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){  //检测用户输入的数据是否与数据库匹配
						flag = true;
					}*/
					emailSet.add(rs.getString("email"));
				}
				DBconn.closeConn();  //关闭数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailSet;
	}
	
	public StringBuffer PassValue(Set<String> em) {  //运用StringBuffer线程不安全（本项目可忽略），效率高，方法多
		StringBuffer wt = new StringBuffer();  //创建StringBuffer对象
		Iterator<String> it = em.iterator();  //创建迭代器
		while(it.hasNext()) {  //进行迭代
			wt.append(it.next());  //append方法是往StringBuffer添加数据
			wt.append(",");  //在其中添加逗号
		}
		if(wt.length()!=0) {
			wt.deleteCharAt(wt.length() - 1);  //删除最后一个逗号
		}
		return wt;
	}
	
}
