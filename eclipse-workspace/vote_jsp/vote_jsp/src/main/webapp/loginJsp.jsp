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
		String id = request.getParameter("id");
		String pwd= request.getParameter("pwd");
		String name= request.getParameter("name");
		ResultSet rs = null;
		ResultSet rs2 = null;

		int n=0;
		int m=0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Connection conn = null;
		try{
			String jdbcUrl = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
		    String dbId = "lion";
		    String dbPass = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
			String sql = "select * from user";
			String sql2 = "select * from manager";
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			rs2 = pstmt2.executeQuery();
			
			while(rs.next()){
				if(id.equals(rs.getString("id"))) {
					if(pwd.equals(rs.getString("password"))){
						n=1;
						break;
					}
				}
			}
			
			while(rs2.next()){
				if(id.equals(rs2.getString("id"))) {
					if(pwd.equals(rs2.getString("password"))){
						m=1;
						break;
					}
				}
			}
			
			
		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
		try{
			if(pstmt!=null) pstmt.close();
			if(pstmt!=null) pstmt2.close();
			if(conn!=null) conn.close();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();

			if(n>0){
				session = request.getSession();
				session.setAttribute("memberId", id);
				System.out.println(id);
				response.sendRedirect("loginMain.jsp");
			}
			if(m>0){
				session = request.getSession();
				session.setAttribute("memberId", id);
				System.out.println(id);
				response.sendRedirect("manager.jsp");
			}
				
			%>
			<h1>회원정보가 올바르지 않습니다.</h1>
			<a href='javascript:history.go(-1)'>이전페이지로 가기</a>
			<%
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
%>
</body>
</html>