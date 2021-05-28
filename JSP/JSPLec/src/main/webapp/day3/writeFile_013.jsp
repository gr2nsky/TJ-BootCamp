<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of saving the file</title>
</head>
<body>
	<h2>Result of saving the file</h2>
	
	<%
		String str = request.getParameter("result");
		if(str.equals("success")){
			out.print("저장되었습니다.");
		} else {
			out.print("저장에 실패했습니다.");
		}
	%>
</body>
</html>