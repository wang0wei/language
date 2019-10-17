package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.FilesMapper;
import com.bjsxt.pojo.Files;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.FilesService;

//@Service交给spring管理，否则无法注入
@Service
public class FilesServiceImpl implements FilesService{
	@Resource
	private FilesMapper filesMapper;

	@Override
	public List<Files> show() {	
		return filesMapper.selAll();
	}

	@Override
	public int updCount(int id, Users users,String name) {
		Logger logger=Logger.getLogger(FilesServiceImpl.class);
		logger.info(users.getUsername()+"下载了"+name);
		return filesMapper.updCountById(id);
	}
	
}
