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
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
	
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		Connection con = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		String userId = request.getParameter("memberId");
		
		System.out.println(userId);
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
			con = DriverManager.getConnection(url, "lion", "1234");
			
			String sql1 = "select flag from user where id = ?";
			String sql4 = "select flag from manager where id = 'admin'";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, userId);
			
			pstmt4 = con.prepareStatement(sql4);		
			rs2 = pstmt4.executeQuery();
			rs2.next();
			if(rs2.getString("flag").equals("0")){
				%>
				<h1>투표가 개최되지 않았습니다.</h1>
				<a href='loginMain.jsp'>메인으로 가기</a>
				<%
				return;
			}
			pstmt4.close();
			rs2.close();
			
			rs = pstmt1.executeQuery();
			rs.next();
			if(rs.getString("flag").equals("1")){
				%>
				<h1>중복 투표는 불가능합니다.</h1>
				<a href='loginMain.jsp'>메인으로 가기</a>
				<%
				return;
			}
			
			String sql2 = "update candidate set cnt=cnt+1 where name=?";

			pstmt2 = con.prepareStatement(sql2);
			
			pstmt2.setString(1, name);
			pstmt2.execute();
	        
			String sql3 = "update user set flag = 1 where id=?";

			pstmt3 = con.prepareStatement(sql3);
			
			pstmt3.setString(1, userId);
			pstmt3.execute();
			
			%>
			<h1>투표에 성공 하였습니다. 감사합니다</h1>
			<a href='loginMain.jsp'>메인으로 가기</a>
			<%
		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
			%>
			<h1>투표에 실패 하였습니다</h1>
			<a href='loginMain.jsp'>메인으로 가기</a>
			<%
		}catch(SQLException se){
			System.out.println(se.getMessage());
			%>
			<h1>투표에 실패 하였습니다</h1>
			<a href='loginMain.jsp'>메인으로 가기</a>
			<%
		}
		try{
			if(rs!=null) rs.close();
			if(rs!=null) rs2.close();
			if(pstmt1!=null) pstmt1.close();
			if(pstmt2!=null) pstmt2.close();
			if(pstmt3!=null) pstmt3.close();
			if(pstmt4!=null) pstmt4.close();
			if(con!=null) con.close();
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	%>
</body>
</html>