<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
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
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();

      // 1. 파라미터로 전송된 값을 얻어오기.
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      String id = request.getParameter("id");
      String pwd= request.getParameter("pwd");
   
	  System.out.println(id);
      int n=0;
      PreparedStatement pstmt2 = null;
      PreparedStatement pstmt = null;
      Connection conn = null;
      ResultSet rs = null;

      try{
         // 2. 전송된 값을 db에 저장.
		 String jdbcUrl = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
	     String dbId = "lion";
	     String dbPass = "1234";
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
         
         
         
         String checksql = "select * from user where id=?";
         pstmt2 = conn.prepareStatement(checksql);
         pstmt2.setString(1, id);
         rs = pstmt2.executeQuery();
         while(rs.next()) {
            if(rs.getString(1).equals(id) == true) {
%>
              <h1>아이디중복 인해 가입에 실패했습니다.</h1>
              <a href='javascript:history.go(-1)'>이전페이지로 가기</a>
<%
               pstmt2.close();
               rs.close();
               return;
            }
            pstmt2.close();
            rs.close();
         }
         
         String sql = "insert into user values( ?,?,?,now(),false )";
            
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.setString(2, pwd);
         pstmt.setString(3, name);

         //sql구문 실행하기
         n=pstmt.executeUpdate();

      }catch(ClassNotFoundException ce){
         System.out.println(ce.getMessage());
      }catch(SQLException se){
         System.out.println(se.getMessage());
      }
      try{
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
      }catch(SQLException se){
         System.out.println(se.getMessage());
      }

      // 3. 사용자(클라이언트)에 결과를 응답하기.

      if(n>0){
    	  
			out.println(id + "님! 성공적으로 가입되었습니다.<br/>");
			%>
			<h1><a href='index.jsp'>메인페이지 이동</a></h1>
		<% 
      }else{
    	  %>
			<h1>오류로 인해 가입에 실패했습니다.</h1><br/>
			<h1><a href='javascript:history.go(-1)'>이전페이지로 가기</a></h1>
			<%
      }   
%>
</body>
</html>