<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of saving the file</title>
</head>
<body>

<h2>Result of saving the file</h2>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	String fileName = "file.txt";
	
	PrintWriter writer = null;
	try{
		String filePath = application.getRealPath("/day3/" + fileName);
		writer = new PrintWriter(filePath);
		writer.println("제목 : " + title);
		writer.println("작성자 : " + name);
		writer.println(content);
		out.print("저장되었습니다.");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			//사실상 close시 파일에 쓰여진다.
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</body>
</html>