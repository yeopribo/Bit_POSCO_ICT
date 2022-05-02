package Pack01;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

//@Controller
//public class Tiger {
//	@RequestMapping("/t1")
//	String f1() {
//		System.out.println("들어옴");
//		return "TigerView";
//	}
//}

//@RestController
//public class Tiger {
//	@RequestMapping("/t1")
//	String f1() {
//		System.out.println("들어옴");
//		return "호랑이";
//	}
//}

@RequiredArgsConstructor
@Getter
@ToString
class Multiplication{
	final int factorA;
	final int factorB;
	Multiplication(){
		this(0, 0);
	}
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User{	// 수검자 정보
	private String alias;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class MultiplicationResultAttempt{
	private User user;	// 수검자
	Multiplication multiplication;	// 문제
	int resultAttempt;	//답안
}

// 문제 출제서비스
interface MultipleService{
	   Multiplication createRandomMultiplication();
	   boolean checkAttempt(MultiplicationResultAttempt resultAttempt);
	}


@Service
class MultiplicationServiceImpl implements MultipleService{
	public Multiplication createRandomMultiplication() {
		Random rnd = new Random();
		int factorA = rnd.nextInt(10);
		int factorB = rnd.nextInt(10);
		
		return new Multiplication(factorA, factorB);
	}
	
	public // 답안 채점 서비스
	boolean checkAttempt(MultiplicationResultAttempt mra) {
		return mra.getResultAttempt() == 
				mra.getMultiplication().getFactorA() *
				mra.getMultiplication().getFactorB();
	}
}
// 채점서비스
@RestController
public class Tiger {
	@Autowired
	MultiplicationServiceImpl ms;
	
	@RequestMapping("/t1")
	Multiplication f1() {
		System.out.println("들어옴");
//		Multiplication m = ms.createRandomMultiplication();
//		System.out.println(m.getFactorA());
//		System.out.println(m.getFactorB());
//		return new Multiplication(3, 4);
		return ms.createRandomMultiplication();
	}
	
	@RequestMapping("/t2")
	boolean f2(@RequestBody MultiplicationResultAttempt mra) {
		System.out.println(mra);
		System.out.println(mra.getUser().getAlias());
		System.out.println(mra.multiplication.factorA);
		System.out.println(mra.multiplication.factorB);
		System.out.println(mra.resultAttempt);
		System.out.println("f2 들어옴");
		
		// true : tiger
		
		// return true;
		return ms.checkAttempt(mra);
	}
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@RequestMapping("/t3")
	public String f3(@RequestBody MultiplicationResultAttempt mra) {
		String username = mra.getUser().getAlias();
	    String userresult = ms.checkAttempt(mra)? "O" : "X";
	    
	    restDAO.rabbitAGet(mra);
	    
	    String q_id = restDAO.selectDB();
	    
	    ResultObj resultObj = new ResultObj(username, userresult, q_id);
	    rabbitTemplate.convertAndSend(
	    		"exchange03",
	    		"routingKey03",
	    		resultObj
        );
	    
	    System.out.println(mra);
		System.out.println(username);
		System.out.println(userresult);
		return userresult;
	}
	
   @RequestMapping("/t4")
   LinkedList<Multi> f4() {
     ResultSet rs =  restDAO.questionBoard();
     String factorA = "";
     String factorB = "";
     String q_id = "";
     
     LinkedList<Multi> result = new LinkedList<Multi>();
     try {
        while(rs.next()) {
               Multi multi = new Multi();
               factorA = rs.getString("factorA");
               factorB = rs.getString("factorB");
               q_id = rs.getString("q_id");
                  
               multi.setFactorA(factorA);
               multi.setFactorB(factorB);
               multi.setQ_id(q_id);
              
               result.add(multi);
               
//             System.out.println(multi.getFactorA() + " " + multi.getFactorB() + " " + multi.getQ_id());
        }
      } catch (Exception e) {
         // TODO: handle exception
      }
     return result;
   }
}

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class ResultObj{
   String name;
   String result;
   String q_id;
}

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Multi{
	String name;
   String factorA;
   String factorB;
   String q_id;
}
