package mysqlResultTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.swing.DB.ShareVar;

public class Main {
	//database connection info
	ShareVar sv = new ShareVar();
	
	//연결에 성공/실패한 Connection 객체를 반환
	public Connection mysqlConnect() {
		Connection conn_mysql = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn_mysql = DriverManager.getConnection(sv.url_mysql, sv.id_mysql, sv.pw_mysql);
			System.out.println("[mysqlConnect] mysql 연결 성공");
		}catch (Exception e) {
			System.out.println("[mysqlConnect] mysql 연결 실패");
			e.printStackTrace();
		}
		return conn_mysql;
	}
	
	public static void main(String[] args) {
	    
		
	}
	
	//모든 프로젝트 목록 출력
	public ArrayList<String[]> selectAllProject() {
		String query = "SELECT * FROM project ORDER BY no ASC";
		ArrayList<String[]> beans = new ArrayList<String[]>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query);
			
			while(rs.next()) {
				String no = Integer.toString(rs.getInt(1));
				String[] temp = {no, rs.getString(2), rs.getString(3)};
				beans.add(temp);
			}
			System.out.println("[searchUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchUser] 불러오기 실패");
			e.printStackTrace();
		}
		return beans;
	}
	
	//프로젝트 추가
	public boolean insertProject(String name) {
		String query = "INSERT INTO project (name, creation) VALUES (?, ?);";
		
		try {
			mysqlConnect();
			ps = conn_mylsq.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, getDate());
			
			ps.executeUpdate();
			System.out.println("[insertProject] 입력 성공");
			conn_mylsq.close();
			System.out.println("[insertProject] mysql연결 종료");
			return true;
		}catch (Exception e) {
			System.out.println("[insertProject] 입력실패");
			e.printStackTrace();
			return false;
		}
	}
	
	//기존 프로젝트 업데이트
	public boolean updateProject(int no, String name) {
		String query1 = "UPDATE project SET name = '" + name + "' WHERE no = " + no;
		
		try {
			mysqlConnect();
			
			stmt_myslq.executeUpdate(query1);
			System.out.println("[updateProject] 업데이트 성공");
			conn_mylsq.close();
			System.out.println("[updateProject] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			System.out.println("[updateProject] 업데이트 실패");
			e.printStackTrace();
		}
		return false;
	}
	
	//프로젝트 삭제
	public boolean deleteProject(int no) {
		String query = "DELETE FROM project WHERE no = " + no;
		
		try {
			mysqlConnect();
			
			stmt_myslq.executeUpdate(query);
			System.out.println("[deleteProject]삭제 성공");
			conn_mylsq.close();
			System.out.println("[deleteProject] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			System.out.println("[deleteProject]삭제 실패");
			e.printStackTrace();
		}
		
		return false;
	}
	
	//헤당 프로젝트의 팀 출력
	public ArrayList<String[]> selectTeamOnProject() {
		String select = "SELECT t.no, t.name, t.project_git_address ";
		String from = "FROM do d, team t";
		String where = "WHERE d.project_no = 1 AND d.team_no = t.no;";
		
		ArrayList<String[]> beans = new ArrayList<String[]>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(select + from + where);
			
			while(rs.next()) {
				String no = Integer.toString(rs.getInt(1));
				String[] temp = {no, rs.getString(2), rs.getString(3)};
				beans.add(temp);
			}
			System.out.println("[searchUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchUser] 불러오기 실패");
			e.printStackTrace();
		}
		return beans;
	}
	//해당 팀의 팀원들을 출력
	public ArrayList<String> selectStudentInTeam() {
		String select = "SELECT s.name ";
		String from = "FROM joining j, student s";
		String where = "WHERE j.team_no = 1 AND j.student_id = s.id AND j.secession IS NULL";
		
		ArrayList<String> beans = new ArrayList<String>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(select + from + where);
			
			while(rs.next()) {
				beans.add(rs.getString(1));
			}
			System.out.println("[searchUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchUser] 불러오기 실패");
			e.printStackTrace();
		}
		return beans;
	}
	
	// return yyyy-mm-dd
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		return year + "-" + month + "-" + date ;
	}
 	
}
