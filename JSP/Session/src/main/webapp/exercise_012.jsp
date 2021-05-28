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
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String name = request.getParameter("name");
	
	session.setAttribute("USER_ID", userID);
	session.setAttribute("USER_PW", userPW);
	session.setAttribute("NAME", name);
	
%>


<h2>약관</h2>
--------------------------------------------
<br>
1. 회원정보는 웹사이트의 운영을 위해서만 사용됩니다.
<br>
2. 웹사이트 정상 운영읇 방해하는 회원은 탈퇴처리 됩니다.
<br>
--------------------------------------------
<br>
위의 약관에 동의 하십니까?
<br><br>
<form action="exercise_013.jsp" method="get">
	<input type="radio" name="result" value="success" > 동의함
	<input type="radio" name="result" value="fail"> 동의하지 않음
	<br><br>
	<input type="submit" value="OK">
</form>


</body>
</html>