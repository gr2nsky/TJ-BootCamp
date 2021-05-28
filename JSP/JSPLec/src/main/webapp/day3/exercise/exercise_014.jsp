<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	String str = null;
	BufferedReader reader = null;
	try{
		String filePath = application.getRealPath("/day3/exercise/ex1.txt");
		out.print(filePath + "<br>");
		reader = new BufferedReader(new FileReader(filePath));
		while(true){
			str = reader.readLine();
			if(str == null)
				break;
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	response.sendRedirect("exercise_015.jsp?str="+str);
%>
</body>
</html>