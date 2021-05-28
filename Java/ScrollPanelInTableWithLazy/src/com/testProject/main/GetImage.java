package com.testProject.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class GetImage {
	//where
	String id;
	
 	public static final String url_mysql = "jdbc:mysql://192.168.2.2/makeavengers?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
    public static final  String id_mysql = "root";
    public static final String pw_mysql = "1q2w3e4r";
    
	public Connection mysqlConnect() {
//		ConnectInfo ci = new ConnectInfo();
		Connection conn_mysql = null;
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        System.out.println("mysql 연결성공");
			
		}catch (Exception e) {
			System.out.println("[mysqlConnect] mysql 연결 실패");
			e.printStackTrace();
		}
		
		return conn_mysql;
	}
	
	public ArrayList<CommentBean> getStudentImage() {
		System.out.println("[getStudentImage] 실행");
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CommentBean> beans = new ArrayList<CommentBean>();
		
		Connection conn_mysql = mysqlConnect();
		
		try{
	        String select = "SELECT s.id, s.name, s.photo, t.content ";
	        String from = "FROM student s ";
	        //dbswovlf2009는 입력값으로s 받도록 수정해
	        String leftJoin = "LEFT JOIN (SELECT * FROM comment WHERE comment.sender = 'dbswovlf2009') t ON s.id = t.taget ";
	        //팀 번호도 받아와야 
	        String where = "WHERE s.id IN (SELECT s.id FROM joining j, student s WHERE j.team_no = 1 AND j.student_id = s.id)";
	       
	        ps = conn_mysql.prepareStatement(select + from + leftJoin + where);
	        
	        rs = ps.executeQuery();
			while(rs.next()) {
				CommentBean bean = new CommentBean();
				bean.id = rs.getString(1);
				bean.name = rs.getString(2);
				bean.photo = ImageIO.read(rs.getBinaryStream(3));
				bean.content = rs.getString(4);
				
				beans.add(bean);
			}
	        
	        conn_mysql.close();
	        System.out.println("이미지 배열 반환성");
	        return beans;
	        
	    } catch (Exception e){                    
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public boolean commentInsert(String taget, String sender, String content){
		
        PreparedStatement ps = null;
        Statement stmt_mysql = null;
		Connection conn_mysql = mysqlConnect();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		String writing = year + "-" + month + "-" + date ;
        
        try{
			stmt_mysql = conn_mysql.createStatement();

//			INSERT INTO comment (taget, sender, content, writing, team_no) 
//			VALUES ('dbswovlf2009', 'crybaby', '고생이많아요', '2021-04-28', '1');
			
			
            String insert = "INSERT INTO comment (taget, sender, content, writing, team_no) ";
            //팀넘버 및 내 아이디 받아오도록 수정해야
            String values = "VALUES (?, ?, ?, ?, ?)";
            System.out.println("[commentInsert] qeury = " + insert + values);
            
          
        
            ps = conn_mysql.prepareStatement(insert + values);
            
            ps.setString(1, taget);
            ps.setString(2, sender);
            ps.setString(3, content);
            ps.setString(4, writing);
            ps.setInt(5, 1);
            
            ps.executeUpdate();
            System.out.println("[commentInsert] 수행완료");
            conn_mysql.close();
            System.out.println("[commentInsert] mysql연결 종료");
            return true;
        } catch (Exception e){                  
            e.printStackTrace();
            return false;
        }
	}
	
	//수
	public boolean commentUpdate(String taget, String sender, String content) {
		Connection conn_mysql = mysqlConnect();
		Statement stmt_myslq = null; 
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		String modify = year + "-" + month + "-" + date ;

		
		try {
			String update = "UPDATE comment SET content = '" + content + "', modify = '" + modify + "', team_no = '1' " ;
			String where = "WHERE taget = '"+ taget + "' AND sender = '" + sender + "'";
			System.out.println("[commentUpdate]query = " + update + where);

			stmt_myslq = conn_mysql.createStatement();
			stmt_myslq.executeUpdate(update + where);
			System.out.println("[commentUpdate] 업데이트 성공");
			conn_mysql.close();
			System.out.println("[commentUpdate] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
