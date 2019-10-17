package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class DemoController {
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name) throws IOException {
		System.out.println("name"+name);
		//获取文件拓展名
		String fileName=file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		
		if(suffix.equalsIgnoreCase(".png")) {
			String uuid = UUID.randomUUID().toString();		
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\Users\\95645\\Desktop"+uuid+suffix));
			return "index.jsp";
		}else {
			return "erroe.jsp";
		}
	}
}
