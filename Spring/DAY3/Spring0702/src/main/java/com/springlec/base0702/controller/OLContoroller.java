package com.springlec.base0702.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0702.command.OLCommand;
import com.springlec.base0702.dto.OLDto;
import com.springlec.base0702.util.Constant;

@Controller
public class OLContoroller {
	
	JdbcTemplate template;
	
	OLCommand command = null;
	private OLCommand listCommand = null;
	private OLCommand insertCommand = null;
	private OLCommand deleteCommand = null;
	
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	public void setCommand(OLCommand list, OLCommand insert, OLCommand delete) {
		this.listCommand = list;
		this.insertCommand = insert;
		this.deleteCommand = delete;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.excute(model);
		return "list";
	}
	
	@RequestMapping("/insert")
	public String insert(Model model) {
		System.out.println("insert()");
		return "insert";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model) {
		System.out.println("delete()");
		return "delete";
	}

}
