package com.cShopfront.controllel;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cShopfront.entity.Product;
import com.cShopfront.entity.User;
import com.cShopfront.service.CartServiceImpl;


@Controller
@RequestMapping(value="/cartAction")
public class CartController {
	@Resource
	private CartServiceImpl cartServiceImpl;
	private ServletRequest session;
	private Object orderServiceImpl;
	@GetMapping("/add")
	public String addProduct(Product p,HttpServletRequest request) {
		//完成向购物车添加货物的工作
		this.cartServiceImpl.addProduct(p.getId(), request);
		return "redirect:/prolist";
		
	}
	@PostMapping("/balance")
	public String balance(HttpServletRequest request) {
		//获得购物车里被购买的货物的key值
		String [] k=request.getParameterValues("buyid");
		//进行商品数量的减少,给用户添加订单
		this.cartServiceImpl.balanceProduct(k,request);
		//跳转到支付成功页面
		return "redirect:/balanceSuccess.html";
	


}}

