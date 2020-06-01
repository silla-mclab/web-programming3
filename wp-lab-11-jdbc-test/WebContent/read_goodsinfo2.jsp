<%@page import="com.wp.goodsmanager.GoodsinfoJdbcDao"%>
<%@page import="com.wp.goodsmanager.GoodsDO"%>
<%@page import="java.util.List"%>
<%@page import="com.wp.goodsmanager.GoodsinfoDao"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC Programming - read from DB</title>
<style>
	table {
		border-collapse: collapse;
	}
	td {
		padding: 5px;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<h1>JDBC Programming Test</h1>
	<h3>Read records from goodsinfo table</h3><hr>
<%
	String jdbcDriver = application.getInitParameter("jdbc_driver");
	String dbUrl = application.getInitParameter("db_url");
	String dbUserId = application.getInitParameter("db_userid");
	String dbPasswd = application.getInitParameter("db_passwd");
	
	GoodsinfoDao dao = new GoodsinfoJdbcDao(jdbcDriver, dbUrl, dbUserId, dbPasswd);
	
	List<GoodsDO> goodsList = dao.getGoodsList();

	if (goodsList != null) {
%>		
		<table>
			<thead>
				<tr><td>Code</td><td>Title</td><td>Writer</td><td>Price</td></tr>
			</thead>
			<tbody>
<%
		for (GoodsDO goods : goodsList) {
%>
				<tr>
					<td><%= goods.getCode() %></td>
					<td><%= goods.getTitle() %></td>
					<td><%= goods.getWriter() %></td>
					<td><%= goods.getPrice() %></td>
				</tr>
<%			
		}
%>			
			</tbody>
		</table>
<%		
	}
%>
</body>
</html>