<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아래의 항목을 입력 후 확인 버튼을 누르세요.</h2>
	
	<form action="purchaserSelect06.jsp" method="post">
		<table>
			<tr>
				<td align="right">성명 : </td>
				<td><input type="text" name="name" size="10"></td>
			</tr>
			<tr>
				<td align="right">전화번호 : </td>
				<td><input type="text" name="telno" size="15"></td>
			</tr>
			<tr>
				<td align="right">주소 : </td>
				<td><input type="text" name="address" size="20"></td>
			</tr>
			<tr>
				<td align="right">전자우편 : </td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td align="right">관계 : </td>
				<td><input type="text" name="relation" size="20"></td>
			</tr>
			<tr>
				<td><br><br></td>
				<td><br><br><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>