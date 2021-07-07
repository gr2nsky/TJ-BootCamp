package com.springlec.base0802.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ACommand {
	void excute(SqlSession sqlSession, Model model);
}
