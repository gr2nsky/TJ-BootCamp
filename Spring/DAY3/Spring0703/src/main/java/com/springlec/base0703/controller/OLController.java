package com.springlec.base0703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0703.command.OLCommand;
import com.springlec.base0703.util.Constant;

public class OLController {
	
	OLCommand command = null;
	private OLCommand listCommand = null;
	private OLCommand wrtieCommand = null;
	private OLCommand deleteCommand = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
	@Autowired
	public void auto(OLCommand list, OLCommand write, OLCommand delete) {
		this.listCommand = list;
		this.wrtieCommand = write;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.excute(model);
		return "list";
	}
	

}
