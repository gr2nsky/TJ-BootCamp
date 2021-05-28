<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	public int powpow(int a, int b){
		int result = (int)Math.pow(a, b);
		return result;	
	}
%>

<%
	for (int i = 1; i <= 5; i++){
		out.println(" 2 ^ " + i + " = " + powpow(2, i) + "<br>");
	}
%>




</body>
</html>