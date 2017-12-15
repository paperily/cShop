package com.cShopfront.controllel;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cShopfront.entity.User;
import com.cShopfront.service.RegistSendMail;
import com.cShopfront.service.RegistServiceImpl;

@Controller
public class RegistController {
		
		@Resource
		private RegistServiceImpl registServiceImpl;
		@Resource
		private RegistSendMail  registSendMail;
		@PostMapping("/registAction")
		public  String regist(User u) {
		
			
			int id=this.registServiceImpl.regist(u);
			String name=u.getName();
			String eMail=u.getEmail();
			//给用户发送邮件，邮件自带跳转链接
			this.registSendMail.SendMail(name,eMail,id);
			
			return "redirect:/index.jsp";
			}
		@GetMapping("/registCheck")
		public void  check(User u,HttpServletResponse response) {
			User user=this.registServiceImpl.checkName(u);
			if(user==null) {//名字没有被注册
					try {
						response.getWriter().write("1");
					} catch (IOException e) {
						e.printStackTrace();
					}
			}else {//名字被注册
					try {
						response.getWriter().write("0");
					} catch (IOException e) {
						e.printStackTrace();
					}
			 
			}
		}
		
}

