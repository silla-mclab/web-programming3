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
<title>상품 관리 - 상품 수정</title>
<style>
	body {
		text-align: center;
	}
	table {
		border-collapse: collapse;
	}
	td {
		padding: 5px;
	}
</style>
</head>
<body>
<%
	GoodsDO goods = (GoodsDO)request.getAttribute("goods");
%>
	<h1>상품 관리</h1>
	<h3>상품 수정</h3><hr>
	<br><br>
	<form action='<%=request.getContextPath()+"/books?action=update" %>' method='POST'>
		<table align="center">
			<tbody>
				<tr><td>코 드 :</td><td><input type="text" name="code" value="<%= goods.getCode()%>" readonly /></td></tr> 
				<tr><td>제 목 :</td><td><input type="text" name="title" value="<%= goods.getTitle()%>" required /></td></tr> 
				<tr><td>저 자 :</td><td><input type="text" name="writer" value="<%= goods.getWriter()%>" required /></td></tr> 
				<tr><td>가 격 :</td><td><input type="number" name="price" value="<%= goods.getPrice()%>" required /></td></tr> 
			</tbody>
		</table>
		<p><input type="button" value="돌아가기" onclick="window.history.go(-1);" />
		   <input type="submit" value="상품 수정" /></p>
	</form>
</body>
</html>