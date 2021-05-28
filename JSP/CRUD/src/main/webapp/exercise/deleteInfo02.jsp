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
	String userid = request.getParameter("userid");	
	String name = null;
	String tel = null;
	String address = null;	

	//--
	String url = "jdbc:mysql://localhost:/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&userSSL=false";
	String user = "root";
	String password = "1q2w3e4r";
	
	String whereStatement = "SELECT * from purchaserinfo where userid = " + userid;
	
	Connection conn = null;
	Statement stmt = null;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(whereStatement);
		while(rs.next()){
			session.setAttribute("ID", rs.getString(1));
			name = rs.getString(2);
			tel = rs.getString(3);
			address = rs.getString(4);
		}
		

	} catch(Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
	//--
%>

	삭제할 정보를 확인 후 삭제버튼을 누르세요.
	<form action="deleteInfo03.jsp">
		<table>
			<tr>
				<td align="right">사용자 ID : </td>
				<td><input type="text" name="userid" value=<%=userid %> readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">성명 : </td>
				<td><input type="text" name="name" value=<%=name %> readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">전화번호 : </td>
				<td><input type="text" name="tel" value=<%=tel %> readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">주소 : </td>
				<td><input type="text" name="address" value=<%=address %> readonly="readonly"></td>
			</tr>
			<tr>
				<td><br><br></td>
				<td><br><br><input type="submit" value="삭제"></td>
			</tr>
		</table>
	</form>
</body>
</html>