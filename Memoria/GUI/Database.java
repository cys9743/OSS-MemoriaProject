package Memoria.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private String JDBC_DRIVER =  "com.mysql.cj.jdbc.Driver"; // Mysql 드라이버
	private final String DB_URL = "jdbc:mysql://localhost:3306/memoria?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false&autoreconnect=true";// 3306포트에 localhost 아이피 주소를 가진다.
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
	
	public boolean registerContents(String title, String text, int priority, String registerDate, String lastDate, String fileLink ) {//DB에서 콘텐츠를 조회하고 존재하면 FALSE 리턴, 존재하지 않으면 매개변수 DB에 삽입하고 TRUE 리턴, 나머지 안되는경우에도 FALSE
		try {	
			String sql_insert_contents = "INSERT INTO memoria.contents " // 콘텐츠 삽입 UPDATE문
					+ "VALUES('"+ 0 
					+ "','" + title 
					+ "','" + text 
					+"','" + priority 
					+"','"+	registerDate 
					+"','"+ lastDate 
					+"','"+ fileLink 
					+ "');";
			String sql_search_contents = "SELECT id FROM memoria.contents WHERE " // 완전히 중복된 콘텐츠가 있는지 검색하는 쿼리문
					+ "TITLE='" + title 
					+ "'AND TEXT='" + text 
					+ "'AND PRIORITY='"+ priority 
					+ "'AND R_DATE='"+ registerDate 
					+ "'AND L_DATE='"+ lastDate 
					+ "'AND F_LINK='"+fileLink+"';";
			resultset = statement.executeQuery(sql_search_contents);
			if(resultset.next()) {
				System.out.println("이미 완전히 중복되는 콘텐츠가 테이블에 있음.");
				return false;
			}
			else {
				setId();
				statement.executeUpdate(sql_insert_contents);
				System.out.println("쿼리 삽입 성공");
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB콘텐츠 등록 오류 : Database.registerContets() ");
		}
		return false;
	}
	
	public void setId() { // 데이터베이스의 id값을 자동으로 초기화해주는 메소드 
		String sql_init_id ="ALTER TABLE `contents` AUTO_INCREMENT=1;";
		String sql_init_id2="SET @COUNT = 0;";
		String sql_init_id3="UPDATE `contents` SET ID = @COUNT:=@COUNT+1;";
				
		try {
			statement.executeUpdate(sql_init_id);
			statement.executeQuery(sql_init_id2);
			statement.executeUpdate(sql_init_id3);
		} catch (SQLException e) {
			System.out.println("DB 테이블 id애트리뷰트 초기화 오류 : Database.SetId()");
			e.printStackTrace();
		}
	}


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
