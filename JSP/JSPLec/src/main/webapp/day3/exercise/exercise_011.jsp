<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택</title>
</head>
<body>
	<form action="exercise_012.jsp" method="post">
		수량	<input type="text" name="nums" size="10">
		<br>
		크기
		<input type="radio" name="size" value="L"> 대
		<input type="radio" name="size" value="M"> 중
		<input type="radio" name="size" value="S"> 소	
		<br>
		색상
		<select name="color">
			<option value="beige"> 베이지
			<option value="brown"> 브라운
			<option value="khaki"> 카키
		</select>
		<br>
		<input type="submit" value="저장">
	</form>

</body>
</html>