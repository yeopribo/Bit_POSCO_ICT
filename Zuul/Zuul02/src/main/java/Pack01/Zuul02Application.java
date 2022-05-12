package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Zuul02Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul02Application.class, args);
	}
}
