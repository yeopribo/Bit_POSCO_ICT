package Pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@RequestMapping("/survey")
public class SurveyController {

	@GetMapping
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);
		return "surveyForm";
	}

	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은 무엇입니까?",
				Arrays.asList("서버", "프론트", "풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",
				Arrays.asList("이클립스", "인텔리J", "서브라임"));
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		return Arrays.asList(q1, q2, q3);
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data,
			@RequestParam(value="responses[0]") String roll,
			@RequestParam(value="responses[1]") String tool,
			@RequestParam(value="responses[2]") String talk,
			@RequestParam(value="res.location") String location,
			@RequestParam(value="res.age") String age) {
		
		System.out.println(roll);
		System.out.println(tool);
		System.out.println(talk);
		System.out.println(location);
		System.out.println(age);
		
		int n=0;
	    PreparedStatement pstmt = null;
	    Connection conn = null;
	    ResultSet rs = null;

	    try{
			 String jdbcUrl = "jdbc:mysql://54.144.194.195:3306/db01?&useSSL=false";
		     String dbId = "lion";
		     String dbPass = "1234";
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	     
	      	 String sql = "insert into survey values( null,?,?,?,?,? )";
	          
	      	 pstmt = conn.prepareStatement(sql);

	      	 pstmt.setString(1, roll);
	         pstmt.setString(2, tool);
	         pstmt.setString(3, talk);
	         pstmt.setString(4, location);
	         pstmt.setString(5, age);

	      	 //sql구문 실행하기
	      	 n=pstmt.executeUpdate();

		    }catch(ClassNotFoundException ce){
		       System.out.println(ce.getMessage());
		    }catch(SQLException se){
		       System.out.println(se.getMessage());
		    }
		    try{
		       if(pstmt!=null) pstmt.close();
		       if(conn!=null) conn.close();
		    }catch(SQLException se){
		       System.out.println(se.getMessage());
		    }
		    
		return "submitted";
	}

}