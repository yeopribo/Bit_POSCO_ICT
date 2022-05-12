package Pack01;

import java.sql.ResultSet;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class rabbitDAO {
	
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	public rabbitDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

   public Integer rabbitGet(String name, String result, String q_id, String score) {
      // 기존값 데리고오기 ID 이미 있는 경우
      Boolean isCheck = null;
      String callDataSql = "SELECT exists (select * from game where name=?) as isCheck";
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(callDataSql);
         pstmt.setString(1, name);
         ResultSet rs1 = pstmt.executeQuery();

         if (rs1.next()) {
            isCheck = rs1.getBoolean(1);
         }

         if (isCheck) {
            String updateSql = "update game set score=(select sum(getScore) from multi where name=?) where name=?;";
            try {
               pstmt = conn.prepareStatement(updateSql);
               pstmt.setString(1, name);
               pstmt.setString(2, name);
               System.out.println("여기오니?");
               return pstmt.executeUpdate();
            } catch (Exception e) {
            }

         } else {
            // 이름없음 insert
            String sql = "INSERT INTO game VALUES (null, ?,?,?,?);";
            try {
               pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, name);
               pstmt.setString(2, result);
               pstmt.setString(3, q_id);
               pstmt.setString(4, score);
               return pstmt.executeUpdate();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
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