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
		int num1, num2, num3, num4;
		request.setCharacterEncoding("utf-8");
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		num3 = Integer.parseInt(request.getParameter("num3"));
		num4 = Integer.parseInt(request.getParameter("num4"));
	%>
	
	
	<%=num1 %> + <%=num2 %> = <%=(num1+num2) %> 
	<br>
	<%=num3 %> x <%=num4 %> = <%=(num1*num2) %>

</body>
</html>