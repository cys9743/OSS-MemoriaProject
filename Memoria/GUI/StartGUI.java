package Memoria.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.sql.SQLException;

public class StartGUI {

	private JFrame frame;
	private Database database;
	
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LogInGUI login = new LogInGUI();
				StartGUI window = new StartGUI();
				
				window.frame.setVisible(true);
				
				try {
					Database database = new Database();
					if(database.login() == 1) {
						System.out.println("접속 성공");
						MainGUI mainGUI = new MainGUI();
						window.frame.setVisible(false);
					}
					else if(database.login() == -2) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						System.out.println("드라이버 오류상태");
						JOptionPane.showMessageDialog(window.frame, "MySql에 접근이 실패하였습니다. Mysql과 메모리아가 정상적으로 설치되었는지 확인하세요.", "MySQL 접속 에러", JOptionPane.WARNING_MESSAGE);
						window.frame.setVisible(false);
					}
					else if(database.login() == -3) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		// 이 코드부분 이후로 생성되는 컴포넌트 객체는 윈도우ui 처럼 형성됨.

						System.out.println("테이블 존재하지 않는 상태");
						if(JOptionPane.showConfirmDialog(window.frame, "MySql에 데이터베이스에 대한 접근이 실패하였습니다. Mysql 데이터베이스 정보를 생성 하시겠습니까?.", "MySQL 스키마 에러", JOptionPane.WARNING_MESSAGE) == 0){
							System.out.println("실험");
							if(database.setUpSchemaAndTable())
								JOptionPane.showMessageDialog(window.frame, "데이터베이스 생성이 정상적으로 완료되었습니다. 프로그램을 다시 실행하세요.", "데이터베이스 생성 완료", JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(window.frame, "데이터베이스 생성하던 도중 오류 발생.", "데이터베이스 생성 실패", JOptionPane.INFORMATION_MESSAGE);
							window.frame.setVisible(false);
						
						}
						else
							window.frame.setVisible(false);
					}
					else if(database.login() == -1) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						System.out.println("접속오류상태");
						if(JOptionPane.showConfirmDialog(window.frame, "MySql에 로그인이 실패하였습니다. Mysql 계정과 비밀번호를 변경하시겠습니까?") == 0) {
							login.setVisible(true);
							window.frame.setVisible(false);
						}
						else
							window.frame.setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartGUI() {
		initialize();

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("메모리아");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Memoria");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		lblNewLabel.setBounds(148, 80, 195, 73);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
}
