<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload action</title>
</head>
<body>
<%
	//3mb로 파일 크기를 제한 
    int fileSize = 1024*1024*3; 
    ServletContext context = getServletContext();
    String uploadPath = context.getRealPath("/save");
%>
업로드 경로 : <%=uploadPath %><br>

<%
	MultipartRequest multi = null;

    try{
      multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",new DefaultFileRenamePolicy());
      String title = multi.getParameter("title");
      String content = multi.getParameter("content");
      String originalFile = multi.getOriginalFileName("uploadfile");
      String uploadFile = multi.getFilesystemName("uploadfile");
%>

<h1>읽어온 데이터 출력하기</h1>
제목 : <%=title %><br>
내용 : <%=content %><br>
오리지날 파일명 : <%=originalFile %><br>
실제 업로드된 파일명 : <%=uploadFile %><br><Br>
<h3>업로드된 파일 불러오기</h3>
<img width="300" src="save/<%=uploadFile %>"/>
<a href="save/<%=uploadFile %>" download>다운로드</a>

<%
    }catch(Exception e){
      e.printStackTrace();
    }

%>

<hr>
    <input type="button" value="업로드 폴더 초기화" onclick="location.href='fileDelete.jsp'">
<hr>
</body>
</html>