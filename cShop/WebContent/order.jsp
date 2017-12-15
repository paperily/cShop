<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<title>Order</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-md-4 world">
					<ul >
						<li>
						<select class="in-drop">
							  <option>English</option>
							  <option>Japanese</option>
							  <option>French</option>
							</select></li>
						<li><select class="in-drop1">
							  <option>Dollar</option>
							  <option>Euro</option>
							  <option>Yen</option>
							</select>
						</li>
					</ul>
				</div>
				<div class="col-md-4 logo">
					<a href="index.html"><img src="images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-md-4 header-left">		
					<p class="log"><a href="account.html"  >Login</a>
						<span>or</span><a  href="account.html"  >Signup</a></p>
					<div class="cart box_1">
						<a href="checkout.jsp">
						<h3> <div class="total">
							<span class="simpleCart_total"></span></div>
							<img src="images/cart.png" alt=""/></h3>
						</a>
						

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-md-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
	
				<div class="col-md-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!---->		
		</div>
	</div>
</div>
<!--//header-->
<!---->
<div class="container">

	<div class="check-out">
			  	<c:if test="${cart==null }">
				<h4 class="title">Shopping cart is empty</h4>
				<p class="cart">
					You have no items in your shopping cart.<br>Click<a
						href="/dsqimo/indexshow"> here</a> to continue shopping
				</p>
			</c:if>
			<c:if test="${cart!=null }">
		<h1>Checkout</h1>
		<form action="${path }/cartAction/balance" method="post">
    	    <table >
		  <tr>
			<th>Item</th>
			<th>  </th>		
			<th>Counts</th>
			<th>Prices</th>
			
			<th>salePrices</th>
		  </tr>
			<c:forEach items="${cart.continer}" var="p">
		  <tr>
		  	<td>	
		  	<input type="checkbox" class="ck" name="productid" 
									value="${p.value.product.id}">
			<span class="price" style="display:none;">${p.value.product.salePrice * p.value.count }</span>
			</td><%--给后台传入商品的id --%>
			
			<td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>${p.value.product.name}</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>

			
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="${p.value.count }" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>${p.value.product.price }</td>
		
			<td>${p.value.product.salePrice }</td>
		  </tr>
		  </c:forEach>
						<tr>
							<td colspan="3">总金额:<span id="balance"></span></td>
							<td ><button  type="submit">结算</button></td>
						</tr>
	</table>
	</form>
	</c:if>
		<script type="text/javascript">
			$(function(){
			    //计算总金额
			    function totalMoney(){
			    	//计算金额
			      var total_price = 0;
			      $(".ck").each(function(){
			        if($(this).prop('checked')==true) {
			          var obj1 =$(this).siblings(".price").text();//获取一行的商品金额
			          total_price += parseInt(obj1);
			        }
			      });
			      $("#balance").text(total_price);//将计算出的总数量显示
			      //更改name属性，把选择的商品传入后台
			      $(".ck").each(function(){
			    	  if($(this).prop('checked')==true){
			    		  $(this).attr("name","buyid");
			    	  }
			    	  if($(this).prop('checked')==false){
			    		  $(this).attr("name","productid");
			    	  }
			      });
		 		}
			    //全选juery
				$("#checkall").change(function(){
					 var status=$(this).prop("checked");
					 $(".ck").each(function(){
						$(".ck").prop("checked",status);
					 });
					 totalMoney();
				});
			    //实时计算商品的总金额
				$(".ck").change(function(){
					 totalMoney();
				});
		})
			    
			 
			  
			</script>
	</div>
	</div>
	
				

<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-md-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus  dui. </li>
						<li>orci, ornareidquet</li>
						<li> ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
</html>