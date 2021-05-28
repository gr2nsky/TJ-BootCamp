<!-- 
	2021-05-06 윤재필
	java의 import처럼 지시자를 사용해 라이브러리를 사용할 수 있다.s
 -->

<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<titl>지시자</title>
</head>
<body>

<%
	//지시자 : page import="java.util.Arrays"
	int[] iArr = {10, 20, 30};
	out.println(Arrays.toString(iArr));
%>

</body>
</html>