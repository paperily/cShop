package com.cShopfront.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cShopfront.dao.CartDaoImpl;
import com.cShopfront.entity.CartItem;
import com.cShopfront.entity.Product;
import com.cShopfront.entity.User;

@Service
@Transactional
public class CartServiceImpl {
	@Resource
	private CartDaoImpl cartDaoImpl;
	@Resource 
	private OrderServiceImpl orderServiceImpl;
	public void addProduct(int id,HttpServletRequest request) {
				//获取请求参数中产品的id值
				//根据id值找到这个商品
				Product pro=this.cartDaoImpl.findProById(id);	
				//创建session
				HttpSession session=request.getSession();
				session=request.getSession();
				Cart c=(Cart)session.getAttribute("cart");
				//将商品添加进购物车,如果购物车不存在
				if(c==null) {
					c=new Cart();
				}
				//商品的数量判断一下
				if(pro.getCount()>0) {
					c.addCart(pro);
					pro.setCount(pro.getCount()-1);//货物减少一个
					//更新session里的cart属性
					session.setAttribute("cart",c);
				}		
	}
	
	public void balanceProduct(String [] k,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String product=null;
		String count=null;
		for(String key:k) {
			Cart c=(Cart)session.getAttribute("cart");//得到购物车
			CartItem ct=(CartItem)c.getContiner().get(Integer.parseInt(key));//得到购物车里的货物信息
			int num=ct.getCount();//得到物品的数量
			Product p=ct.getProduct();//得到这个物品
			product=p.getName()+",";
			count=num+",";
			p.setCount(p.getCount()-num);//数量减少
			this.cartDaoImpl.updatePro(p);//更新操作
		}
		//创建完成订单的操作
		//得到用户
		
		User user=(User) session.getAttribute("user");
		//得到时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date()).toString();
		//得到用户的名字
		String name=user.getName();
		//添加订单
		this.orderServiceImpl.addOrder(user, date, name,product,count);
		//清除这个session
		session.setAttribute("user", null);
	}
}
