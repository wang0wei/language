package com.excel;

import java.io.File;
import java.util.List;

import com.entity.User;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FromDbToExcel {
   public static void DbToExcel() {
	        try {
	            WritableWorkbook wwb = null;
	             
	               // ������д���Excel������
	               String fileName = "C:\\Users\\95645\\Desktop\\3.xls";
	               File file=new File(fileName);
	               if (!file.exists()) {
	                   file.createNewFile();
	               }
	               //��fileNameΪ�ļ���������һ��Workbook
	               wwb = Workbook.createWorkbook(file);
	
	               // ����������
	               WritableSheet ws = wwb.createSheet("��Ա", 0);
	               
	               //��ѯ���ݿ������е�����
	               List<User> list= UserService.getAllByDb();
	               //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
	               Label labelId= new Label(0, 0, "id");
	               Label labelName= new Label(1, 0, "name");
	               Label labelPwd= new Label(2, 0, "pwd");
	               Label labelEmail=new Label(3,0,"email");
	               Label labelIs_push= new Label(4, 0, "is_push");
	               
	               ws.addCell(labelId);
	               ws.addCell(labelName);
	               ws.addCell(labelPwd);
	               ws.addCell(labelEmail);
	               ws.addCell(labelIs_push);
	               
	               for (int i = 0; i < list.size(); i++) {
	                   
	                   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
	                   Label labelName_i= new Label(1, i+1, list.get(i).getName());
	                   Label labelPwd_i= new Label(2, i+1, list.get(i).getPwd());
	                   Label labelEmail_i= new Label(3, i+1, list.get(i).getPwd());
	                   Label labelIs_push_i= new Label(3, i+1, list.get(i).getPwd());
	                  
	                   ws.addCell(labelId_i);
	                   ws.addCell(labelName_i);   
	                   ws.addCell(labelPwd_i);
	                   ws.addCell(labelEmail_i);
	                   ws.addCell(labelIs_push_i);
	               }
	             
	              //д���ĵ�
	               wwb.write();
	              // �ر�Excel����������
	               System.out.println("���ݵ����ɹ�!");
	               wwb.close();
	             
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	    
		}
  }

