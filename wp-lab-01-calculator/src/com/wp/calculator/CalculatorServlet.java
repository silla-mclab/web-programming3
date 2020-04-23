package com.wp.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
//@WebServlet("/calculate.do")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String num1_ = request.getParameter("num1");
		String num2_ = request.getParameter("num2");
		String operator = request.getParameter("operator");
		
		int num1 = Integer.parseInt(num1_);
		int num2 = Integer.parseInt(num2_);
		
		// step #2. data processing
		int result = 0;
		if ("+".equals(operator)) {
			result = num1 + num2;
		}
		else if ("-".equals(operator)) {
			result = num1 - num2;
		}
		else if ("*".equals(operator)) {
			result = num1 * num2;
		}
		else if ("/".equals(operator)) {
			result = num1 / num2;
		}
		
		// step #3. output results ==> send response to client
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>Calculator</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h2>Calculation Result</h2><hr><br>");
			out.println("<div style='font-size: 1.5rem;'>");
			out.printf("<p>%d %s %d = %d</p>\n", num1, operator, num2, result);
			out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
