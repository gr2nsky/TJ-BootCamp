package com.springlec.base0702.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springlec.base0702.dto.OLDto;
import com.springlec.base0702.util.Constant;

public class OLDao {
	
	JdbcTemplate template;
	
	public OLDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<OLDto> list(){
		String query = "SELECT * FROM board";
		return (ArrayList<OLDto>) template.query(query, new BeanPropertyRowMapper<OLDto>(OLDto.class));
	}

	
}
