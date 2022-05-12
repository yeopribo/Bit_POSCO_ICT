package Pack01;

import java.util.Random;

import org.junit.jupiter.api.Test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lombok.*;

import static org.mockito.BDDMockito.*;


@SpringBootTest
class Msa011ApplicationTests{

	@Test
	void test01() {
		
	}
}


/*// 3.9,10
class Multiple{
	int factorA, factorB;
	int result;
	Multiple(int factorA, int factorB){
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = this.factorA * this.factorB;
	}
	void show() {
		System.out.println("factorA : " + factorA);
		System.out.println("factorB : " + factorB);
		System.out.println("result : " + result);
	}
}
interface RandomGenService{
	int getGenRandom();
}
// 난수 생성 서비스
@Service
class RandomGenServiceImpl implements RandomGenService{
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
}

interface MultipleService{
	Multiple getMultiple();
	boolean checkAttempt(MultiplicationResultAttempt resultAttempt);
}
// 곱셈 생성 서비스
@Service
class MultipleServiceImpl implements MultipleService{
	@Autowired
	RandomGenService rnd;
	public Multiple getMultiple() {
		int a = rnd.getGenRandom();
		int b = rnd.getGenRandom();
		return new Multiple(a, b);
	}
	@Override
	public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
		return false;
	}
}

@RequiredArgsConstructor
@ToString
@Getter
class User{
	final String alias;
	User(){
//		this(null);
		alias = "익명";
	}
}

@RequiredArgsConstructor
class MultiplicationResultAttempt{
	final User user;
	final Multiple multiple;
	final int resultAttempt;
	
	public MultiplicationResultAttempt() {
		this( null, null, 0);
	}
}

@SpringBootTest
class Msa01ApplicationTests{
	@Autowired
	MultipleService multipleService;
	
	@Test
	void test01() {
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(
				new User("tiger"), multipleService.getMultiple(), 3000
		);
		multipleService.checkAttempt(attempt);
	}
}
*/

/*
// 3.8
//class Tiger{
//	final String name;
//	final int age;
//	Tiger(){
//		this("",0);
//	}
//	Tiger(String name, int age){
//		this.name = name;
//		this.age = age;
//	}
//}
@RequiredArgsConstructor
class Tiger{
	final String name;
	final int age;
	Tiger(){
		this("",0);
	}
}

@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
//		Tiger t1 = new Tiger("호랑이", 10);
//		System.out.println(t1.toString());
	}
}
*/

/*
// 2장
class Multiple{
	int factorA, factorB;
	int result;
	Multiple(int factorA, int factorB){
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = this.factorA * this.factorB;
	}
	void show() {
		System.out.println("factorA : " + factorA);
		System.out.println("factorB : " + factorB);
		System.out.println("result : " + result);
	}
}
interface RandomGenService{
	int getGenRandom();
}
class RandomGenServiceImpl implements RandomGenService{
	@Override
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
}
// 곱셈 문제 생성지
interface MultipleGenService{
	Multiple getMultiple();
}
class MultipleGenServiceImpl implements MultipleGenService{
	@Override
	public Multiple getMultiple() {
		RandomGenServiceImpl r = new RandomGenServiceImpl();
		return new Multiple(r.getGenRandom(),r.getGenRandom());
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		
	}
}
*/

/*
// 곱셈 문제지 
class Multiple{
	int factorA, factorB;
	int result;
	Multiple(int factorA, int factorB){
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = this.factorA * this.factorB;
	}
	void show() {
		System.out.println("factorA : " + factorA);
		System.out.println("factorB : " + factorB);
		System.out.println("result : " + result);
	}
}
interface RandomGenService{
	int getGenRandom();
}
// 난수 생성 서비스
@Service
class RandomGenServiceImpl implements RandomGenService{
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
}
interface MultipleService{
	Multiple getMultiple();
}
// 곱셈 생성 서비스
@Service
class MultipleServiceImpl implements MultipleService{
	@Autowired
	RandomGenService rnd;
	public Multiple getMultiple() {
		int a = rnd.getGenRandom();
		int b = rnd.getGenRandom();
		return new Multiple(a, b);
	}
}

@SpringBootTest
class Msa01ApplicationTests{
	@Autowired
	MultipleService multipleService;
	@Test
	void test01() {
		Multiple multiple = multipleService.getMultiple();
		multiple.show();
	}
}
*/

/*
// 					Multiplication

// RandomGeneratorService		MultiplicationService
// RandomGeneratorServiceImpl	MultiplicationServiceImpl

class Multiplication{
	int factorA, factorB;
	int result;
	Multiplication(int factorA, int factorB){
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = factorA * factorB;
	}
	int getFactorA() { return factorA; }
	int getFactorB() { return factorB; }
	int getResult() { return result; }
	@Override
	public String toString() {
		return "Multiplication [factorA=" + factorA + ", factorB=" + factorB + ", result=" + result + "]";
	}
	
}
// ex) B
interface RandomGeneratorService {
	int generateRandomFactor();
}
// p28
@Service
class RandomGeneratorServiceImpl implements RandomGeneratorService{
	@Override
	public int generateRandomFactor() {
//		int a = 10;
//		int b = 20;
//		return new Random().nextInt(b-a+1)+a;
		return new Random().nextInt(100);
	}
}

// ex) C
interface MultiplicationService{
	Multiplication createRandomMultiplication();
}

@Service
class MultiplicationServiceImpl implements MultiplicationService{
	@Autowired
	RandomGeneratorService randomGeneratorService;
	
//	정석코드
//	@Autowired
//	MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
//		this.randomGeneratorService = randomGeneratorService;
//	}
	
	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}
}

interface AAA{
	int getRandomNum();
}

interface BBB{
	int get();
}
@Service
class BBBImpl implements BBB{
	@Autowired
	AAA aaa;
	
	@Override
	public int get() {
		System.out.println(aaa.getRandomNum());
	    System.out.println(aaa.getRandomNum());
	    System.out.println(aaa.getRandomNum());
	    System.out.println(aaa.getRandomNum());
		return 10;
	}
}

@SpringBootTest
class Msa01ApplicationTests{
	@Autowired
	MultiplicationServiceImpl multiplicationServiceImpl;
	
	@MockBean
	AAA aaa;
	
	@Autowired
	BBB bbb;
	
	@Test
	void test01() {
//		Multiplication m = multiplicationServiceImpl.createRandomMultiplication();
//		System.out.println(m.toString());
		
		// 랜덤한 2개의 숫자를 뽑는다
		given(aaa.getRandomNum()).willReturn(10,20,30,40);
		
		bbb.get();
		
		System.out.println("end");
		// 1. 회사에서 시험 문제를 출제한다
		// 2. 시험문제는 랜덤한 2개의 숫자이다
		// 3. 2개의 숫자를 사용자가 곱한다
		// 4. 곱한결과를 회사에 다시 제출한다
		// 5. 제출된 결과를 채점한다
		// 6. 채점결과를 사용자에게 다시 돌려준다
	}
}
*/

/*
// 0419-3
class A{
	int a, b;
	A(int a, int b){
		this.a = a;
		this.b = b;
	}
	int getResult() { return a * b; }
}

interface B{
	int getNum();
}

// 랜덤 전문 관리 클래스
@Service
class BImpl implements B{
	@Override
	public int getNum() {
		return new Random().nextInt(10);
	}
}

interface C{
	A f1();
}
@Service
class CImpl implements C{
	@Autowired
	B b;
	
	@Override
	public A f1() {
		return new A(b.getNum(), b.getNum());
	}
}

@SpringBootTest
class Msa01ApplicationTests{
	@Autowired
	C c;
	
	@Test
	void test01() {
		A a = c.f1();
		System.out.println(a.a + " " + a.b );
		System.out.println(a.getResult());
	}
}

// @Service
// @Component
// @Controller
// @Repository
*/

/*
// 0419-2
interface A{
	void f1();
}
@Service
class AImpl implements A{
	@Override
	public void f1() {
		System.out.println("call");

	}
}
@SpringBootTest
class Msa01ApplicationTests{
	// 99%
	@Autowired
	A a;
	// 1%
	@Autowired
	AImpl b;

	@Test
	void test01() {
		a.f1();
		b.f1();
	}
}
*/


/*
 * // 0419 확인용
 * 
 * @Service("tiger") class Tiger{ Tiger(){ System.out.println("생성자 콜"); } void
 * f1() { System.out.println("f1 call"); } }
 * 
 * @SpringBootTest class Msa01ApplicationTests implements
 * ApplicationContextAware{ ApplicationContext applicationContext;
 * 
 * @Override public void setApplicationContext( ApplicationContext
 * applicationContext) throws BeansException {
 * System.out.println("setApplicationContext"); this.applicationContext =
 * applicationContext; }
 * 
 * @Test void test01() { System.out.println(1000); try { Tiger t =
 * applicationContext.getBean("tiger", Tiger.class);
 * System.out.println(toString().hashCode()); t.f1(); } catch (Exception e) { //
 * TODO: handle exception e.printStackTrace(); } // System.out.println(); }
 * 
 * }
 */
