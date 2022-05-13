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
      // 1. �Ķ���ͷ� ���۵� ���� ������.
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String content= request.getParameter("content");
      String wr = request.getParameter("wr");

      int n=0;
      PreparedStatement pstmt = null;
      Connection con = null;

      try{
         // 2. ���۵� ���� db�� ����.
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/db01?&useSSL=false";
         con = DriverManager.getConnection(url, "root", "1234");
         String sql = "insert into boards values( ?,?,?, now() )";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, title);
         pstmt.setString(2, content);
         pstmt.setString(3, wr);

         //sql���� �����ϱ�

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

      // 3. �����(Ŭ���̾�Ʈ)�� ����� �����ϱ�.
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
      pw.println("<html>");
      pw.println("<head></head>");
      pw.println("<body>");
      if(n>0){
         pw.println( wr + "��! �Խñ��� �ۼ��Ǿ����ϴ�.<br/>");
         pw.println("<a href='index.html'>������������ ����</a>");
      }else{
    	 pw.println("<script type=\"text/javascript\">");
    	 pw.println("alert('�������� �ʴ� ���̵��Դϴ�.');");
    	 pw.println("</script>");
         pw.println("�Խñ� �ۼ��� �����߽��ϴ�.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>������������ ����</a>");
      }
      pw.println("</body>");
      pw.println("</html>");
   }
}