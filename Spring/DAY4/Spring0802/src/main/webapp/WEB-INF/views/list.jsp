<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 조건 리스트</title>
</head>
<body>

<!-- mybatis에서 대문자로 쓰므로 같이 대문자로 써준다 -->
<h3>3MyBatis 주소록 조건 검색</h3>
<form action="listQuery" method="post">
	검색선택
	<select name="query">
		<option value="ADDRESS">주소</option>
		<option value="RELATION">관계</option>
	</select> %nbsp; %nbsp; %nbsp;
	<input type="text" name="content" size="30">
	<input type="submit" value="검색">
</form>

<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>주소</td>
		<td>이메일</td>
		<td>관계</td>
	<tr>
	<c:set var="cnt" value="0"></c:set>
	<c:forEach items="${list}" var="ADto">
	<tr>
		<td><a href="content_view?seqno=${ADto.seqno}">${ADto.seqno}</a></td>
		<td>${ADto.name}</td>
		<td>${ADto.telno}</td>
		<td>${ADto.address}</td>
		<td>${ADto.email}</td>
		<td>${ADto.relation}</td>
	<tr>
	<c:set var="cnt" value="${cnt=cnt+1 }"></c:set>
	</c:forEach>
</table>
<br><br>
<p>검색 결과는 <b>${cnt }</b>명 입니다.</p>

<p><a href="writeForm">주소록 등록</a></p>
</body>
</html>