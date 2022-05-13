package Pack;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class InsertBoard extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 1. 파라미터로 전송된 값을 얻어오기.
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String content= request.getParameter("content");
      String wr = request.getParameter("wr");

      int n=0;
      PreparedStatement pstmt = null;
      Connection con = null;

      try{
         // 2. 전송된 값을 db에 저장.
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/db01?&useSSL=false";
         con = DriverManager.getConnection(url, "root", "1234");
         String sql = "insert into boards values( ?,?,?, now() )";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, title);
         pstmt.setString(2, content);
         pstmt.setString(3, wr);

         //sql구문 실행하기

         n=pstmt.executeUpdate();
      }catch(ClassNotFoundException ce){
         System.out.println(ce.getMessage());
      }catch(SQLException se){
         System.out.println(se.getMessage());
      }finally{
         try{
            if(pstmt!=null) pstmt.close();
            if(con!=null) con.close();
         }catch(SQLException se){
            System.out.println(se.getMessage());
            
         }
      }

      // 3. 사용자(클라이언트)에 결과를 응답하기.
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
      pw.println("<html>");
      pw.println("<head></head>");
      pw.println("<body>");
      if(n>0){
         pw.println( wr + "님! 게시글이 작성되었습니다.<br/>");
         pw.println("<a href='index.html'>메인페이지로 가기</a>");
      }else{
    	 pw.println("<script type=\"text/javascript\">");
    	 pw.println("alert('존재하지 않는 아이디입니다.');");
    	 pw.println("</script>");
         pw.println("게시글 작성에 실패했습니다.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>이전페이지로 가기</a>");
      }
      pw.println("</body>");
      pw.println("</html>");
   }
}