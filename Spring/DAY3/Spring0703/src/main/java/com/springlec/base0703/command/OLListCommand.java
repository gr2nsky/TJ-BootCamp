package com.springlec.base0703.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0703.dao.OLDao;
import com.springlec.base0703.dto.OLDto;

public class OLListCommand implements OLCommand {
	
	private OLDao dao;
	
	@Autowired
	public void setDao(OLDao dao) {
		this.dao = dao;
	}

	@Override
	public void excute(Model model) {
		ArrayList<OLDto> dtos = dao.list();
		model.addAttribute("list", dtos);

	}

}
