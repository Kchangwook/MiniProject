<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kind</title>
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
<style>
.car-box {
	height: 380px;
	padding-top: 10px;
}

.car-img {
	width: 100%;
}

.car-text {
	margin: 40px 40px;
	font-size: 40pt;
}
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../Domain/header.jsp" />
	<!-- Modal -->
	<div class="modal fade" id="detail">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="w3-container modal-header w3-animate-zoom">
					<div class="w3-center">
						<span class="w3-text-blue modal-head login-text"><b id = "carName"></b></span>
					</div>
				</div>
				<div class="modal-body">
					<div class="w3-content">
						<div class=" w3-row w3-margin">
							<div class="w3-third ">
								<img id = "carImg" class = "detail-img" style="display: block; width: 200%;">
							</div>
							<div class="w3-twothird w3-container detail-declare">
								<h4>가격: <span id = "carPrice"></span>만원</h4>
								<h4>1회 충전 거리: <span id = "carMaxDistance"></span>km</h4>
								<h4>연비: <span id = "carEfficiency"></span>km/l</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Body -->
	<div class="w3-container text-center" style="display: block;">
		<h1 class="car-text text-declare">
			<b>전기차 종류</b>
		</h1>
	</div>
	<div class="w3-row-padding w3-margin-top">
		<section id="contact" class="w3-row-padding w3-margin-top">
		<c:forEach var="car" items="${carList }" varStatus="status">
			<div class="w3-third">
				<div class="w3-card-2 car-box">
					<a href="#" onclick="popModal(${car.carNum})" data-toggle="modal"data-target="#detail"> 
					<img src="${car.carImgSrc}"class="car-img">
						<div class="w3-container">
							<h4>
								<b>${car.carName }</b>
							</h4>
							<input type="hidden" id="carNum" value="${car.carNum }">
						</div>
					</a>
				</div>
			</div>
			<c:if test="${status.index%3 == 2 }"></section>
		<section id="contact" class="w3-row-padding w3-margin-top">
		</c:if> </c:forEach> </section>
		</section>
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
	<script type="text/javascript">
    
	var reqObject;
	
	function popModal(number){
    	
		//요청 객체 생성
		reqObject = new XMLHttpRequest();
		
		//응답 완료시 자동호출되는 함수 등록: call-back 함수 호출 문법
		reqObject.onreadystatechange = dataView;
		reqObject.open("get","Kind.do?command=carNum&num="+number,true);
		
		//실제 서버에 요청하는 함수
		reqObject.send(null);
		
    }

	/* 응답 완료시 div tag에 데이터 출력 로직 */
	function dataView(){
		//state가 4이면 응답 받았음을 표시, status가 200이면 정상 응답을 표시
		if(reqObject.readyState == 4 && reqObject.status == 200){			
			
			
			//step01 - json 포멧응답 처리 코드(response.jsp)
			var text = eval("("+reqObject.responseText+")");
			document.getElementById("carName").innerHTML = text.car.carName;
			document.getElementById("carPrice").innerHTML = text.car.carPrice;
			document.getElementById("carMaxDistance").innerHTML = text.car.carMaxDistance;
			document.getElementById("carEfficiency").innerHTML = text.car.carEfficiency;
			document.getElementById("carImg").src = text.car.carImgSrc;
		}
		
	}//end of dataView
    </script>
</body>
</html>