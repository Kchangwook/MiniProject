<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kind</title>
    <!-- Bootstrap core CSS -->
    <link href="/MiniProject/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="/MiniProject/css/freelancer.min.css" rel="stylesheet">
    
    <!-- Join -->
    <link rel="stylesheet" href="/MiniProject/css/w3.css">
	<link rel="stylesheet" href="/MiniProject/css/font-awesome.min.css">
<style>
*{
	padding:0px;
	margin:0px;
	display:block;
}
</style>
</head>
<body>
	<!-- Header -->
		<jsp:include page="../Domain/header.jsp" />
		
	<!-- Body -->
	<div class="w3-row-padding w3-margin-top">
		<section id="contact" class="w3-row-padding w3-margin-top">
		<c:forEach var = "car" items = "${carList }">
			<div class="w3-third">
				<div class="w3-card-2">
					<img src="${car.carImgSrc}" style="width: 100%">
					${car.carImgSrc}
					<div class="w3-container">
						<h4>${car.carName }</h4>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		</section>
	<!-- Footer -->
	<footer class="text-center">
	 <jsp:include page="../Domain/footer.jsp" />
	</footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/MiniProject/vendor/jquery/jquery.min.js"></script>
    <script src="/MiniProject/vendor/popper/popper.min.js"></script>
    <script src="/MiniProject/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="/MiniProject/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="/MiniProject/js/jqBootstrapValidation.js"></script>
    <script src="/MiniProject/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="/MiniProject/js/freelancer.min.js"></script>
</body>
</html>