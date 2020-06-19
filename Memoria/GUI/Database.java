package Memoria.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	private String JDBC_DRIVER =  "com.mysql.cj.jdbc.Driver"; // Mysql 드라이버
	private final String DB_URL = "jdbc:mysql://localhost:3306/memoria?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false&autoreconnect=true";// 3306포트에 localhost 아이피 주소를 가진다.
	private final String DB_USER = "root"; // DB에 접속할 ID
	//DOKKU
	private final String DB_PASSWORD = "root"; // DB에 접속할 비밀번호.
	//land1!4$7&2@
	
	ArrayList <String> dbTitle = new ArrayList<>();
	
	MainGUI mainGUI;
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
	public ResultSet getContentsResultSet ( int thisYear, int thisMonth) { // 해당년도와 월에 맞춰서 캘린더에 존재할 수 있는 콘텐츠들을 가져오는 메소드
		String previousDate = null;
		String nextDate = null;
		String date = null;
		// 20201200 20210100
		if(Integer.valueOf(thisMonth) == 12 ) {
			previousDate = String.valueOf(thisYear) + "1100";
			nextDate = String.valueOf(thisYear+1) + "0100";
			date = String.valueOf((thisYear + thisMonth + "00"));
		}
		else if(Integer.valueOf(thisMonth) < 10 && Integer.valueOf(thisMonth) != 12 ) {
			previousDate = String.valueOf(thisYear) + "1100";
			nextDate = String.valueOf(thisYear) + "0" + Integer.valueOf(thisMonth) + "00";
			date = String.valueOf((thisYear + "0" +thisMonth + "00"));
		}
		String sql_select_Contents = "SELECT * \r\n" + 
				"FROM memoria.contents\r\n" + 
				"WHERE " +previousDate +">R_DATE AND R_DATE >"+nextDate+"\r\n" + 
				"OR L_DATE > " + date + " AND R_DATE < " + date + ";";
		try {
			
			return resultset = statement.executeQuery(sql_select_Contents);
		} catch (SQLException e) {
			System.out.println("DB콘텐츠 셀렉트 오류 : Database.getContets() ");
			e.printStackTrace();
		}
		return resultset;
	}
	//ALTER TABLE contents MODIFY ID INT NOT NULL AUTO_INCREMENT; mysql에서 실행시 ID 값이 자동으로 증가하게 바뀜
	
	
	public void clearContents() { // 데이터베이스를 초기화해주는 메소드 
		String sql_init_id ="ALTER TABLE contents AUTO_INCREMENT=1;";
		String sql_init_id2="DELETE FROM contents";
				
		try {
			statement.executeUpdate(sql_init_id2);
			statement.executeUpdate(sql_init_id);
		} catch (SQLException e) {
			System.out.println("DB 테이블 id애트리뷰트 초기화 오류 : Database.SetId()");
			e.printStackTrace();
		}
	}
	
	 public void searchTitle(){			//등록한 제목들을 불러오는 메소드
         try{
        	 	String sql;
        	 	ResultSet result;
                 sql = "SELECT TITLE FROM contents";
                 result = statement.executeQuery(sql);
                 
                 while(result.next()) {
                	 dbTitle.add(result.getString("title"));
                 }
         }catch(NullPointerException e){
        	 System.out.println("serachTitle() : 등록되있는 컨탠츠가 없습니다.");
        	 
         }catch(Exception e){
                e.printStackTrace();
                System.out.println("DB 테이블 title 불러오기 실패 : Database.searchTitle()");
         }
   }//end searchTitle();
	


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
