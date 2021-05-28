<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File preview</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body>
<hr>
    <input type="button" value="업로드 폴더 초기화" onclick="location.href='fileDelete.jsp'">
<hr>

<form action="fileUploadAction.jsp" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="title">
	<br>
	제목 : <input type="text" name="content">
	<br>
	이미지 : <input type="file" name="uploadfile" onchange="readURL(this);">
	<br>
	<img id="blah" src="http://placehold.it/180" alt="your_image" style="width:100px" />
	<br>
	<input type="submit" value="submit" >
</form>
    <script>

      function readURL(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();

          reader.onload = function (e) {
            $('#blah')
              .attr('src', e.target.result);
          };

          reader.readAsDataURL(input.files[0]);
        }
      }
    </script>
</body>
</html>