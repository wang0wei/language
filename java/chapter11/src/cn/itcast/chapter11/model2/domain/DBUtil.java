package cn.itcast.chapter11.model2.domain;

import java.util.HashMap;

public class DBUtil {
	private static DBUtil instance=new DBUtil();
	//����users����,����ģ�����ݿ�
	private HashMap<String,UserBean>users=new HashMap<String,UserBean>();
	private DBUtil() {
		//�����ݿ�(users)�д�����������
		UserBean user1=new UserBean();
		user1.setName("jack");
		user1.setPassword("123456");
		user1.setEmail("jack@it315.org");
		users.put("jack", user1);
		
		UserBean user2=new UserBean();
		user2.setName("rose");
		user2.setPassword("123456");
		user2.setEmail("rose@it315.org");
		users.put("rose", user2);
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	//��ȡ���ݿ�(users)�е�����
	public UserBean getUser(String userName) {
		UserBean user=(UserBean)users.get(userName);
		return user;
	}
	
	//�����ݿ�(users)��������
	public boolean insertUser(UserBean user) {
		if(user==null) {
			return false;
		}
		String userName=user.getName();
	    if(users.get(userName)!=null) {//�Ѿ����ڴ������û�
	    	return false;
	    }
	    users.put(userName, user);
	    return true;
	}

}
