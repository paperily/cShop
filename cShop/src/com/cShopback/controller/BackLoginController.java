package com.cShopback.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cShopback.entity.BackUser;
import com.cShopback.service.BackLoginServiceImpl;

@Controller
public class BackLoginController {

	@Resource
	private BackLoginServiceImpl backLoginServiceImpl;
	/*
	@GetMapping("/backuserlogin")
	public String backUserLogin(BackUser bu,HttpSession session) {
		
		BackUser user=this.backLoginServiceImpl.findByNameOrPassword(bu);
		if(user!=null) {
			session.setAttribute("backUser", user);
			return "redirect:/a-index.jsp";
		}else {
			return "redirect:/loginFailed.jsp";
		}
		
	}
	*/
	@PostMapping("/backlogin")
	public String backlogin(){
		return "redirect:a-index.jsp";
	}
	@PostMapping("/adminCancel")
	public String amminCancel(HttpSession session) {
		session.setAttribute("backUser",null);
		return "redirect:admin-login.jsp";
	}
}
