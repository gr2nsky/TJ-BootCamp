<!-- 
	2021.5.10 윤재필
	
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
	<form action="EL_02.jsp" method="post">
	
	아이디 <input type="text" value="userID">
	<br>
	다음 중, 회원님이 키우고 계신 반려동물을 선택하십시오.
	<br>
	강아지 <input type="checkbox" name="animal" value="강아지">
	고양이 <input type="checkbox" name="animal" value="고양이">
	거북이 <input type="checkbox" name="animal" value="거북이">
	<br>
	<br>
	<input type="reset" value="reset">
	<input type="submit" value="submit	">
		
	</form>
</body>
</html>