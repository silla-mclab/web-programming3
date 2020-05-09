<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>재미있는 2분 성격 테스트</title>
	<style>
		body {
			width: 600px;
			margin-top: 50px;
			margin-left: 50px;
		}
		header {
			height: 100px;
		}
		.question {
			padding-top: 25px;
		}
	</style>
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
	%>
	<header>
		<h1>재미있는 2분 성격 테스트</h1>
		<div style="text-align: right;">
			<p>반갑습니다, <%= name %> !...</p>
		</div>
		<hr>
	</header>
	<article>
		<form action="test5" method="POST">
			<div class="question">
				<p>7. 완전히 일에 몰두한 채로 열심히 일하다가 방해 받았을 때, 나는</p>
				<div>
					<input type="radio" name="q7" value="6" required> a. 휴식의 기회를 반갑게 맞이한다. <br>
					<input type="radio" name="q7" value="2"> b. 열라 짜증이 훨훨난다. <br>
					<input type="radio" name="q7" value="4"> c. 그 중간 어딘가쯤. <br>			
				</div>
			</div>
 			<div class="question">
				<p>8. 다음 중에 제일 좋아하는 색은?</p>
				<div>
					<input type="radio" name="q8" value="6" required> a. 빨강이나 오렌지 <br>
					<input type="radio" name="q8" value="7"> b. 까망 <br>
					<input type="radio" name="q8" value="5"> c. 노랑이나 연한 파랑 <br> 
					<input type="radio" name="q8" value="4"> d. 녹색 <br>
					<input type="radio" name="q8" value="3"> e. 짙은 파랑이나 보라 <br> 
					<input type="radio" name="q8" value="2"> f. 하양 <br>
					<input type="radio" name="q8" value="1"> g. 갈색이나 회색  <br> 
				</div>		
			</div>	
			<div style="padding-top: 50px; text-align: right;">
				<input type="button" value="<< 이전" onclick="window.history.go(-1);" />
				<input type="submit" value="다음 >>" />
			</div>
		</form>
	</article>
</body>
</html>