package service;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBdao.DBhelp;
import jxl.Sheet;
import jxl.Workbook;

public class UserService {
	//查询数据库表中所有的数据
	public static List<User> getAllByDb(){
	     List<User> list = new ArrayList<User>();
		       
		        String sql = "select * from stu";
		        ResultSet rs = DBhelp.Search(sql, null);
		        try {
		            while(rs.next()){
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                String pwd =rs.getString("pwd");
		                String email =rs.getString("email");
		                int is_push=rs.getInt("is_push");
		                list.add(new User(id,name,pwd,email,is_push));
		            }
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return list;
		    }
		
		//查询指定目录中电子表格中所有的数据
			public static List<User> getAllByExcel(String file){
				List<User>list =new ArrayList<User>();
				
				try {
					Workbook rwb=Workbook.getWorkbook(new File(file));
					Sheet rs=rwb.getSheet(0);
					
					int rows=rs.getRows();   //得到所有的行
											
						for (int i = 1; i < rows; i++) {
							
							String id=rs.getCell(0,i).getContents();
							String name=rs.getCell(1,i).getContents();
							String pwd=rs.getCell(2,i).getContents();
							String email=rs.getCell(3,i).getContents();
							String is_push=rs.getCell(4,i).getContents();
										
							System.out.println("id:"+id+" name:"+name+" pwd:"+pwd+"email"+email+"is_push"+is_push);
							User user=new User();
							user.setId(Integer.parseInt(id));
							user.setName(name);
							user.setPwd(pwd);
							user.setEmail(email);
							user.setIs_push(Integer.parseInt(is_push));
							list.add(user);
							
							
						}
						
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				return list;
				
				
			}
			
			//通过id判断是否存在
			
			public static boolean isExist(String id) {
				
				try {
					
					ResultSet rs=DBhelp.Search("select * from stu where id =? ", new String[] {id+""});
					if (rs.next()) {
						return true;
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
				return false;
			}
}
