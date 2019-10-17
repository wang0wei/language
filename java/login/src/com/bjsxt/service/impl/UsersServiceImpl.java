package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	

	@Value("${my.demo}")
	private String test;
	@Value("${my.demo1}")
	private String test1;
	
	
	
	@Resource
	private UsersMapper usersMapper;
	
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users login(Users users) {
		
		System.out.println("Êä³ö£º"+test);
		return usersMapper.selByUsers(users);
	}

}
