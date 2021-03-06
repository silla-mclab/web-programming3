package com.wp.builtinobjects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginLoggingServlet
 */
//@WebServlet("/login.do")
public class LoginLoggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter logFile = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLoggingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
//		String logFileName = getServletConfig().getInitParameter("log_filename");
		String logFileName = getInitParameter("log_filename");
		
		try {
			logFile = new PrintWriter(new FileWriter(logFileName, true));
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
		if (logFile != null) {
			logFile.close();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String name = request.getParameter("name");
		
		// step #2. data processing
		String greeting = "안녕하세요, " + name + "님!...";
		
		if (logFile != null) {
			GregorianCalendar now = new GregorianCalendar();
			logFile.printf("%TF %TT - %s \n", now, now, name);
		}
		
		// step #3. output results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>로그인 인사</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h2>로그인 인사</h2><hr><br>");
			out.println("<div style='font-size: 1.2rem;'>");
			out.println(greeting);
			out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
