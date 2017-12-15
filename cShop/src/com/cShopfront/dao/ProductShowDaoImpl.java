package com.cShopfront.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.cShopfront.entity.Product;
import com.cShopfront.entity.ProductPage;

@Repository
public class ProductShowDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	 
	public List<Product> findProByPage(int start, int maxNum) {
		Query<Product> query=this.sessionFactory.getCurrentSession().createQuery("from Product");
		query.setFirstResult(start);
		query.setMaxResults(maxNum);
		return query.list();
	}

	/**
	 * 
	 * @return 数据总条数
	 */
	public int count() {
		//查询数据表的商品总数
		Query query=this.sessionFactory.getCurrentSession().createQuery("select count(id) from Product");
		return new Integer(query.uniqueResult().toString());
	}

	public int countPage(int proNumOfEachPage,ProductPage pp) {
		 	int i=count();
			if(i%proNumOfEachPage==0) {
				pp.setCountPage(i/proNumOfEachPage);
			}else {
				pp.setCountPage(i/proNumOfEachPage+1);
			}
			return pp.getCountPage();
	}
}
