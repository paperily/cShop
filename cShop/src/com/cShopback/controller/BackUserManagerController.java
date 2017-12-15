package com.cShopback.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cShopback.entity.BackUser;
import com.cShopback.service.BackUserManagerService;
import com.cShopfront.entity.User;

@Controller
public class BackUserManagerController {

	@Resource
	private BackUserManagerService backUserManagerService;
	@PostMapping("/userlist")
	public String userList(HttpServletRequest request) {
	 	this.backUserManagerService.userShow(request);
		return "a-user";
	}
	/*@PostMapping("/adminlist")
	public String adminList(HttpServletRequest request) {
		this.backUserManagerService.adminShow(request);
		return "/admin-role";
	}*/
	//修改
	@GetMapping("/userRevise")
	public String userRevise(User u) {
		this.backUserManagerService.userRevise(u);
		return "redirect:/userlist";
	}
	@PostMapping("/userAdd")
	public String userAdd(User u) {
		this.backUserManagerService.userAdd(u);
		return "redirect:/userlist";
	}
	/*@PostMapping("/adminAdd")
	public String adminAdd(BackUser bu) {
		this.backUserManagerService.adminAdd(bu);
		return "redirect:/adminlist";
	}*/
	//删除
	@GetMapping("/userDelete")
	public String userDelete(User u) {
		this.backUserManagerService.userDelete(u);
		return "redirect:/userlist";
	}
	@PostMapping("/userDeleteAll")
	public String userDeleteAll(HttpServletRequest request) {
		String []values=request.getParameterValues("check");//获得要被删除的元素
		this.backUserManagerService.userDeleteAll(values);
		return "redirect:/userlist";
	}
	/*@PostMapping("/adminDeleteAll")
	public String backUserDeleteAll(HttpServletRequest request) {
		String []values=request.getParameterValues("check");//获得要被删除的元素
		this.backUserManagerService.backUserDeleteAll(values);
		return "redirect:/adminlist";
	}*/
	//修改状态
	@GetMapping("/userState")
	public String userState(User u) {
		this.backUserManagerService.userState(u);
		return "redirect:/userlist";
	}
	
}
