package Pack01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ResultController")
public class ResultController{
	
	@GetMapping
	public String selectSurveyService(Model model){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<SurveyDTO> surveylist = new ArrayList<SurveyDTO>();

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://54.144.194.195:3306/db01?&useSSL=false";
			con = DriverManager.getConnection(url, "lion", "1234");
			String sql = "select * from survey";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				surveylist.add(new SurveyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getInt(6)));
			}

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
		model.addAttribute("surveylist", surveylist);
		return "surveyList";
	}
}
