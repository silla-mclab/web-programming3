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
		<form action="test3" method="POST">
			<div class="question">
				<p>3. 사람들과 얘기할 때, 나는</p>
				<div>
					<input type="radio" name="q3" value="4" required> a. 내 팔짱을 끼고 서서 <br>
					<input type="radio" name="q3" value="2"> b. 두손을 마주잡고 <br>
					<input type="radio" name="q3" value="5"> c. 한손이나 양손을 힙에 얹고 <br>			
					<input type="radio" name="q3" value="7"> d. 얘기 나누는 상대방을 건드리거나 살짝 밀면서 <br>
					<input type="radio" name="q3" value="6"> e. 내 귀나 턱을 만지작거리거나 손가락으로 머리를 빗으면서 <br>			
				</div>
			</div>
			<div class="question">
				<p>4. 편안히 쉴 때, 나는</p>
				<div>
					<input type="radio" name="q4" value="4" required> a. 다리를 굽힌 채로 나란히 두고 앉는다. <br>
					<input type="radio" name="q4" value="6"> b. 다리를 꼬고 앉는다. <br>
					<input type="radio" name="q4" value="2"> c. 다리를 쭉 펴고 앉는다. <br> 
					<input type="radio" name="q4" value="1"> d. 한 쪽 다리를 접어 깔고 앉는다. <br>
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