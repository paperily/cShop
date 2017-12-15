package com.cShopback.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cShopback.dao.BackOrderDaoImpl;
import com.cShopfront.entity.Order;

@Service
@Transactional
public class BackOrderServiceImpl {

	@Resource
	private BackOrderDaoImpl dodi;
	public List<Order> findAllOrder(){
		return this.dodi.findAll();
	}
}
