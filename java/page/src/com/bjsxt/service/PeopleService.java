package com.bjsxt.service;

import java.io.IOException;

import com.bjsxt.pojo.PageInfo;

public interface PeopleService {
	//��ҳ��ʾ
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
