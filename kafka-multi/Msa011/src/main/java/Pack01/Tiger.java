package Pack01;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
class Multiplication {
	final int factorA;
	final int factorB;

	Multiplication() {
		this(0, 0);
	}
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User { // 수검자 정보
	private String alias;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class MultiplicationResultAttempt {
	private User user; // 수검자
	Multiplication multiplication; // 문제
	int resultAttempt; // 답안\
	int score;
}

// 문제 출제서비스
interface MultipleService {
	Multiplication createRandomMultiplication();

	boolean checkAttempt(MultiplicationResultAttempt resultAttempt);
}

@Service
class MultiplicationServiceImpl implements MultipleService {
	public Multiplication createRandomMultiplication() { // 문제생성
		Random rnd = new Random();
		int factorA = rnd.nextInt(90) + 10;
		int factorB = rnd.nextInt(90) + 10;

		return new Multiplication(factorA, factorB);
	}

	public // 답안 채점 서비스
	boolean checkAttempt(MultiplicationResultAttempt mra) {
		return mra.getResultAttempt() == mra.getMultiplication().getFactorA() * mra.getMultiplication().getFactorB();
	}
}

// 채점서비스
@RestController
public class Tiger {

	@Autowired
	DataSource dataSource;

	@Autowired
	MultiplicationServiceImpl ms;

	@RequestMapping("/t1")
	Multiplication f1() {
		System.out.println("들어옴");
		return ms.createRandomMultiplication(); //문제 생성 -> msa 인덱스 문제요청 버튼 
	}

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	private KafkaTemplate<String, ResultObj> kafkaTemp;

	@RequestMapping("/t3") //문제 풀고 난 후 제출. 
	public String f3(@RequestBody MultiplicationResultAttempt mra) {
		
		// data 만들기
		String username = mra.getUser().getAlias();
		String userresult = ms.checkAttempt(mra) ? "O" : "X";
		String userscore = "0";
		if (userresult == "O") {
			userscore = Integer.toString(
					(mra.getMultiplication().getFactorA() / 10) + (mra.getMultiplication().getFactorB() / 10) + 10);
		}
		LocalDate now = LocalDate.now();

		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		String q_id = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
		
		// db 넣기
		restDAO restDao = new restDAO(dataSource);
		restDao.rabbitAGet(mra, q_id);

		// 카프카 전송
		ResultObj resultObj = new ResultObj(username, userresult, q_id, userscore);
		this.kafkaTemp.send("exam", resultObj);
		return userresult;
	}

	@RequestMapping("/t4") //멀티 프로젝트의 tiger 에서 씀. 
	LinkedList<Multi> f4() {
		// 데이터 만들기
		restDAO restDao = new restDAO(dataSource);
		LinkedList<Multi> result = restDao.questionBoard(); 
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 데이터 보내기
		return result;
	}
}

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class ResultObj {
	String name;
	String result;
	String q_id;
	String score;
}

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Multi {
	String name;
	String factorA;
	String factorB;
	String q_id;
	String score;
}