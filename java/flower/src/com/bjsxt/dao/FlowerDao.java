package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerDao {

	List<Flower> selAll();
	
	int insFlower(Flower flower);
}
