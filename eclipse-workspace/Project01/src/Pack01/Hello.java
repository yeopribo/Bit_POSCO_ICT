package Pack01;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 	1.Serializable 인터페이스 내부는 비어있지만
//	JVM이 알아서 뭔가를 한다.
//	JSON으로 대충만들고(직렬화) 대충 가져온다(역직렬화).
//	2. FileOutputStream(byte저장 12 34) >> FileWriter(문자 저장) >> 1234
//	3. 자바 직렬화, JSON직렬화
class Tiger implements Serializable{
	String name = "호랑이";
	int age = 1000;
}
public class Hello{
	public static void main(String[] args) {
		Tiger tiger = new Tiger();
		
		try {
			// save
			FileOutputStream fos = new FileOutputStream("sample.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tiger);
			fos.close();
			oos.close();
			
			// load
			FileInputStream fis = new FileInputStream("sample.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Tiger t2 = (Tiger)ois.readObject();
			System.out.println(t2.name + " " + t2.age);
			fis.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
// ex)
class Tiger{

}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
*/

/*
//ex89)

public class Hello {
	public static void main(String[] args) {
		System.out.println("����� Hello");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		System.out.println("Hello ����");
	}
}
*/

/*
//ex88-7) UI
class Tiger extends Thread{
	Hello hello;
	Tiger(Hello hello){
		this.hello = hello;
	}
	@Override
	public void run() {
		System.out.println("������ ����");
		System.out.println("������ ����");
		
		Platform.runLater( ()-> {							
			//btn.setText("ȣ����");
			hello.btn1.setText("ȣ����");
			hello.btn2.setText("������");
		} ); // ����(����)
	}
}

public class Hello extends Application{
	Button btn1;	// ����� ����
	Button btn2;
	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);

		//---------------------------------------------
		btn1 = new Button("��ư1");
		btn2 = new Button("��ư2");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Tiger t = new Tiger(Hello.this); // �͸�Ŭ�����϶� Ŭ�����̸� ����ϰ� this���
				t.start();
			}
		});

		root.getChildren().addAll(btn1, btn2);
		
		//---------------------------------------------
		Scene scene = new Scene(root); // ����
		stage.setScene(scene);
		stage.setTitle("ȣ����");	// ����
		stage.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-6) UI 
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);

		//---------------------------------------------
		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new Thread() {
					@Override
					public void run() {
						System.out.println("������ ����");
						Platform.runLater( ()-> {							
							btn1.setText("ȣ����");
						} ); // ����(����)
						System.out.println("������ ����");
					}
				}.start();
			}
		});

		root.getChildren().addAll(btn1);
		
		//---------------------------------------------
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-5) UI �Ӽ�����

public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);

		//---------------------------------------------
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("ȫ�浿"); // ��ư�̸� �ٲ�
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println("�ڳ���");
				//btn1.setVisible(false); // 
				//btn1.setDisable(true); // Ȱ��ȭ ��Ȱ��ȭ
				//btn1.setVisible( !btn1.isVisible() ); // ���δ�~�Ⱥ��δ�~
				btn1.setVisible( !btn1.isDisable() );
			}
		});
		
		root.getChildren().addAll(btn1, btn2);
		
		//---------------------------------------------
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-4) UI ä��
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);

		//---------------------------------------------
		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Ŭ����......");
			}
		});
		
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
		
		root.getChildren().addAll(btn1, textField, textArea);
		
		
		//---------------------------------------------
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-3) UI
//interface A<T>{
//	void f1();
//}
//
//class Tiger{
//	void f100(A<Integer> tt) {
//		
//	}
//}
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
//		Tiger tiger = new Tiger();
//		
//		tiger.f100(new A<Integer>() {
//			@Override
//			public void f1() {	
//			}
//		});
		
		//VBox root = new VBox(); // ����
		HBox root = new HBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);

		//---------------------------------------------
		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Ŭ����......");
			}
		});
		Button btn2 = new Button("��ư2");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("�ڳ���......");
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		
		//---------------------------------------------
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-2) UI

public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		//VBox root = new VBox(); // ����
		HBox root = new HBox(); // ����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(10);
		
		// ���1
		//--------------------------------------------
//		Button btn1 = new Button("��ư1");
//		root.getChildren().add(btn1);
//		Button btn2 = new Button("��ư2");
//		root.getChildren().add(btn2);
		//---------------------------------------------
		
		// ���2
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		Button btn3 = new Button("��ư3");
		root.getChildren().addAll(btn1, btn2, btn3);
		
		
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex88-1) UI

public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300); // ũ�� ����
		//--------------------------------------------
		//
		// ��ġ�� �Ͼ�ٰ� ġ��...
		//
		
		// ������ ������ Ŭ���� �ȿ� ���� ������ �ʴ� ��ġ�� ���
		//---------------------------------------------
		//
		Scene scene = new Scene(root); // ����
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");	// ����
		arg0.show(); // ������ ��ϵȰ��� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();	// ���̾�α�â�� ���������� ���ŷ
		System.out.println("Exit");
	}
}
*/

/*
//ex87) UI : JavaFx
// Application >> static launch() { start() }
// 			   >> abstract start();
abstract class MyApp{
	static void launch() {
		//Hello h = new Hello();
		try {		
//			Class<?> cls; 
//			cls = Class.forName("Pack01.Hello");
//			System.out.println(cls);
//			
//			Constructor<?> constructor = cls.getConstructor();
//			Object obj = constructor.newInstance();
//			
//			Method start = cls.getMethod("start", String.class);
//			System.out.println(start);
			
			// start�Լ� ȣ��
			Hello h = new Hello();
			h.start("ȣ����");
//			start.invoke(obj, "ȣ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//h.start();
	}
	abstract void start(String s);
}
public class Hello extends MyApp{
	public void start(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		launch();
	}
}
*/

/*
//ex86-1) UI

public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.show();
	}
	public static void main(String[] args) {
		launch();
	}
}
*/

/*
//ex85-2)thread
class Tiger extends Thread{
	public void run() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		
		Thread t2 = new Tiger();
		t2.start();
		
		Thread t4 = new Thread() {
			public void run() {
				System.out.println(2);
			}
		};
		t4.start();
		
		new Thread() {			// ���ǥ��
			public void run() {
				System.out.println(3);
			}
		}.start();
	}
}
*/

/*
//ex85) thread�� ���ÿ� ���� �ֱ� ������ �̷л�
class Lion extends Thread{
	public void run() {
		new Scanner(System.in).nextInt();
		System.out.println("������");
	}
}
class Tiger extends Thread{
	public void run() {
		Lion t1 = new Lion();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("�ڳ���");
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("ȣ����");
	}
}
*/

/*
//ex84) thread����
class Tiger extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("ȣ���� : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("�ڳ��� : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
		}
	}
}
*/

/*
//ex83) thread
class Tiger extends Thread{
	public void run() {
		System.out.println("thread start");
		System.out.println("call");
		System.out.println("thread end");
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		System.out.println("ȣ����");
	}
}
*/

/*
//ex82)
class A{
	void start() {
		//System.out.println("start call");
		run();
	}
	void run() {
		System.out.println("A class Run Call");
	}
}
class B extends A{
	@Override
	void run() {
		System.out.println("B class Run Call");
	}	
}
public class Hello {
	public static void main(String[] args) {
		A t1 = new B();	// upcasting
		t1.start();
	}
}
*/

/*
//ex81) Ű����� �Է¹޴¹��
public class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Random rnd = new Random();
		int random = new Random().nextInt(100);
		// nextInt�� ���ŷ�Լ��̴�
		// ���ŷ�Լ��� ��ӵ� Ư�������� �����ɶ�����
		// ���α׷��� ���̻� �������� ���ϴ� �Լ�
		// sleep();
		for (int i = 0; i < 100; i++) {			
			System.out.println("���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();
			//int num = new Scanner( System.in).nextInt(); // ��� ���̵�� ���
			System.out.println(num);
			if(num == 999) {
				break;
			}
		}
		sc.close();
		System.out.println("���α׷��� �����մϴ�");
	}
}
*/

/*
//ex80-2)
class Book{
	String title;
	String author;
	String publisher;
	int price;
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	// void showInfo()
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
	}
	
}

public class Hello {
	public static void main(String[] args) {
		LinkedList<Book> mm = new LinkedList<Book>();
		// C
		mm.add(new Book("�ڹٸ�����","ȫ�浿","���������ǻ�1",100));
		mm.add(new Book("���� �ڴ¹�","������","���������ǻ�2",150));
		mm.add(new Book("�����Ͷ� �����ΰ�","�̼���","���������ǻ�3",300));
		mm.add(new Book("�������� ����","������","���������ǻ�4",1000));
		System.out.println(mm.size());
		
		// R
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// �˻� R
		Book onebook = mm.get(2);
		System.out.println(onebook);
		System.out.println("---------------------------------");
		
		// U
		mm.set(1, new Book("���� ���¹�","������","���������ǻ�2",200));
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// D
		System.out.println("---------------------------------");
		mm.remove(3);
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		 Book findBook = search(mm, "�̽�ö");
		 if(findBook != null) {
			 System.out.println("ã�Ҵ�.");
			 System.out.println(findBook);
		 }else {
			 System.out.println("�׷� ���� ����..");
		 }
	}
	
	static Book search(LinkedList<Book> mm,String name) {
		for (Book book : mm) {
			if( book.author.equals(name)) {
				return book;
			}
		}
		return null;
	}
}
*/

/*
//ex80-1) LinkedList
class Tiger{
	
}
class Lion<T>{
	T age;
	void setAge(T age) {
		this.age = age;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion<Tiger> t1 = new Lion<>();
	}
}
*/

/*
//ex79-3) �Ǵ� �ڵ�
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		Random rnd = new Random();
		
		for (int i = 0; i < 20; i++) {
			mm.add(rnd.nextInt(100));
		}
		System.out.println(mm);
		
		for (int i = 0; i < mm.size(); ) {
			int num = mm.get(i);
			if(num % 2 == 0) {
				mm.remove(i);
			}else {
				i++;
			}
		}
		System.out.println(mm);
	}
}
*/

/*//ex79-2) �ȵǴ� �ڵ�
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		for (int i = 0; i < 6; i++) {
			mm.add(i*10+i);
		}
		mm.add(100);
		mm.add(102);
		mm.add(104);
		mm.add(106);
		mm.add(108);
		System.out.println(mm);
		
		// ���� ���Ŀ� index��ȣ�� ���� �����ȴ�
		for (int i = 0; i < mm.size(); i++) {
			if( mm.get(i) % 2 == 0) {
				mm.remove(i);
			}
		}
		System.out.println(mm);
	}
}*/

/*
//ex79-1) �˻� ����
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm);
		
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i) == 55) {
				mm.remove(i);
				break;
			}
		}System.out.println(mm);
	}
}
*/

/*
//ex78)
// C/C++
// 1. �ݷ��� Ŭ������ ���� ����� �ֳ�?  >> �ڷᱸ��
// JAVA �ڷᱸ���� ����
// 2. �̹� ���۵� Ŭ������ �� ����ϴ°� ?
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		// (C)RUD + �˻�, ����
		System.out.println(mm.size());
		// create(), add(), insert()
		mm.add(100);
		System.out.println(mm.size());
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm.size());
		
		// C(Read)UD
		// 1. Ȱ�뵵�� ��������.
		System.out.println(mm); // mm.toString();
		
		// 2. read, get, select
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) + " ");
		}System.out.println();
		
		// 3. for ���� ����ȭ ����. �����ڵ� ( forEach )
		// data : ���� ������ �̴��� �ƴϸ� �ε��� �̴���
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// �迭
		int[] ar = {10, 20, 30};
		// data, item, value
		for (int value : ar) {
			System.out.print(value + " ");
		}System.out.println();
		
		//String s = "����ȭ�����Ǿ����ϴ�."; // java�� ���� string �ȵ�
		//for (char i : s) {}
		
		// CR(Update)D
		mm.set(5, 99);
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// CRU(Delete)
		// delete, erase, remove
		mm.remove(4);
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// �˻�
		for (Integer data : mm) {
			if( data == 77 ) {
				System.out.println("find");
				break;
			}
		}System.out.println();
		
		for (int i = 0; i < mm.size(); i++) {
			Integer value = mm.get(i);
			if( value == 77 ) {
				System.out.println(i + " : find");
				break;
			}
			if( i == mm.size() - 1) {
				System.out.println("not found");
			}
		}
	}
}
*/

/*
//ex77) ���׸�
class Tiger{
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
class Lion{
	private String data;
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
}
class Cat{
	private float data;
	
	public float getData() {
		return data;
	}
	
	public void setData(float data) {
		this.data = data;
	}
	
}
// generic���� // <>���� ����Ÿ�� ��ü�� �������� Ŭ������ �����// ��ü�� �����Ǵ� ������ Ÿ�� ����
// class Dog<U, K>{
class Dog<T>{ // <> �����̳�
	private T data;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Dog<Integer> t4 = new Dog<Integer>();
		t4.setData(100);
		System.out.println(t4.getData());
		
		Dog<Float> t5 = new Dog<Float>();
		t5.setData(100.0f);
		System.out.println(t5.getData());
		//Dog<Float>
		//Dog<Boolean>
		
		Tiger t1 = new Tiger();
		t1.setData(100);
		System.out.println(t1.getData());
		
		Lion t2 = new Lion();
		t2.setData("ȣ����");
		System.out.println(t2.getData());
		
		Cat t3 = new Cat();
		t3.setData(3.14f);
		System.out.println(t3.getData());
	}
}
*/

/*
//ex76) bmp������ read, bmp������ ���� ����� ������. ��������� ���ϴ°�
public class Hello {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("sample.txt");
			System.out.println(1000);
			// int java.io.Reader.read() throws IOException
			
			while(true) {				
				int readData = reader.read();
				if( readData == -1 ) { // EOF
					System.out.println("���ϳ����� ��� ����");
					break;
				}
				System.out.println((char)readData);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2000);
	}
}
*/

/*
//ex75) �ǽ�
public class Hello {
	public static void main(String[] args) {

		try {
			Writer writer = new FileWriter("sample2.txt");
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {	
					if ((i + j) % 2 == 0) {
						//System.out.print("O ");
						writer.write("O ");
					} else {
						//System.out.print("X ");
						writer.write("X ");
					}
				}
				//System.out.println();
				writer.write("\n");
			}
			
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
*/

/*
//ex74)
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			// open
			Writer writer = new FileWriter("sample.txt"); // �����ϸ� ����� // ��ĳ����	
			
			writer.write("apple");
			writer.write("\n"); // �ٹٲ�
			writer.write("ȣ����");
			
			// close
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(2);
	}
}
*/

/*
//ex73)
class Tiger{
	
}

public class Hello {
	static int m1() {
		return 100;
	}
	static void m2(int a, int b) {
		System.out.println("ȣ����1");
		if(a > b) {
			System.out.println("ȣ����2");
		}else{
			// �Լ� ���� �ߴ�
			return;
		}
		System.out.println("ȣ����3");
	}
	static void m3(int a, int b) {
		try {
			System.out.println("ȣ����1");
			if(a > b) {
				System.out.println("ȣ����2");
			}else{
				// �Լ� ���� �ߴ�
				return; // �ݵ�� finally�� ����
			}			
		} catch (Exception e) {
			
		} finally {
			System.out.println("ȣ����3");			
		}
	}
	public static void main(String[] args) {
		System.out.println(m1());
		//m2(1, 2);
		m3(1, 2);
//		try {
//			System.out.println(2/1);
//		} catch (Exception e) {
//			System.out.println(1);
//		}finally {	// �������ְ� �Ⱦ���������(������ �����ؾ��Ұ� ������)
//			System.out.println(2);
//		}
//		System.out.println(3);
	}
}
*/

/*
//ex72) sleep
class Tiger{

}

public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			
			try {Thread.sleep(1000);} catch (Exception e) {}
		}
	}
}

*/
/*
//ex71)
class Tiger{
	// ���1 - catch�� ��¹�
	void f1() {
		System.out.println("�Լ� 1");
		
		try {			
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ���2 - �Լ� ȣ���� �ʿ��� catch
	// ���� �ͼ��ǳ����� ȣ���� ������ ���ѱ�°� �Ϲ���
	void f2()throws Exception { // �ͼ��� ���ѱ��
		System.out.println("�Լ� 2");
		
		throw new Exception();
	}
}

public class Hello {
	public static void main(String[] args) throws Exception{
		Tiger t1 = new Tiger();
		// 1.
		t1.f1();
		System.out.println("ȣ����1");
		// Unhandled exception
		
		// 2.
		try {			
			t1.f2();
		} catch (Exception e) {
			System.out.println("�߻�");
		}
		System.out.println("ȣ����2");
		
		// 3.
		t1.f2();
	}
}
*/

/*
//ex70) // ������ try-catch�� ��������� �ʴ´�. �����ϻ�
public class Hello {
	public static void main(String[] args) {
		//Tiger t1 = new Tiger();
		// 1. ArrayIndexOutOfBoundsException
		int[] ar = new int[3]; // 0 1 2
		System.out.println("ȣ����1");
		// �ͼ����� �߻��ϸ� ���α׷��� �ߴܵȴ�.
		try {
			ar[3] = 10; // >> ���⼭ �ߴ�			
		} catch (Exception e) {
			// �ͼ����� �߻��ϸ� catch ������� ���´�
			System.out.println("�߻�");
			//e.printStackTrace(); // �ͼ��� ���� ���
		}
		System.out.println("ȣ����2");
		
		// 2. ArithmeticException
		try {
			System.out.println(5 / 0);			
		} catch (Exception e) {
			System.out.println("�߻�");
		}
		System.out.println("ȣ����3");
		
		// 3. NullPointerException
		String s = null;
		try {			
			s.length();
		} catch (Exception e) {
			System.out.println("�߻�");
		}
		System.out.println("ȣ����4");
		
		s = new String("������");
		if( s != null) {		// ������� ���α׷�	
			s.length();
		}
	}
}
*/

/*
//ex69-2) ���ٽ� ����
interface Aaa{
	void f1();
}
interface Bbb{
	void f1(int num);
}
interface Ccc{
	int f1();
}
interface Ddd{
	String f1(String s, int n);
}

public class Hello {
	public static void main(String[] args) {
		Aaa t1 = ()->{
			System.out.println(1);
		};
		t1.f1();
		
		Bbb t2 = (n)->{
			System.out.println(n);
		};
		t2.f1(100);
		
		Ccc t3 = ()->{
			System.out.println("test1");
			return 200;
		};
		System.out.println(t3.f1());
		
		Ddd t4 = (s, n)->{
			System.out.println("test2");
			return s + n;
		};
		System.out.println(t4.f1("ȣ����", 3000));
		
		// ���� �ڵ� 1�ٸ� �ִ°�쿡��
		// return �� {} �� ���� ������ �� �ִ�
		Ccc t5 = ()-> 200;
		System.out.println(t5.f1());
		
		Ddd t6 = (s, n)-> s + n;
		System.out.println(t6.f1("����", 4000));
	}
}
*/

/*
//ex69)
interface Tiger{
	void f1();
}

class Lion{
	void f1(Tiger t) {
		t.f1();	// ������
	}
}

public class Hello {
	public static void main(String[] args) {
		Lion lion = new Lion();
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("ȣ����");
			}
		});
		
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("������");
			}
		});
		
		Tiger t1 = new Tiger() {
			@Override
			public void f1() {
				System.out.println("�޹���");
			}
		};
		// ���� �Լ� //()->  �̰� ���ο�, f1()�� �μ��� ���ٴ°� ����ϰ�
		Tiger t2 = ()->{				
			System.out.println("�޹���");
		};
		
		Tiger t3 = ()->{
			System.out.println("�޹���2");
		};
		
		lion.f1(()->{
			System.out.println("�޹���3");
		});
	}
}
*/

/*
//ex68)
interface Tiger{
	void f1();
}

class Lion implements Tiger{
	public void f1() {}
}

public class Hello {
	public static void main(String[] args) {
		// ����: ��ü�� ������ų���� ����
		//Tiger t1 = new Tiger();
		
		// �������̽� �����1
		Lion t1 = new Lion();
		Tiger t2 = new Lion();
		
		// �������̽� �����2
		// �͸� Ŭ����
		Tiger t3 = new Tiger() {
			@Override
			public void f1() {
				System.out.println("ȣ����");
			}
		};
		t3.f1();
		
		// �������̽� �����3
		// �͸� ��ü - ��� �����Լ�
		new Tiger() {
			@Override
			public void f1() {
				System.out.println("�޹���");
			}
		}.f1();
	}
}
*/

/*
//ex67-7) ���������� ��
class Aaa{
	Bbb bbb;
	Aaa(Bbb bbb){	// ������ �Ͼ�� �ְ� a�� b�� ������ ����
		this.bbb = bbb;
	}
	void f2() {
		bbb.f1();
	}
}

interface Bbb{
	void f1();
}
class Ccc implements Bbb{
	public void f1() {System.out.println("���� ����");}
}

public class Hello {
	public static void main(String[] args) {
		Aaa t = new Aaa(new Ccc());
		t.f2();
	}
}
*/

/*
//ex67-6) �̱��� Ŭ������ �����ϴ� ���� ����
class Baduk{
	Ai ai;
	
	// �����ڴ� ����(injection)�� �޴´�	��������(DI)
	Baduk(Ai ai){
		this.ai = ai;
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {	// �μ� �������� ����� �μ� ���� ���ص� ������ ����� ������ ���ϴ°� ����
		ai.play();
	}
	void stop() {
		ai.stop();
	}
}

interface Ai{
	void play();
	void stop();
}
//�Ƹ���
class AlphaGo implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ������ ����մϴ�.");
	}
}
//ms
//class BetaGo implements Ai{
//	public void play() {
//		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
//	}
//	public void stop() {
//		System.out.println("��Ÿ�� ������ ����մϴ�.");
//	}
//}
public class Hello {
	public static void main(String[] args) {
		Baduk baduk1 = new Baduk(new AlphaGo());
		baduk1.play();
		baduk1.stop();
		System.out.println("-----------------");
		Baduk baduk2 = new Baduk(new BetaGo());
		baduk2.play();
		baduk2.stop();
	}
}
*/

/*
//ex67-3) �̱��� Ŭ������ �����ϴ� ���� ����
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(Ai alphago) {
		alphago.play();
	}
}

//ex67-4) �߻� Ŭ����ȭ ��Ŵ
//abstract class Ai{
//	abstract void play();
//}
//ex67-5) �������̽�ȭ ��Ŵ
interface Ai{
	void play();
}
// �Ƹ���
class AlphaGo implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
// ms
class BetaGo implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
}
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
	}
}
*/

/*
//ex67-2) �ٸ� �ΰ��������� �����ɶ����� Ŭ������ �Լ��� �߰��ؾ��ϴ� ����
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(AlphaGo alphago) {
		alphago.play();
	}
	void play(BetaGo betago) {
		betago.play();
	}
}
// �Ƹ���
class AlphaGo{
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
// ms
class BetaGo{
	void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
}
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
	}
}
*/

/*
//ex67-1) �ΰ������� ������ ���
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play();
	}
}
*/

/*
//ex66) final( ������ )
// 1. �ʵ� final
// 2. Ŭ���� final
// 3. �Լ� final
class Tiger{
	// 1. �ʵ� final( ���� �ʱ�ȭ �ϴ� ���� ���Ⱑ ������)
	// ���ȭ �Ǿ������(������ �������� ���)
	// const
	final int NUM = 100;	// ���� �����ʱ�ȭ�Ҷ� �� ������ // final�� ���ִ°� �Ϲ������� �빮�ڷ� ����
	Tiger(){	// ó���� �ʱ�ȭ��Ű�������� �����ڿ����� �� �ѹ� ���� ����. ���Կ����� �ѹ��ۿ� �ȵȴٴ� �Ҹ�
		//num = 30;
	}
	void f1() {
		//this.num = 20;
	}
}
class Aaa{}
final class Bbb extends Aaa{}	// class �̸� �տ� fianl�� �������� ����� ���Ⱑ ������
//class Ccc extends Bbb{}

//class Ddd extends String{}
//class Eee extends Thread{}

class Fff{
	final void f1() {}	//�Լ� �տ� final ������ �������̵� �Ұ�
	void f2() {
		f1();
	}
}
class Ggg extends Fff{
	void f1() {}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		String s;
		// t1.num = 20;
		// Math.PI
	}
}
*/

/*
//ex65) ��ĳ����(���ڰ���)�� ���õ� ������ �����ϱ� ���ؼ�
interface ParentsTiger{
	void f1();
}
class Tiger implements ParentsTiger{
	public void f1() {
		
	}
}
class Lion implements ParentsTiger{
	public void f1() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		ParentsTiger t1 = new Tiger();
	}
}
*/

/*
//ex64)
class Aaa{
	void f1() {}
}

interface Bbb{
	void f2();
}
interface Ccc{
	void f3();
}

class Ddd extends Aaa implements Bbb, Ccc{	// interface�� ���߻�� ����
	public void f2() {}
	public void f3() {}
}

@FunctionalInterface // �̱����Լ��� �� 1��������
interface Eee{
	void f1();
}
public class Hello {
	public static void main(String[] args) {
		String s;
		Thread t;
	}
}
*/

/*
//ex63) class�� ���߻���� �ȵ�
abstract class Aaa{
	abstract void f1();
	abstract void f2();
}

class Bbb extends Aaa{
	void f1() {}
	void f2() {}
}

interface Ccc{
	void f1();	// abstract void f1(); - abstract ���� ���� (����Ʈ����)
	void f2();	// abstract void f2();
}

class Ddd implements Ccc{	// interface�� ��ӹ��� �Լ��� �ݵ�� public
	public void f1() {}
	public void f2() {}
}

public class Hello {
	public static void main(String[] args) {
		
	}
}
*/

/*
//ex62)
public class Hello {
	public static void main(String[] args) {
		int num = 100;
		int r1 = num * 3;	// num + num + num
		int r2 = 3 * num;	// 3 + 3 + 3 ...
		
		System.out.println(r1);
		System.out.println(r2);
		
		int test = 6;	//   0110(6)
						//  01100(12)	test << 1
						// 011000(24)	test << 2
		System.out.println(test << 1);	// 6 * 2�� 1
		System.out.println(test << 2);	// 6 * 2�� 2
		System.out.println(test << 3);	// 6 * 2�� 3
		System.out.println(test << 4);	// 6 * 2�� 4
		
		int a = 23;
		
//		for (int i = 0; i < 600; i++) {
//			for (int j = 0; j < 800; j++) {			
				System.out.println(a * 800);			
				System.out.println((a<<9) | (a<<8) | (a<<5));
//			}
//		}
	}
}
*/

/*
//ex61) & | >> << ~ ^
public class Hello {
	static String hexaTobinary(int n) {	// 32bit�� ǥ���ϴ� �Լ�
		String s = Integer.toBinaryString(n);
		while(s.length() < 32)
			s = "0" + s;

		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < 7; i++) 
			sb.insert((7-i)*4, " ");
		
		return sb.toString();	
	}
	public static void main(String[] args) {
		int n1 = 0x1234abcd;
		//System.out.println(n1 & 0xffff0000);
		
		System.out.println(hexaTobinary(n1));
		System.out.println(hexaTobinary(0xffff0000)); // mask
		// ��Ʈ and
		System.out.println(hexaTobinary(n1 & 0xffff0000));
		
		// ������ �ռ� - ��Ʈ or
		System.out.println(hexaTobinary(n1 | 0xffff0000));
		
//		int a = 0xF3;
//		int b = 0x3600;
//		int c = 0xEC0000;
		
		int a = 0x000000F3;
		int b = 0x00003600;
		int c = 0x00EC0000;
		int d = a | b | c;
		System.out.println(hexaTobinary(d));
		System.out.println("---------------------------------------");
		
		int e = 0xF09;
		System.out.println(hexaTobinary(e));
		System.out.println(hexaTobinary(e<<1));	// <<, >> ����Ʈ������
		System.out.println(hexaTobinary(e>>1));	// <<, >> ����Ʈ������
		System.out.println("---------------------------------------");
		
		int data = 0xABCD;
		//                        21    30     13
		// 0000 0000 0000 0000 1010 1011 1100 1101
		System.out.println(hexaTobinary(data));

		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0000 0001 1111
		System.out.println(data & 0x1F);
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0111 1110 0000
		System.out.println((data & 0x000007E0)>>5);
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 1111 1000 0000 0000
		System.out.println((data & 0xF800)>>11);
		System.out.println((data & 0x0000F800)>>11);
		// �������� ��������
		System.out.println((data >> 11) & 0x1f);
		System.out.println("------------------------------");
		System.out.println(hexaTobinary(data));
		System.out.println(hexaTobinary(~data)); // not
		
		System.out.println(hexaTobinary(data));
		System.out.println(hexaTobinary(0x0000ffff));
		System.out.println(hexaTobinary(data ^ 0x0000ffff)); // xor ���� �ٸ��� 1
		
	}
}
*/

/*
//ex60)
public class Hello {
	static String hexaTobinary(int n) {	// 32bit�� ǥ���ϴ� �Լ�
		String s = Integer.toBinaryString(n);
		//System.out.println(s);
		//System.out.println(s.length()); // 31
		
		// 32bit�� �ش��ϴ� ���ڿ��� �����
		while(s.length() < 32) {
			//
			s = "0" + s;
		}
		//System.out.println(s.length()); // 32
		//System.out.println(s);
		
		StringBuffer sb = new StringBuffer(s);
		//System.out.println(sb);
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
			//System.out.println((7-i) * 4);
		}
		//System.out.println(sb);
		return sb.toString();	// stringbuffer�� string���� - toString()
		// StringBuffer : insert(); --> String������ �������� ������ ������ ������ �� �����ϱ�
		// 
		// 0000 0000 0000 0000 0000 0000 0000 0000
	}
	public static void main(String[] args) {
		// >> ���� ���ϴ� �������� 2���� ���
		int num = 0x63ce7bcd;
		System.out.println(hexaTobinary(num));
		
		System.out.println(hexaTobinary(0xab));
		
		System.out.println(hexaTobinary(123456));
		
		int num2 = 100;
		System.out.println(hexaTobinary(num2));
		
		System.out.println(hexaTobinary(0x7fffffff));
		
		// 00
		// 1f
		// 7f 0111 1111
		// 80 1000 0000
		// af
		// ff 1111 1111
	}
}
*/

/*
//ex59)	// 0x : 16���� 0b : 2����
public class Hello {
	public static void main(String[] args) {
		int num1 = 100;
		System.out.println(num1);
		
		int num2 = 0x100;
		System.out.println(num2);
		
		int num3 = 0xABCD;
		System.out.println(num3);
		// 4byte�� �������� ����(FF FF FF FF)
		int num4 = 0x63ce7bcd;	// 16���� ���ڸ��� 4��Ʈ 2�ڸ��� 8��Ʈ = 1����Ʈ
		// 0110 0011 1100 1110 0111 1011 1100 1101
		// 0110 0011 1100 1110 0111 1011 1100 1101	
		// 0x7f ff ff ff >> 0 ~ 80 00 00 00 ~ FF FF FF FF
		
		System.out.println(Integer.toBinaryString(num4)); // 16������ ���ڿ���
		int num5 = 0xab;
		// 1010 1011
		// 0000 0000 0000 0000 0000 0000 1010 1011 // 32bit
		System.out.println(Integer.toBinaryString(num5)); // 16������ ���ڿ���
	}
}
*/

/*
//ex58) ����(bit ����) : 2(��), 10(�ΰ�), 16(����)
class Tiger{
	// A 10
	// B 11
	// C 12
	// D 13
	// E 14
	// F 15
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
*/

/*
//ex57)
public class Hello {
	public static void main(String[] args) {
		String s1 = "����ȭ�����Ǿ����ϴ�";		
		// ex1) ����
		System.out.println(s1.length());
		
		// ex2) ���� �˻�
		// char String.charAt(int index)
		System.out.println(s1.charAt(3));
		
		// ex3) ���ڿ� �˻�
		System.out.println(s1.indexOf("���Ǿ�"));
		
		// ����, Ȥ�� -1���� ���ϵȴ�. << �˻����� 
		System.out.println(s1.indexOf("���ϴ�"));
		
		if(s1.indexOf("���ϴ�") == -1) {
			System.out.println("�˻�����");
		}else {
			System.out.println("�˻�����");
		}
		
		// ex4)
		// String replace(CharSequence target, CharSequence replacement)
		String s2 = s1.replace("����", "������");
		// ���� : ���� �����͸� �����ϴ°� �����ʴ°�?
		// String Ŭ������ ����� ������ �������� �ʴ´�
		// StringBufferŬ������ ���� �����͸� ������ �� �ִ�
		System.out.println(s1);
		// s1�� �޸𸮰� �����ȴ� (��ü�� �������)
		// s1�� �޸𸮴� ���Ҵ���� (���ο� ��ü�� ���������)
		// s1 = "ȣ����";
		// System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.replace("����", "�Ĺ���"));
		
		// ex5) sub string �ε������� ~~
		System.out.println(s1.substring(3));
		// start ~ end-1
		// end - start = 2
		System.out.println(s1.substring(3, 5));
		
		// ex6)
		s1 = "Apple";
		System.out.println(s1.toLowerCase()); // �ҹ��ڷ�
		System.out.println(s1.toUpperCase()); // �빮�ڷ�
		
		// ex7)
		s1 = "  A p p l e  ";
		System.out.print(s1);
		System.out.println(1000);
		
		System.out.print(s1.trim()); // �յڰ��� ����
		System.out.println(2000);
	}
}
*/

/*
//ex56)
// 4. �߻��Լ��� ������ Ŭ������ �ݵ�� �߻�Ŭ�������� �Ѵ�.
abstract class Aaa{	// AaaŬ����(�߻�Ŭ����)�� ��ü�� ������ų �� ����. - �ڵ尡 �̿ϼ��̱� ����
	// 1. �������̵��� ��ǥ�� �Ѵ�
	// 2. ���� ������ �ڵ带 �ۼ��� ������ ����.
	// 3. �����ݷ��� ��� ���� �̿ϼ�(=�߻�) �ڵ尡 �ȴ�.
	abstract void f1();
}
class Bbb extends Aaa{
	// ��ӹ��� Ŭ������ �ڵ带 �ݵ�� �ϼ����Ѿ� �Ѵ�.
	@Override
	void f1() {
		// TODO Auto-generated method stub
		
	}
}

public class Hello {
	public static void main(String[] args) {
		Aaa a = new Bbb();
		a.f1();
		
		// �̿ϼ� Ŭ������ ��ü�� ������ų �� ����.
		// Aaa t = new Aaa();
	}
}
*/

/*
//ex55)
class Animal{
	void cry() {
		System.out.println("�Ҹ� ���� ����");
	}
}
class Tiger extends Animal{
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal{	
	void cry() {
		System.out.println("�߿�");
	}
}
class Lion extends Animal{	
	void cry() {
		System.out.println("���");
	}
}
class Snake extends Animal{
}

class Zoo{	// solid ��Ģ - ��������� ��Ģ(OCP) �� ���.
	void sound(Animal t) {	// ��ĳ���� ( �� �� ����) -> �ϸ� ������ ���α׷��� �ڵ�����
		t.cry();	// ������ - �پ��� ������ ����� ������ ���α׷�
	}
}
public class Hello {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.sound(new Tiger());
		zoo.sound(new Cat());
		zoo.sound(new Snake());
		zoo.sound(new Lion());
	}
}
*/

/*
//ex54)
class Animal{
	void cry() {
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
	}
}
class Snake extends Animal{
}

public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		Tiger t0 = new Tiger();
		Cat t1 = new Cat();
		Snake t2 = new Snake();
		
		for (int i = 0; i < 6; i++) {
			switch(rnd.nextInt(3)) {
			case 0:
				t0.cry();
				break;
			case 1:
				t1.cry();
				break;
			case 2:
				t2.cry();
				break;
			}
		}
		System.out.println("-------------");
		Animal[] ani = new Animal[] {new Tiger(), new Cat(), new Snake()};
		for (int i = 0; i < 6; i++) {			
			ani[rnd.nextInt(3)].cry();
		}
//		ani[0] = new Tiger();
//		ani[1] = new Cat();
//		ani[2] = new Snake();
	}
}
*/

/*
//ex53)
class Animal{
	void cry() {
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
	}
}
class Snake extends Animal{
}

class Test{
	void f1() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {	
		System.out.println("------");
		
		Animal t1 = new Tiger();
		t1.cry();
		Animal t2 = new Cat();
		t2.cry();
		Animal t3 = new Snake();
		t3.cry();
		
		Tiger t4 = new Tiger();
		t4.cry();
		Cat t5 = new Cat();
		t5.cry();
		Snake t6 = new Snake();
		t6.cry();
		
//		String s0, s1, s2, s3;
//		s0 = "ȣ����0";
//		s1 = "ȣ����1";
//		s2 = "ȣ����2";
//		s3 = "ȣ����3";
//		String[] ar = new String[4];	// ������ 4�� ��������� ��ü�� ������� �ƴ�
//		ar[0] = "ȣ����0";	// �̰� ��ü ����
//		ar[1] = "ȣ����1";
//		ar[2] = "ȣ����2";
//		ar[3] = "ȣ����3";
		String[] ar = new String[] {"ȣ����0","ȣ����1","ȣ����2","ȣ����3"};
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		Test [] br = new Test[] {new Test(), new Test(), new Test()};
		for (int i = 0; i < br.length; i++) {
			br[i].f1();
		}
		// br[0] = new Test();
	}
}
*/

/*
//ex52-2) ������, ��ĳ����
class Aaa{		// �������̵� Ȯ�� - ������ �ڽ� ��ü ����, ������ �ڽ� ��ü ����
	void f1() {}
	void f3() {
		System.out.println(10);
	}
	void f4() {
		System.out.println(20);
	}
}
class Bbb extends Aaa{
	void f2() {}
	@Override
	void f4() {
		System.out.println(40);
	}
}

public class Hello {
	public static void main(String[] args) {
		Aaa t = new Bbb();
		t.f3();	// 10
		t.f4();	// 40
		
		Bbb t2 = new Bbb();
		t2.f3(); // 10
		t2.f4(); // 40
	}
}
*/

/*
//�١١١١�
//ex52-1) ������, ��ĳ����
class Aaa{
	void f1() {}
}
class Bbb extends Aaa{
	void f2() {}
}

public class Hello {
	public static void main(String[] args) {
		// ����ϰ� �ƹ� ���谡 ����
		Aaa t1 = new Aaa();	// �� = ��
		t1.f1();
		
		// ��ĳ����(UpCasting)
		Aaa t2 = new Bbb(); // �� = ��
		t2.f1(); // f2(); �޸𸮴� �ִ�. ����� ���һ�
		// �ٿ�ĳ����(�ڹٿ��� ����x)
		//Bbb t3 = new Aaa(); // �� = ��
		
		Bbb t4 = new Bbb(); // �� = ��
		t4.f1();
		t4.f2();
	}
}
*/

/*
//ex51) this���4 - ������ ������ �ҷ��ö� this �̿�
class Tiger{
	int num;
	int age;
	Tiger(){
		age = 10000;
		System.out.println(1);
	}
	Tiger(int a){
		this();	// this�����ڴ� �ݵ�� �ڵ��� ù ��
		num = a;
		System.out.println(2);
	}
	Tiger(int b, int c){
		this(b*c);
		System.out.println(3);
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10);
		Tiger t2 = new Tiger(2, 3);
	}
}
*/

/*
//ex50)
//class Aaa extends Object{}	// ����. ��� Ŭ������ �⺻������ Object��� Ŭ������ ���
class Aaa{
	void f1() {	}
}
class Bbb extends Aaa{
	void f2() {	}
}
class Ccc extends Bbb{
	void f3() {	}
	void f4() {	}
}

public class Hello {
	public static void main(String[] args) {
		Ccc t1 = new Ccc();
		StringBuffer sb;
	}
}
*/

/*
//ex49)
// �����ڰ� ȣ��Ǵ� ������� :
// �θ� >> �ڽ� : <------- �߸��� �ؼ�.
class Aaa{
	Aaa(){
		System.out.println(1);
	}
	Aaa(int a){
		System.out.println(3);
	}
}
class Bbb extends Aaa{	// �ڽ��� �θ� �ǳʶٰ� ���θ� ���Ҽ��� ����
	Bbb(){
		// �θ� �����ڸ� ���ϴ� �ڵ尡 ������
		super(100);	// �ڽ��� �θ� ���������� ���Ҽ� ����
		System.out.println(2);
	}
	Bbb(int a, int b){
		// �θ� �����ڸ� ���ϴ� �ڵ尡 ������
		super();	// �ڽ��� �θ� ���������� ���Ҽ� ����
		System.out.println(4);
	}
}

public class Hello {
	public static void main(String[] args) {
		Bbb b = new Bbb();
		System.out.println("------");
		Bbb b2 = new Bbb(3, 4);
	}
}
*/

/*
//ex48) ���߻�� - �ڹٿ����� X
class Aaa{	// ����
	void f1() {	System.out.println(1);} 
}
class Bbb extends Aaa{	// �θ�
	
}
class Ccc extends Bbb{	
	
}
class Ddd extends Bbb{	
	
}

public class Hello {
	public static void main(String[] args) {
		Ccc t1 = new Ccc();
		t1.f1();
	}
}
*/

/*
//ex47) ��� - 1. is a 2. has a �����̸� ���
class Aaa{	// �θ�
	void f1() {
		System.out.println(1);
	}
	// �Լ�����(prototype) - void f3() <-- �� �κ� {} �� �κ�
	void f3() {
		System.out.println(31);
	}
	
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa{	// �ڽ�	
	void f2() {
		System.out.println(2);
	}
	// �������̵�(overriding) - �θ�Ŭ������ �Լ������� �״�� ���� ��
	@Override
	void f3() {
		System.out.println(32);
	}
	void f4() {
		this.f3();
		super.f3();	// super - �θ� �θ���
	}
	@Override // �������̵� �ȵ����� ���� ��������
	String f5(int a, int b, String t) {
		return null;
	}
}

public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1();
		t1.f2();
		t1.f3();	// �Ѵ� �ִ��� �ڱⲬ ����
		System.out.println("--------");
		t1.f4();
	}
}
*/

/*
//ex46-3) this���3
class Man{
	void f1() {
		Women w = new Women();
		boolean result = w.marry(this);
		System.out.println(result ? "^.^" : "��.��");
	}
	String ����() {
		return "����";
	}
}
class Women{
	boolean marry(Man info) {
		String str = info.����();
		return str == "����" ? false : true;

	}
}

public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();
		
		Control con = new Control();
		//				Hello ��ü
		con.makeButton( this, "�ؽ�Ʈ", "����"){ // ù��° �μ��� this ������ �� Ŭ�������� ���� �ʿ���ϴ�~
			this.ĥ�ϴ�();
		}
	}
	
	void ĥ�ϴ�() {
		
	}
}
*/

/*
//ex46-2) this���2
// channing(.)�� �������� ��
class Tiger{
	// Tiger this;
	Tiger f1() {
		//System.out.println("��ħ");
		System.out.println("���̵� Ȯ��");
		// return null;
		// return new Tiger();
		return this;	// this�� ���ϵǴϱ� ü�̴װ���
	}
	Tiger f2() {
		//System.out.println("����");
		System.out.println("�н����� Ȯ��");
		return this;
	}
	void f3() {
		//System.out.println("����");
		System.out.println("��ȿ�� �˻�");
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f1().f2().f3();	// t1.f1() = this
		System.out.println("-----------");
		t1
		.f1()
		.f2()
		.f3();	// ü�̴��ϸ� ������ �Ұ� ���������Ҷ� ���
		
		t1.f1();
		System.out.println("�ζ�....������");
		t1.f2();
		t1.f3();
	}
}
*/

/*
//ex46-1) this���1
// �Լ��� �����μ��� �ʵ带 �����ϱ� ���� �뵵
// �ڵ� : 1.������, 2.setter, getter, 3.toString
class Tiger{
	String name;
	int age;
	
	public Tiger(String name, int age) {
		this.name = name;
		this.age = age;
	}
//	Tiger(String name, int age){
//		this.name = name;	// �ʵ� <= �μ�;
//		this.age = age;
//	}
	void f1() {
		//System.out.println(name + " " + age);
		//System.out.println(this.name + " " + this.age);
		System.out.println(name + " " + age);
	}
	void f2() {
		f1();
		this.f1();
	}
	void f3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger("ȣ����", 10);
		System.out.println(t1);
		t1.f3("������", 20);
		System.out.println(t1);
	}
}
*/

/*
//ex45) this = ��� ������ ��ü
class Lion{}
class Tiger{
//	Lion lion;
//	Tiger tiger;
	Tiger(){
		//this = ?;
		//this = t1;	// this�� new�� ������ ���� - t1�� �޸� ����
		System.out.println(this.hashCode());
	}
	// ������ �ڵ�
	//Tiger this;
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger();		// ��ü �����ɶ����� this�� ����
		System.out.println(t2.hashCode());
	}
}
*/

/*
//ex44)
class Tiger{
	private Tiger(){	}
}

public class Hello {
	public static void main(String[] args) {
		//Tiger t = new Tiger();
		//Thread.sleep(0);
		
		//Math m = new Math();
		//m.abs();
		System.out.println(Math.abs(-10));
		
	}
}
*/

/*
//ex43-3)
class Tiger{
	static int count = 0;	// ����
	int num = 0;			// ����
	Tiger(){
		count++;
		num++;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		System.out.println(t1.num);
		System.out.println(t2.num);
		System.out.println(t3.num);
		
		System.out.println("������ ��ü���� : " + Tiger.count);
	}
}
*/

/*
//ex43-2)
class Tiger{
	void f1() {
		Tiger t = new Tiger();
	}
}

public class Hello {	// �����찡 ������Ų Hello ��ü 1��
	int n1;
	static int n2;
	void f1() {}
	static void f2() {}
	public static void main(String[] args) {
		//f1();
		f2();
		//n1 = 10;
		n2 = 10;
		Hello h = new Hello();	// ���� ������Ų ���ο� Hello ��ü 1�� -- �� 2��
		h.n1 = 10;
		h.n2 = 20;
		h.f1();
		h.f2();
	}
}
*/

/*
//ex43-1) static �ȿ����� static�� ��밡�� static�ƴѾֵ� ������ ��ü���� �̿� new~~
class Tiger{
	int n1;
	static int n2;
	static void f1() {
		//n1 = 100;
		n2 = 200;
		//f2();
		f3();
	}
	void f2() {
		f1();
	}
	static void f3() {	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
*/

/*
//ex42-2)
class Tiger{
	static void f1() {
		
	}
	void f2() {
		
	}
}

public class Hello {
	int age;
	
	Hello(){
	}
	
	void f1() {
	}
	// ������(Entry Point)
	// main ȣ���� OS
	// Hello h = new Hello();
	// h.main();
	// Hello.main()
	public static void main(String[] args) {
		// ��ü ���� ����� ���� ���
		//Tiger t1 = new Tiger();
		//Tiger t2 = new Tiger();
	}
	void f2() {
		
	}
}
*/

/*
//ex42-1) static �ϳ� ��! �� ������ ��ü �������Ѿ���
class Tiger{
	static int n1;
	int n2;
	static void ����ž() {
		System.out.println("��");
	}
	
	void ����() {
		System.out.println("����");
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger.����ž();
		t1.����();
		t1.����ž();
		
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}
*/

/*
//ex42)
class Tiger{
	private String name;
	private int age;
	
	String getName() {	return name;	}
	void setName(String name) {	this.name = name;	}
	int getAge() {	return age;	}
	void setAge(int age) {	this.age = age;	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
*/

/*
//ex41)
class Tiger{
	// ��ǰ���
	// ������ ����
	private int age;
	private String name;
	void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
	// getter, setter �Լ�
	int getAge() {
		return age;
	}
	void setAge(int data) {
		age = data;
	}
	
	Tiger(){
		age = 100;
	}
	
	private void f1() {
	}
	void f2() {
	}
	void f3() {
		f1();
		f2();
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// t1.f1();
		// ����ʵ�� ��ü�� �������Ѽ�
		// ���� ����ϴ� ���� ���� �ҹ�
		t1.setAge(1000);
		System.out.println(t1.getAge());
		//t1.money = 200;
	}
}
*/

/*
//ex40)
class Tiger{
	String name;
	int age;
	
	Tiger(){}
	Tiger(int data){
		//name = null;
		name = "�͸�";
		age = data;
	}
	Tiger(String n, int data){
		name = n;
		age = data;
	}
	void showData(){
		System.out.println(name + " " + age);		
	}
	
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		System.out.println(t1.name + " " + t1.age);
		Tiger t2 = new Tiger("ȫ�浿",200);
		t2.showData();
		
		System.out.println(t1.toString());
		System.out.println(t1);
	}
}
*/

/*
//ex39-2)
class Tiger{
	int age = 10;
	Tiger(int data) {
		age = data;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		Tiger t2 = new Tiger(200);
		System.out.println(t1.age);
		System.out.println(t2.age);
		
	}
}
*/

/*
//ex39-1)
class Tiger{
	int age;					// �ʱ�ȭ ���1(���� ����)
	Tiger(){					// �ʱ�ȭ ���2(���� ����)
		System.out.println(1);
		age = 100;
	}
	Tiger(int data){
		System.out.println(2);
		age = data;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.age);
		Tiger t2 = new Tiger(999);
		System.out.println(t2.age);
	}
}
*/

/*
//ex38)
// ������
// 1. ��� ���� : �ʵ� �ʱ�ȭ
// 2. ������ �޼ҵ��� ��(�Լ�)
// 3. �Լ��� �̸��� �ݵ�� Ŭ���� �̸��� ����
// 4. �μ��� ���޹������� ������, return�� ���� �� ����
// 5. �μ������� ���� �����ڸ� ����Ʈ �����ڶ�� ��
// 6. ȣ���� new Ű���带 ����� �� �� 1�� ȣ���
// 	  ���α׷��Ӱ� ���Ƿ� ȣ���� �� ����
// 7. �Լ��̱⶧���� �����ε��� �� �� ����
// 8. �������ڵ带 �ۼ����� ������ �ڵ����� ����Ʈ �����ڰ� �������
//    - ������ �ڵ带 �ۼ��ϸ� �ڵ����� �����ڰ� ��������� ����
class Tiger{
	// �ʵ�
	int age;
	// ����Ʈ ������
	Tiger() {
		System.out.println("������ ��");
		age = 100;
	}
	// �޼ҵ�

}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Tiger t1 = new Tiger();
		System.out.println(2);
		Tiger t2 = new Tiger();
		System.out.println(3);
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			Tiger temp = new Tiger();
			System.out.println(temp.hashCode());
		}
	}
}
*/

/*
//ex37-2)
class Tiger{
	int getrectangle(int w, int h) {
		return w * h;
	}
	int getrectangle(int x1, int y1, int x2, int y2){
		int width = x2-x1+1;
		int height = y2-y1+1;
		return width * height;
	}
	int getrectangle(int x) {
		return x * x;
	}
	// return������ �� ����
//	int test() {
//		return 0;
//	}
//	float test() {
//		return 0.0f;
//	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.getrectangle(10, 5));
		System.out.println(t1.getrectangle(10, 5, 20, 15));
		System.out.println(t1.getrectangle(25));
		
	}
}
*/

/*
//ex37-1)
// �Լ��̸��� �����ϰ� �۸��� ������ ���
// 1. �μ� ���� ������ �ٸ� ���
// 2. ���� �μ� ������ ������ Ÿ���� �ٸ� ���
// �����ε�( Overloading)
class Tiger{
	void showMeTheMoney() {
		System.out.println(1);
	}
	void showMeTheMoney(int a) {
		System.out.println(2);
	}
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	void showMeTheMoney(float a) {
		System.out.println(4);
	}
	void showMeTheMoney(Tiger t) {
		System.out.println(5);
	}
	void showMeTheMoney(short a) {
		System.out.println(6);
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.showMeTheMoney();
		t1.showMeTheMoney(10);
		t1.showMeTheMoney(10, 20);
		t1.showMeTheMoney(3.14f);
		t1.showMeTheMoney(new Tiger());
		float f = 3;
		t1.showMeTheMoney((float)3);
		
		t1.showMeTheMoney((short)10);
	}
}
*/

/*
//ex36)
class Tiger{
	int number;
}
class Lion{
	// Tiger bbb = aaa; // ����
	Tiger m1(Tiger bbb) {
		System.out.println(bbb.number);
		System.out.println(bbb.hashCode());
		bbb.number = 888;
		return bbb;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		Tiger aaa = new Tiger();
		aaa.number = 999;
		System.out.println(aaa.hashCode());
		Tiger ccc = t1.m1(aaa);
		System.out.println(ccc.hashCode());
		System.out.println(ccc.number);
	}
}
*/

/*
//ex35)
class Tiger{
	int num = 100;
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
		
		Tiger t3 = null;
		// NullPointerException
		//System.out.println(t3.hashCode());
		t3 = t1;
		System.out.println(t3.hashCode());
		System.out.println(t1.num);
		t1.num = 200;
		System.out.println(t3.num);
	}
}
*/


/*
//ex34)
class Tiger{

}
class Lion{
	// Tiger t = new Tiger();
	void m1(int a, String s, Tiger t, Lion l) {
		if( s != null ) {
			
		}
	}
	
	Tiger m2() {
		return null;
	}
	
	Tiger m3() {
		return new Tiger();
	}
	
	Tiger m4() {
		Tiger t = new Tiger();
		return t;
	}
	
	Tiger m5(Tiger t) {
		return t;
	}
}

public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		t1.m1(10, "ȣ����", new Tiger(), new Lion());
		t1.m1(10, null, null, null);
	}
}
*/


/*
//ex33)
class Tiger{
	// �μ������� ���� : 8(int, float ...) + class
	void m1(float a, String s) {
		System.out.println(a + " " + s);
		
		System.out.println(s.length());
	}
	
	String m2() {
		// ���1
		//return "ȣ����";
		
		// ���2
		String s = "������";
		return s;
	}
	
	String m3() {
		// 
		return null;
	}

}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "ȣ����");
		//1
		t1.m2();
		
		//2
		String s = t1.m2();
		System.out.println(s);
		
		//3
		System.out.println(t1.m2());
		
		// ���� s2�� ��ü�� �ƴϴٶ�� ���� ��������� ǥ��
		String s2 = null;
		
		String s3 = "�ڳ���";
		
		// �����ϰ� ����ϴٰ�....
		
		s3 = null;
	}
}
*/

/*
//ex32)
class Tiger{
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		// ���ڿ�
		// ù���ڰ� �빮��(Ŭ����)
		// ���� ���� ���� ����
		// �ڹٿ��� �����Ǵ� ǥ�� Ŭ����
		// ������ �ٸ��� method�� ���� �ִ����� �ñ�?
		String s1 = new String();
		s1 = "ȣ����";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// ��� ǥ��
		String s2 = "�޹���";
		System.out.println(s2);
		
		Thread t;
		
		Math m;
	}
}
*/

/*
//ex31)
class Tiger{
	int a, b;
	
	void showData() {
		System.out.println(a + " " + b);
	}
	
	int add() {
		return a + b;
	}
	
	void m1(int a, int b) {
		// ���������� ���� ���
		// �μ����� ���� ���
		int result = a + b;
		System.out.println(result);
		// �ʵ��� a, b�� ����ϰ� �ʹٸ�
		// this >> Ű���带 ���
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.a = 10;
		t1.b = 20;
		t1.showData();
		System.out.println(t1.add());
		t1.m1(100, 400);
	}
}
*/

/*
//ex30)
class Tiger{
	void f1() {
		System.out.println(1);
	}
	void f2() {
		f1();
		System.out.println(2);
	}
	void f3() {
		f2();
		System.out.println(3);
	}
	
	// ��ȣ ȣ��
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	
	// ��� ȣ��(recursive call)
	// �߾��� ������ ���� ex)��Ʈ��
	void f6() {
		System.out.println(6);
		f6();
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f3();
		System.out.println(4);
		//t1.f4();
		//t1.f6();
	}
}
*/

/*
//ex29)
class Tiger{
	// ������ �ִ�. FuncName(){}
	// ~~�� ����.
	// ���ϰ��� ����.
	void func01() {
		System.out.println("ȣ����");
	}
	int func02() {
		System.out.println(1);
		return 100;
	}
	
	// �޼ҵ忡�� return Ű���带 ������ �Լ��� �ߴܵ�
	// � ������ �ڵ尡 ������ �Ǵ���� return�� ��������
	int func03() {
		if( 3 < 2 ) {
			return 100; // �Լ� ���� ����			
		}else if( false ){
			return 200; // �Լ� ���� ����
		}else {
			System.out.println(1000);
			//return 300;
		}
		System.out.println(1000);
		return 2000;
	}
	
	// void ������ return Ű���带 ����� �� �ִ�
	void func04() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if( i == 5 ) {
				//break;
				return;	// �ٷ� ��
			}
		}
		System.out.println("for �ߴܵ�");
	}
	
	// 4��° ����
	int func05(int num) {
		
		//return num * num;
		int result = num * num;
		//System.out.println(result);
		if(result < 0) {
			
		}
		return result;
	}
	
	int func06(int num) {
		//System.out.println(num*num);
		return num * num;
	}
	
	// ��Ģ�� �����
	// -1�� ���ϵ� ���� ������ ���
	// +1 ~~~ ����
	int func07(int num) {
		if( num < 0) {
			//System.out.println("������");
			return -1;
		}
		
		if( num % 2 == 0) {
			System.out.println("¦");
		}else {
			System.out.println("Ȧ");
		}
		
		return 1;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// 1. �ܸ�
		t1.func02();
		// 2.
		int num = t1.func02();
		//int num = 100;
		System.out.println(num);
		// 3.
		System.out.println(t1.func02());
		// System.out.println(100);
		
		// �������� ��ã�´�
		// System.out.println(t1.func01());
		System.out.println(t1.func03());
		System.out.println("------------");
		t1.func04();
		
		System.out.println("------------");
		System.out.println(t1.func05(4));
		
		System.out.println(t1.func06(5) + t1.func06(3));
		
		if( t1.func07(-4) == -1) {
			System.out.println("�����Դϴ�.");
		}
	}
}
*/

/*
//ex28)
class Tiger{
	void m1() {
		System.out.println("��");
	}
	void m2(int num) { // = ���Կ����� �Ͼ
		System.out.println("��" + num);
	}
	void m3(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("��");
		}System.out.println();
	}
	//void m4(int a, b) { >> X
	void m4(int a, int b) {
		System.out.println(a + " " + b);
		System.out.println(a * b);
	}
	// void m5(int w, int h, char ch) {
	void m5(int width, int height, char ch, boolean b) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(ch + " ");
			}System.out.println();
		}
	}
	void m6(int n) {
		for (int i = 0; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + i*n);
		}
	}
	void m7(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	void m8(int w, int h, char ch1, char ch2) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
//				if((i + j) % 2 == 0) {
//					System.out.print(ch1 + " ");
//				}else {
//					System.out.print(ch2 + " ");
//				}
				System.out.print(((i + j) % 2 == 0 ? ch1 : ch2) + " ");
			}System.out.println();
		}
	}
}

public class Hello { 
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();
		t1.m2(3);
		t1.m3(8);
		t1.m3(14);
		t1.m4(3, 4);
		// ����, ����
		t1.m5(5, 4, '*', true);
		t1.m6(19);
		t1.m7(100);
		t1.m8(8, 7, '��', '��');
	}
}
*/

/*
class Tiger{
	// 1. void f1() {}
	// 2. void f1(int a) {}
	// 3. int f1() {}
	// 4. int f1(int a) {}
	
	// 1. ���Ͼ��� f1(�μ����� ����) {}
	// 2. ���Ͼ��� f1(�μ����� ����) {}
	// 3. �����ִ� f1(�μ����� ����) {}
	// 4. �����ִ� f1(�μ����� ����) {}
	
	// 1. X f1(X) {}
	// 2. X f1(O) {}
	// 3. O f1(X) {}
	// 4. O f1(O) {}
	
	// 1
	void method01() {
		System.out.println("method01");
		System.out.println("method01");
		System.out.println("method01");
		System.out.println("method01");
	}
	
	void method02() {
		System.out.println("method02");		
	}
}
//ex27)
public class Hello {
	public static void main(String[] args) {
		// �ڵ��� ��Ȱ��
		// �Լ�(�޼ҵ�) : ���� ���Ǵ� �ڵ带 �����ؼ� ��Ȱ��
		
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // �Լ��� ȣ��
		System.out.println(2000);
		t1.method01(); // �Լ��� ȣ��
		System.out.println(3000);
		
		Tiger t2 = new Tiger();
		t2.method01();
		System.out.println("------------");
		t1.method02();
		t2.method02();
	}
}
*/

/*
// ���������� Ŭ������ ù���ڴ� �빮��
// ���赵
class Airplane{
	// 1. �ʵ�(����) >> �Ӽ�
	int a; // int fuel;
	float b;
	int seat;
	int[] ar = new int[4];
	
	int num = 99;
	// 2. ������
	
	// 3. �޼ҵ�(�Լ�)
}

//ex26)
public class Hello {
	public static void main(String[] args) {
		// Airplane a = new Airplane();
		// Airplane airplane = new Airplane();
		// ���� ����Ⱑ ���������
		Airplane air = new Airplane();
		Airplane air2 = new Airplane();
		
		// air.a = 10;
		air.b = 20.0f;
		air.seat = 30;
		System.out.println(air.a);
		System.out.println(air.b);
		
		air2.seat = 40;
		// ������ ���� �ٸ� �޸�
		System.out.println(air.seat + " " + air2.seat);
		
		System.out.println(air.ar.length);
		for (int i = 0; i < air.ar.length; i++) {
			air.ar[i] = i * 10;
		}
		for (int i = 0; i < air.ar.length; i++) {
			System.out.print(air.ar[i] + " ");
		}System.out.println();
		
		for (int i = 0; i < air2.ar.length; i++) {
			System.out.print(air2.ar[i] + " ");
		}System.out.println();
		
		air.ar = new int[8];
		for (int i = 0; i < air.ar.length; i++) {
			System.out.print(air.ar[i] + " ");
		}System.out.println();
		
		System.out.println(air.num);
		System.out.println(air2.num);
		air.num = 1000;

		System.out.println(air.num);
		System.out.println(air2.num);
//		int[]ar;
//		System.out.println("------");
//		ar = new int[10];
//		// ar�� ����ߴٰ� ġ��....
//		// ������ 10���� �������
//		// �׸��� ���ο� 20���� ����
//		ar = new int[20];

		// �޸� �ݳ��ڵ�
		// delete ar; << �ڹٿ����� ���α׷��Ӱ� �Ű澵 �κ� �ƴ�
	}
}
*/

/*
//ex25)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		// 
		int num = 50;
		int[] ar = new int[num];
		for (int i = 0; i < ar.length; i++) {
			// ������ ����
			ar[i] = rnd.nextInt(20);
		}
		for (int i = 0; i < ar.length; i++) {
			// ������ ���
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		for (int i = 0; i < ar.length/2; i++) {
			System.out.print(ar[i] + ar[(num-1)-i] + " ");
		}System.out.println();
		// ar[0] + ar[9]
		// ar[1] + ar[8]
		// ar[2] + ar[7]
		// ar[3] + ar[6]
		// ar[4] + ar[5]
		
	}
}
*/

/*
//ex24) �迭(array)
public class Hello {
	public static void main(String[] args) {
		// ȣ����[] arr = new ȣ����[10];
		// 1. ����
		int[] arr = new int[10];
		// 2. ���� ���ÿ��� ���
		int[] brr = new int[] {10, 20, 30};
		// 3.
		int[] crr = {40, 50, 60};
		
		// arr�� ������ 10��
		// ex1)
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		// ex2)
		// 0 - 9
		// arr[-5] = 100; // �ߴܵ�
		// arr[10] = 100;
		// ArrayIndexOutOfBoundsException
		System.out.println("ȣ����");
		
		// ex3) ���� ��� �� ������� ����
		int num = 4;
		arr[num*2-7] = 999;
		System.out.println(arr[1]);
		
		// ex4)
		arr[5] = 7;
		arr[7] = 777;
		arr[arr[5]*2-7] = 888;
		System.out.println(arr[7]);
		
		// ex5)
		System.out.println("----------------");
		System.out.println(arr.length);
		
		// ex6)
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}System.out.println();
		
		System.out.println("������");
	}
}
*/

/*
//ex23)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int num = rnd.nextInt(30);
		switch (num % 2) {
		case 0:{
			for (int i = 0; i <10; i++) {
				System.out.println(num + " * " + i + " = " + num*i);
			}
		}break;
			
		case 1:{
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "������ ���� : " + sum);
		}break;

		default: break;
		}
	}
}
*/

/*
//ex22) ����
public class Hello {
	public static void main(String[] args) {
		int score = 87;
		switch (score / 10) {
		case 10: // break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;

		default:
			System.out.println("F");
			break;
		}
	}
}
*/

/*
//ex21) switch
public class Hello {
	public static void main(String[] args) {
		// 1. switch �ȿ� ������ ����� �� �ִ�.
		// 2. case �ڿ� ������ ����� �� ����.
		// 3. break�� �����ϸ� switch�� ���������� �ʴ´�.
		// 4. �����ϴ� �б⹮�� �������� default�� �̵�.
		// 5. ����, ����, ���ڿ� ��� �бⰡ ����.
		// 6. �ǵ������� break�� �����ϱ⵵ �Ѵ�.
		int num = 99;
		int nn = 10;
		char ch = '��';
		switch ("ȣ����") {
		// case nn: >> ����� �� ����.
		case "ȣ����":
			System.out.println(1);
			break;
			
		case "�ڳ���":
			System.out.println(2);
			break;
			
		case "������":
			System.out.println(3);
			break;

		default:
			System.out.println("ȣ����");
			break;
		}
	}
}
*/

/*
//ex20) ���� �߻��� - �ڸ��� �� ���ϱ�
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int sum = 0;
		int num = rnd.nextInt();
		if(num < 0) {
			num = -num;
		}
		System.out.println(num);
		
		while(true) {
			sum = num % 10 + sum;
			if(num < 10) {
				break;
			}
			num /= 10;
		}
		System.out.println(sum);
	}
}
*/

/*
//ex19) ��ڼ�
public class Hello {
	public static void main(String[] args) {
		int num = 29292;
		
		while(true) {
			System.out.println(num);
//			if(num % 2 == 0) {
//				num = num / 2;
//			}else {
//				num = num * 3 + 1;
//			}
			
			num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
			
			if(num == 1) {
				System.out.println(num);
				break;
			}
		}
	}
}
*/

/*
//ex18) while( ����ϰ� ��� : for)
public class Hello {
	public static void main(String[] args) {
//		int num = 0;
//		while( true ) {
//			num++;
//			System.out.println(num);
//		}
		
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num++;
		}
		
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("Ż����");
				break;
				//System.out.println("unreach code");
			}
			System.out.println(num);
			num++;
		}
		
		//System.out.println("ȣ����");
	}
}
*/

/*
//ex17-2)
public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) { // ����
			for (int j = 0; j < 4; j++) { // ����
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; i++) { // ����
			for (int j = 0; j < 4; j++) { // ����
				System.out.print("[" + i + " " + j + "]");
			}
			System.out.println();
		}
		System.out.println();
		
		int width = 8, height = 7;
		for (int i = 0; i < height; i++) { // ����
			for (int j = 0; j < width; j++) { // ����
//				if( (i+j)%2 == 0) {
//					System.out.print("O ");
//				}else {
//					System.out.print("X ");
//				}
				System.out.print( (i+j)%2 == 0 ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println();
		int result;
		if( 3 > 2 ) {
			result = 10;
		}else {
			result = 20;
		}
		// ������ ���׿������� �����Ѵ�.
		result = ( 3 > 2 ) ? 10 : 20;
		//( 3 > 2 ) ? result = 10 : result = 20; x
		
//		int func() {
//			if( 3 > 2 ) {
//				return 100;
//			}else {
//				return 200;
//			}
//			//( 3 > 2 ) ? return 100 : return 200; x
//			return ( 3 > 2 ) ? 100 : 200;
//		}
	}
}
*/

/*
//ex17-1) ��������
public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println("---------------");
			for (int j = 0; j < 4; j++) {
				System.out.println(1);
			}
			System.out.println("***************");
		}
	}
}
*/

/*
//ex16) ������
public class Hello {
	public static void main(String[] args) {
		int num = 15;
		for (int i = 0; i <10; i++) {
			System.out.println(num + " * " + i + " = " + num*i);
		}
		System.out.println("-------------");
		
		int sum = 0;
		int num2 = 1000;
		for (int i = 1; i <= num2; i++) {
			//sum = sum + i;
			// 1 = 0 + 1
			// 3 = 1 + 2
			// 6 = 3 + 3
			// 10 = 6 + 4
			
			sum += i;
			//System.out.println(sum);
		}
		System.out.println(sum);
		
		int sum2 = 1;
		int a = 3, b = 4;
		// 2�� 8��
		for (int i = 0; i < b; i++) {
			sum2 *= a;
			// ? = 1 * 2
			// ? = (1 * 2 ) * 2
			// ? = ((1 * 2 ) * 2) * 2
		}
		System.out.println(sum2);

	}
}
*/

/*
//ex15)
public class Hello {
	public static void main(String[] args) {
		// ����1
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
		}

		// ����2
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		// ����3 - �������� ��ǥ��
		for (int i = -3; i <= 3; i++) {
			System.out.println(i);
		}
		
	}
}
*/

/*
//ex14) if else if
public class Hello {
	public static void main(String[] args) {
		int score = 87;
		
		if(score >= 90) {
			System.out.println('A');
		}else if(score >= 80) {
			System.out.println('B');
		}else if(score >= 70) {
			System.out.println('C');
		}else {
			System.out.println('F');
		}
		System.out.println(5);
	}
}
*/

/*
//ex13) if else
public class Hello {
	public static void main(String[] args) {
		// 1. if() {}
		// 2. if() {} else {}
		// 3. if() {} else if() else if() {}
		int num = 10;
		if(num % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
		
		int password = 1234;
		if(password != 1234) {
			System.out.println("Ʋ��");
			//break;
			//return;
			//exit();
			//continue;
		} 
		System.out.println("����");
		System.out.println("������ �α��� �Ͽ���");
		System.out.println("���� ���� Ȯ��");
		
//		int nn = 10;
//		while() {
//			if( nn < 0 ) {
//				sin(); //nn = -nn;
//			}else {
//				sin(); //nn = +nn;
//			}
//		}
	}
}
*/

/*
//ex12)
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		if(3 > 2) {
			System.out.println(2);
			if(3 != 4) {
				System.out.println(3);
			}
			System.out.println(4);
			if( 3+4 >= 7) {
				System.out.println(5);
			}
			System.out.println(6);
		}
		System.out.println(7);
	}
}
*/

/*
//ex11) ��� if, for, while, switch : // >> >> do while(x)
public class Hello {
	public static void main(String[] args) {
		if(true) {
			System.out.println(1);
			System.out.println(2);
		}
		if(false) {
			System.out.println(3);
			System.out.println(4);
		}
		
		System.out.println(5);
		System.out.println("-------------");
		
		if(true) {
			System.out.println(6);
			if(true) {
				System.out.println(7);
			}
			System.out.println(8);
		}
		System.out.println(9);
	}
}
*/

/*
//ex10) swap ���α׷�
public class Hello {
	public static void main(String[] args) {
		int a = 10, b = 20;
		int t; // temp
		System.out.println(a + " " + b);
		t = a; // t = 10		
		a = b; // a = 20
		b = t; // b = 10
		System.out.println(a + " " + b);
	}
}
*/

/*
//ex9)
public class Hello {
	public static void main(String[] args) {
		int n = 10;
		n = 20;
		System.out.println(n);
		// ex1)
		n = n + 10;
		System.out.println(n);
		// ex2)
		n += 10;
		System.out.println(n);
		
		n = n + 1;
		n += 1;
		n++;
		++n;
		
		n = 10;
		int a, b;
		a = n++; // ���� ����
		// a = 10, n = 11
		System.out.println(a + " " + n);
		
		n = 10;
		b = ++n; // ���� ����
		System.out.println(b + " " + n);
		// b = 11, n = 11
		
	}
}
*/

/*
//ex8)
public class Hello {
	public static void main(String[] args) {
		//1. �����̸��� �ߺ��� �� ����.
		int apple;
		// int apple; (x)
		
		//2. ��� ���еȴ�.
		int Apple;
		
		//3. ù���ڰ� ���ڰ� �ƴ϶�� ���� ��밡��
		int Apple123;
		// int 9Apple; (x)
		
		//4. _ $ �� �����ϸ� Ư������ ��� �Ұ�
		int apple_num;
		int _34;
		
		//5. �ѱ� ��� ����(������ ����)
		int ��� = 10;
		System.out.println(���);
		
		//6. �ܾ� �ռ��ÿ��� ī��ǥ��� ���
		int BananaNumber = 10;
		int bananaNumber = 10;
		
	}
}
*/

/*
//ex7)
public class Hello {
	public static void main(String[] args) {
		// byte, short, int, long : ��������
		// boolean(1), char(2), float(4,�Ҽ���), double(8,�Ҽ���)
		byte apple; // ���� <-> ���
		// = �� ���Կ�����
		apple = 10;
		System.out.println(apple);
		apple = 20;
		System.out.println(apple);
		apple = 127;
		
		// short 	type 
		// banana 	����(variable)
		// = 		���Կ�����
		// 20; 		���ͷ�
		
		short banana = 20;
		
		int orange = 30;
		
		long kiwi = 40;
		
		// boolean(1), char(2), float(4,�Ҽ���), double(8,�Ҽ���)
		boolean t1 = true;// false
		char t2 = 'A';
		char t3 = '��';
		// ���� ���α׷��� ������ ���Ѵ�.
		char t4 = 65; // ������ ������ - �ƽ�Ű�ڵ� A ��Ÿ��
		System.out.println(t2);
		System.out.println(t3);
		System.out.println((int)t2);
		System.out.println((int)t3);
		System.out.println((char)(t3+1));
		System.out.println((int)Character.MAX_VALUE); // char = 0 ~ 65535
		
		char a = 'A', b = 20;
		System.out.println(a + b);
		
		float t5 = 3.14f; // 4byte, float�� ���ڵڿ� f �ʼ�
		double t6 = 3.14; // 8byte, f ������, �� �� ������ ���
		
		double sum = 0.0;
		for (int i = 0; i < 100; i++) {
			sum = sum + 0.1;
		}
		System.out.println(sum);
		
	}
}
*/

/*
//ex6)
public class Hello {
	public static void main(String[] args) {
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE); // 2byte
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE); // 4byte
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE); // 8byte
		System.out.println(Long.MAX_VALUE);
	}
}
*/

/*
//ex5) ������ 
public class Hello {
	public static void main(String[] args) {
		System.out.println(false || false); // or
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		System.out.println("-----");
		System.out.println(false && false); // and
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);
		System.out.println("-----");
		System.out.println(3 + 2 > 7 && 2 + 6 < 8); // ������� �켱���� - ��� > ���� > ��
		System.out.println("-----");
		System.out.println(!true); // not
		System.out.println(!(3 > 2));
	}
}
*/

/*
//ex4) ���迬��
public class Hello {
	public static void main(String[] args) {
		System.out.println(10 > 5);
		System.out.println(10 >= 5);
		System.out.println(10 < 5);
		System.out.println(10 <= 5);
		System.out.println(10 == 5);
		System.out.println(10 != 5);
	}
}
*/

/*
//ex3) �������
public class Hello {
	public static void main(String[] args) {
		System.out.println(17 + 3); // ���ϱ�
		System.out.println(17 - 3); // ����
		System.out.println(17 * 3); // ���ϱ�
		System.out.println(17 / 3); // ��
		System.out.println(17 % 3); // ������
		System.out.println(3 + 4 * 5); // �������
		System.out.println((3 + 4) * 5); // �������
		System.out.println((2 + 3) * 4 + 5); // �������
	}
}
*/

/*
//ex2)
public class Hello {
	public static void main(String[] args) {
		System.out.println(100); // ����
		System.out.println('��'); // ���� = �ݵ�� �Ѱ�
		System.out.println("ȣ����"); // ���ڿ� = �Ѱ� �̻�
		System.out.println(100+200); // ����+���� - �������
		System.out.println(100 + "ȣ����"); // ����+���ڿ� - ���ڿ�
		System.out.println("ȣ����" + 100); // ���ڿ�+���� - ���ڿ�
		System.out.println("ȣ����" + "����"); // ���ڿ�+���ڿ� - ���ڿ�
		System.out.println("100" + 100); // "����"+���� - ���ڿ�
		System.out.println(10 + 20 + "ȣ����"); // ���ʺ��� ����������
		System.out.println("ȣ����" + 10 + 20); // ���ʺ��� ����������
		System.out.println(10 + " " + 20); // ��ĭ���
		System.out.println(10 + " " + 20 + " " + 30); // ��ĭ���
		System.out.println(10 + 'A'); // �ƽ�Ű�ڵ�
		System.out.println(1 + 'A'); // �ƽ�Ű�ڵ�
		System.out.println((char)(1 + 'A')); // �ƽ�Ű�ڵ�
	}
}
*/

/*
// ex1)
public class Hello {
	public static void main(String[] args) {
		System.out.println( 1000 );
		System.out.println( 2000 );
	}

}
*/