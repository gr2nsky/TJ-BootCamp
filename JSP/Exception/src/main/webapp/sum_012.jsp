<!-- 
	2021.5.12 윤재필
	sum_011.jsp로부터 입력받은 두 값을 더합니다.
	입력받은 값 연산이 오류가 난다면 sum_013.jsp로 이동합니다.
	try-catch에 dispactcher.forward를 사용해도 되지만,
	errorPage를 이용하는 방법이 훨씬 편하고 효율적입니다.
	
	<안좋은 예>
	int num1 = 0;
	int num2 = 0;
	int result = 0;
	try{
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		
		result = num1 + num2;
	}catch(Exception e){
		RequestDispatcher dispatcher = request.getRequestDispatcher("sum_013.jsp");
		dispatcher.forward(request, response);
	}
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="sum_013.jsp" %>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int result = num1 + num2;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈 결과</title>
</head>
<body>


<%=num1 %> + <%=num2 %> = <%=result %>


</body>
</html>