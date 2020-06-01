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
	
	Class.forName(jdbcDriver);
	Connection conn = DriverManager.getConnection(dbUrl, dbUserId, dbPasswd);
	Statement stmt = conn.createStatement();

	String sql = "select * from goodsinfo";
	ResultSet rs = stmt.executeQuery(sql);
	
	if (rs.isBeforeFirst()) {
%>		
		<table>
			<thead>
				<tr><td>Code</td><td>Title</td><td>Writer</td><td>Price</td></tr>
			</thead>
			<tbody>
<%
		while (rs.next()) {
%>
				<tr>
					<td><%= rs.getString("code") %></td>
					<td><%= rs.getString("title") %></td>
					<td><%= rs.getString("writer") %></td>
					<td><%= rs.getInt("price") %></td>
				</tr>
<%			
		}
%>			
			</tbody>
		</table>
<%		
	}
	
	rs.close();
 	stmt.close();	
 	conn.close(); 		
%>
</body>
</html>