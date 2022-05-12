<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Pack01.rabbitDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>

<body>
	<h1>index</h1>
	<a href="t1">링크1</a><br/>
	
	<a href="select">select</a><br/>
	<a href="selectQ">selectQ</a><br/>
	
	<table id='tableId' border='1'>
          <tbody>
          <tr>
            <th>문제 ID</th>
            <th>factor A</th>
            <th>factor B</th>
          </tr>
          </tbody>
        </table>
</body>
</html>