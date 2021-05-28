<!-- 
	items에 db array가 들어올거야. 잊지마!
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 식사 메뉴</title>
</head>
<body>
	<h3>점심메뉴 표</h3>
	<ul>
		<c:forEach var="dish" items="${MENU }">
			<li>${dish}</li>
		</c:forEach>
	</ul>
</body>
</html>