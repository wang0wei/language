package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
		@Resource
		private UsersMapper usersMapper;
		@Override
		public int insRegister(Users users) {
			return usersMapper.insUsers(users);
		}

}
