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
	 public int decAdd(int a, int b){
		return a + b;
	}
%>

	2 + 1 = <%=decAdd(2,1) %> <br>
	3 + 1 = <%=decAdd(3,1) %> <br>
	4 + 1 = <%=decAdd(4,1) %> <br>
	5 + 1 = <%=decAdd(5,1) %> <br>
</body>
</html>