package com.bjsxt.service.impl;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

public class UsersServiceImpl implements UsersService{

	@Override
	public int insert(Users users) {
		
		return 0;
	}

	@Override
	public int insUsers(Users users) {
		System.out.println("asdf");
		insert(users);
		System.out.println("asdf");
		return 0;
	}
	
	public int updUsers(Users users) {
		insert(users);
		return 0;
	}
	
}
