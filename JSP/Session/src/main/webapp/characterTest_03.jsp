<!-- 
	2021.5.10 윤재필
	세선에 값 출력
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성격 테스트 결과</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String animal = request.getParameter("animal");
	session.setAttribute("ANIMAL", animal);
%>

	당신은 <%=session.getAttribute("FOOD") %>와 <%=session.getAttribute("ANIMAL") %>를 좋아하는 성격입니다!
	
<%
	//세션 종료
	session.invalidate();
%>
</body>
</html>