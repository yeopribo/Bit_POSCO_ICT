<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POSCO ICT 당신의 선택은?</title>
<link href="style.css" rel="stylesheet" type="text/css">

<style>
body{
background-image:url(https://www.poscoict.com/images/main/main_visual3.jpg);
}
.vote-wrapp{
	background-color: rgba( 255, 255, 255, 1);
	width: 1500px;
	margin-left:200px; 
}
.vote-button{
	background-color: #ffffff;
	width: 150px;
	display: block;
	margin-left:10px; 
	margin-top:30px;
	height: 50px;
	line-height: 50px;
	border-radius: 80px;
	color: #0020f0;
	font-size: 16px;
	font-weight: 700;
}
table, th, td {
  border-color: #e32fe5;
}
</style>

</head>
<body>
<img src="https://biz.chosun.com/resizer/15rHyQGMpgxl4L6HePAMYYmZM9Y=/601x500/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosunbiz/XM62ZAO6SQOLVNHOP4HQGFFBAU.jpg" width=100 height=100>
	<% String memberId = request.getParameter("memberId"); %>

	<form name="votelist_form" method="post" action="vote.jsp">
		<div class="vote-wrapp">
			<h1 align="center">희망 근무지역 투표</h1>
			<table style="width: 100%">
				<tr>
					<th><img
						src="https://www.poscoict.com/images/support/img_loc_go.png"
						width=250 height=250></th>
					<th><img
						src="https://www.poscoict.com/images/support/img_loc_ho.png"
						width=250 height=250></th>
					<th><img
						src="https://www.poscoict.com/images/support/img_loc_po.png"
						width=250 height=250></th>
					<th><img
						src="https://www.poscoict.com/images/support/img_loc_vi.png"
						width=250 height=250></th>
				</tr>
				<tr align="center">
					<td>광양</td>
					<td>포항</td>
					<td>판교</td>
					<td>베트남</td>
				</tr>
				<tr align="center">
					<input type=hidden name="memberId" value=<%=memberId %>>
					<td><input type="radio" name="name" value="광양"></td>
					<td><input type="radio" name="name" value="포항"></td>
					<td><input type="radio" name="name" value="판교"></td>
					<td><input type="radio" name="name" value="베트남"></td>
				</tr>
			</table>
		</div>
		<div align="center">
			<input class="vote-button" type="submit" value="투표" />
			<button class="vote-button" type="button"
				onclick="location.href='voteResult.jsp' ">결과</button>
		</div>
	</form>
</body>
</html>