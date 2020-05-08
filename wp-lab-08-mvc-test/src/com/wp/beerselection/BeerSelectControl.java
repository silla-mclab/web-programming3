package com.wp.beerselection;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelectControl
 */
@WebServlet("/beer_select.do")
public class BeerSelectControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelectControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		String color = request.getParameter("color");
		
		// step #2. data processing
		BeerExpert expert = new BeerExpert();
		List<String> brands = expert.getBrands(color);
		
		// step #3. output results
		request.setAttribute("color", color);
		request.setAttribute("brands", brands);
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
