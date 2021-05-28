<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");	
	String pass = "false";
	
	// ---
	String url = "jdbc:mysql://localhost:/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	Connection conn = null;
	PreparedStatement ps = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		
		String query = "INSERT INTO wtest (userid) VALUES (?)";
		
		ps = conn.prepareStatement(query);
		ps.setString(1, userid);
		ps.executeUpdate();
		
		pass = "succ";
		
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	// ---
	
	response.sendRedirect("insertTest03.jsp?pass="+pass);
%>