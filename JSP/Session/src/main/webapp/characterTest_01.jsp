<!-- 
	2021.5.10 윤재필	
	세션을 위한 간단한 입력 예제
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성격 테스트
</title>
</head>
<body>
	<h2>좋아하는 음식은?</h2>
	<form action="characterTest_02.jsp" method="get">
		<input type="text" name="food">
		<br><br>
		<input type="submit" value="OK">
	</form>
</body>
</html>