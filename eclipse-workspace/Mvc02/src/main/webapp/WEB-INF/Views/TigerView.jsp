<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>여기는 호랑이</h3>
	
	<%-- <%
		//String nn = request.getParameter("name");
		String nn = (String)request.getAttribute("name");
		String aa = (String)request.getAttribute("age");
	%>
	
	<%=nn %>
	<%=aa %> --%>
	<h3>${name} ${age}</h3>
</body>
</html>