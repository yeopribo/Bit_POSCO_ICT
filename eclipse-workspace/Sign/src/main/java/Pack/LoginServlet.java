package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest resquest, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/db01?&useSSL=false";
			con = DriverManager.getConnection(url, "root", "1234");
			String sql = "select id from members";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");

				pw.println("<td>" + id + "</td>");
				pw.println("<td>" + pwd + "</td>");

			}
			pw.println("</table>");
			pw.println("</div>");
			pw.println("<a href='index.html'>회원가입</a>");
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
	}
}