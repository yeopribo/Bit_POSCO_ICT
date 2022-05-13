<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 페이지</title>
</head>
<body>
	<h1>호랭이</h1>
	
	<%
		out.println("1<p/>");
		String s1 = request.getParameter("tiger");
		String s2 = request.getParameter("pass");
	%>

	<h1> <%= s1 %></h1>
	<h1> <%= s2 %></h1>
</body>
</html>