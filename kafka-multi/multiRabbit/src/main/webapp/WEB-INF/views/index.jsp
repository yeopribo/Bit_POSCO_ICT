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
   	<%-- <%
   	class Multi{
   	   String factorA;
   	   String factorB;
   	   String q_id;
   	}
   	 	Multi[] rs = (Multi[])request.getAttribute("resultArray");
   		System.out.println(rs);
   		
		/* ResultSet rs = rabbitDAO.questionBoard();
		System.out.println(rs);
   		 if(rs == null){
   			return;
   		}
		while(rs.next()) {
			String q_id = rs.getString("q_id");
			String factorA = rs.getString("factorA");
			String factorB = rs.getString("factorB");
			
		System.out.println(q_id + " " + factorA + " " + factorB); */
	%>
          <tr>
           <td><% out.println(rs[1]); %></td>
            <td><% out.println(rs[2]); %></td>
            <td><% out.println(rs[3]); %></td>
          </tr>
          <%
		/* } */
          %> --%>
          </tbody>
        </table>
</body>
</html>