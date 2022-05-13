package Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Mysql {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹�
	static final String DB_URL = "jdbc:mysql://192.168.0.86/db01?&useSSL=false"; //������ DB ����

	static final String USER_NAME = "lion"; //DB�� ������ ����� �̸��� ����� ����
	static final String PASSWORD = "1234"; //������� ��й�ȣ�� ����� ����



	static Scanner sc = new Scanner(System.in);
	static Connection conn = null;
	Statement state = null;
	ResultSet rs = null;
	PreparedStatement prstate = null;


	public static void main(String[] args) {
		new Mysql().crudStart();
	}

	public void crudStart(){
		while(true){
			int choice = Menu();

			switch(choice){
			case 1: Insert(); break; //�߰�
			case 2: Select();break; //����
			case 3: Update(); break; //���� (���̵����� ��ü �׸� ����)
			case 4: Delete(); break; //��ü�ڷ� ���
			case 0: System.out.println("���α׷��� �����մϴ�."); //����
			return;
			default : System.out.println("��ȣ���߸��Է��߽��ϴ�. �ٽ� �Է��ϼ���");

			}
		}
	}

	void Insert() {
		try{
			PreparedStatement state = null;

			System.out.println("�߰��� ���� �Է��ϼ���");

			System.out.println("�߰��� name : ");
			String insertName = sc.next();
			System.out.println("�߰��� kor : ");
			int insertKor = sc.nextInt();
			System.out.println("�߰��� eng : ");
			int insertEng = sc.nextInt();
			System.out.println("�߰��� mat : ");
			int insertMat = sc.nextInt();
			
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			String sql = " insert into table01 values(null , ? , ? , ? , ?)";
			state = conn.prepareStatement(sql);
			state.setString(1, insertName);
			state.setInt(2, insertKor);
			state.setInt(3, insertEng);
			state.setInt(4, insertMat);

			int cnt = state.executeUpdate();
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("insert ����");
			}else{
				System.out.println("insert ����");
			}
		} catch(Exception e){
			//���� �߻� �� ó���κ�
		} finally { //���ܰ� �ֵ� ���� ������ ����
			try{
				if(state!=null)
					state.close();
			}catch(SQLException ex1){
				//
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException ex1){
				//
			}
		}

	}
	void Select() {
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;

		System.out.println("������� ���̺� ����");
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();

			String sql = "select * from table01";
			rs = state.executeQuery(sql); //SQL���� �����Ͽ� ����

			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String kor = rs.getString("kor");
				String eng = rs.getString("eng");
				String mat = rs.getString("mat");
				System.out.print("id: "+ id + "Name: " + name + "KOR: " + kor); 
				System.out.print("ENG: " + eng + "MATH: "+ mat + "\n-------------\n");
			}

			rs.close();
			state.close();
			conn.close();
		} catch(Exception e){
			//���� �߻� �� ó���κ�
		} finally { //���ܰ� �ֵ� ���� ������ ����
			try{
				if(state!=null)
					state.close();
			}catch(SQLException ex1){
				//
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException ex1){
				//
			}
		}
	}
	void Update() {
		Connection conn = null;
		ResultSet rs = null;
		try{
			
			PreparedStatement state = null;
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);


			System.out.println("������Ʈ�� id : ");
			int updateId = sc.nextInt();        

			System.out.println("������Ʈ�� name : ");
			String updateName = sc.next(); //nextLine() X

			System.out.println("������Ʈ�� ���� ���� : ");
			int updateKOR= sc.nextInt();


			System.out.println("������Ʈ�� ���� ���� : ");
			int updateENG= sc.nextInt();

			System.out.println("������Ʈ�� ���� ���� : ");
			int updateMATH= sc.nextInt();

			String sql = "update table01 set name = ? ,kor = ? , eng = ?, mat = ? where id = ?";

			state = conn.prepareStatement(sql);
			state.setString(1, updateName);
			state.setInt(2, updateKOR);
			state.setInt(3, updateENG);
			state.setInt(4, updateMATH);
			state.setInt(5, updateId);

			int cnt = state.executeUpdate();
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("update ����");
			}else{
				System.out.println("update ����");
			}
			rs.close();
			state.close();
			conn.close();
		} catch(Exception e){
			//���� �߻� �� ó���κ�
		} finally { //���ܰ� �ֵ� ���� ������ ����
			try{
				if(state!=null)
					state.close();
			}catch(SQLException ex1){
				//
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException ex1){
				//
			}
		}
	}
	void Delete() {
		Connection conn = null;
		ResultSet rs = null;
		try{
			PreparedStatement state = null;
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			
			System.out.println("����� ���� ���̵� �Է��ϼ��� : ");
			int select_id= sc.nextInt();

			String sql = "delete from table01 where id = ?";  
			state = conn.prepareStatement(sql);
			state.setInt(1, select_id);
			
			int cnt = state.executeUpdate();
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("delete ����");
			}else{
				System.out.println("delete ����");
			}

			rs.close();
			state.close();
			conn.close();
		} catch(Exception e){
			//���� �߻� �� ó���κ�
		} finally { //���ܰ� �ֵ� ���� ������ ����
			try{
				if(state!=null)
					state.close();
			}catch(SQLException ex1){
				//
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException ex1){
				//
			}
		}
	}

	private int Menu() {
		System.out.println("==�۾�����==");
		System.out.println("1.�ڷ��߰� 2.�ڷ���ȸ 3.�ڷ���� 4.�ڷ���� 0.�۾���");
		System.out.print("����>");

		int input=sc.nextInt(); 
		sc.nextLine();

		return input;
	}

}

