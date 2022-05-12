package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

@RestController
class AppController {
	@RequestMapping("/app")
	public String f1() {
		System.out.println("f1");
		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate.getForObject(
			"http://localhost:8082/bpp", String.class);
		
		return "Test01 : " + str;
	}
}

@FeignClient(name="tiger", url="http://localhost:8082")
interface TestClient{
	@RequestMapping("/bpp2")
	String myfunc();
}

@RestController
class AppController2 {
	@Autowired
	TestClient testClient;
	
	@RequestMapping("/app2")
	public String f1() {
		System.out.println("f2");
		String str = testClient.myfunc();
		
		return "Test01 : " + str;
	}
}

//@FeignClient(name="tiger2", url="http://localhost:8082")
//@FeignClient(name="tiger2", fallbackFactory = FallbackFactory.class)
@FeignClient(name="tiger2" , fallbackFactory = FeignFactory.class)
interface TestClient2{
	@RequestMapping("/bpp2")
	String myfunc();
}
@Component
class FeignFactory implements FallbackFactory<TestClient2>{
	@Override
	public TestClient2 create(Throwable cause) {
		System.out.println("factory");
		return new TestClient2() {
			@Override
			public String myfunc() {
				return "에러 발생";
			}
		};
	}
}

@Service
class TestService{
	@Autowired
	TestClient2 testClient;
	
	String myfunc() {
		// 100줄
		String str = testClient.myfunc();
		return str;
	};
}

@RestController
class AppController3 {
	@Autowired
	TestService testService;
	
	@RequestMapping("/app3")
	public String f1() {
		System.out.println("f3");
		String str = testService.myfunc();
		
		return "Test01 : " + str;
	}
}

























