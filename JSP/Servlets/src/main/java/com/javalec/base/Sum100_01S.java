package com.javalec.base;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sum100_01S
 */
@WebServlet("/Sum100_01S")
public class Sum100_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()s
     */
    public Sum100_01S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 0; i <=100; i++) {
			total += 1;
		}
		request.setAttribute("result", total);
		
		for (int i = 101; i <=200; i++) {
			total += 1;
		}
		request.setAttribute("result2", total);
		
		RequestDispatcher rd = request.getRequestDispatcher("sum100_01.jsp");
		rd.forward(request, response);
	}

}
