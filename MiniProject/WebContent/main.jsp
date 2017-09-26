<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/freelancer.min.css" rel="stylesheet">
    
    <!-- Join -->
    <link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
<style>
.main_img{
	margin-top:130px;
	margin-left:220px;
	width:70%;
	margin-bottom:30px;
	border-width:1px;
	border-style:solid;
	border-color:#959595;
}
.main-car{
	width:300px;
	position:relative;
	top:-180px;
	left:100px;
}
.text-ev{
	font-size:30pt;
}
.text-declare{
	color:#001379;
}
.main-charger{
	position:relatvie;
	width:300px;
	z-index:-800;
}
.declare{
	background-image: url(img/img_main/evcharger.png);
	background-size: 500px;
	background-position: right;
	background-repeat: no-repeat;
}
.form-body{
	background-image:url("img/img_etc/evcar.png");
	background-size:70%;
	background-repeat: no-repeat;
	background-position: center;
}
.modal-head{
	position:relative;
	margin:auto;
}
.img-login {
	width: 50px;
	margin-bottom: 10px;
}

.login-text {
	font-size: 40px;
}
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page="header.jsp"/>
	<c:if test = "${requestScope.page == 'join' }">
	<div class="modal fade">
  		<div class="modal-dialog">
    		<div class="modal-content">
       		 	<jsp:include page = "LoginAndJoin/join.jsp"/>
    		</div>
		 </div>
	</div>
	</c:if>
	<c:if test = "${requestScope.page == 'login' }">
	<div class="modal fade">
  		<div class="modal-dialog">
    		<div class="modal-content">
       		 	<jsp:include page = "LoginAndJoin/login.jsp"/>
    		</div>
		 </div>
	</div>
	</c:if>
	
	 <!-- Main -->
    <header class = "header_back">
        <img class = "main_img" src="img/img_main/background1.jpg" alt="">
        <img class = "main_img" src="img/img_main/background2.jpg" alt="">
        <img class = "main_img" src="img/img_main/background3.jpg" alt="">
    </header>
    
    <!-- About Section -->
    <section class="success" id="about">
      <div class="container">
        <h2 class="text-ev text-left">전기자동차, 무엇이 궁금하세요?</h2><br>
        <div class="row">
          <div class="col-lg-10 mr-auto">
            <p>전기자동차의 작동원리 및 구조에 대한 내용과 충전시 주의사항에<br> ${page }관한 내용, 
            	전기자동차의 관리 방법 및 운행 요령에 대한 <br>자세한 내용을 확인 하실 수 있습니다.</p>
            <div class = "ml-auto" align = "right">
        		<img class = "main-car" src = "img/img_main/evcar.png">
          	</div>
          </div> 
        </div>
      </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class = "declare">
      <div class="container">
        <h3 class="text-center text-declare">환경부는 2011년부터 온실가스와 대기오염물질을 줄여 대기질을 개선하고자<br>전기자동차 보급사업을 추진하고 있습니다.</h3>
        <br><br>
        <div class="row">
          <div class="col-lg-8 mx-auto">
          	<p class = "text-center">전기자동차 구매보조금을 지원하고<br>전기자동차 구매 시 세제 감경 등 운행 인센티브와<br>구매 보조금 지원 절차에 대해 알려드립니다.</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="text-center">
		<jsp:include page = "Footer.jsp"/>
    </footer>
    
    


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>
    <script type="text/javascript">
    
    
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("main_img");
        for (i = 0; i < x.length; i++) {
           x[i].style.display = "none";  
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}    
        x[myIndex-1].style.display = "block";  
        setTimeout(carousel, 2000); // Change image every 2 seconds
    }
    </script>
	
</body>
</html>