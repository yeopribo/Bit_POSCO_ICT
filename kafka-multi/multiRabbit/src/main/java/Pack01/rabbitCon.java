package Pack01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class rabbitCon {

	@Autowired
	DataSource dataSource;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	String selectBoard(Model model) {
		System.out.println("결과보기");
		rabbitDAO rabbitDao = new rabbitDAO(dataSource);
		ResultSet rs = rabbitDao.resultBoard();
		try {
			//         while(rs.next()) {
			//            System.out.println(rs.getString("name") + rs.getString("result"));
			//         }
			//         model.addAttribute("resultBoard", rabbitDAO.resultBoard());
			model.addAttribute("resultBoard", rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}

//	@RequestMapping(value = "/selectQ", method = RequestMethod.GET)
//	String selectQuestion(Model model) {
//		System.out.println("결과보기");
//		ResultSet rs = rabbitDAO.questionBoard();
//		try {
//			//        while(rs.next()) {
//			//           System.out.println(rs.getString("name") + rs.getString("result"));
//			//        }
//			//        model.addAttribute("resultBoard", rabbitDAO.resultBoard());
//			model.addAttribute("questionBoard", rs);
//			while (rs.next()) {
//				System.out.println(rs.getString("name"));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "index";
//	}
}
