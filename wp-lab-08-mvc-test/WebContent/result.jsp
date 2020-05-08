<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Beer Recommandation Service</title>
	<style>
		body {
			padding: 50px;
		}
	</style>
</head>
<body>
	<h1>Beer Recommandation Service</h1><br>
	<p>Selected color : <%= (String)request.getAttribute("color") %></p>
	<%
		List<String> brands = (List<String>)request.getAttribute("brands");
		Iterator it = brands.iterator();
		while (it.hasNext()) {
	%>
			Try : <b> <%= it.next() %> </b><br>
	<%
		}
	%>
</body>
</html>