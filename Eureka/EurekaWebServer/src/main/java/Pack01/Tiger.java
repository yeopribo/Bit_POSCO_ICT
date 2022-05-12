package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import feign.hystrix.FallbackFactory;

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


@FeignClient(name="service01" , fallbackFactory = FeignFactory.class, configuration = HystrixConfiguration.class)
interface TestClient{
	@RequestMapping("/bpp/{tlrks}")
	String myfunc(@PathVariable("tlrks") String tlrks);
}
@Component
class FeignFactory implements FallbackFactory<TestClient>{
	@Override
	public TestClient create(Throwable cause) {
		System.out.println("factory");
		return new TestClient() {
			@Override
			public String myfunc(String tlrks) {
				return "에러 발생";
			}
		};
	}
}

@Service
class TestService{
	@Autowired
	TestClient testClient;
	
	String myfunc(String tlrks) {
		// 100줄
		String str = testClient.myfunc(tlrks);
		return str;
	};
}

@RestController
class AppController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/app/{tlrks}")
	public String f1(@PathVariable String tlrks) {
		System.out.println("f1");
		String str = testService.myfunc(tlrks);
		
		return "Test01 : " + str;
	}
}


@FeignClient(name="service02")
interface TestClient2{
	@RequestMapping("/bpp2")
	String myfunc();
}

@RestController
class AppController2 {
	@Autowired
	TestClient2 testClient;
	
	@RequestMapping("/app2")
	public String f1() {
		System.out.println("f2");
		String str = testClient.myfunc();
		
		return "Test02 : " + str;
	}
}












