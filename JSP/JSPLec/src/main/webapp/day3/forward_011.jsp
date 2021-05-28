<!-- 	
forword는 동일한 웹서버 및 웹 앱 저장소에 속하는 웹 자원만 호출 가능.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산</title>
</head>
<body>
	<form action="forward_012.jsp" method="post">
		첫번째 수 <input type="text" name="num1"><br>
		두번째 수 <input type="text" name="num2"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>