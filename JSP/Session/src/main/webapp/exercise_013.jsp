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
	String result = request.getParameter("result");
	String pirntResult = "";
	String userID = "";
	String userPW = "";
	String name = "";
	
	if(result.equals("success")) {
		pirntResult = "되었습니다.";
		userID = (String)session.getAttribute("USER_ID");
		userPW = (String)session.getAttribute("USER_PW");
		name = (String)session.getAttribute("NAME");
	} else {
		pirntResult = "실패했습니다.";
	}

%>
	<!--  ${var} 왜 출력 안되지??? -->
	<h2>회원가입 결과</h2>
	가입 ${pirntResult} <%=pirntResult %>
	<br>
	<h2>가입 내용</h2>
	아이디 : ${userID} <%=userID %>
	<br>
	패스워드 : ${userPW} <%=userPW %>
	<br>
	성명 :  ${name} <%=name %>
</body>
</html>