package com.cShopback.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cShopfront.entity.Product;
import com.cShopfront.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Resource
	private ProductServiceImpl ps;
	
	@PostMapping("/backProductShow")
	public String backProductShow(HttpServletRequest request) {//查询商品然后展示数据
		this.ps.productShow(request);
		return "a-product";
	}
	
	
}
