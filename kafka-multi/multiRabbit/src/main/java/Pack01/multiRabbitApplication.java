package Pack01;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class multiRabbitApplication extends SpringBootServletInitializer{
	@Bean	// 여기서 객체가 생성된다라는것을 의미
	Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	// 이 부분을 추가함 (war 배포를 위한 소스)
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(multiRabbitApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(multiRabbitApplication.class, args);
	}

}
