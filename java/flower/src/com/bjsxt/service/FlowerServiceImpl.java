package com.bjsxt.service;

import java.util.List;

import com.bjsxt.dao.FlowerDao;
import com.bjsxt.dao.impl.FlowerDaoImpl;
import com.bjsxt.pojo.Flower;

public class FlowerServiceImpl implements FlowerService {

	private FlowerDao flowerDao=new FlowerDaoImpl();
	@Override
	public List<Flower> show() {
		
		return flowerDao.selAll();
	}
	@Override
	public int add(Flower flower) {
		
		return flowerDao.insFlower(flower);
	}

}
