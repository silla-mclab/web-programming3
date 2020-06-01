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
<title>상품 관리 - 상품 목록</title>
<style>
	body {
		text-align: center;
	}
	table {
		border-collapse: collapse;
	}
	td {
		padding: 5px;
		border: 1px solid black;
	}
	a {
		text-decoration: none;
		color: green;
	}
</style>
<script>
	function confirmAndDelete(code, title) {
		let result = confirm('"' + title + '" 상품을 정말로 삭제하시겠습니까?');
		if (result) {
			let formEl = document.getElementById('list_form');
			formEl.setAttribute("action", 
				'<%= request.getContextPath() + "/books?action=delete&code="%>' + code);
			formEl.submit();
		}
	}
</script>
</head>
<body>
	<h1>상품 관리</h1>
	<h3>상품 목록</h3><hr>
	<br><br>
<%
	List<GoodsDO> goodsList = (List<GoodsDO>)request.getAttribute("goods_list");

	if (goodsList != null) {
%>		
		<form id='list_form' action='<%=request.getContextPath()+"/books?action=register_form"%>' method='POST'>
			<table align="center">
				<thead>
					<tr><td>코 드</td><td>제 목</td><td>저 자</td><td>가 격</td><td>처 리</td></tr>
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
						<td>
							<a href='<%= request.getContextPath() + 
								"/books?action=update_form&code=" + goods.getCode() %>'>수정</a>
							<a href='#' onclick='confirmAndDelete(
									"<%= goods.getCode() %>","<%= goods.getTitle() %>");'>삭제</a>
						</td>
					</tr>
<%			
		}
%>			
				</tbody>
			</table>
			<p><input type="submit" value="새 상품 등록" /></p>
		</form>
<%		
	}
	else {
%>
		<p>관리할 상품 목록이 존재하지 않습니다.</p>		
<%		
	}
%>
</body>
</html>