/*
 * 최종작성일자 4.21 / 작성자 윤재필
 * CRUD 구현 완료
 */

package com.javalec.modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMS {
	final String ipAddress = "192.168.2.2";
	final String url_mysql = "jdbc:mysql://" + ipAddress + "/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	final String id_mysql = "root";
	final String pw_mysql = "1q2w3e4r";
	
	Connection conn_mylsq = null;
	PreparedStatement ps = null;
	Statement stmt_myslq;
	
	//mysql 연결
	public void mysqlConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn_mylsq = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			stmt_myslq = conn_mylsq.createStatement();
			System.out.println("[mysqlConnect] mysql 연결 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//input에 저장된 데이터로 새 튜플을 생성
	public boolean insertUserInfo(String[] input) {
		String query = "insert into userinfo (name, telno, address, email, relation) values (?, ?, ?, ?, ?)";
		
		try {
			mysqlConnect();
			ps = conn_mylsq.prepareStatement(query);
			for (int i = 1; i <= 5; i ++) {
				ps.setString(i, input[i - 1]);
			}
			ps.executeUpdate();
			System.out.println("[insertUserInfo] 입력 성공");
			conn_mylsq.close();
			System.out.println("[insertUserInfo] mysql연결 종료");
			return true;
		}catch (Exception e) {
			System.out.println("[insertUserInfo] 입력실패");
			e.printStackTrace();
			return false;
		}
	}
	
	//테이블의 모든 튜플을 출력
	public ArrayList<String[]> searchUser() {
		String query = "select seqno, name, telno, relation from userinfo";
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query);
			
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				result.add(qTxt);
			}
			System.out.println("[searchUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchUser] 불러오기 실패");
			e.printStackTrace();
		}

		return result;
	}
	//해당 seqNo에 해당하는 튜플을 출력
	public ArrayList<String> searchOneUser(String seqNo) {
		System.out.println("[searchOneUser] 시작");
		String query = "select seqno, name, telno, address, email, relation from userinfo where seqno = " + seqNo ;
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query);
			
			if (rs.next()) {
				for (int i = 1; i <= 6; i++) {
					result.add(rs.getString(i));
				}
			}
			
			System.out.println("[searchOneUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchOneUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchOneUser] 불러오기 실패");
			e.printStackTrace();
		}

		return result;
	}
	
	//type 속성에서 input 보유한 튜플 출력
	public ArrayList<String[]> conditionQueryAction(String type, String input) {
		ArrayList<String[]> rsArr = new ArrayList<String[]>();
		String query1 = "select seqno, name, telno, relation from userinfo ";
		String query2 = "where " + type + " like '%" + input + "%'";
		System.out.println(query1 + "\n" + query2);
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query1 + query2);
			
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				rsArr.add(qTxt);
			}
			
			System.out.println("[conditionQueryAction] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[conditionQueryAction] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[conditionQueryAction] 불러오기 실패");
			e.printStackTrace();
		}
		
		return rsArr;
	}
	
	//해당 seqno에 해당하는 데이터 삭제
	public boolean deleteAddress(String seqno) {
		String query = "delete from userinfo where seqno = " + seqno;
		System.out.println("[deleteAddress] query : " + query);
		
		try {
			mysqlConnect();
			
			stmt_myslq.executeUpdate(query);
			System.out.println("[deleteAddress]삭제 성공");
			conn_mylsq.close();
			System.out.println("[deleteAddress] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			System.out.println("[deleteAddress]삭제 실패");
			e.printStackTrace();
		}
		
		return false;
	}
	
	//seqno의데이터를 수정
	public boolean updateAddress(String seqno, ArrayList<String> data) {
		String query1 = "update userinfo ";
		String query2 = "set name = '" + data.get(1) + "', telno = '" + data.get(2) + 
				"', address = '" + data.get(3) + "', email = '" + data.get(4) + "', relation = '" + data.get(5) + "' ";
		String query3 = "where seqno = " + seqno;
		System.out.println("[deleteAddress] query \n" + query1 + "\n" + query2 + "\n" + query3);
		
		try {
			mysqlConnect();
			
			stmt_myslq.executeUpdate(query1 + query2 + query3);
			System.out.println("[updateAddress] 업데이 성공");
			conn_mylsq.close();
			System.out.println("[updateAddress] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			System.out.println("[updateAddress] 업데이트 실패");
			e.printStackTrace();
		}
		return false;
	}
}
