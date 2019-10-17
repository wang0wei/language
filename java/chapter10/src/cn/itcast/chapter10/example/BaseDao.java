package cn.itcast.chapter10.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class BaseDao {

	//�Ż���ѯ
	public static Object query(String sql,ResultSetHandler<?> rsh,Object...params)throws SQLException {
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  try {
		  //�������
		  conn=JDBCUtils.getConnection();
		  //Ԥ����sql
		  pstmt=conn.prepareStatement(sql);
		  //���������ý�ȥ
		  for(int i=0;params!=null&&i<params.length;i++) {
			  pstmt.setObject(i+1, params[i]);
		  }
		  //����sql
		  rs=pstmt.executeQuery();
		  //�õ�����ȥʵ�ֶԽ�����Ĵ���
		  Object obj=rsh.handle(rs);
		  return obj;
	  }catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
	}finally {
		//�ͷ���Դ
		JDBCUtils.release(rs,pstmt, conn);
	}
		return rs;
		
	}
}
