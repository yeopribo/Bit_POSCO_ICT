package Pack;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application{
	Socket cs;	// 필드로 선언
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		//--------------------------------------------
		Button btn1 = new Button("접속 버튼");
		btn1.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent arg0) {
				cs = new Socket();
				try {		
					cs.connect( new InetSocketAddress("localhost", 5001) );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//-----------------------------------------------------------	
		TextArea textArea = new TextArea(); // 글자화면공간

		TextField textField = new TextField(); // 글자입력공간
		textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println("앵무새");
				String s = textField.getText(); // 글자출력
				textField.setText(""); // 입력창 초기화
				//System.out.println(s);
				textArea.appendText(s + "\n"); // 공간에 출력
			}
		});
		//---------------------------------------------------------
		
		Button btn2 = new Button("데이터 전송");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream os = cs.getOutputStream();
					String s = textField.getText(); // apple
					byte[] data = s.getBytes(); // 생략된건 보류하고.
					os.write(data);
					System.out.println("데이터 보냄");
				} catch (Exception e) {	e.printStackTrace(); }
			}
		});
				
		Button btn3 = new Button("접속 종료");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
			}
		});
		
		
		root.getChildren().addAll(btn1, btn2, btn3, textArea, textField);
		//--------------------------------------------
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();
	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Client Start");
//		
//		Socket cs = new Socket();
//		try {
//			System.out.println("숫자를 입력하면 접속을 시도합니다.");
//			new Scanner(System.in).nextInt();			
//			cs.connect( new InetSocketAddress("localhost", 5001) );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
	}

}
