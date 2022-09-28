<%@page import="model.Customer"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Bootie Ecommerce Bootstrap Responsive Web Template |
	Contact :: W3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Bootie Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome-icons -->
<!-- /Fonts -->
<link
	href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900"
	rel="stylesheet">
<!-- //Fonts -->

</head>

<body>

<% Customer c1 = null;
if(session.getAttribute("data")!=null){
	c1 = (Customer)session.getAttribute("data");
}
else{
	response.sendRedirect("customer-login.jsp");
}%>

	<!-- mian-content -->
	<div class="main-banner inner" id="home">
		<!-- header -->
		<header class="header">
			<div class="container-fluid px-lg-5">
				<!-- nav -->
				<nav class="py-4">
					<div id="logo">
						<h1>
							<a href="seller-index.jsp"><span class="fa fa-bold"
								aria-hidden="true"></span>ootie</a>
						</h1>
					</div>

					<label for="drop" class="toggle">Menu</label> <input
						type="checkbox" id="drop" />
					<ul class="menu mt-2">
						<li class="active"><a href="seller-index.jsp">Home</a></li>
						<li><a href="about.html">About</a></li>

						<li>
							<!-- First Tier Drop Down --> <label for="drop-2" class="toggle">Drop
								Down <span class="fa fa-angle-down" aria-hidden="true"></span>
						</label> <a href="#">Product<span class="fa fa-angle-down"
								aria-hidden="true"></span></a> <input type="checkbox" id="drop-2" />
							<ul>
								<li><a href="seller-upload-product.jsp">Upload product</a></li>
								<li><a href="seller-manage-product.jsp">Manage product </a></li>

							</ul>
						</li>
					  <li>
                            <!-- First Tier Drop Down -->
                            <label for="drop-2" class="toggle">Drop Down <span class="fa fa-angle-down" aria-hidden="true"></span> </label>
                            <a href="#"><%=c1.getName()%><span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                            	<li><a href="customer-profile.jsp">Profile</a></li>
                                <li><a href="customer-change-password.jsp">Change Password</a></li>
                                <li><a href="logout.jsp">Logout </a></li>
                                
                            </ul>
                        </li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</nav>
				<!-- //nav -->
			</div>
		</header>
		<!-- //header -->

	</div>
	<!--//main-content-->
	<!---->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
		<li class="breadcrumb-item active">Seller Profile</li>
	</ol>
	<!---->
	<!--// mian-content -->
	<!-- banner -->
	<section class="ab-info-main py-5">
		<div class="container py-3">
			<h3 class="tittle text-center">
				<span class="sub-tittle"></span>Seller Profile
			</h3>
			<div class="row contact-main-info mt-5">
				<div class="col-md-12 contact-right-content">
					<form action="SellerController" method="post">
						<input type="hidden" name="id" value="<%=c1.getId()%>">
						<input type="text" name="name" value="<%=c1.getName() %>"> 
						<input type="text" name="contact" value="<%=c1.getMobile_no()%>">
						<input type="text" name="address" value="<%=c1.getAddress() %>">
						<input type="email"name="email" value="<%=c1.getEmail() %>"> 
					    <input type="text" name="password" value="<%=c1.getPassword() %>">


						<div class="text center mt-3">
							<input type="submit" value="update" name="action">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>