<%@page import="java.net.URLEncoder"%>
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
		int age = Integer.parseInt(request.getParameter("age"));
		String pos;
		if (age <= 19) {
			pos = "불가능";
		} else {
			pos = "가능";
		}
		String encodedValue=URLEncoder.encode(pos,"UTF-8");
		
		
		response.sendRedirect("http://localhost:8080/JSPLec/day2/exercise_052.jsp?age=" + age +"&pos=\"" + encodedValue +"\"");
	%>

</body>
</html>