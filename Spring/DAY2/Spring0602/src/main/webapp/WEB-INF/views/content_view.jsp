<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<form action="update" method="post">
		<input type="hidden" name="bId" value="${dto.bId }">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${dto.bName }" size="20"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${dto.bTitle }" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10">${dto.bContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					&nbsp;&nbsp;
					<a href="list">목록</a>
					<a href="delete?bId=${dto.bId }">삭제</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>