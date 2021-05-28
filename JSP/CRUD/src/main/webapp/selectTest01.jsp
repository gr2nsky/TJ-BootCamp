<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select test</title>
</head>
<body>
<%	
	int count = 0;
	//--
	String url = "jdbc:mysql://localhost:/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	String whereStatement = "SELECT * from purchaserinfo";
	
	Connection conn = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(whereStatement);
%>

	<table border="1">
		<tr>
			<th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th><th>입력일자</th>
		</tr>
<%
		while(rs.next()){
			count ++;
%>
		<tr>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
		</tr>
<%
		}

	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	//--
%>
	</table>
	<br>
	<br>
	총 인원은 <%=count %>명 입니다.
</body>
</html>