package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;

@Controller
public class BController {
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand wrtieCommand = null;
	private BCommand readCommand = null;
	private BCommand updateCommand = null;	
	private BCommand deleteCommand = null;
	
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand read, BCommand update, BCommand delete) {
		this.listCommand = list;
		this.wrtieCommand = write;
		this.readCommand = read;
		this.updateCommand = update;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.excute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		model.addAttribute("request", request);
		wrtieCommand.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		model.addAttribute("bId", request);
		readCommand.excute(model);
		
		return "content_view";
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		model.addAttribute("request", request);
		updateCommand.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		model.addAttribute("request", request);
		deleteCommand.excute(model);
		
		return "redirect:list";
	}


}
