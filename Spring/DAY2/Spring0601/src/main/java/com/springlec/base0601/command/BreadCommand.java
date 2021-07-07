package com.springlec.base0601.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;
import com.springlec.base0601.dto.BDto;

public class BreadCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("bId");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BDao dao = new BDao();
		BDto dto = dao.content(bId);
		
		model.addAttribute("dto", dto);
	}

}
