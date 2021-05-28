<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보 수정</title>
</head>
<body>
	<h4>아이디를 수정 후 확인버튼을 누르세요</h4>
<%	
	String id = request.getParameter("id");	
	String userid = null;

	//--
	String url = "jdbc:mysql://localhost:/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	String whereStatement = "SELECT userid from wtest where id = " + id;
	
	Connection conn = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(whereStatement);
		while(rs.next()){
			userid = rs.getString(1);
		}
		session.setAttribute("ID", id);
		session.setAttribute("OLD", userid);
		

	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	//--
%>

	아이디를 수정 후 확인 버튼을 누르세요.
	<form action="updateTest03.jsp">
		사용자ID <input type="text" name="userid">
		<input type="submit" value="확인">
	</form>
</body>
</html>