package com.wp.personalitytest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test1Control
 */
@WebServlet("/test3")
public class Test3Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3Control() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		
		int q3 = Integer.parseInt(request.getParameter("q3"));
		int q4 = Integer.parseInt(request.getParameter("q4"));
		
		// step #2. data processing
		HttpSession session = request.getSession(false);
	
		if (session == null) {
			response.sendRedirect(request.getContentType() + "/start.html");
			return;			
		}
		
		List<Integer> testStore = (List<Integer>)session.getAttribute("test_store");
		testStore.add(q3);
		testStore.add(q4);
		
		// step #3. output results
		RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
		view.forward(request, response);
	}

}
