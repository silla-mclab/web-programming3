<%@page import="com.wp.scoreprocessing.ScoreDO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>성적 처리 결과</title>
	<style>
		.td { padding-left: 5px; }
	</style>
</head>
<body>
	<%
		ScoreDO scoreDO = (ScoreDO)request.getAttribute("score");
		int[] scores = scoreDO.getScores();
	%>
	<header>
		<h2>성적 처리 결과</h2><hr><br>
	</header>
	<article>
		<table>
			<tr><td class='td'>성 적</td></tr>
			<%			
				for(int i=0; i<scores.length; i++) {
			%>
					<tr><td class='td'><%= (i+1) %></td><td class='td'><%= scores[i] %></td></tr>
			<%
				}
			%>
			<tr><td>&nbsp;</td></tr>
			<tr><td class='td'>총 합 :</td><td class='td'><%= scoreDO.getSum() %></td></tr>
			<tr><td class='td'>평 균 :</td><td class='td'><%= scoreDO.getMean() %></td></tr>
			<tr><td class='td'>표준편차 :</td><td class='td'><%= scoreDO.getStdDev() %></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr align='center'><td colspan='2'>
				<a href='<%= request.getContextPath() + "/score_input.html" %>'>첫 페이지로 가기</a>
			</td></tr>	
		</table>
	</article>
</body>
</html>