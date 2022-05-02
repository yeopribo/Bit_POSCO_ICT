package Pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {

	public static Connection getConnection()
	{
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://18.212.179.103:3306/kafka";
			conn = DriverManager.getConnection(url, "lion", "1234");

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null)
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}