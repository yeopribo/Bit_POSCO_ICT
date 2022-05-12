package Pack01;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.*;

@RestController
public class Tiger {
	@RequestMapping("/")
	public String f0() {
		System.out.println("f0 call");
		RestTemplate restTemplete = new RestTemplate();
		//
		@SuppressWarnings("unchecked")
		ResponseEntity<Multi[]> result = restTemplete.getForEntity("http://54.180.120.214:8080/msa011/t4", Multi[].class);

		String st = "";
		for (int i = 1; i <= result.getBody().length; i++) {
			st += ("<tr>" + "<td>" + i + "</td>" + "<td>" + result.getBody()[i - 1].getName() + "</td>" + "<td>"
					+ result.getBody()[i - 1].getScore() + "</td>" + "</tr>");
		}

		return "<table border='1'>" + "<tr>" + "<th>rank</th>" + "<th>name</th>" + "<th>Score</th>" + "</tr>" + st
				+ "</table>";
	}

	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		return "TigerView";
	}
}

@Component
//@Controller
class RecvResult {
	@Autowired
	DataSource dataSource;
	public void receiver(ResultObj resultObj) {

		System.out.println(resultObj.toString());
	}

	@KafkaListener(topics = "exam", groupId = "foo", containerFactory = "stockChangeListener")
	public void consume(ResultObj resultObj) {
		System.out.printf("Consumed message : %s%n", resultObj.toString());
		rabbitDAO rabbitDao = new rabbitDAO(dataSource);
		rabbitDao.rabbitGet(resultObj.getName(), resultObj.getResult(), resultObj.getQ_id(), resultObj.getScore());
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
	String score;
}