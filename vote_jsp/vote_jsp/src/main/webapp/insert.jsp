<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background-image:url(https://www.poscoict.com/images/main/main_visual6.jpg);
}
.vote-title{
	font-size: 30px;
	colot: #c92bcc;
	text-align: center;
	font-weight: 400;
}
.vote-form{
	margin-top: 30px;
}

.vote-box{
	background-color: #fdeafd;
	width: 230px;
	height: 250px;
	margin: 40px 40px 40px;
	border-radius: 20px;
	padding: 20px 40px 40px;
	box-shadow: 0px 3px 20px rgb(0,0,0,0.2);
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
	<form method="post" action="insertJsp.jsp">
	
	<div align="center">			

		<div class="vote-box">
			<h1 class="vote-title">JOIN</h1>
			<ul class="vote-form">
				<li>
					<strong class="vote-guide">NAME&ensp;&emsp;&emsp;</strong>
					<input type="text" name="name" /><br/><br/>
				</li>
				<li>
					<strong class="vote-guide">ID&ensp;&emsp;&emsp;&emsp;&emsp;</strong>
					<input type="text" name="id" /><br/><br/>
				</li>
				<li>
					<strong class="vote-guide">PASSWORD</strong>
					<input type="text" name="pwd" /><br/><br/>
				</li>
			</ul>
			<input class="vote-button" id="insert-button" type="submit" value="가입"/>
			<input class="vote-button" id="insert-button" type="reset" value="취소" />
			<button class="vote-button" type="button" onclick="location.href='main.jsp' ">뒤로가기</button>

		</div>
	</div>	
		
	</form>

</body>
</html>