package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Files;
import com.bjsxt.pojo.Users;

public interface FilesService {
	List<Files> show();
	
	int updCount(int id,Users users,String name);
}
