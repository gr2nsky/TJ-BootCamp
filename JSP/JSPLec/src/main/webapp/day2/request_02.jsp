<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반갑습니다</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	안녕하세요, <%=request.getParameter("yourName") %>님!
	안녕하세요, <%=request.getParameter("yourName2") %>님!
	
</body>
</html>