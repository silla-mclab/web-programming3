package com.wp.goodsmanager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoodsManagerControl
 */
@WebServlet("/books/*")
public class GoodsManagerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsManagerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		GoodsinfoDao dao = (GoodsinfoDao)session.getAttribute("dao");
		if (dao == null) {
			ServletContext context = getServletContext();
//			dao = new GoodsinfoJdbcDao(
//				context.getInitParameter("jdbc_driver"),
//				context.getInitParameter("db_url"),
//				context.getInitParameter("db_userid"),
//				context.getInitParameter("db_passwd")
//			);
			dao = new GoodsinfoDbcpDao(
					context.getInitParameter("dbcp_resource_name")
				);
			session.setAttribute("dao", dao);
		}
		
		// step #2. data processing
		// get routing info.
		String pathInfo = request.getPathInfo();
		String action = request.getParameter("action");
		
		String viewName = null;
		
		if (pathInfo != null && pathInfo.length() > 1) {
			if (pathInfo.equals("/list")) {
				// get all records from db table
				List<GoodsDO> goodsList = null;
				try {
					goodsList = dao.getGoodsList();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				
				// bind result as a request attribute
				request.setAttribute("goods_list", goodsList);
				
				viewName = "/views/list_goodsinfo.jsp";
			}
		}
		else if (action != null) {
			if (action.equals("register_form")) {
				viewName = "/views/register_form.jsp";
			}
			else if (action.equals("register")) {
				// form data binding
				GoodsDO goods = new GoodsDO();
				goods.setCode(request.getParameter("code"));
				goods.setTitle(request.getParameter("title"));
				goods.setWriter(request.getParameter("writer"));
				goods.setPrice(Integer.parseInt(request.getParameter("price")));
				
				// form data validation
				// ...
				
				// data processing...
				// insert new goods info to DB
				try {
					dao.insertGoods(goods);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				
				// redirect to goods-list page
//				response.sendRedirect("/books/list");
				viewName = "redirect:/books/list";
			}
			else if (action.equals("update_form")) {
				// get code parameter
				String code = request.getParameter("code");
				
				//search goods info of the code
				GoodsDO goods = null;
				try {
					goods = dao.getGoods(code);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				
				// bind goods into to request attribute
				request.setAttribute("goods", goods);
				
				// forward to update_form.jsp
				viewName = "/views/update_form.jsp";				
			}
			else if (action.equals("update")) {
				// form data binding
				GoodsDO goods = new GoodsDO();
				goods.setCode(request.getParameter("code"));
				goods.setTitle(request.getParameter("title"));
				goods.setWriter(request.getParameter("writer"));
				goods.setPrice(Integer.parseInt(request.getParameter("price")));
				
				// form data validation
				// ...
				
				// data processing...
				// update goods info on DB
				try {
					dao.updateGoods(goods);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				
				// redirect to goods-list page
				viewName = "redirect:/books/list";
			}
			else if (action.equals("delete")) {
				// get code parameter
				String code = request.getParameter("code");
				
				// data processing...
				// delete goods info from DB
				try {
					dao.deleteGoods(code);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				
				// redirect to goods-list page
				viewName = "redirect:/books/list";
			}
		}
			
		// step #3. output results
		if (viewName != null) {
			if (viewName.contains("redirect:")) {
				String location = viewName.split(":")[1];
				response.sendRedirect(request.getContextPath() + location);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
