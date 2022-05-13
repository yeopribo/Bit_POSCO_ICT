package Pack;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//0317-7장 AOP ex8
interface Ai{
	void play();
}

class AlphaGo implements Ai{
	@Override
	public void play() {
		System.out.println("인공지능은 알파고");
	}
}
class BetaGo implements Ai{
	@Override
	public void play() {
		System.out.println("인공지능은 베타고");
	}
}

@Aspect
class ProxyBaduk{
	@Pointcut("execution(public void Pack.*.*(..))")
	void something() {}

	@Around("something()")	
	void common(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("대국을 시작합니다.");

		joinpoint.proceed(); 
	
		System.out.println("대국을 종료합니다.");
		System.out.println("---------------------");
	}
}

@Configuration
@EnableAspectJAutoProxy
class AppConfig{
	@Bean
	Ai alphaGo() {
		return new AlphaGo();
	}
	@Bean
	Ai betaGo() {
		return new BetaGo();
	}
	@Bean
	ProxyBaduk proxyBaduk() {
		return new ProxyBaduk();
	}

}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Ai alphaGo = ctx.getBean("alphaGo", Ai.class);
		alphaGo.play();
		
		Ai betaGo = ctx.getBean("betaGo", Ai.class);
		betaGo.play();
		
		ctx.close();
	}
}

/*
//0317-7장 AOP ex7
interface Frute{
	void taste();
}

class Apple implements Frute{
	@Override
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	@Override
	public void taste() {
		System.out.println("Bad");
	}
}
//1. @Aspect 추가
@Aspect
class ProxyTest{
	@Pointcut("execution(public void Pack.*.taste(..))")
	void something() {}	// 아무거나
	// 1. *
	@Around("something()")	// 함수 원형 경로 다 적어줘야함
	void common(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("start");
		// 3. try catch 수정
		joinpoint.proceed(); // {frute.taste();}
	
		System.out.println("end");
		System.out.println("---------------------");
	}
}
// 3
@Configuration
@EnableAspectJAutoProxy
class AppConfig{
	@Bean
	Frute apple() {
		return new Apple();
	}
	@Bean
	Frute orange() {
		return new Orange();
	}
	@Bean
	ProxyTest proxyTest() {
		return new ProxyTest();	// 이름 수정함
		//return new ProxyTest(apple());
	}
	// 4. 주석
//	@Bean
//	ProxyTest proxyTest2() {
//		return new ProxyTest();
//		//return new ProxyTest(orange());
//	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Frute apple = ctx.getBean("apple", Frute.class);
		apple.taste();
		
		// 2. 오렌지 추가
		Frute orange = ctx.getBean("orange", Frute.class);
		orange.taste();
		
		ctx.close();
	}
}*/

/*/
/0317-7장 AOP ex6
interface Frute{
	void taste();
}

class Apple implements Frute{
	@Override
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	@Override
	public void taste() {
		System.out.println("Bad");
	}
}
// 1. @Aspect 추가
@Aspect
class ProxyTest{
	
	// 2. @Around 설정
	// 관심 함수가 인수로 전달이 되는데
	// 그 함수의 원형이 어떻게 생겼는지를 정의해주는 어노테이션을 설정해야 한다.
	@Around("execution(public void Pack.Apple.taste(..))")	// 함수 원형 경로 다 적어줘야함
	void common(ProceedingJoinPoint joinpoint) {
		System.out.println("start");
		
		try {
			joinpoint.proceed(); // {frute.taste();}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("end");
		System.out.println("---------------------");
	}
}
// 3.
@Configuration
@EnableAspectJAutoProxy
class AppConfig{
	@Bean
	Frute apple() {
		return new Apple();
	}
	@Bean
	Frute orange() {
		return new Orange();
	}
	@Bean
	ProxyTest proxyTest() {
		return new ProxyTest();	// 이름 수정함
		//return new ProxyTest(apple());
	}
	// 4. 주석
//	@Bean
//	ProxyTest proxyTest2() {
//		return new ProxyTest();
//		//return new ProxyTest(orange());
//	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Frute apple = ctx.getBean("apple", Frute.class);
		apple.taste();
		
		ctx.close();
	}
}*/

/*
//0317-7장 AOP ex5
interface Frute{
	void taste();
}

class Apple implements Frute{
	@Override
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	@Override
	public void taste() {
		System.out.println("Bad");
	}
}
class ProxyTest{
	// 1. 주입객체 생성자 주석처리
//	Frute frute;
//	public ProxyTest(Frute frute) {
//		this.frute = frute;
//	}
	
	// 2. ProceedingJoinPoint joinpoint
	void common(ProceedingJoinPoint joinpoint) {
		System.out.println("start");
		
		// 3. 스프링에서 제공하는 코드로 변경
		//frute.taste();
		try {
			joinpoint.proceed(); // {frute.taste();}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("end");
		System.out.println("---------------------");
	}
}
@Configuration
class AppConfig{
	@Bean
	Frute apple() {
		return new Apple();
	}
	@Bean
	Frute orange() {
		return new Orange();
	}
	// 4. 생성자 인수 전달 삭제
	@Bean
	ProxyTest proxyTest1() {
		return new ProxyTest();
		//return new ProxyTest(apple());
	}
	// 4. 생성자 인수 전달 삭제
	@Bean
	ProxyTest proxyTest2() {
		return new ProxyTest();
		//return new ProxyTest(orange());
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// 5. 
//		ProxyTest t1 = ctx.getBean("proxyTest1", ProxyTest.class);
//		ProxyTest t2 = ctx.getBean("proxyTest2", ProxyTest.class);
//		t1.common();
//		t2.common();
		
		ctx.close();
	}
}*/

/*
//0317-7장 AOP ex4
interface Frute{
	void taste();
}

class Apple implements Frute{
	@Override
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	@Override
	public void taste() {
		System.out.println("Bad");
	}
}
class ProxyTest{
	Frute frute;
	public ProxyTest(Frute frute) {
		this.frute = frute;
	}
	
	void common() {
		System.out.println("start");	// 공
		frute.taste();	// 관심
		System.out.println("end");	// 공
		System.out.println("---------------------");	// 공
	}
}
@Configuration
class AppConfig{
	@Bean
	Frute apple() {
		return new Apple();
	}
	@Bean
	Frute orange() {
		return new Orange();
	}
	@Bean
	ProxyTest proxyTest1() {
		return new ProxyTest(apple());
	}
	@Bean
	ProxyTest proxyTest2() {
		return new ProxyTest(orange());
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		ProxyTest t1 = ctx.getBean("proxyTest1", ProxyTest.class);
		ProxyTest t2 = ctx.getBean("proxyTest2", ProxyTest.class);
		t1.common();
		t2.common();
		
		ctx.close();
	}
}*/

/*
//0317-7장 AOP ex3
interface Frute{
	void taste();
}

class Apple implements Frute{
	@Override
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	@Override
	public void taste() {
		System.out.println("Bad");
	}
}
class ProxyTest{
	Frute frute;
	public ProxyTest(Frute frute) {
		this.frute = frute;
	}
	
	void common() {
		System.out.println("start");	// 공
		frute.taste();	// 관심
		System.out.println("end");	// 공
		System.out.println("---------------------");	// 공
	}
}
public class Hello {
	public static void main(String[] args) {
		ProxyTest t1 = new ProxyTest(new Apple());
		t1.common();
		
		ProxyTest t2 = new ProxyTest(new Orange());
		t2.common();
	}
}*/

/*
// 0317-7장 AOP ex2
interface Frute{
	void taste();
}

class Apple implements Frute{
	public void taste() {
		System.out.println("Good");
	}
}
class Orange implements Frute{
	public void taste() {
		System.out.println("Bad");
	}
}
public class Hello {
	public static void main(String[] args) {
		Frute f1 = new Apple();
		System.out.println("start");	// 공
		f1.taste();	// 관심
		System.out.println("end");	// 공
		System.out.println("---------------------");	// 공
		
		Frute f2 = new Orange();
		System.out.println("start");	// 공
		f2.taste();	// 관심
		System.out.println("end");	// 공
		System.out.println("---------------------");	// 공
	}
}

//----------------------------------------------------------
// 로그인											// 공통
// 보안설정										// 공통
// 공인인증서										// 공통
// 입금, 출금, 이체									// 관심
// 로그아웃										// 공통
//----------------------------------------------------------입출금 프록시

//----------------------------------------------------------
// a = 현재시간										// 공통
// 선택정렬, 버블정렬, 퀵정렬, 합병정렬 >>> 					// 관심
// b = 현재시간										// 공통
// c = b - a										// 공통
//----------------------------------------------------------시간측정 프록시

//----------------------------------------------------------
// 대리운전 접수기능							// 공통
// 대리운전을 실제로 한다.	 					// 관심
// 요금정산								// 공통
//----------------------------------------------------------대리운전 프록시

// 웹 서버 프록시
*/

/*//0317-7장 AOP ex1
class Tiger{
	void f1() {
		System.out.println("start"); // 공통코드(advice)
		
		//System.out.println("아침먹고땡");	// 핵심코드(JoinPoint)
		System.out.println("점심먹고땡");	// 핵심코드(JoinPoint)
		//System.out.println("저녁먹고땡");	// 핵심코드(JoinPoint)
		
		System.out.println("end");	// 공통코드(advice)
	}
}

//System.out.println("아침먹고땡");	// 핵심코드(JoinPoint)
//System.out.println("점심먹고땡");	// 핵심코드(JoinPoint)
//System.out.println("저녁먹고땡");	// 핵심코드(JoinPoint)

@Configuration
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		ctx.close();
	}
}*/

/*//0317-6장 라이프사이클 ex2 page 147
class Tiger{
	Tiger(){
		System.out.println(2);
	}
	public void connect() {
		System.out.println(3);
	}
	public void disconnect(){
		System.out.println(7);
	}
	void f1() {
		System.out.println(5);
	}
}

@Configuration
class AppConfig{
	@Bean(initMethod = "connect", destroyMethod = "disconnect")
	Tiger tiger() {
		return new Tiger();
	}
}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(4);
		Tiger t = ctx.getBean("tiger", Tiger.class);
		t.f1();
		System.out.println(6);
		ctx.close();
		System.out.println(8);
	}
}*/

/*//0317- 6장 라이프사이클 ex1
class Tiger implements InitializingBean, DisposableBean{
	Tiger(){
		System.out.println(2);
	}
	public void afterPropertiesSet() throws Exception {
		// System.out.println(3);
		// 네트워크 접속
	}
	public void destroy() throws Exception {
		System.out.println(7);
		// 접속 종료
	}
	void f1() {
		System.out.println(5);
	}
}

@Configuration
class AppConfig{
	@Bean
	Tiger tiger() {
		return new Tiger();
	}
}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(4);
		Tiger t = ctx.getBean("tiger", Tiger.class);
		t.f1();
		System.out.println(6);
		ctx.close();
		System.out.println(8);
	}
}*/

/*
//0317-5장 컴포넌트스캔 ex6
// 사용자 정의 어노테이션을 자동객체 생성시키고 싶다.
//class Apple{}
//
//class Banana extends Apple{}
//
//class Orange extends Apple{}
//
//class Kiwi{}

@Configuration
@ComponentScan(
		useDefaultFilters = false,
		includeFilters = 
		@ComponentScan.Filter(
				type = FilterType.ASPECTJ,
				// 1.
				// Pack.. = Pack패키지 하위의 모든 패키지
				// * = 모든 클래스
				//pattern = "Pack..*"))
				
				// 2. 모든 패키지
				// pattern = "*..*"))
				
				// 3. 1번과 비교
				// pattern = "Pack.*"))
				
				// 4.
				// pattern = "*..Animal..*"))
				
				// 5.
				// pattern = "*..Animal.*"))
				
				// 6.
				// pattern = "*..Animal..Lion.*"))
				
				// 7. 블랙으로 시작하는 모든 클래스
				// pattern = "*..Black*"))
				
				// 8. Iris로 끝나는 모든 클래스
				// pattern = "*..*Iris"))
				
				// 9. o가 들어가는 모든 클래스
				// pattern = "*..*o*"))
				
				// 10. Rose안에서 o가 들어가는 모든 클래스
				pattern = "*..Rose.*o*"))
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition beanDefinition = ctx.getBeanDefinition(name);
			if(beanDefinition.getRole() != 2) {
				System.out.println(name);
			}
		}
		
		ctx.close();
	}
}*/

/*
//0317-5장 컴포넌트스캔 ex5 
// 사용자 정의 어노테이션을 자동객체 생성시키고 싶다.

class Apple{}

class Banana extends Apple{}

class Orange extends Apple{}

class Kiwi{}

@Configuration
@ComponentScan(
		useDefaultFilters = false,
		includeFilters = 
		@ComponentScan.Filter(
				type = FilterType.ASSIGNABLE_TYPE, // 부모자식관계 모두 객체 생성
				classes = {Apple.class, Kiwi.class}))
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition beanDefinition = ctx.getBeanDefinition(name);
			//System.out.println(bf.getRole());
			if(beanDefinition.getRole() != 2) {
				System.out.println(name);
			}
		}
		
		ctx.close();
	}
}
*/

/*
//0317-5장 컴포넌트스캔 ex4 page 137
//사용자 정의 어노테이션을 자동객체 생성시키고 싶다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Apple{}

@Apple
class Tiger1{}

@Apple
class Tiger2{}

@Apple
class Tiger3{}

@Configuration
@ComponentScan(
		useDefaultFilters = false,
		includeFilters = 
		@ComponentScan.Filter(
				type = FilterType.ANNOTATION,	// 어노테이션 되있는애들 객체 생성
				classes = Apple.class))
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition beanDefinition = ctx.getBeanDefinition(name);
			//System.out.println(bf.getRole());
			if(beanDefinition.getRole() != 2) {
				System.out.println(name);
			}
		}
		
		ctx.close();
	}
}
*/

/*//0317-5장 컴포넌트스캔 ex3
// 어노테이션은 프로그래머가 직접 만들수 있다
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Apple{}

@Apple
class Tiger1{}

@Apple
class Tiger2{}

@Apple
class Tiger3{}

@Configuration
@ComponentScan(useDefaultFilters = false)
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition beanDefinition = ctx.getBeanDefinition(name);
			//System.out.println(bf.getRole());
			if(beanDefinition.getRole() != 2) {
				System.out.println(name);
			}
		}
		
		ctx.close();
	}
}
*/

/*
//0317-5장 컴포넌트스캔 ex2
// 객체를 만들어주는 어노테이션 4가지
@Component
class Tiger1{}

@Controller
class Tiger2{}

@Service
class Tiger3{}

@Repository
class Tiger4{}

@Configuration
@ComponentScan(useDefaultFilters = false)
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition beanDefinition = ctx.getBeanDefinition(name);
			//System.out.println(bf.getRole());
			if(beanDefinition.getRole() != 2) {
				System.out.println(name);
			}
		}
		
		ctx.close();
	}
}
*/
/*
//0317-5장 컴포넌트스캔 ex1
@Configuration
class AppConfig{
	
}

public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			//System.out.println(bf.getRole());
			if(bf.getRole() != BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name);
			}
		}
		ctx.close();
	}
}
*/

/*
//ex4
class FormDTO{
	String name;
}
// VO class
class RegisterRequest{
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다.
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member{
	int id;
	String name;
}
class MemberDao{
	boolean insert(Member member) {
		// 쿼리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
class MemberRegisterService{
	@Autowired
	MemberDao memberDao;
	
	void register(RegisterRequest rr) {
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		if( memberDao.insert(member) == true ) {
			System.out.println("모든 작업이 정상입니다.");
		}
	}
}
@Configuration
class AppConfig{
	@Bean
	MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberRegisterService mrs = 
				ctx.getBean("memberRegisterService",MemberRegisterService.class);
		mrs.register(new RegisterRequest("홍길동"));
//		MemberRegisterService mrs = 
//				new MemberRegisterService(new MemberDao());
//		
//		mrs.register(new RegisterRequest("홍길동"));
		
		ctx.close();
	}
}
*/

/*
//ex3
class FormDTO{
	String name;
}
// VO class
class RegisterRequest{
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다.
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member{
	int id;
	String name;
}
class MemberDao{
	boolean insert(Member member) {
		// 쿼리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
class MemberRegisterService{
	MemberDao memberDao;
	MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	// vo ->> entity
	void register(RegisterRequest rr) {
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		if( memberDao.insert(member) == true ) {
			System.out.println("모든 작업이 정상입니다.");
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		// 1.클라이언트에서 데이터를 전송함
		// 2. 서버에서는 DTO클래스로 값을 얻게 된다.
		// 3. String name = DTO개체.name;
		// 4. 키보드에서 input을 받는다 (input이 DTO데이터이다.)
		
		//RegisterRequest rr = new RegisterRequest(inputName);
		
		MemberRegisterService mrs = new MemberRegisterService(new MemberDao());
		mrs.register(new RegisterRequest("홍길동"));
		
//		MemberDao memberDao = new MemberDao();
//		memberDao.insert(member);
		// member >> DB에 저장( Map Collection 사용)
	}
}
*/

/*
//ex3
class FormDTO{
	String name;
}
// VO class
class RegisterRequest{
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다.
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member{
	int id;
	String name;
}
class MemberDao{
	boolean insert(Member member) {
		// 쿼리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
class MemberRegisterService{
	void register() {
		insert();
	}
}
public class Hello {
	public static void main(String[] args) {
		// 1.클라이언트에서 데이터를 전송함
		// 2. 서버에서는 DTO클래스로 값을 얻게 된다.
		// 3. String name = DTO개체.name;
		// 4. 키보드에서 input을 받는다 (input이 DTO데이터이다.)
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
		
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		MemberDao memberDao = new MemberDao();
		memberDao.insert(member);
		// member >> DB에 저장( Map Collection 사용)
	}
}
*/

/*
//ex2
class FormDTO{
	String name;
}
// VO class
class RegisterRequest{
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다.
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member{
	int id;
	String name;
}

public class Hello {
	public static void main(String[] args) {
		// 1.클라이언트에서 데이터를 전송함
		// 2. 서버에서는 DTO클래스로 값을 얻게 된다.
		// 3. String name = DTO개체.name;
		// 4. 키보드에서 input을 받는다 (input이 DTO데이터이다.)
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
		
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		// member >> DB에 저장( Map Collection 사용)
	}
}
*/

/*
//ex1
class FormDTO{
	String name;
}
// VO class
class RegisterRequest{
	String name;
	RegisterRequest(String name){
		this.name = name;
	}
}
public class Hello {
	public static void main(String[] args) {
		// 1.클라이언트에서 데이터를 전송함
		// 2. 서버에서는 DTO클래스로 값을 얻게 된다.
		// 3. String name = DTO개체.name;
		// 4. 키보드에서 input을 받는다 (input이 DTO데이터이다.)
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
	}
}
*/

/*
// 1. 스프링 없이 주입시키는 방법(생성자주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	Apple apple;
	Orange(Apple apple){
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}

public class Hello {

	public static void main(String[] args) {
		Orange o = new Orange(new Apple());
		o.f2();
	}
}
*/

/*
// 2.스프링 없이 주입시키는 방법(수정자 주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	Apple apple;
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}

public class Hello {
	
	public static void main(String[] args) {
		Orange o = new Orange();
		o.setApple(new Apple());
		o.f2();
	}
}
*/

/*
//3.AutoWired 없이 스프링으로 주입시키는 방법(생성자 주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	// 한번주입이 일어나면 이후는 불변이 원칙. final 적극 권장
	final Apple apple;
	Orange(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig{
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		return new Orange(apple());
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
				Orange orange = ctx.getBean("orange", Orange.class);
				orange.f2();
				ctx.close();
	}
}
*/

/*
//4.AutoWired 없이 스프링으로 주입시키는 방법(setter수정자 주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	Apple apple;
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig{
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		Orange o = new Orange();
		o.setApple(apple());
		return o;
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}
*/

/*
//5.AutoWired를 사용하여 스프링으로 주입시키는 방법(필드 주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	@Autowired
	Apple apple;

	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig{
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		return new Orange();
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}
*/

/*
//6.AutoWired를 사용하여 스프링으로 주입시키는 방법(setter 주입)
class Apple{
	void f1() {	System.out.println("f1 call"); }
}

class Orange{
	Apple apple;
	
	@Autowired
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig{
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		return new Orange();
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}
*/

/* ex
class Apple{
	void f1() {	System.out.println("Apple Call"); }
}
class Orange extends Apple{
	@Override
	void f1() { System.out.println("Orange Call"); }
}
class Kiwi{
	@Autowired
	//@Qualifier("apple")
	@Qualifier("orange")
	Apple apple;
	
	void f2() {
		apple.f1();
	}
}

@Configuration
class AppConfig{	
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		return new Orange();
	}
	@Bean
	Kiwi kiwi() {
		return new Kiwi();
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Kiwi kiwi = ctx.getBean("kiwi", Kiwi.class);
		kiwi.f2();
		
		ctx.close();
	}
}
*/

/*
@Component
class Airplane{
	@Autowired
	Water water;
	
	void fly() {
		this.water.use();
		System.out.println(" 날아올라 저 하늘~");
	}
}
class Water{
	void use() {
		System.out.print("물사용해서");
	}
}
@Configuration
@ComponentScan
class AppConfig{	
	@Bean
	Water water() {
		return new Water();
	}
}
public class Hello {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		airplane.fly();
		
		ctx.close();
	}
}
*/


/*
// 스프링에게 객체를 생성할 환경설정하는 클래스라는 것을 알림
@Configuration
class AppConfig{
	@Bean
	Apple apple() {
		return new Apple();
	}
	@Bean
	Orange orange() {
		return new Orange();
	}
}

// DI(의존주입), AOP(관점지향프로그램), IOC(제어의역전)

public class Hello {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		
		ctx.close();
	}
}
*/
