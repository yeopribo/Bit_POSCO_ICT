package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class Tiger {
	@RequestMapping("/")
	public String f0() {
		System.out.println("f0 call");
		
		return "index";
	}
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "TigerView";
	//	return "redirect:/";	// 항상 root경로로 보내고싶을때
	}

}

@RestController
class AppController {
	@RequestMapping("/bpp")
	public String f1() {
		System.out.println("bpp");
		
		return "Test 02";
	}
	
	@RequestMapping("/bpp2")
	public String f2() {
		System.out.println("bpp2");
		
		return "Test 03";
	}
}