package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDao;
import com.jsplec.bbs.dto.BDto;

public class BListCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB(mvc.mbv_board)를 읽어 attribute로 jsp에 전달
		
		BDao dao = new BDao();
		ArrayList<BDto> bdtos = dao.list();
		request.setAttribute("list", bdtos);
		
		
		
	}

}
