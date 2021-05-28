<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		//Empty check
		if(form.userID.value == ""){
			alert("id를 입력해 주세요.");
			//action으로 안넘어가도록 retrun false
			form.id.focus();
			return false;
		}
		if(form.userPW.value == ""){
			alert("pw를 입력해 주세요.");
			form.pw.focus();
			return false;
		}
		//length check
		if(form.userID.value.length < 4 || form.id.value.length > 12) {
			alert("id는 4~12자리 이내로 입력해 주세요.");
			form.id.select();
			return false;
		}
		if(form.userPW.value.length < 4 ) {
			alert("pw는 4자리 이상 입력해 주세요.");
			form.pw.select();
			return false;
		}
		
		form.submit();
	}
</script>
<body>
	<form name="loginForm" action="validation_03_process.jsp" method="post">
		<p>아이디 <input type="text" name="userID"></p>
		<p>비밀번호 <input type="password" name="userPW"></p>
		<!-- submit type은 무조건 이동한다. submit이고 false고 깡그리 무시하고 이동 -->
		<p><input type="button" value="OK" onclick="checkLogin()"></p>
	</form>
</body>
</html>