package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerService {

	List<Flower>show();
	
	int add(Flower flower);
}
