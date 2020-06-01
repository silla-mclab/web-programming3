<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC Programming - update a record into DB</title>
</head>
<body>
	<h1>JDBC Programming Test</h1>
	<h3>Update a record into goodsinfo table</h3><hr>
<%
	String jdbcDriver = application.getInitParameter("jdbc_driver");
	String dbUrl = application.getInitParameter("db_url");
	String dbUserId = application.getInitParameter("db_userid");
	String dbPasswd = application.getInitParameter("db_passwd");
	
	Class.forName(jdbcDriver);
	Connection conn = DriverManager.getConnection(dbUrl, dbUserId, dbPasswd);
	Statement stmt = conn.createStatement();

 	String sql = "update goodsinfo set writer='홍길동외 2인', price=28000 where code='10006'";
	int result = stmt.executeUpdate(sql);

	if (result == 1) {
%>		
		<p>Successfully update a record into goodsinfo table...</p>

<%
	} else {
%>
		<p>Failed to update a record into goodsinfo table...</p>

<%			
	}

 	stmt.close();	
 	conn.close(); 		
%>
</body>
</html>