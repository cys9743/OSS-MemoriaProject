package Memoria.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private String JDBC_DRIVER =  "com.mysql.cj.jdbc.Driver"; // Mysql 드라이버
	private final String DB_URL = "jdbc:mysql://localhost:3306/memoria?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";// 3306포트에 localhost 아이피 주소를 가진다.
	private final String DB_USER = "root"; // DB에 접속할 ID
	private final String DB_PASSWORD = "root"; // DB에 접속할 비밀번호.
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	
	public Database() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			statement = connection.createStatement();

			System.out.println("DB 접속 완료");
		}catch(SQLException e) {
			System.out.println("DB 접속 오류");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DB(MYsql) 드라이버 오류");
			e.printStackTrace();
		}
	}
	/*SQL 보내는 메소드 예제 (참고용)
	public boolean loginSend(String id, String password) {//DB에서 아이디와 비밀번호 조회하고 존재하고 DB와 일치하면 TRUE 아니면 FALSE 리턴.
		try {
			String sql_search_account = "SELECT * FROM send.account WHERE id='" + id +"' AND pw='"+ password +"'";
		resultset = statement.executeQuery(sql_search_account);
		
		if(resultset.next())
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB로그인 오류");
		}
		return false;
	}
	
	public boolean register(String id, String password, String name, String phone) {//DB에서 아이디 조회하고 존재하면 FALSE 리턴, 존재하지 않으면 매개변수 DB에 삽입하고 TRUE 리턴
		try {	

			String sql_search_account = "SELECT id FROM send.account WHERE id='" + id +"'";
			String sql_insert_register1 = "INSERT INTO send.account VALUES('" + id + "','" + password +"');" ;
			
			String sql_insert_register2 = "INSERT INTO send.user_info VALUES('"+id+"','" + name + "','" + phone + "');";
			
			resultset = statement.executeQuery(sql_search_account);
			if(resultset.next()) {
				
			System.out.println("DB회원가입 오류- 이미 존재하는 계정");
				return false;
			}
			else
			{
				statement.executeUpdate(sql_insert_register1);
				statement.executeUpdate(sql_insert_register2);
				System.out.println("회원가입 성공");
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB회원가입 오류 ");
		}
		return true;
	}
	
	public boolean searchAccount(String id) {//DB에서 아이디 조회하고 존재하면 TRUE 리턴, 존재하지 않으면 FALSE 리턴.
		try {
		String sql_search_account = "SELECT id FROM send.account WHERE id='" + id +"'";
		resultset = statement.executeQuery(sql_search_account);
		if(resultset.next())
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("로그인 중복 오류");
		}
		return false;
	}
	*/

	public void closeDB() {//DB 커넥션, 스테이트먼트, 리설트셋 CLOSE()
		try {
			connection.close();
			statement.close();
			resultset.close();
		} catch (SQLException e) {
			System.out.println("DB 종료 오류");
			e.printStackTrace();
		}
	}
}
