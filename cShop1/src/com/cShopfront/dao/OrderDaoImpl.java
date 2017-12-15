package com.cShopfront.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cShopfront.entity.Order;
import com.cShopfront.entity.User;
@Repository
public class OrderDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void savaOrder(User user,String date,String name,String product,String count) {
		Order o=new Order();
		o.setCount(count);
		o.setDate(date);
		o.setDate(date);
		o.setName(name);
		o.setState(1);//订单为完成状态
		o.setProduct(product);
		Session session=this.sessionFactory.getCurrentSession();
		User u=session.get(User.class, new Integer(user.getId()));
		
		o.setUser(u);
		session.save(o); 
	}


}
