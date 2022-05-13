<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>메인 페이지</title>
</head>

<body>
	<%=new Date()%>
	<h2>Hello World</h2>
	<a href="t1">링크1</a><br />
	<a href="t2">링크2</a><br />
	<a href="t3?name=apple">링크3</a><br />
	<a href="t4?name=apple&age=30">링크4</a><br />
	<a href="t5?name=apple&age=30">링크5</a><br />
	<a href="t6">링크6</a><br />
	<a href="t7?name=banana&age=300">링크7</a><br />
	<a href="t8">링크8</a><br />
	<a href="t9">링크9</a><br />
	
	<form method="post" action="t10">
		<input type="text" name="id" value="호랑이"/>
		<input type="number" name="pwd" value=500/>
		<input type="submit" value="전송"/>
	</form>
	<a href="t11">링크11</a><br />
</body>