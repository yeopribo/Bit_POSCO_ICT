<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String nickName = request.getParameter("nickName");
	%>
	<%= nickName %><br/>
	<%= request.getParameter("nickName") %><br/>
	<%= request.getParameter("age") %><br/>
	
	<h1>a.jsp</h1>
	
</body>
</html>