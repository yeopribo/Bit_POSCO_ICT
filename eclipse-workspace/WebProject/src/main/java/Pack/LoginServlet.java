package Pack;



import java.io.IOException;


import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.ResultSet;



import java.sql.Timestamp;





public class LoginServlet extends HttpServlet{


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// 1. �Ķ���ͷ� ���۵� ���� ������.

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		String pwd= request.getParameter("pwd");

		ResultSet rs = null;


		System.out.println(1);

		int n=0;

		PreparedStatement pstmt = null;

		Connection con = null;

		try{

			// 2. ���۵� ���� db�� ����.

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
			con = DriverManager.getConnection(url, "lion", "1234");

			//			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";
			//			con = DriverManager.getConnection(url, "root", "1234");

			System.out.println(2);

			String sql = "select * from members";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println(3);

			//sql���� �����ϱ�

			while(rs.next()){
				if(id.equals(rs.getString("id"))) {
					if(pwd.equals(rs.getString("pwd"))){
						n=1;
						break;
					}
				}
			}
			System.out.println(4);
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
			pw.println( id + "�α��εǾ����ϴ�..<br/>");
			HttpSession session = request.getSession();
			session.setAttribute("memberId", id);
			//response.sendRedirect("/loginMain.jsp");


			RequestDispatcher rd = request.getRequestDispatcher("/loginMain.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/loginMain.jsp");
		}else{

			pw.println("���� �����Դϴ�..<br/>");

			pw.println("<a href='javascript:history.go(-1)'>������������ ����</a>");

		}


		pw.println("</body>");

		pw.println("</html>");

	}

}