package com.cShopback.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cShopfront.entity.Order;

@Repository
public class BackOrderDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	public List<Order> findAll(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Order");
		return query.list();
		
	}
}
