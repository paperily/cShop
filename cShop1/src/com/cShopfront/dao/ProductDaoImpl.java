package com.cShopfront.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.cShopback.entity.ProductType;
import com.cShopfront.entity.Product;
import com.cShopfront.entity.ProductPage;

@Repository
public class ProductDaoImpl {

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

	public void productDeleteAll(String[] check) {
		Product p=new Product();
		for(String id:check) {
			p.setId(Integer.parseInt(id));
			this.sessionFactory.getCurrentSession().delete(p);
		}
	}

	public void productDeleteAll(Product p) {
		this.sessionFactory.getCurrentSession().save(p);
	}

	public void producRevise(Product p) {
		this.sessionFactory.getCurrentSession().update(p);
	}

	public Product producFindOne(Product p) {
		p=this.sessionFactory.getCurrentSession().get(Product.class,new Integer(p.getId()));
		return p;
	}

	public List<ProductType> findProductType() {
		Query<ProductType> query=this.sessionFactory.getCurrentSession().createQuery("from ProductType");
		return  query.list();
		
	}

	public Set<Product> findProByType(ProductType p) {
		p=this.sessionFactory.getCurrentSession().get(ProductType.class, new Integer(p.getId()));
		return (Set<Product>)p.getProSet();//返回商品集
	}

	public List<Product> findProByPageInGroup(int start, int maxNum, Set<Product> product) {
		
		return null;
	}
}
