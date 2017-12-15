package com.cShopfront.controllel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.cShopfront.service.ProductServiceImpl;
@Controller
public class ProductShow {

	@Resource
	private ProductServiceImpl ps;
	
	@GetMapping("/prolist")
	public String produceShow(HttpServletRequest request) {//查询商品然后在products.jsp展示数据
		this.ps.productShow(request);
		return "product";
	}
}
