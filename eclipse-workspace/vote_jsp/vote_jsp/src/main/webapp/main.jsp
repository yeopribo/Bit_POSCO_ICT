<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background-image:url(https://www.poscoict.com/images/main/main_visual1.jpg);
}

.vote-box{
	margin-top:300px;
	border-radius: 20px;
	padding: 20px 40px 40px;
	position: relative;
}

.vote-button{
	background-color: #ffffff;
	width: 200px;
	display: block;
	margin-left:10px; 
	margin-top:30px;
	height: 70px;
	line-height: 70px;
	border-radius: 80px;
	color: #0020f0;
	font-size: 16px;
	font-weight: 700;
}
</style>
</head>
<body>
	
<img src="https://biz.chosun.com/resizer/15rHyQGMpgxl4L6HePAMYYmZM9Y=/601x500/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosunbiz/XM62ZAO6SQOLVNHOP4HQGFFBAU.jpg" width=100 height=100>
	
	<div class="vote-box" align="center">
		<button class="vote-button" onclick="location.href='login.jsp'">로그인</button>
		<button class="vote-button" onclick="location.href='insert.jsp'">회원가입</button>
	</div>

</body>
</html>