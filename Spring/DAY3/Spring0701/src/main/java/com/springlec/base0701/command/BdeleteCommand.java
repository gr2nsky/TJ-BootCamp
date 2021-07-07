package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;

public class BdeleteCommand implements BCommand{
	
	private BDao dao = null;
	
	@Autowired
	public void setDoa(BDao dao) {
		this.dao = dao;
	}

	
	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		dao.delete(bId);

	}
}
