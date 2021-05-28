<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>JDBC Driver Test</h2>

<%
	Connection conn = null;

	try{
		String url = "jdbc:mysql://localhost:3306/MakeAvengers";
		String user = "root";
		String password = "1q2w3e4r";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		out.print("MySQL Connection Complete");
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
%>

</body>
</html>