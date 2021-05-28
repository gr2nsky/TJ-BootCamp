<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1단</title>
</head>
<body>
    <h2>이미지를 업로드해 주세요.</h2>
    <form action="fileUploadAction.jsp" method="post" enctype="multipart/form-data">
      Title : <input type="text" name="title">
      <br>
      Content : <input type="text" name="content">
      <br>
      Image : <input type="file" name="uploadfile" >
      <br>
      <br>
      <input type="submit" value="submit" >
    </form>
</body>
</html>
