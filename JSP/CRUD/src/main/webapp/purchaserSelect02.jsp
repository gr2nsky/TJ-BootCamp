<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보 수정</title>
</head>
<body>
	<h4>내용을 수정 후 확인버튼을 누르세요</h4>
<%	
	request.setCharacterEncoding("utf-8");
	String seqno = request.getParameter("seqno");	
	String name = null;
	String telno = null;
	String address = null;	
	String email = null;	
	String relation = null;	

	//--
	String url = "jdbc:mysql://localhost:/useraddress?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	String whereStatement = "SELECT * from userinfo where seqno = " + seqno;
	
	Connection conn = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(whereStatement);
		while(rs.next()){
			session.setAttribute("SEQNO", rs.getString(1));
			name = rs.getString(2);
			telno = rs.getString(3);
			address = rs.getString(4);
			email = rs.getString(5);
			relation = rs.getString(6);
		}
		

	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	//--
%>

	아이디를 수정 후 확인 버튼을 누르세요.
	<form action="purchaserSelect03.jsp">
		<table>
			<tr>
				<td align="right">SeqNo : </td>
				<td><input type="text" name="userid" value=<%=seqno %> readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">성명 : </td>
				<td><input type="text" name="name" value=<%=name %>></td>
			</tr>
			<tr>
				<td align="right">전화번호 : </td>
				<td><input type="text" name="telno" value=<%=telno %>></td>
			</tr>
			<tr>
				<td align="right">주소 : </td>
				<td><input type="text" name="address" value=<%=address %>></td>
			</tr>
			<tr>
				<td align="right">전자우편 : </td>
				<td><input type="text" name="email" value=<%=email %>></td>
			</tr>
			<tr>
				<td align="right">관계 : </td>
				<td><input type="text" name="relation" value=<%=relation %>></td>
			</tr>
			<tr>
				<td><br><br></td>
				<td><br><br><input type="submit" value="수정"></td>
			</tr>			
		</table>
	</form>
	<form action="purchaserSelect04.jsp">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="삭제"></td>
			</tr>			
		</table>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>