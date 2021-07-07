<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1">
		<form action="update" method="post">
			<input type="hidden" name="seqno" value="${ADto.seqno }">
			<tr>
				<td > 이름 </td>
				<td> <input type="text" name="name" value="${ADto.name }" size = "20"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td>
				<td> <input type="text" name="telno" value="${ADto.telno }" size = "20" > </td>
			</tr>
						<tr>
				<td > 주소 </td>
				<td> <input type="text" name="address" value="${ADto.address }" size = "20"> </td>
			</tr>
						<tr>
				<td > 이메일 </td>
				<td> <input type="text" name="email" value="${ADto.email }" size = "50"> </td>
			</tr>
			<tr>
				<td > 관계 </td>
				<td> <input type="text" name="relation" value="${ADto.relation }" size = "20"> </td>
			</tr>
			<tr >
				<td colspan="5"> <input type="submit" value="수정"> 
				&nbsp;&nbsp; 
				<a href="list">목록보기</a></td>
				&nbsp;&nbsp; 
				<a href="delete?seqno=${ADto.seqno}">삭제하기</a>
			</tr>
		</form>
</table>
</body>
</html>