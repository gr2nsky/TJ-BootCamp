package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BdeleteCommand;
import com.springlec.base0601.command.BreadCommand;
import com.springlec.base0601.command.BupdateCommand;
import com.springlec.base0601.command.BwriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.excute(model);
		
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
		command = new BwriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("bId", request);
		command = new BreadCommand();
		command.excute(model);
		
		return "content_view";
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		
		model.addAttribute("request", request);
		command = new BupdateCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BdeleteCommand();
		command.excute(model);
		
		return "redirect:list";
	}


}
