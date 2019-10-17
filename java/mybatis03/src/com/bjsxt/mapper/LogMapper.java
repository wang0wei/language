package com.bjsxt.mapper;

import java.util.List;

import com.bjsxt.pojo.Log;

public interface LogMapper {
	List<Log> selAll();
	
	List<Log> selByAccInAccount(String accin,String accout);
}
