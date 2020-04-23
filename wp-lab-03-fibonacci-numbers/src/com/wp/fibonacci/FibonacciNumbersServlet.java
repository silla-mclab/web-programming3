package com.wp.fibonacci;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciNumbersServlet
 */
//@WebServlet("/fibonacci.do")
public class FibonacciNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BigInteger[] fiboNumbers = null;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibonacciNumbersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		fiboNumbers = new BigInteger[100];
		fiboNumbers[0] = new BigInteger("1");
		fiboNumbers[1] = new BigInteger("1");
		for (int i=2; i<100; i++) {
			fiboNumbers[i] = fiboNumbers[i-1].add(fiboNumbers[i-2]);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		int count = Integer.parseInt(request.getParameter("count"));
		if (count > 100)  count = 100;
		
		// step #2. data processing
//		BigInteger[] fiboNumbers = null;
//		if (count != 0) {
//			fiboNumbers = new BigInteger[count];
//			fiboNumbers[0] = new BigInteger("1");
//			fiboNumbers[1] = new BigInteger("1");
//			for (int i=2; i<count; i++) {
//				fiboNumbers[i] = fiboNumbers[i-1].add(fiboNumbers[i-2]);
//			}
//		}
		
		// step #3. output results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>피보나치 숫자 생성</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h2>피보나치 숫자 생성</h2><hr><br>");
			out.printf("생성 갯수 : %d <br>\n", count);
			if (count != 0) {
				for (int i=0; i<count; i++) {
					out.printf("%d: %s <br>\n", (i+1), fiboNumbers[i]);
				}
			}
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
