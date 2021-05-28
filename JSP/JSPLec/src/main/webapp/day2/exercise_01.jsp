<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day 2</title>
</head>
<body>
	
	<!-- 서버사용량을 최소화하는게 jsp식 코딩이다. -->
	
	
	<!-- exercise 01 -->
	<%
		int total = 0;
	
		for (int i = 0; i <= 100; i++){
			total += i;
		}
		out.println("1 + 2 + 3 + ... + 99 + 100 = " + total + "<br>");
	%>	
	
	<!--  exercise 02 -->
	<%
		total = 100 * (100+1)/2;	
		out.println("1부터 100까지의 합 = " + total + "<br>");
		total = 200 * (200+1)/2;
		out.println("1부터 100까지의 합 = " + total + "<br>");
	%>
	<!-- exercise 02: 다른방법 -->
	<%
	int i = 1;
	total = 0;
	while(i<=100){
		total += i;
		i++;			
	}
	out.println("1부터 100까지의 합 = " + total);
	while(i<=200){
		total +=i;
		i++;
	}
	out.println("<br>1부터 200까지의 합 = " + total);
	%>

</body>
</html>