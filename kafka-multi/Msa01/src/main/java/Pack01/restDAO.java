package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class restDAO {
	public static Integer rabbitAGet(MultiplicationResultAttempt mra) {
	       Connection conn = null;
	       PreparedStatement pstmt = null;
	       LocalDate now = LocalDate.now();
	       
	       int year = now.getYear();
	       int month = now.getMonthValue();
	       int day = now.getDayOfMonth();
	       
	       String name = mra.getUser().getAlias();
	       String factorA = Integer.toString(mra.multiplication.getFactorA());
	       String factorB = Integer.toString(mra.multiplication.getFactorB());
	       String result = Integer.toString(mra.resultAttempt);
	       String check = (mra.multiplication.getFactorA() * mra.multiplication.getFactorB() == mra.resultAttempt)? "O" : "X";
	       String q_id = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
	       
	       String sql = "INSERT INTO multi VALUES (null, ?,?,?,?,?,now());";
	       
	       try {
	          conn = ConnectionDB.getConnection();
	          pstmt = conn.prepareStatement(sql);
	          pstmt.setString(1, name);
	          pstmt.setString(2, factorA);
	          pstmt.setString(3, factorB);
	          pstmt.setString(4, result);
	          pstmt.setString(5, check);
	          int rs = pstmt.executeUpdate();
	          return rs;
	       } catch (Exception e) {
	          e.printStackTrace();
	       }
	       
	       return null;
	 }
	public static String selectDB() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT q_id FROM multi ORDER BY q_id DESC LIMIT 1;";
        String q_id = "";
        try {
           conn = ConnectionDB.getConnection();
           pstmt = conn.prepareStatement(sql);
           rs = pstmt.executeQuery();
           while(rs.next()) {
              q_id = rs.getString("q_id");
           }
           return q_id;
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        return null;
     }
	
	public static ResultSet questionBoard() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select m.q_id, m.factorA, m.factorB from multi m inner join game g on m.q_id = g.q_id;";
		
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
