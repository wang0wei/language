package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.People;

public interface PeopleService {
	
	//��ʾȫ��
	List<People> show() throws IOException;
}
