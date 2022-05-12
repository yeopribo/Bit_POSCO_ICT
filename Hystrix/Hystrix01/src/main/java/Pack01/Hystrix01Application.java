package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker	//hystrix랑 동급 용어
@SpringBootApplication
public class Hystrix01Application {

	public static void main(String[] args) {
		SpringApplication.run(Hystrix01Application.class, args);
	}

}
