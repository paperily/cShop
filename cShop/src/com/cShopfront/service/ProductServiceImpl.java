package com.cShopfront.service;

import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cShopback.entity.ProductType;
import com.cShopfront.dao.ProductDaoImpl;
import com.cShopfront.entity.Product;
import com.cShopfront.entity.ProductPage;

@Service
@Transactional
public class ProductServiceImpl {
	@Resource
	private ProductDaoImpl cccc;//产品查询dao
	public void productShow(HttpServletRequest request) {
		//数字6代表每页最多显示6条数据
		Object thisnum=request.getParameter("pagenumber");
		int num=1;//现在的页数
		if(thisnum==null || thisnum.equals("")) {
			//查询第1页,每页显示6个
			ProductPage pp=new ProductPage(num);//初始化当前页码和每页的商品个数
			List<Product> list=cccc.findProByPage((num-1)*6,6);//数据库的分页查询
			request.setAttribute("prolist", list);//产品的list
			request.setAttribute("count", cccc.count());//产品的总数
			request.setAttribute("countPage", cccc.countPage(6,pp));//产品的总页面
			request.setAttribute("thispage", pp.getThisPage());//当前是第几页
		}else {
			num=new Integer(thisnum.toString());
			ProductPage pp=new ProductPage(num);
			if(num<=0 || num> (this.cccc.countPage(6,pp))) {
				num=1;//现在的页数
				pp.setThisPage(num);//如果页码超了范围则默认为1
			}
			//查询第num页，每页显示6个
			List<Product> list=cccc.findProByPage((num-1)*6,6);
			request.setAttribute("prolist", list);
			request.setAttribute("count", cccc.count());
			request.setAttribute("countPage", cccc.countPage(6,pp));
			request.setAttribute("thispage", pp.getThisPage());
		}
//		List<ProductType> protypelist=this.cccc.findProductType();
//		request.setAttribute("pty", protypelist);
		
	}
	
}
