package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

import feign.Feign;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableCircuitBreaker
public class EurekaWebServerApplication {
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaWebServerApplication.class, args);
	}
	
}

@Configuration
class HystrixConfiguration{
	@Bean
	Feign.Builder feignBuilder() {
	SetterFactory setterFactory = (target, method) -> HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(target.name()))
	    .andCommandKey(HystrixCommandKey.Factory.asKey(Feign.configKey(target.type(), method)))
	    // 위는 groupKey와 commandKey 설정
	    // 아래는 properties 설정
	    .andCommandPropertiesDefaults(HystrixCommandProperties.defaultSetter()
	        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
	        .withMetricsRollingStatisticalWindowInMilliseconds(10000) // 기준시간
	        .withCircuitBreakerSleepWindowInMilliseconds(3000)// 서킷 열려있는 시간
	        .withExecutionTimeoutInMilliseconds(10000)
	        .withCircuitBreakerErrorThresholdPercentage(50)// 에러 비율 기준 퍼센트
	        .withCircuitBreakerRequestVolumeThreshold(5)); // 최소 호출 횟수
	return HystrixFeign.builder().setterFactory(setterFactory);
	}
}
