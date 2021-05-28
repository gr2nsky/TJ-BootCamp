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

	<h2>주소록 명단 리스트</h2>
	<br>
	<form action="purchaserSelect07.jsp" method="post">
		검색 선택 : 
		<select name="conditionType">
			<option value="name">이름
			<option value="telno">전화번호
			<option value="address" selected="selected">주소
			<option value="email">이메일
			<option value="relation">관계
		</select>
		<input type="text" name="conditionInput">
		<input type="submit" value="검색">
	</form>
	<br>
	<br>
	<hr>
<%	
	int count = 0;
	//--
	String url = "jdbc:mysql://localhost:/useraddress?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	String condition = (String)session.getAttribute("TYPE");
	String query = null;
	
	if (condition == null){
		query = "SELECT * from userinfo";
	} else {
		String conditionInput= (String)session.getAttribute("INPUT");
		String query1 = "SELECT * from userinfo ";
		String query2 = "WHERE " + condition + " LIKE '%" + conditionInput + "%'";
		
		query = query1 + query2;
	}
	
	
	Connection conn = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
%>
	<table border="1">
		<tr>
			<th>Seq</th><th>이름</th><th>전화번호</th><th>주소</th><th>전자우편</th><th>관계</th>
		</tr>
<%
		while(rs.next()){
			count ++;
%>
		<tr>
			<td><a href = "purchaserSelect02.jsp?seqno=<%=rs.getString(1) %>"> <%=rs.getString(1) %> </a></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
		</tr>
<%
		}

	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	//--
	session.invalidate();
%>
	</table>
<%
		if (count > 0) {
			int numOfPage = count / 5;
			for (int i = 1; i <= numOfPage + 1; i++){
%>
	<a href = "purchaserSelect01.jsp"> <%=i %> </a>
<%
			}
		}
%>
	<br>
	<form action="purchaserSelect05.jsp" method="post">
		<input type="submit" value="입력">
	</form>
	<hr>
	<br>
	총 인원은 <%=count %>명 입니다.
</body>
</html>