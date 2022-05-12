package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping("/bpp/{tlrks}")
	public String f1(@PathVariable String tlrks) {
		System.out.println("bpp" + tlrks);
		
		try { Thread.sleep(Integer.parseInt(tlrks)); } catch (Exception e) {}
		return "Test 01";
	}
	
}