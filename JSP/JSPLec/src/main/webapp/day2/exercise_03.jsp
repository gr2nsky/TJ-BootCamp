<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="exercise_03_print.jsp" method="get" >
		<input type="text" name="num1">	+ <input type="text" name="num2">
		<br>
		<select name="num3">
			<% 
				for (int i = 1; i <= 999; i++) {
					out.println("<option value=" + i + ">" + i + "</option>");
				}	
			%>
		</select> x
		<select name="num4">
			<% 
				for (int i = 1; i <= 999; i++) {
					out.println("<option value=" + i + ">" + i + "</option>");
				}	
			%>
		</select>
		<br>
		
		<input type="submit" value="OK">
	</form>
	


</body>
</html>