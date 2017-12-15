<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
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
                       <a href="index.html" title="Go to Home Page">返回首页</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
              			       后台管理
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
				<table border="1">
				        <tr>
						<td>用户姓名</td>
						<td>用户密码</td>
						<td>修改</td>
						</tr>
				<c:forEach items="${userlist}" var="a" begin="0" end="2" step="1">	
						<tr>
						<td>${a.name }</td>
						<td>${a.password }</td>
						<td><a href="userRevise?id=${a.id }">修改</a>
							<a href="userDelete?id=${a.id }">删除</a></td>
						</tr>
				</c:forEach>
				</table>
			   </div>			   
			   <div class="clearfix"> </div>
		   </div>
	    </div>
	    <div class="clearfix"> </div>   	
    </div>   
</div>

</body>
</html>		