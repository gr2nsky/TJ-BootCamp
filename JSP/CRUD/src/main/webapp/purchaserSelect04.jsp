<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");	
	String tel = request.getParameter("tel");	
	String address = request.getParameter("address");	
	
	
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
		
		String query = "DELETE FROM userinfo where seqno = ?";

		ps = conn.prepareStatement(query);
		ps.setString(1, (String)session.getAttribute("SEQNO"));
		ps.executeUpdate();
		
		session.invalidate();
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	// ---
	
	response.sendRedirect("purchaserSelect01.jsp");
%>