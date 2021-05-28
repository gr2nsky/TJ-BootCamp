<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Date today = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String todayString = df.format(today);

	String userid = request.getParameter("userid");	
	String name = request.getParameter("name");	
	String tel = request.getParameter("tel");	
	String address = request.getParameter("address");	
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
		
		String query = "INSERT INTO purchaserinfo (userid, name, tel, address, insertdate) VALUES (?, ?, ?, ?, ?)";
		
		ps = conn.prepareStatement(query);
		ps.setString(1, userid);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, address);
		ps.setString(5, todayString);
		ps.executeUpdate();
		
		pass = "succ";
		//session에 입력하기 (name은 보통 대문자)
		session.setAttribute("USERID", userid);
		session.setAttribute("NAME", name);
		session.setAttribute("TEL", tel);
		session.setAttribute("ADDRESS", address);
		session.setAttribute("PASS", pass);
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	// ---
	response.sendRedirect("purchaserinfo03.jsp");
%>

