<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
body{
background-image:url(https://www.poscoict.com/images/main/main_visual1.jpg);
}

.vote-title{
	font-size: 30px;
	color: #ffffff;
	text-align: center;
	font-weight: 400;
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
<%String memberId=(String)session.getAttribute("memberId");
session = request.getSession();
%>

<div align="center">

<ul>
	
	<div class="vote-box" align="center">
	
	<h1 class="vote-title">안녕하세요 <%= session.getAttribute("memberId")%> 님</h1>
	<button class="vote-button" type="button" onclick="location.href='voteResult.jsp' ">투표율</button>
	<button class="vote-button" type="button" onclick="location.href='voteList.jsp?memberId=<%=memberId %>'">투표하기</button>
	<button class="vote-button" type="button" onclick="location.href='logout.jsp' ">로그아웃</button>
	
	</div>
</ul>
</div>

</body>
</html>