<%@page import="com.wp.goodsmanager.GoodsinfoJdbcDao"%>
<%@page import="com.wp.goodsmanager.GoodsinfoDbcpDao"%>
<%@page import="com.wp.goodsmanager.GoodsDO"%>
<%@page import="com.wp.goodsmanager.GoodsinfoDao"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC Programming - insert a record into DB</title>
</head>
<body>
	<h1>JDBC Programming Test</h1>
	<h3>Insert a record into goodsinfo table</h3><hr>
<%
	String jdbcDriver = application.getInitParameter("jdbc_driver");
	String dbUrl = application.getInitParameter("db_url");
	String dbUserId = application.getInitParameter("db_userid");
	String dbPasswd = application.getInitParameter("db_passwd");
	
	GoodsinfoDao dao = new GoodsinfoJdbcDao(jdbcDriver, dbUrl, dbUserId, dbPasswd);
	
	GoodsDO goods = new GoodsDO("10006", "자바 서블릿 프로그래밍", "홍길동", 32000);	
	int result = dao.insertGoods(goods);

	if (result == 1) {
%>		
		<p>Successfully insert a record into goodsinfo table...</p>

<%
	} else {
%>
		<p>Failed to insert a record into goodsinfo table...</p>

<%			
	}
%>
</body>
</html>