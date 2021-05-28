<!-- 
	2021.5.10 윤재필
	세선에 값을 저장
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String food = request.getParameter("food");
	//session에 입력하기 (name은 보통 대문자)
	session.setAttribute("FOOD", food);
%>
	<h2>좋아하는 동물은?</h2>
	<br>
	<form action="characterTest_03.jsp" method="post">
		<input type="text" name="animal">
		<br><br>
		<input type="submit" value="OK">
	</form>


</body>
</html>