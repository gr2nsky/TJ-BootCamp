package com.jsplec.bbs.homeController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.command.BContentCommand;
import com.jsplec.bbs.command.BDeleteCommand;
import com.jsplec.bbs.command.BListCommand;
import com.jsplec.bbs.command.BModifyCommand;
import com.jsplec.bbs.command.BWriteCommand;
import com.jsplec.bbs.command.Bcommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<<<< DoGet() >>>>>");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<<<< DoPost() >>>>>");
		actionDo(request, response);
	}
	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<< actionDo() >>>");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("<Request URI : " + uri + ">");
		System.out.println("<Request Context Path : " + conPath + ">");
		System.out.println("<Request com : " + com + ">");
		
		String viewPage = null;
		Bcommand bcommand = null;
		
		switch (com) {
		case "/list.do":
		System.out.println(com);
			bcommand = new BListCommand();
			bcommand.execute(request, response);
			viewPage = "list.jsp";
			break;
		case "/write_view.do":
			System.out.println(com);
			viewPage = "write_view.jsp";
			break;
		case "/write.do":
			System.out.println(com);
			bcommand = new BWriteCommand();
			bcommand.execute(request, response);
			viewPage = "list.do";
			break;
		case "/content_view.do":
			System.out.println(com);
			bcommand = new BContentCommand();
			bcommand.execute(request, response);
			viewPage = "content_view.jsp";
			break;
		case "/modify.do":
			System.out.println(com);
			bcommand = new BModifyCommand();
			bcommand.execute(request, response);
			viewPage = "list.do";
			break;
		case "/delete.do":
			System.out.println(com);
			bcommand = new BDeleteCommand();
			bcommand.execute(request, response);
			viewPage = "list.do";
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}



























