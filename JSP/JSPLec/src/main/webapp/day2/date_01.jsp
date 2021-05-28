<!-- 
	2021-05-06 윤재필
	날자 표기 방법
 -->
<%@page import="java.util.GregorianCalendar"%>
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
	GregorianCalendar now = new GregorianCalendar();
	String date = String.format("%TF", now); //yyyy-mm-dd
	String time = String.format("%TT", now); //hh:mm:ss
%>

	now - <%=now %>
	오늘 - <%=date %> <br>	
	현재시간 - <%=time %> <br>
	<%=String.format("%TY년 %Tm월 %Td일", now, now, now) %> <br>
	<%=String.format("%TH시 %TM분 %TS초", now, now, now) %>

</body>
</html>