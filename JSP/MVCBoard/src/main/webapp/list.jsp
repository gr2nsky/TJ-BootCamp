<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Board</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
		<!-- items name은 command가 준다. -->
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td><a href="content_view.do?bId=${dto.bId }">${dto.bTitle }</a></td>
				<td>${dto.bDate }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4"><a href="write_view.do">글작성</a></td>
			</tr>
	</table>
</body>
</html>