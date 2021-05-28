<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
	<%
		int a = 30;
		int b = 20;
		int addition = a + b;
		int sub = a - b;
		int mul = a * b;
		int div = a / b;
		int rem = a % b;
	%>
	
	<%=a %> + <%=b %> = <%=addition %> <br>
	<%=a %> - <%=b %> = <%=sub %> <br>
	<%=a %> * <%=b %> = <%=mul %> <br>
	<%=a %> / <%=b %> = <%=div %> <br>
	<%=a %> % <%=b %> = <%=rem %> <br>
	
	---------------------------------------------<br>
	
	<%
		out.println(a + " + " + b + " = " + (a + b) + "<br>");
		out.println(a + " - " + b + " = " + (a - b) + "<br>");
		out.println(a + " * " + b + " = " + (a * b) + "<br>");
		out.println(a + " / " + b + " = " + (a / b) + "<br>");
		out.println(a + " % " + b + " = " + (a % b) + "<br>");
	%>
	
		---------------------------------------------<br>
		
	<%
		for(int i = 1; i <= 9; i++){
			out.println("2 * " + i + " = " + (2 * i) + "<br>");
			out.println("==============================" + "<br>");
		}
	%>
		
	---------------------------------------------<br>
	
	<%
		int count = 1;
		while(count <= 9){
			out.println("2 * " + count + " = " + (2 * count) + "<br>");
			out.println("==============================" + "<br>");
			count ++;
		}
	%>
	
</body>
</html>