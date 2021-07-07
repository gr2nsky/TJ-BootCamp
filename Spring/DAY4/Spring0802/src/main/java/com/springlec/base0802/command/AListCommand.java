package com.springlec.base0802.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0802.dao.ADao;

public class AListCommand implements ACommand {

	@Override
	public void excute(SqlSession sqlSession, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		model.addAttribute("list", dao.listDao());
	}

}
