package com.cShopback.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cShopback.dao.BackLoginDaoImpl;
import com.cShopback.entity.BackUser;

@Service
@Transactional
public class BackLoginServiceImpl {

	@Resource
	private BackLoginDaoImpl backLoginDaoImpl;
	
	public BackUser findByNameOrPassword(BackUser bu) {
		 return this.backLoginDaoImpl.findByNameOrPassword(bu);
	}
}
