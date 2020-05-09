package com.wp.personalitytest;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/test1")
public class Test1Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Control() {
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
		
		String name = request.getParameter("name");
		
		// step #2. data processing
		HttpSession session = request.getSession();
		
		if (session.isNew()) {
			session.setAttribute("name", name);
			session.setAttribute("test_store", new ArrayList<Integer>());		
		}
		else {
			if (session.getAttribute("name") == null) {
				response.sendRedirect(request.getContentType() + "/start.html");
				return;
			}
		}
		
		// step #3. output results
		RequestDispatcher view = request.getRequestDispatcher("test1.jsp");
		view.forward(request, response);
	}

}
