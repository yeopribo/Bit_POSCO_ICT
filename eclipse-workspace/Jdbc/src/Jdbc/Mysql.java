package Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Mysql {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	static final String DB_URL = "jdbc:mysql://192.168.0.86/db01?&useSSL=false"; //접속할 DB 서버

	static final String USER_NAME = "lion"; //DB에 접속할 사용자 이름을 상수로 정의
	static final String PASSWORD = "1234"; //사용자의 비밀번호를 상수로 정의



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
			case 1: Insert(); break; //추가
			case 2: Select();break; //삭제
			case 3: Update(); break; //수정 (아이디제외 전체 항목 수정)
			case 4: Delete(); break; //전체자료 출력
			case 0: System.out.println("프로그램을 종료합니다."); //종료
			return;
			default : System.out.println("번호를잘못입력했습니다. 다시 입력하세요");

			}
		}
	}

	void Insert() {
		try{
			PreparedStatement state = null;

			System.out.println("추가할 정보 입력하세요");

			System.out.println("추가할 name : ");
			String insertName = sc.next();
			System.out.println("추가할 kor : ");
			int insertKor = sc.nextInt();
			System.out.println("추가할 eng : ");
			int insertEng = sc.nextInt();
			System.out.println("추가할 mat : ");
			int insertMat = sc.nextInt();
			
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			String sql = " insert into table01 values(null , ? , ? , ? , ?)";
			state = conn.prepareStatement(sql);
			state.setString(1, insertName);
			state.setInt(2, insertKor);
			state.setInt(3, insertEng);
			state.setInt(4, insertMat);

			int cnt = state.executeUpdate();
			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("insert 성공");
			}else{
				System.out.println("insert 실패");
			}
		} catch(Exception e){
			//예외 발생 시 처리부분
		} finally { //예외가 있든 없든 무조건 실행
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

		System.out.println("보고싶은 테이블 선택");
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();

			String sql = "select * from table01";
			rs = state.executeQuery(sql); //SQL문을 전달하여 실행

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
			//예외 발생 시 처리부분
		} finally { //예외가 있든 없든 무조건 실행
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


			System.out.println("업데이트할 id : ");
			int updateId = sc.nextInt();        

			System.out.println("업데이트할 name : ");
			String updateName = sc.next(); //nextLine() X

			System.out.println("업데이트할 국어 점수 : ");
			int updateKOR= sc.nextInt();


			System.out.println("업데이트할 영어 점수 : ");
			int updateENG= sc.nextInt();

			System.out.println("업데이트할 수학 점수 : ");
			int updateMATH= sc.nextInt();

			String sql = "update table01 set name = ? ,kor = ? , eng = ?, mat = ? where id = ?";

			state = conn.prepareStatement(sql);
			state.setString(1, updateName);
			state.setInt(2, updateKOR);
			state.setInt(3, updateENG);
			state.setInt(4, updateMATH);
			state.setInt(5, updateId);

			int cnt = state.executeUpdate();
			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("update 성공");
			}else{
				System.out.println("update 실패");
			}
			rs.close();
			state.close();
			conn.close();
		} catch(Exception e){
			//예외 발생 시 처리부분
		} finally { //예외가 있든 없든 무조건 실행
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

			
			System.out.println("지우고 싶은 아이디 입력하세요 : ");
			int select_id= sc.nextInt();

			String sql = "delete from table01 where id = ?";  
			state = conn.prepareStatement(sql);
			state.setInt(1, select_id);
			
			int cnt = state.executeUpdate();
			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("delete 성공");
			}else{
				System.out.println("delete 실패");
			}

			rs.close();
			state.close();
			conn.close();
		} catch(Exception e){
			//예외 발생 시 처리부분
		} finally { //예외가 있든 없든 무조건 실행
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
		System.out.println("==작업선택==");
		System.out.println("1.자료추가 2.자료조회 3.자료수정 4.자료삭제 0.작업끝");
		System.out.print("선택>");

		int input=sc.nextInt(); 
		sc.nextLine();

		return input;
	}

}

