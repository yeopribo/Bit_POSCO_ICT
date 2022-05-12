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
//		System.out.println("f0 call");
		
		return "index";
	}
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "TigerView";
	//	return "redirect:/";
	}
}

@RestController
@RequestMapping("/bpp")
class BppController{
	@GetMapping("/{bppNum}")
	public String f1(@PathVariable String bppNum) {
		System.out.println(bppNum);
		
		try { Thread.sleep(Integer.parseInt(bppNum)); } catch (Exception e) {	}
		
		return "서비스 광고";
//		throw new RuntimeException("익셉션");
	}
}