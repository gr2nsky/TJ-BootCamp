package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanS
 */
@WebServlet("/GugudanS")
public class GugudanS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>결과 확인</h1>");
		gugudan(num, writer);
		writer.println("</body>");
		writer.println("</html>");
	}
	
	private void gugudan(int num, PrintWriter writer) {
		for (int i = 1; i <= 9; i ++) {
			String str = num + " X " + i + " = " + num * i + "<br>";
			writer.println(str);
		}
	}

}
