package com.cShopfront.entity;

import org.springframework.stereotype.Component;
@Component
public class CartItem {
	private Product product;
	private int count;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public int getCount() {
		return this.count;
	}
	
}
