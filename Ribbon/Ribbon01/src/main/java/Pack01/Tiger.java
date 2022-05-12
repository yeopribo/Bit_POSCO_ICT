package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

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
@RequestMapping("/app")
class AppController{
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("")
	public String f1() {
		System.out.println(1000);
		String result = restTemplate.getForObject(
//				"http://localhost:8082/bpp", 
				"http://tiger/bpp", 
				String.class);
		return "test : " + result;
	}
}







