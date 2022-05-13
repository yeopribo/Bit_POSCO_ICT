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
			// read ���ŷ�Լ�
			while(true) {	// Ŭ���̾�Ʈ�� ������ ��������� -1�� ���Ϲ���
				int size = is.read(recvData);
				if( size == -1 ) {
					System.out.println("Ŭ���̾�Ʈ ���� ����");
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
			System.out.println("���μ��� ���� ����");
			//ss.bind("ip�ּ�", ��Ʈ��ȣ);
			ss.bind( new InetSocketAddress("localhost", 5001) );	// localhost - 127.0.0.1
			System.out.println("���ε� �Ϸ�");
			// accept ���ŷ �Լ�
			Socket socket = ss.accept();
			System.out.println("������ ������ �õ�����.");
			ClientThread ct = new ClientThread(socket);
			ct.start();
			
			new Thread() {
				@Override
				public void run() {
					
				}
			}.start();
		} catch (Exception e) {	e.printStackTrace(); } // ������ �ɾ���� ��
	}
}

public class Server extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		//--------------------------------------------
		Button btn1 = new Button("���� ����");
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
//			System.out.println("���μ��� ���� ����");
//			//ss.bind("ip�ּ�", ��Ʈ��ȣ);
//			ss.bind( new InetSocketAddress("localhost", 5001) );	// localhost - 127.0.0.1
//			System.out.println("���ε� �Ϸ�");
//			// ���ŷ �Լ�
//			ss.accept();
//			System.out.println("������ ������ �õ�����.");
////			if( ss == null ) {
////				System.out.println("������ �����Ҽ� ����,");
////				exit(0);
////			}
//		} catch (Exception e) {
//			e.printStackTrace(); // ������ �ɾ���� ��
//		}
//		
//		System.out.println("���ڸ� �Է��ϸ� ������ �����մϴ�.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");

	}

}
