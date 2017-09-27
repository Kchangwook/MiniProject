<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>carDetail</title>
<!-- Bootstrap core CSS -->
<link href="/MiniProject/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="/MiniProject/css/freelancer.min.css" rel="stylesheet">

<!-- Join -->
<link rel="stylesheet" href="/MiniProject/css/w3.css">
<link rel="stylesheet" href="/MiniProject/css/font-awesome.min.css">

<!-- main -->
<link rel="stylesheet" href="/MiniProject/css/main.css">
<link rel="stylesheet" href="/MiniProject/css/header.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../Domain/header.jsp" />

	<!-- Body -->
	<div class="w3-content">
		<div class="detail-box w3-row w3-margin">
			<div class="w3-third detail-img">
				<img src="${carDetail.carImgSrc }" style="display:block;width: 200%;">
			</div>
			<div class="w3-twothird w3-container detail-declare">
				<h2><b>${carDetail.carName}</b></h2>
				<h4>가격: ${carDetail.carPrice}만원</h4>
				<h4>크기: ${carDetail.carSize}</h4>
				<h4>1회 충전 거리${carDetail.carMaxDistance}km</h4>
				<h4>연비: ${carDetail.carEfficiency}km/l</h4>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="text-center"> <jsp:include
		page="../Domain/footer.jsp" /> </footer>

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