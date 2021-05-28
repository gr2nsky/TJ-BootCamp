<!-- 
	2021.5.12 윤재필
	입력받은 두 수를 sum_012.jsp로 post방식을 통해 전송합니다.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더하기</title>
</head>
<body>
덧셈을 위한 두 수를 입력하세요.
<br>
<form action="sum_012.jsp" method="post">
	
	<input type="text" name="num1">
	+
	<input type="text" name="num2">
	<br>
	<input type="submit" name="OK">
</form>
</body>
</html>