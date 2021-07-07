package com.springlec.base0702.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0702.dao.OLDao;
import com.springlec.base0702.dto.OLDto;

public class OLListCommand implements OLCommand {
	
	private OLDao dao = null;
	
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
