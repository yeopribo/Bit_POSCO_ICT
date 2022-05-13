package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tiger {
	@RequestMapping("/t1")
	String func01() {
		System.out.println("호랑이1");

		return "TigerView";
	}
	
	@RequestMapping("/t2")
	String func02() {
		System.out.println("호랑이2");

		return "TigerView";
	}
	//@RequestParam(value="name") : 클라이언트에서 name이라는 이름으로 전송됨
	@RequestMapping("/t3")
	String func03(@RequestParam(value="name") String name ) {
		System.out.println("f3 call");
		System.out.println(name);
		
		return "TigerView";
	}
	
	@RequestMapping("/t4")
	String func04(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") String age) {
		System.out.println("f4 call");
		System.out.println(name + " " + age);
		
		return "TigerView";
	}
	
	@RequestMapping("/t5")
	String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("f5 call");
		System.out.println(name + " " + age);
		
		return "TigerView";
	}
	
	@RequestMapping("/t6")
	String func06(Model model) {
		System.out.println("f6 call");
		model.addAttribute("name", "독수리");
		model.addAttribute("age", 200);
		return "TigerView";
	}
	
	@RequestMapping("/t7")
	String func07(
			Model model,
			@RequestParam(value="name") String name,
			@RequestParam(value="age") String age) {
		System.out.println("f7 call");
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "TigerView";
	}
	
	@RequestMapping("/t8")
	ModelAndView func08() {
		System.out.println("f8 call");
		String s = null;
		if(3 > 2) {			
			s = "TigerView";
		}else {
			s = "LionView";
		}
		ModelAndView mv = new ModelAndView(s);
		mv.addObject("name", "앵무새");
		mv.addObject("age", 400);
		return mv;
	}
	
	@RequestMapping("/t10")
	String func10(Person person) {
		// 속성이 10개를 보냈다고 했을때
		// 객체로 10로 한꺼번에 받을려고 한다.
		// DTO(커멘드 객체) ->>
		// VO >> Entity
		System.out.println("f10 call");
		System.out.println(person.getId());
		System.out.println(person.getPwd());

		return "TigerView";
	}
	
	@RequestMapping("/t11")
	String func11(Model model) {
		// 1. Int
		int num = 10;
		model.addAttribute("num", num);
		
		// 2. String
		String str = "문자열";
		model.addAttribute("str", str);
		
		// 3. Array 전달
		int[] ar = {10, 20, 30};
		model.addAttribute("ar", ar);
	
		// 4. 객체 전송
		Person person = new Person();
		person.setId("소나무");
		person.setPwd(1234);
		model.addAttribute("person", person);
		
		// 5. Collection 전송(Integer)
		LinkedList<Integer> list01 = new LinkedList<Integer>();
		list01.add(40);
		list01.add(50);
		list01.add(60);
		model.addAttribute("list01", list01);
		
		// 6. Collection 전송(String)
		LinkedList<String> list02 = new LinkedList<String>();
		list02.add("독수리0");
		list02.add("독수리1");
		list02.add("독수리2");
		model.addAttribute("list02", list02);
		
		// 7. Collection 전송(String)
		LinkedList<Person> list03 = new LinkedList<Person>();
		list03.add(new Person("독수리3", 10));
		list03.add(new Person("독수리4", 20));
		list03.add(new Person("독수리5", 30));
		model.addAttribute("list03", list03);


		return "LionView";
	}
}

