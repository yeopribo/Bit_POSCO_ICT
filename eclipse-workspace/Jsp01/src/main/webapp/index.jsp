<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.Date"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>호랭이</h1>

	<a href="./a.jsp"> ex1 </a><br/>
	<a href="./dog/b.jsp"> ex2 </a><br/>
	<a href="./dog/cat/c.jsp"> ex3 </a><br/>
	<!-- 클라이언트에서 서버로 데이터를 날린다. -->
	<a href="a.jsp?nickName=tiger"> ex4 </a><br/>
	
	<% String nickName = "lion"; %>
	<a href="a.jsp?nickName=<%= nickName %>"> ex5 </a><br/>
	
	<a href="a.jsp?nickName=apple&age=30"> ex6 </a><br/>
	
	<a href="http://www.daum.net"> ex7 </a><br/>
	
	<form action="dog/b.jsp">
		<input type="text" name="nickName" value="banana">
		<input type="hidden" name="age" value="23">
		<input type="submit" value="전송" />
	</form>
	
	<% String data = "ORANGE"; %>
	<form action="dog/b.jsp">
		<input type="text" name="nickName" value=<%= data %>>
		<input type="hidden" name="age" value="30">
		<input type="submit" value="전송" />
	</form>
	
	<a href="index.jsp"> 새로고침 </a><br/>
	
</body>
</html>
















<%-- 	
	<%
		int num = 10;
		String s = "Apple";
		out.println(num + "</br>");
		out.println(s);
	%>
	<%! 
		public void func( javax.servlet.jsp.JspWriter out ){
			System.out.println("test");
			try{
			out.println("함수 콜");
			}catch(Exception e){}
		}
	
		public int func2(){
			return 1000;
		}
	%>
	
	<%
		func(out);
		int num = func2();
		out.println(num);
	%>
	<%= func2() %>
	
	<%
		int n = 10;
		java.util.Date date = new java.util.Date();
	%>
	
	<%= date %></br>
	
	<%
		Date date1 = new Date();
	%>
	<%= date1 %>
	
	<%
		// 가상의 배열이고 원칙은 DB에서 가져온것.
		String[] name = {"호랑이1","코끼리2","독수리3","앵무새4"};
	%>
	
	<table border="1" width="200">
		<%
			for(int i=0; i<name.length; i++){
		%>	
			<tr>
				<td><%=i*100+100 %></td>
				<td><%=name[i] %></td>
			</tr>
		<%	
			}
		%>
		</table>
		
		<% int num = 10; %>
	<%= 3 %>
	<%= "문자열" %>
	<%= 3 * 4 + 2 %>
	<%= num * 3 %>
	<%= (num > 100) ? "호랑이" : "독수리" %>
	<%-- <%= 함수콜() %> 
	
	<table border="1">
	<%
		for(int i=2; i<10; i++){
			out.println("<tr>");
			for(int j=1; j<10; j++){
				out.println("<td>" + i + "X" + j + "=" + i*j + "</td>");
			}
			out.println("</tr>");
		}
	%>
	<tr></tr>
	</table>
	
	<table width="80%" border="1" align="center">
		<tr>
			<td align="center" bgcolor="ef8284">
				<FORM METHOD=POST action="testPage.jsp">
					<table width="80%" border="1" cellpadding ="10" cellspacing="1">
						<tr>
							<td colspan="3">회원가입</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="tiger"></td>
							<td>아이디를 적어주세요></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="text" name="pass"></td>
							<td>패스워드를 적어주세요></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" value="가입"></td>
						</tr>
					</table>
				</FORM>
			</td>
		</tr>
	</table>
	
	<c:forEach var="i" begin="1" end="10">
		${i}
	</c:forEach>
	
	<form action="tiger" method="post">
		<input type="text" name="name" value="호랭이">
		<input type="hidden" name="age" value="23">
		<input type="submit" value="다음단계" />
	</form>
	
	이름1 : <input type="text"/><br/>
	<label>
		이름2 : <input type="text"/><br/>
	</label>
	
	<ol type="I">
		<li>호랑이</li>
		<li>코끼리</li>
		<li>독수리</li>
	</ol>
	
	<ol start="1">
		<li>호랑이</li>
		<li>코끼리</li>
		<li>독수리</li>
	</ol>
	
	<ul>
		<li>호랑이</li>
		<li>코끼리</li>
		<li>독수리</li>
	</ul>
	
	<ul>
		<li>이름 : <%= "홍길동" %></li>
		<li>코끼리</li>
	</ul>
--%>
