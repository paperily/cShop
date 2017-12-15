package com.cShopback.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cShopback.service.BackOrderServiceImpl;
import com.cShopfront.entity.Order;

@Controller
public class BackOrder {

	@Resource
	private BackOrderServiceImpl bost;
	@PostMapping("/orderlist")
	public String orderAllList(HttpServletRequest request) {
		List<Order>list=this.bost.findAllOrder();
		request.setAttribute("order", list);
		return "a-item";
	}
}
