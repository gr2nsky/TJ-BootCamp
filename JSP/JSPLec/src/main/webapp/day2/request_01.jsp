<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름을 입력하고 확인 버튼을 누루세요.
	<br>
	<br>
	<form action="request_02.jsp" method="get">
		이름 : <input type="text" name="yourName">
		<input type="submit" value="확인 - get">
	</form>
		<form action="request_02.jsp" method="post">
		이름 : <input type="text" name="yourName2">
		<input type="submit" value="확인 - post">
	</form>
</body>
</html>