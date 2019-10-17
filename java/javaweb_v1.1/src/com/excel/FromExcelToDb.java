package com.excel;

import java.util.List;

import com.entity.User;
import com.util.DBconn;



public class FromExcelToDb {
	 public static void ExcelToDb() {
		//�õ���������е�����
			List<User>listExcel=UserService.getAllByExcel("C:\\Users\\95645\\Desktop\\3.xls");
			for (User stuEntity : listExcel) {
				String id=Integer.toString(stuEntity.getId());
				String is_push=Integer.toString(stuEntity.getIs_push());
				if (!UserService.isExist(id)) {
					//�����ھ����
					String sql="insert into user(id,name,pwd,email,is_push)values(?,?,?,?,?)";//�ʺ���ռλ��
					String[] str=new String[] {id,stuEntity.getName(),stuEntity.getPwd(),is_push};
					DBconn.AddU(sql, str);
			
				}else {
					//���ھ͸���
					String sql="update user set id=?,name=?,pwd=?,email=?,is_push=? where id=?";
					String[] str=new String[] {Integer.toString(stuEntity.getId()),stuEntity.getName(),stuEntity.getPwd(),stuEntity.getEmail(),Integer.toString(stuEntity.getIs_push()),Integer.toString(stuEntity.getId())};
					DBconn.AddU(sql, str);
				}
			}
			DBconn.closeConn();

	}
}
