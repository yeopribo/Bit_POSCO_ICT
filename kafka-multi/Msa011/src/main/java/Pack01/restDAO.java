package Pack01;

import java.time.LocalDate;
import java.util.LinkedList;
import java.sql.*;

import javax.sql.DataSource;

public class restDAO {

	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	public restDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Integer rabbitAGet(MultiplicationResultAttempt mra, String q_id) {

		String name = mra.getUser().getAlias();
		String factorA = Integer.toString(mra.multiplication.getFactorA());
		String factorB = Integer.toString(mra.multiplication.getFactorB());
		String result = Integer.toString(mra.resultAttempt);
		String check = (mra.multiplication.getFactorA() * mra.multiplication.getFactorB() == mra.resultAttempt) ? "O"
				: "X";
		
		int getScore = (check == "O")
				? (mra.getMultiplication().getFactorA() / 10) + (mra.getMultiplication().getFactorB() / 10) + 10
				: 0;

		String sql = "INSERT INTO multi VALUES (null, ?,?,?,?,?,now(),?);";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("여기들어오고있어야해...");
			pstmt.setString(1, name);
			pstmt.setString(2, factorA);
			pstmt.setString(3, factorB);
			pstmt.setString(4, result);
			pstmt.setString(5, check);
			pstmt.setInt(6, getScore);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	    	         System.out.println(e.getMessage());
	    	      }
		}

		return null;
	}

	public LinkedList<Multi> questionBoard() {
		String sql = "select name, score as score from game order by cast(score as unsigned) desc;";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			LinkedList<Multi> result = new LinkedList<Multi>();
			String name = "";
			String score = "";
			
			while (rs.next()) {
				Multi multi = new Multi();
				name = rs.getString("name");
				score = rs.getString("score");
				multi.setName(name);
				multi.setScore(score);
				
				result.add(multi);
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	    	         System.out.println(e.getMessage());
	    	      }
		}
		return null;
	}
}