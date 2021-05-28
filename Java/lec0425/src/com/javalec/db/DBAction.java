package com.javalec.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.modle.Bean;

public class DBAction {
	
	int seqno;
	String name; 
	String telno;
	String address;
	String email;
	String relation;
	
	public DBAction() {
	}
	
	public DBAction(int seqno, String name, String telno, String address, String email, String relation) {
		this.seqno = seqno;
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}
	
	public DBAction(int seqno) {
		this.seqno = seqno;
	}
	
	public Connection mysqlConnect() {
		ConnectInfo ci = new ConnectInfo();
		Connection conn_mysql = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn_mysql = DriverManager.getConnection(ci.getUrl_mysql(), ci.getId_mysql(), ci.getPw_mysql());
			System.out.println("[mysqlConnect] mysql 연결 성공");
			
		}catch (Exception e) {
			System.out.println("[mysqlConnect] mysql 연결 실패");
			e.printStackTrace();
		}
		
		return conn_mysql;
	}
	
	//테이블의 모든 튜플을 출력
	public ArrayList<Bean> searchAll() {
		Connection conn_mysql = null;
        Statement stmt_mysql = null;
		ArrayList<Bean> beanList = new ArrayList<Bean>();
		
		
		String query = "select seqno, name, telno, relation from userinfo";
		
		try {
			conn_mysql = mysqlConnect();
			stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				int wrkSeq = rs.getInt(1);
				String wrkName = rs.getString(2);
				String wrkTelno = rs.getString(3);
				String wrkRelation = rs.getString(4);
				
				Bean bean = new Bean(wrkSeq, wrkName, wrkTelno, wrkRelation);
				beanList.add(bean);
			}
			System.out.println("[searchAll] 불러오기 성공");
			conn_mysql.close();
			System.out.println("[searchAll] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchAll] 불러오기 실패");
			e.printStackTrace();
		}

		return beanList;
	}
	
	//seqno로 셀렉
	public Bean tableClick() {
		Connection conn_mysql = null;
        Statement stmt_mysql = null;
		ResultSet rs = null;
		
		Bean bean = null;
		String query = "select seqno, name, telno, address, email, relation "
				+ "from userinfo where seqno = " + seqno ;
		
		try {
			conn_mysql = mysqlConnect();
			stmt_mysql = conn_mysql.createStatement();
			rs = stmt_mysql.executeQuery(query);
			
            while(rs.next()){
            	int wkseq = rs.getInt(1);
            	String wrkName = rs.getString(2);
            	String wrkTelno = rs.getString(3);
            	String wrkAddress= rs.getString(4);
            	String wrkEmail = rs.getString(5);
            	String wrkRelation = rs.getString(6);
            	
            	bean = new Bean(wkseq, wrkName, wrkTelno, wrkAddress, wrkEmail, wrkRelation);
            }

			System.out.println("[tableClick] 불러오기 성공");
            conn_mysql.close();
			System.out.println("[tableClick] mysql연결 종료");
			
		} catch (Exception e) {
			System.out.println("[tableClick] 불러오기 실패");
			e.printStackTrace();
		}
		
		
		return bean;
	}
}
