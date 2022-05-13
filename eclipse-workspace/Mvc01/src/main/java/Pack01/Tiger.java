package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {
	@RequestMapping("/t1")
	String func01() {
		System.out.println("호랑이");

		return "TigerView";
	}
	
}
