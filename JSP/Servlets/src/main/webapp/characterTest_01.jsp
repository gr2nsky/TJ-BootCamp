<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>성격 테스트</h2>
당신의 성격을 테스트 합니다. 데이터를 입력한 후 확인 버튼을 눌러주세요.<br>
<form action="characterTest_01S" method="get">
	이름 <input type="text" name="name">
	<br>
	좋아하는 색 
	<input type="radio" name="color" value="노랑색" checked="checked"> 노랑
	<input type="radio" name="color" value="빨강색"> 빨강
	<input type="radio" name="color" value="파랑색"> 파랑
	<br>
	좋아하는 동물
	<select name="animal">
		<option value="호랑이">호랑이</option>
		<option value="얼룩말">얼룩말</option>
		<option value="치타">치타</option>
		<option value="사자">사자</option>
	</select>
	<br>
	좋아하는 음식 (모두 고르기)
	<input type="checkbox" name="food" value="짜장면"> 짜장면
	<input type="checkbox" name="food" value="탕수육"> 탕수육
	<input type="checkbox" name="food" value="짬뽕"> 짬뽕
	<input type="submit" value="확인">
</form>
</body>
</html>