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

public class UpdateOkBoard extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String wr=req.getParameter("wr");
		String title=req.getParameter("title");
		String content=req.getParameter("content");

		PreparedStatement pstmt = null;
		Connection con = null;
		int n=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/db01?&useSSL=false";
			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "update boards set title=?,content=? where wr=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, wr);

			n = pstmt.executeUpdate();

			if(n>0){
				resp.sendRedirect("listboard.do");
			}else{
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head></head>");
				pw.println("<body>½ÇÆÐ</body>");
				pw.println("</heal>");
				pw.close();
			}

		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}
}