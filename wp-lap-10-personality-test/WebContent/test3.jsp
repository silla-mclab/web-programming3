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
		<form action="test4" method="POST">
			<div class="question">
				<p>5. 뭔가 아주 재미있는 일이 생겼을 때, 나는</p>
				<div>
					<input type="radio" name="q5" value="6" required> a. 아주 큰 소리로 즐거움을 숨기지 않고 웃는다. <br>
					<input type="radio" name="q5" value="4"> b. 웃지만 그다지 크지 않은 소리로 웃는다. <br>
					<input type="radio" name="q5" value="3"> b. 웃지만 그다지 크지 않은 소리로 웃는다. <br>			
					<input type="radio" name="q5" value="2"> d. 오히려 쑥쓰러운 듯한 미소 짓는다. <br>
				</div>
			</div>
			<div class="question">
				<p>6. 파티나 사람들이 많이 모이는 장소에서 나는</p>
				<div>
					<input type="radio" name="q6" value="6" required> a. 사람들이 내 존재를 의식하도록 화려한 등장을 한다. <br>
					<input type="radio" name="q6" value="4"> b. 아는 사람들을 찾을 수 있을까 해서 둘러보며 차분히 들어선다. <br>
					<input type="radio" name="q6" value="2"> c. 시선을 끌지 않기 위해 할 수있는 한 최대로 조용히 입장한다. <br> 
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