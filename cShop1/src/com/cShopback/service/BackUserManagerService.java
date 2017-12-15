package com.cShopback.service;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cShopback.dao.BackUserManagerDaoImpl;
import com.cShopback.entity.AdminPage;
import com.cShopback.entity.BackUser;
import com.cShopback.entity.UserPage;
import com.cShopfront.entity.User;

@Service
@Transactional
public class BackUserManagerService {

	@Resource
	private BackUserManagerDaoImpl cc;
	
	public void userShow(HttpServletRequest request) {
	//	return this.backUserManagerDaoImpl.selectUser();
		//数字6代表每页最多显示6条数据
				Object thisnum=request.getParameter("pagenumber");
				int num=1;//现在的页数
				if(thisnum==null || thisnum.equals("")) {
					//查询第1页,每页显示6个
					UserPage pp=new UserPage(num);//初始化当前页码和每页的商品个数
					List<User> list=cc.findProByPage((num-1)*6,6);//数据库的分页查询
					request.setAttribute("userlist", list);//产品的list
					request.setAttribute("count", cc.countUser());//产品的总数
					request.setAttribute("countPage", cc.countUserPage(6,pp));//产品的总页面
					request.setAttribute("thispage", pp.getThisPage());//当前是第几页
				}else {
					num=new Integer(thisnum.toString());
					UserPage pp=new UserPage(num);
					if(num<=0 || num> (this.cc.countUserPage(6,pp))) {
						num=1;//现在的页数
						pp.setThisPage(num);//如果页码超了范围则默认为1
					}
					//查询第num页，每页显示6个
					List<User> list=cc.findProByPage((num-1)*6,6);
					request.setAttribute("userlist", list);
					request.setAttribute("count", cc.countUser());
					request.setAttribute("countPage", cc.countUserPage(6,pp));
					request.setAttribute("thispage", pp.getThisPage());
				}
	}

	public void adminShow(HttpServletRequest request) {
		//return this.backUserManagerDaoImpl.selectUser();
		//数字3代表每页最多显示3条数据
				Object thisnum=request.getParameter("pagenumber");
				int num=1;//现在的页数
				if(thisnum==null || thisnum.equals("")) {
					//查询第1页,每页显示3个
					AdminPage pp=new AdminPage(num);//初始化当前页码和每页的商品个数
					List<BackUser> list=cc.findAdminByPage((num-1)*3,3);//数据库的分页查询
					request.setAttribute("adminlist", list);//产品的list
					request.setAttribute("count", cc.countAdmin());//产品的总数
					request.setAttribute("countPage", cc.countAdminPage(3,pp));//产品的总页面
					request.setAttribute("thispage", pp.getThisPage());//当前是第几页
				}else {
					num=new Integer(thisnum.toString());
					AdminPage pp=new AdminPage(num);
					if(num<=0 || num> (this.cc.countAdminPage(3,pp))) {
						num=1;//现在的页数
						pp.setThisPage(num);//如果页码超了范围则默认为1
					}
					//查询第num页，每页显示6个
					List<BackUser> list=cc.findAdminByPage((num-1)*3,3);
					request.setAttribute("adminlist", list);
					request.setAttribute("count", cc.countAdmin());
					request.setAttribute("countPage", cc.countAdminPage(3,pp));
					request.setAttribute("thispage", pp.getThisPage());
				}
	}
	public void userAdd(User u) {
		this.cc.userAdd(u);
	}

	public void userDelete(User u) {
		this.cc.userDelete(u);
	}

	public void userState(User u) {
		this.cc.userState(u);
	}

	public void userRevise(User u) {
		this.cc.userRevise(u);
	}

	public void userDeleteAll(String [] values) {
		
		this.cc.userDeleteAll(values);
	}

	public void backUserDeleteAll(String[] values) {
		this.cc.backUserDeleteAll(values);
	}

	public void adminAdd(BackUser bu) {
		this.cc.adminAdd(bu);
		
	}
}
