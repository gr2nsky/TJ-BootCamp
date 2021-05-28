<!-- 
	2021-05-06 윤재필
	%! 태그를 사용하는 선언부를 써 메서드를 정의하는 방법 
	 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 선언부의 위치는 자유롭다. 메서드는 반드시 선언부에 작성해야 함. -->

<%
	int i = 10;
	String str = "i have a dream";
	
	out.println("i = " + i + "<br>");		
	out.println("str = " + str + "<br>");		
	out.println("sum = " + sum(12, 15) + "<br>");		
%>

</body>
</html>

<%!
	public int sum(int a, int b){
		
		return a + b;
	}
%>