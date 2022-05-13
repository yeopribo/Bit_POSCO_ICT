package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {
	@RequestMapping("/") // default
	public String f0() {
		System.out.println("곧 index.jsp가 실행될것임.");
		return "index";
	}
	@RequestMapping("t1")
	public String f1() {
		System.out.println("곧 TigerView.jsp 실행");
		return "TigerView";	
	}
}