<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
		function CheckForm(){
			alert("아이디 : " + document.loginForm.userID.value + "\n" +
					"비밀번호 : " + document.loginForm.userPW.value);
		}
	</script>
<body>
	<form name="loginForm">
		<p>아이디 <input type="text" name="userID"></p>
		<p>비밀번호 <input type="password" name="userPW"></p>
		<p><input type="submit" value="OK" onclick="CheckForm()"></p>
	</form>
</body>
</html>