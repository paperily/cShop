package com.cShopfront.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cShopfront.dao.LoginDaoImpl;
import com.cShopfront.entity.User;

@Service
@Transactional
public class LoginServiceImpl {

	@Resource
	private LoginDaoImpl loginDaoImpl;
	
	public User loginByNameAndPass(User u) {
		return  this.loginDaoImpl.findByNameAndPass(u);
	}
	
	public User loginFindById(int id) {
		return this.loginDaoImpl.findById(id);
	}
}
