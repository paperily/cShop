package com.cShopfront.service;

import java.util.HashMap;

import com.cShopfront.entity.CartItem;
import com.cShopfront.entity.Product;
public class Cart {
	//货物的id值,货物的信息
	private HashMap<Integer,CartItem> continer=new HashMap<Integer,CartItem>();
	
	public HashMap<Integer, CartItem> getContiner() {
		return continer;
	}

	public void setContiner(HashMap<Integer, CartItem> continer) {
		this.continer = continer;
	}

	public void addCart(Product pro) {
		//如果购物车里物品已经存在
		 if(continer.containsKey(pro.getId())) {
			 //根据键值取,shaping的数目加一
			 CartItem ct=continer.get(pro.getId());
			 ct.setCount(ct.getCount()+1);
		 }else {//如果购物车里的物品不存在
			 CartItem ct=new CartItem();
			 ct.setProduct(pro);
			 ct.setCount(1);
			 continer.put(pro.getId(),ct);
		 }
	}
	
	public void print() {
		System.out.println(continer);
	}
}