<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
</head>
<body>
	<div class = "modal-header w3-animate-zoom">
		<h2 class="w3-text-blue modal-head"><b>회원 가입</b></h2>	
	</div>
	<div class = "modal-body form-body w3-animate-zoom">
	<form action="../Join.do" method = "post" class="w3-container w3-margin">
		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input id = "id" class="w3-input w3-border" name="memberID" type="email"
					placeholder="이메일">
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input id = "pwd" class="w3-input w3-border" name="memberPwd" type="password"
					placeholder="비밀번호">
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input id = "repwd" class="w3-input w3-border" name="memberPwdCon" type="password"
					placeholder="비밀번호 확인" onblur = "checkPwd()">
				<span id = "msg"></span>
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input class="w3-input w3-border" name="memberName" type="text"
					placeholder="이름">
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input class="w3-input w3-border" name="memberAddr" type="text"
				  placeholder="주소" >
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-rest">
				<input class="w3-input w3-border" name="memberPhone" type="text"
					placeholder="전화번호" pattern="[0-9]{11}" title="'-'를 뺀 휴대전화 번호 10~11자리를 입력해주세요.">
			</div>
		</div>
		
		<p class="w3-center">
			<input class="w3-button w3-section w3-blue w3-ripple" type = "submit" value = "회원가입">
			<input class="w3-button w3-section w3-red w3-ripple" type = "reset" value = "취소">
		</p>
	</form>
	</div>
	<script type="text/javascript">
		var pwd = document.getElementById("pwd");
		var repwd = document.getElementById("repwd");
		
		function checkPwd(){
			
			if(pwd.value != repwd.value){
				document.getElementById("msg").innerHTML = "<b style = 'color:red;'>비밀번호가 맞지 않습니다.</b>";
			}else{
				document.getElementById("msg").innerHTML = "<b style = 'color:blue;'>비밀번호가 맞습니다.</b>";
			}
			
		}
		
	</script>
</body>
</html>