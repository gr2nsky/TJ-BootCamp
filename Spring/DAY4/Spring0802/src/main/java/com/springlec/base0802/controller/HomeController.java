package com.springlec.base0802.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.base0802.command.ACommand;
import com.springlec.base0802.command.AListCommand;
import com.springlec.base0802.dao.ADao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	ACommand command = null;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ADao dao = sqlSession.getMapper(ADao.class);
//		model.addAttribute("list", dao.listDao());
		
		//위의 코드를 AListCommand로 이동.
		command = new AListCommand();
		command.excute(sqlSession, model);
		
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		String name = request.getParameter("name");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String relation = request.getParameter("relation");
		dao.writeDao(name, telno, address, email, relation);
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		model.addAttribute("ADto", dao.contentDao(seqno));
		return "content_view";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		String name = request.getParameter("name");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String relation = request.getParameter("relation");
		dao.updateDao(seqno, name, telno, address, email, relation);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		dao.deleteDao(seqno);
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/listQuery")
	public String listQuery(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		model.addAttribute("list", dao.listQuery(request.getParameter("query"), request.getParameter("content")));
		return "list";
	}
	
	
	
	
	
}
