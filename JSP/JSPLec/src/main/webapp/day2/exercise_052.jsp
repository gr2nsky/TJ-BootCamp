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
	int age = Integer.parseInt(request.getParameter("age"));
	String pos = request.getParameter("pos");
%>

당신의 나이는 <%=age %>이므로 주류구매가 <%=pos %>합니다.
<br>

<a href="http://localhost:8080/JSPLec/day2/exercise_05.jsp">처음으로 돌아가기</a>
</body>
</html>