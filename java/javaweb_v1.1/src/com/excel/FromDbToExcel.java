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
	             
	               // 创建可写入的Excel工作簿
	               String fileName = "C:\\Users\\95645\\Desktop\\3.xls";
	               File file=new File(fileName);
	               if (!file.exists()) {
	                   file.createNewFile();
	               }
	               //以fileName为文件名来创建一个Workbook
	               wwb = Workbook.createWorkbook(file);
	
	               // 创建工作表
	               WritableSheet ws = wwb.createSheet("成员", 0);
	               
	               //查询数据库中所有的数据
	               List<User> list= UserService.getAllByDb();
	               //要插入到的Excel表格的行号，默认从0开始
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
	             
	              //写进文档
	               wwb.write();
	              // 关闭Excel工作簿对象
	               System.out.println("数据导出成功!");
	               wwb.close();
	             
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	    
		}
  }

