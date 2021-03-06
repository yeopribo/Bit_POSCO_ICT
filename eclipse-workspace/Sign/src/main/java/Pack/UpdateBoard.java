package Pack;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class UpdateBoard extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1. parameter로 전송된 id얻기.
		String wr=req.getParameter("wr");

		// 2. id에 해당하는 정보를 db에서 조회해서 출력.
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs=null;
		try{
			// 2. 전송된 값을 db에 저장.
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/db01?&useSSL=false";
			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "select * from boards where wr=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wr);

			//sql구문 실행하기
			rs = pstmt.executeQuery();
			rs.next();
			String title = rs.getString("title");
			String content=rs.getString("content");

			//pw.println("<div class=\"container\">");
			pw.println("<form method='post' action='updateokboard.do'>");
			pw.println("<input type='hidden' name='wr' value='" + wr + "'/>");
			pw.println("작성자<input type='text' name='id' value='" + wr + "' disabled='disabled'/><br/>");
			pw.println("제목<input type='text' name='title' value='" + title + "'/><br/>");
			pw.println("내용<textarea name='content' row='5' value='" + content + "'</textarea><br/>");
			pw.println("<input type='submit' value='저장'/><br/>");
			pw.println("</form>");
			//pw.println("</div>");
			
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
		pw.close();
	}
}