<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");	
	String telno = request.getParameter("telno");	
	String address = request.getParameter("address");	
	String email = request.getParameter("email");	
	String relation = request.getParameter("relation");
	
	// ---
	String url = "jdbc:mysql://localhost:/useraddress?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	Connection conn = null;
	PreparedStatement ps = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		
		String query = "INSERT INTO userinfo (name, telno, address, email, relation) VALUES (?, ?, ?, ?, ?)";
		
		ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, telno);
		ps.setString(3, address);
		ps.setString(4, email);
		ps.setString(5, relation);
		ps.executeUpdate();
		
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	// ---
	response.sendRedirect("purchaserSelect01.jsp");
%>

