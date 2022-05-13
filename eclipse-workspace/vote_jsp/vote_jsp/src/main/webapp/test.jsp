<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Driver Test Page</title>
</head>
<body>
	<h1>DB Driver TEST PAGE</h1>

	<%
	  Connection conn=null;
	
	  try{
		 String jdbcUrl = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
	     String dbId = "lion";
	     String dbPass = "1234";
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
		 %>
		 <h1>DB에 연결되었습니다.</h1>
		 <%
	  }catch(Exception e){ 
		 e.printStackTrace();
	  }
	%>

</body>
</html>