package Pack;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class ListBoard extends HttpServlet{
	@Override
	protected void service(HttpServletRequest resquest, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/db01?&useSSL=false";
			con = DriverManager.getConnection(url, "root", "1234");
			String sql = "select * from boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			pw.println("<div>");
			pw.println("<table border='1' width='1200'>");
			pw.println("<tr>");
			pw.println("<td>����</td>");
			pw.println("<td>�ۼ���</td>");
			pw.println("<td>�����</td>");
			pw.println("<td>����</td>");
			pw.println("<td>����</td>");
			pw.println("</tr>");
			while(rs.next()){

				String title = rs.getString("title");
				String wr = rs.getString("wr");
				Timestamp regdate = rs.getTimestamp("regdate");
				pw.println("<tr>");
				pw.println("<td>" + title + "</td>");
				pw.println("<td>" + wr + "</td>");
				pw.println("<td>" + regdate + "</td>");
				pw.println("<td><a href='deleteboard.do?wr=" + wr + "'>����</a></td>");
				pw.println("<td><a href='updateboard.do?wr=" + wr + "'>����</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("</div>");
			pw.println("<a href='index.html'>������������ �̵�</a>");
		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		pw.println("</body>");
		pw.println("</html>");
	}
}