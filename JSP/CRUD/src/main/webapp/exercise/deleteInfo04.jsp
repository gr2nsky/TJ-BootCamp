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
	String pass = (String)session.getAttribute("PASS");
	String useris = (String)session.getAttribute("ID");
	
	String result = "되지 않았습니다.";
	if (pass == "succ"){
		result = "되었습니다. 감사합니다.";
	}
%>
	<table>
		<tr>
			<td align="right">사용자 ID : </td>
			<td>${ID }</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	상기의 정보로 삭제<%=result %>
	
	<% session.invalidate(); %>

</body>
</html>