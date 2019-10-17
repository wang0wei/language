package excel;

import java.util.List;

import DBdao.DBhelp;
import service.User;
import service.UserService;

public class FromExcelToDb {
	public static void main(String[] args) {
		//得到表格中所有的数据
		List<User>listExcel=UserService.getAllByExcel("C:\\Users\\95645\\Desktop\\3.xls");
		for (User User : listExcel) {
			String id=Integer.toString(User.getId());
			String is_push=Integer.toString(User.getIs_push());
			if (!UserService.isExist(id)) {
				//不存在就添加
				String sql="insert into stu(id,name,pwd,email,is_push)values(?,?,?,?,?)";//问号是占位符
				String[] str=new String[] {id,User.getName(),User.getPwd(),User.getEmail(),is_push};
				DBhelp.AddU(sql, str);
		
			}else {
				//存在就更新
				String sql="update stu set id=?,name=?,pwd=?,email=?,is_push=? where id=?";
				String[] str=new String[] {Integer.toString(User.getId()),User.getName(),User.getPwd(),User.getEmail(),Integer.toString(User.getIs_push()),Integer.toString(User.getId())};
				DBhelp.AddU(sql, str);
			}
		}
		DBhelp.close();

}
	//public class FromDbToExcel {
//	public static void main(String[] args) {
//        try {
//            WritableWorkbook wwb = null;
//             
//               // 创建可写入的Excel工作簿
//               String fileName = "C:\\Users\\95645\\Desktop\\3.xls";
//               File file=new File(fileName);
//               if (!file.exists()) {
//                   file.createNewFile();
//               }
//               //以fileName为文件名来创建一个Workbook
//               wwb = Workbook.createWorkbook(file);
//
//               // 创建工作表
//               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
//               
//               //查询数据库中所有的数据
//               List<StuEntity> list= StuService.getAllByDb();
//               //要插入到的Excel表格的行号，默认从0开始
//               Label labelId= new Label(0, 0, "编号(id)");
//               Label labelName= new Label(1, 0, "姓名(name)");
//               Label labelPwd= new Label(2, 0, "密码(pwd)");
//               
//               ws.addCell(labelId);
//               ws.addCell(labelName);
//               ws.addCell(labelPwd);
//               for (int i = 0; i < list.size(); i++) {
//                   
//                   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
//                   Label labelName_i= new Label(1, i+1, list.get(i).getName());
//                   Label labelPwd_i= new Label(2, i+1, list.get(i).getPwd());
//                  
//                   ws.addCell(labelId_i);
//                   ws.addCell(labelName_i);   
//                   ws.addCell(labelPwd_i);
//               }
//             
//              //写进文档
//               wwb.write();
//              // 关闭Excel工作簿对象
//               System.out.println("数据导出成功!");
//               wwb.close();
//             
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } 
//    
//	}
}
