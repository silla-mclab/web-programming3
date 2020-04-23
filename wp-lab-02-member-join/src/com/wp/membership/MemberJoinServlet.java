package com.wp.membership;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberJoinServlet
 */
//@WebServlet("/join.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
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
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String inotice = request.getParameter("inotice");
		String cnotice = request.getParameter("cnotice");
		String dnotice = request.getParameter("dnotice");
		String job = request.getParameter("job");
			
		// step #2. data processing
		// business logic
		// preprocess data ...
		// register a member to DB ...
		
		// step #3. output results
		// presentation logic
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>회원 가입 정보 입력</title>");
		out.println("</head>");
		out.println("<body style='padding-left: 100px;'>");
			out.println("<h2>회원 가입 정보 입력 결과</h2><hr><br>");
			out.println("<div style='font-size: 1.2rem;'>");
			out.printf("이름 : %s <br>\n", name);
			out.printf("아이디 : %s <br>\n", id);
			out.printf("비밀번호 : %s <br>\n", passwd);
			out.printf("성별 : %s <br>\n", gender.equals("male") ? "남자" : "여자");
			out.printf("공지메일 수신여부 : %s <br>\n", getNoticeMsg(inotice));
			out.printf("광고메일 수신여부 : %s <br>\n", getNoticeMsg(cnotice));
			out.printf("배송확인메일 수신여부 : %s <br>\n", getNoticeMsg(dnotice));
			out.printf("직업 : %s <br>\n", job);
			out.println("<br>위와 같은 정보로 회원 가입이 완료되었습니다...<br>");
			out.println("<div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	private String getNoticeMsg(String notice) {
		if (notice == null) {
			return "수신하지 않음";
		}
		else if (notice.equals("on")) {
			return "수신함";
		}
		else {
			return notice;
		}
	}

}
