<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>입력에 성공헀습니다.</h3>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3");
		String email = request.getParameter("email");
	%>
	<p>아이디 : ${id} <%=id %></p>
	<br>
	<p>비밀번호 : ${pw} <%=pw %></p>
	<br>
	<p>이름 : ${name} <%=name %></p>
	<br>
	<p>연락처 : ${phone} <%=phone %></p>
	<br>
	<p>이메일 : ${email} <%=email %></p>
</body>
</html>