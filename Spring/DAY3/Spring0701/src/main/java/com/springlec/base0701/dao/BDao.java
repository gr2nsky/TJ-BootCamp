package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {

	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<BDto> list(){
		String query = "SELECT * FROM mvc_board";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?, ?, ?, now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
				return preparedStatement;
			}
		});
	}
	
	public BDto content(int bId) {
		String query = "SELECT * FROM mvc_board where bId = " + bId;
		//원래 순서-값 쌍을 매치해주는 작업이 따로 필요한데 순서랑 값 타입이 같으면 이대로만 써도 가능함
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	
	public void update(final int bId, final String bName, final String bTitle, final String bContent) {
		String query = "UPDATE mvc_board SET bName = ?, bTitle = ?, bContent = ?, bDate = now() WHERE bId = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
				
			}
		});
	}
	
	public void delete(final int bId) {
		String query = "DELETE FROM mvc_board WHERE bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bId);
			}
		});
	}
}
