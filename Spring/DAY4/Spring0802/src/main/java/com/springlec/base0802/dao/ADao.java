package com.springlec.base0802.dao;

import java.util.ArrayList;

import com.springlec.base0802.dto.ADto;

public interface ADao {
	public ArrayList<ADto> listDao();
	public void writeDao(String name, String telno, String address, String email, String relation);
	public ADto contentDao(int seqno);
	public void updateDao(int seqno, String name, String telno, String address, String email, String relation);
	public void deleteDao(int seqno);
	public ArrayList<ADto> listQuery(String query, String content);
}
