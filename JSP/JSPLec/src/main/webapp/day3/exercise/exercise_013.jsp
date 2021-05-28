<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>상품 선택 저장 결과</h2>
	<%
		String str = request.getParameter("result");
		if(str.equals("success")){
			out.print("저장되었습니다.");
		} else {
			out.print("저장에 실패했습니다.");
		}
	%>
	
	<input type="button" onClick="location.href='exercise_014.jsp'" value="저장결과 불러오기">


</body>
</html>