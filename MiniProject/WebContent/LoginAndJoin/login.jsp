<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div class="w3-container modal-header w3-animate-zoom">
		<div class="w3-center">
			<span class="w3-text-blue modal-head login-text"><b>로그인</b></span>
		</div>
	</div>

	<div class="modal-body">
		<form class="w3-container" action="../login.do">
			<div class="w3-section">
				<input class="w3-input w3-border w3-margin-bottom" type="email" placeholder="이메일" name="id" required> 
				<input class="w3-input w3-border" type="password" placeholder="비밀번호" name="pwd" required> 
				<input class="w3-button w3-block w3-blue w3-section w3-padding"type="submit" value="로그인"> 
				<input class="w3-button w3-block w3-red w3-section w3-padding" type="reset" value="취소">
			</div>
		</form>

	</div>
</body>
</html>