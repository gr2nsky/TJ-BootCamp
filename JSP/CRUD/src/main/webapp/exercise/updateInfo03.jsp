<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pass = "false";
	String name = request.getParameter("name");	
	String tel = request.getParameter("tel");	
	String address = request.getParameter("address");	
	
	
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
		
		String query = "UPDATE purchaserinfo SET ";
		String query2 = "name = ?, tel = ?, address = ? ";
		String query3 = "where userid = ?";
		

		ps = conn.prepareStatement(query + query2 + query3);
		ps.setString(1, name);
		ps.setString(2, tel);
		ps.setString(3, address);
		ps.setString(4, (String)session.getAttribute("ID"));
		ps.executeUpdate();
		
		pass = "succ";
		session.setAttribute("PASS", pass);
		session.setAttribute("NAME", name);
		session.setAttribute("TEL", tel);
		session.setAttribute("ADDRESS", address);
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	// ---
	
	response.sendRedirect("updateInfo04.jsp");
%>