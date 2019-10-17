package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("download")
	public void download(String filename,HttpServletResponse res,HttpServletRequest req) throws IOException {
		//������Ӧ�����ļ���������
		res.setHeader("Content-Disposition", "attachment;filename="+filename);
		//�Ѷ����������뵽��Ӧ����
		ServletOutputStream os = res.getOutputStream();
		String path = req.getServletContext().getRealPath("files");
		File file = new File(path,filename);
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
	}
}
