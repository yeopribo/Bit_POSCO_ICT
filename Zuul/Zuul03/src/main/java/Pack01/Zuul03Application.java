package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Zuul03Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul03Application.class, args);
	}
}
