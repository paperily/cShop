package com.cShopfront.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cShopfront.dao.RegistDaoImpl;
import com.cShopfront.entity.User;


@Service
@Transactional
public class RegistServiceImpl {
	
	@Resource
	private RegistDaoImpl registDaoImpl;
	public int regist(User u) {
		return this.registDaoImpl.save(u);
	}
	public void editState(int id) {
		this.registDaoImpl.updateState(id);
	}
	public User checkName(User u) {
		return this.registDaoImpl.findByName(u);
		
	}
}
