<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String nums = request.getParameter("nums");
	String size = request.getParameter("size");
	String color = request.getParameter("color");
	
	String fileName = "/day3/exercise/ex1.txt";
	String result = null;
	PrintWriter writer = null;
	
	try{
		String filePath = application.getRealPath(fileName);
		out.print(filePath);
		writer = new PrintWriter(filePath);
		writer.println("수량 : " + nums);
		writer.println("사이즈 : " + size);
		writer.println("컬러 : " + color);
		result = "Success";
	}catch(Exception e){
		e.printStackTrace();
		result = "fail";
	}finally{
		try{
			//사실상 close시 파일에 쓰여진다.
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	response.sendRedirect("exercise_013.jsp?result="+result);
%>
</body>
</html>