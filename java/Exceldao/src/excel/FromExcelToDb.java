package excel;

import java.util.List;

import DBdao.DBhelp;
import service.User;
import service.UserService;

public class FromExcelToDb {
	public static void main(String[] args) {
		//�õ���������е�����
		List<User>listExcel=UserService.getAllByExcel("C:\\Users\\95645\\Desktop\\3.xls");
		for (User User : listExcel) {
			String id=Integer.toString(User.getId());
			String is_push=Integer.toString(User.getIs_push());
			if (!UserService.isExist(id)) {
				//�����ھ����
				String sql="insert into stu(id,name,pwd,email,is_push)values(?,?,?,?,?)";//�ʺ���ռλ��
				String[] str=new String[] {id,User.getName(),User.getPwd(),User.getEmail(),is_push};
				DBhelp.AddU(sql, str);
		
			}else {
				//���ھ͸���
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
//               // ������д���Excel������
//               String fileName = "C:\\Users\\95645\\Desktop\\3.xls";
//               File file=new File(fileName);
//               if (!file.exists()) {
//                   file.createNewFile();
//               }
//               //��fileNameΪ�ļ���������һ��Workbook
//               wwb = Workbook.createWorkbook(file);
//
//               // ����������
//               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
//               
//               //��ѯ���ݿ������е�����
//               List<StuEntity> list= StuService.getAllByDb();
//               //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
//               Label labelId= new Label(0, 0, "���(id)");
//               Label labelName= new Label(1, 0, "����(name)");
//               Label labelPwd= new Label(2, 0, "����(pwd)");
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
//              //д���ĵ�
//               wwb.write();
//              // �ر�Excel����������
//               System.out.println("���ݵ����ɹ�!");
//               wwb.close();
//             
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } 
//    
//	}
}
