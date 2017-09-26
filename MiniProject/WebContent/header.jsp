<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/freelancer.min.css" rel="stylesheet">
<style>
.head_logo{
	width:50px;
}
.header{
	background-color:#001379;
}
</style>
</head>
<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="main.jsp"><img class = "head_logo" src = "./img/img_main/logo.png">&nbsp;&nbsp;Get Off Work With EV Car</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	<c:if test="${not empty sessionScope.id}">
          	<li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">마이 페이지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">전기차 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">전기차 종류</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">충전소 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">자유 게시판</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">FAQ</a>
            </li>
            </c:if>
            <c:if test="${empty sessionScope.id }">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger"href = "#" data-toggle="modal" data-target="#login">로그인</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger"href = "#" data-toggle="modal" data-target="#join">회원가입</a>
            </li>
            <li>
            	<input type = "hidden" name = "page">
            </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>

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
    function loginModal(){
    	document.getElementById("page").value = "login";
	}
    function joinModal(){
    	document.getElementById("page").value = "join";
    }
    </script>
</body>
</html>