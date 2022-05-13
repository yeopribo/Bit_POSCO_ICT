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
	Socket cs;	// �ʵ�� ����
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		//--------------------------------------------
		Button btn1 = new Button("���� ��ư");
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
		TextArea textArea = new TextArea(); // ����ȭ�����

		TextField textField = new TextField(); // �����Է°���
		textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println("�޹���");
				String s = textField.getText(); // �������
				textField.setText(""); // �Է�â �ʱ�ȭ
				//System.out.println(s);
				textArea.appendText(s + "\n"); // ������ ���
			}
		});
		//---------------------------------------------------------
		
		Button btn2 = new Button("������ ����");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream os = cs.getOutputStream();
					String s = textField.getText(); // apple
					byte[] data = s.getBytes(); // �����Ȱ� �����ϰ�.
					os.write(data);
					System.out.println("������ ����");
				} catch (Exception e) {	e.printStackTrace(); }
			}
		});
				
		Button btn3 = new Button("���� ����");
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
//			System.out.println("���ڸ� �Է��ϸ� ������ �õ��մϴ�.");
//			new Scanner(System.in).nextInt();			
//			cs.connect( new InetSocketAddress("localhost", 5001) );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		System.out.println("���ڸ� �Է��ϸ� Ŭ���̾�Ʈ�� �����մϴ�.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
	}

}
