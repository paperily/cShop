package com.cShopfront.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cShopfront.entity.Product;

@Repository
public class CartDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public Product findProById(int id) {
		//Product p= this.sessionFactory.getCurrentSession().get(Product.class, id);
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Product p where id=?");
		query.setParameter(0,id);
		return (Product)query.uniqueResult();
	}

	public void updatePro(Product p) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(p);//进行更新操作
	}
}
