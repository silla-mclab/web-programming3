package com.wp.scoreprocessing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreProcessServlet
 */
//@WebServlet("/score_process.do")
public class ScoreProcessControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreProcessControl() {
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
		
		String[] scores = request.getParameterValues("score");
		
		// step #2. data processing(business logic)
		ScoreProcessingService service = new ScoreProcessingService();
		ScoreDO scoreDO = service.processScores(scores);
			
		// step #3. output results(presentation logic)
		request.setAttribute("score", scoreDO);
			
//		RequestDispatcher view = request.getRequestDispatcher("score_output.do");
		RequestDispatcher view = request.getRequestDispatcher("ScoreOutput.jsp");
		view.forward(request, response);
	}

}
