package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Component
//	1. @Controller
//	2. @Service
//	3. @Repository
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
	@RequestMapping("t2")
	public String f2(@RequestParam(value="name") String name) {
		System.out.println(name);
		return "TigerView";
	}
	@RequestMapping("t3/{num}")
	public String f3(@PathVariable String num) {
		System.out.println(num);
		return "TigerView";
	}
}
// @RestController : @Controller + @ResponseBody
//@Controller
//@ResponseBody
@RestController
@RequestMapping("t4")
class Lion{
	@RequestMapping("")
	public String f4() {
		System.out.println("@Con + @Resp");
		return "무궁화 꽃이 피었습니다."; // 문자열 아니면 객체
	}
	// @RequestMapping("/{num}")
	@GetMapping("/{num}")
	public String f5(@PathVariable String num) {
		System.out.println("@Con + @Resp");
		return "무궁화 : " + num; // 문자열 아니면 객체
	}
	@GetMapping("t5/{num}")
	public String f6(@PathVariable String num) {
		System.out.println("@Con + @Resp");
		return "민들레 : " + num; // 문자열 아니면 객체
	}
}

interface Apple{
	void f1();
}
@Service
class AppleImpl implements Apple{
	@Override
	public void f1() {
		System.out.println("call");
	}
}

@Controller
class Frute{
	@Autowired
	Apple apple = null;
	
	@RequestMapping("t6")
	public String f2() {
		apple.f1();
		return "TigerView";
	}
}













