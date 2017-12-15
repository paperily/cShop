<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品修改</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Suity Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href='http://fonts.useso.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close2').on('click', function(c){
		$('.message2').fadeOut('slow', function(c){
	  		$('.message2').remove();
		});
	});	  
});
</script>
</head>
<body>
<div class="sales">
    <div class="container">
	  <div class="header_top">
   		<div class="logo">
			<a href="index.html"><img src="images/logo.png" alt=""/></a>
		</div>
		<div class="menu">																
			<a href="#" class="right_bt" id="activator"><img src="images/menu.png" alt=""/></a>
				<div class="box" id="box">
				   <div class="box_content_center">
					   <div class="menu_box_list">
						   <ul>
							   <li><a href="index.html">New Arrivals</a></li>
							   <li class="active"><a href="sales.html">Sales</a></li> 
							   <li><a href="sales.html">Collection</a></li> 
							   <li><a href="about.html">About Us</a></li>
							   <li><a href="contact.html">Contact</a></li>
						   </ul>
						</div>
						<a class="boxclose" id="boxclose"><img src="images/close.png" alt=""/></a>
					  </div>                
					</div>
			                 <script type="text/javascript">
								var $ = jQuery.noConflict();
									$(function() {
										$('#activator').click(function(){
												$('#box').animate({'left':'0px'},500);
										});
										$('#boxclose').click(function(){
												$('#box').animate({'left':'-2300px'},500);
										});
									});
									$(document).ready(function(){
									
									//Hide (Collapse) the toggle containers on load
									$(".toggle_container").hide(); 
									
									//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
									$(".trigger").click(function(){
										$(this).toggleClass("active").next().slideToggle("slow");
										return false; //Prevent the browser jump to the link anchor
									});
									
									});
								</script>
			         </div> 	
			         <div class="clearfix"></div>		
		      </div>
		</div>	
</div>
<div class="about_top">
  <div class="container">
		<div class="col-md-3"></div>
		<div class="col-md-9 content_right">
		   <div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.html" title="Go to Home Page">后台</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
              			       管理
                    </li>
               </ul>
                <ul class="previous">
                	<li><a href="index.html"></a></li>
                </ul>
                <div class="clearfix"></div>
		   </div>
		   <div class="register">
			  <div class="col-md-6 login-right">
			  	<h3>管理员管理页</h3>
				<p>后台管理员管理模块</p>
				<form action="./doProductUpdateGet" method="post">
				  <div>
					<span>商品名称<label>*</label></span>
					<input type="text" name="name" value="${pro.name }"> 
				  </div>
				  <div>
					<span>商品价格<label>*</label></span>
					<input type="text" name="price" value="${pro.price }"> 
				  </div>
				  <div>
					<span>商品简介<label>*</label></span>
					<input type="text" name="text" value="${pro.text }"> 
				  </div>
				  <div>
					<span>商品数量<label>*</label></span>
					<input type="text" name="count" value="${pro.count }"> 
				  </div>
				  <div>
					<span>商品类型<label>*</label></span>
					<input type="text" name="type" value="${pro.type }"> 
				  </div>
				  <input type="submit" value="提交">
			    </form>
			   </div>			   
			   <div class="clearfix"> </div>
		   </div>
	    </div>
	    <div class="clearfix"> </div>   	
    </div>   
</div>
<div class="footer">
	<div class="container">
		<img src="images/f_logo.png" alt=""/>
		<p><a href="mailto:info@mycompany.com">KIKI.com</a></p>
		<div class="copy">
			<p>版权所有©2017.公司名称版权所有 - 河北师范大学 - 软件学院 - java和大数据开发 </a></p>
		</div>
		<ul class="social">
		  <li><a href="#"> <i class="fb"> </i> </a></li>
		  <li><a href="#"> <i class="tw"> </i> </a></li>
		</ul>
	</div>
</div>
</body>
</html>		