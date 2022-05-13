package Pack;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ClientThread extends Thread{
	Socket socket;
	ClientThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		try {										
			InputStream is = socket.getInputStream();
			byte [] recvData = new byte[512]; 
			// read 블로킹함수
			while(true) {	// 클라이언트가 접속을 끊어버리면 -1을 리턴받음
				int size = is.read(recvData);
				if( size == -1 ) {
					System.out.println("클라이언트 접속 종료");
					break;
				}
				String s = new String(recvData, 0, size);
				System.out.println(s);
			}
		} catch (Exception e) { e.printStackTrace(); }
	}
}
class ConnectThread extends Thread{
	@Override
	public void run() {
		try {			
			ServerSocket ss = new ServerSocket();
			System.out.println("메인서버 소켓 생성");
			//ss.bind("ip주소", 포트번호);
			ss.bind( new InetSocketAddress("localhost", 5001) );	// localhost - 127.0.0.1
			System.out.println("바인딩 완료");
			// accept 블로킹 함수
			Socket socket = ss.accept();
			System.out.println("누군가 접속을 시도했음.");
			ClientThread ct = new ClientThread(socket);
			ct.start();
			
			new Thread() {
				@Override
				public void run() {
					
				}
			}.start();
		} catch (Exception e) {	e.printStackTrace(); } // 무조건 걸어놔라 걍
	}
}

public class Server extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		//--------------------------------------------
		Button btn1 = new Button("서버 오픈");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ConnectThread ct = new ConnectThread();
				ct.start();
			}
		});
		
		root.getChildren().add(btn1);
		//--------------------------------------------
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Server");
		stage.show();
	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Server Start");
//		try {			
//			ServerSocket ss = new ServerSocket();
//			System.out.println("메인서버 소켓 생성");
//			//ss.bind("ip주소", 포트번호);
//			ss.bind( new InetSocketAddress("localhost", 5001) );	// localhost - 127.0.0.1
//			System.out.println("바인딩 완료");
//			// 블로킹 함수
//			ss.accept();
//			System.out.println("누군가 접속을 시도했음.");
////			if( ss == null ) {
////				System.out.println("소켓을 생성할수 없다,");
////				exit(0);
////			}
//		} catch (Exception e) {
//			e.printStackTrace(); // 무조건 걸어놔라 걍
//		}
//		
//		System.out.println("숫자를 입력하면 서버를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");

	}

}
