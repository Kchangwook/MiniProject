<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
</head>
<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="${pageContext.request.contextPath }/Domain/main.jsp">
        <img class = "head_logo" src = "${pageContext.request.contextPath }/img/img_main/logo.png">&nbsp;&nbsp;Get Off Work With EV Car</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto head-right">
          	<c:if test="${not empty sessionScope.id}">
          	<li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath }/test.jsp">마이 페이지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath }/Introduce/introduce.jsp">전기차 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath }/Kind.do?command=getList">전기차 종류</a>
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
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath }/logout.do">로그아웃</a>
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
    <div style = "height:100px;"></div>
</body>
</html>