package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		System.out.println("Connecting to database...");
		try {
			//context xml 연결
			Context context = new InitialContext();
			//java:comp/env :내부소스 접근
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mvc");
			System.out.println("Database connection success");
		} catch (Exception e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> list(){
		ArrayList<BDto> bdtos = new ArrayList<BDto>();
		
		String query = "SELECT * FROM mvc_board";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()){
				
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				
				BDto bdto = new BDto(bId, bName, bTitle, bContent, bDate);
				bdtos.add(bdto);
			}
			
		} catch (Exception e) {
			System.out.println("<list-data load Fail>");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("< rs, psmt, conn close Fail>");
				e.printStackTrace();
			}
		}
		
		return bdtos;
	}
	
	public void write(String bName, String bTitle, String bContent) {
		
		String query = "INSERT INTO mvc_board (bName, bTitle, bContent, bDate) VALUES (?, ?, ?, now())";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
				
			psmt.setString(1, bName);
			psmt.setString(2, bTitle);
			psmt.setString(3, bContent);
			
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("<data insert Fail>");
			e.printStackTrace();
		} finally {
			try {
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("< psmt, conn close Fail>");
				e.printStackTrace();
			}
		}
	}
	
	public BDto contentView(String strId) {
		BDto bdto = null;
		String query = "SELECT * FROM mvc_board where bId = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(strId));
			rs = psmt.executeQuery();
			
		if(rs.next()){
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				
				bdto = new BDto(bId, bName, bTitle, bContent, bDate);
			}
			
		} catch (Exception e) {
			System.out.println("<content-data load Fail>");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("< rs, psmt, conn close Fail>");
				e.printStackTrace();
			}
		}
		
		return bdto;
	}
	
	public void modify(String strId, String bName, String bTitle, String bContent) {
		
		String query = "UPDATE mvc_board SET bname = ?, bTitle = ?, bContent = ?, bDate = now() Where bId = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			psmt.setString(1, bName);
			psmt.setString(2, bTitle);
			psmt.setString(3, bContent);
			psmt.setInt(4, Integer.parseInt(strId));
			
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("<data insert Fail>");
			e.printStackTrace();
		} finally {
			try {
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("< psmt, conn close Fail>");
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String strId) {
		String query = "DELETE FROM mvc_board WHERE bId = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(strId));
			
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("<data delete Fail>");
			e.printStackTrace();
		} finally {
			try {
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("< psmt, conn close Fail>");
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
