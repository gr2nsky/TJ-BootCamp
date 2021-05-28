<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력결과</title>
</head>
<body>
<%
	String pass = request.getParameter("pass");	
	String result = "fail";
	if (pass == "succ"){
		result = "Complete";
	}
%>
	<H2>입력결과</H2>
	<%=result %>
</body>
</html>