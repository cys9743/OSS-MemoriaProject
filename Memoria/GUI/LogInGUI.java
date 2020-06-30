package Memoria.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextField;
import javax.swing.JButton;

public class LogInGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField textField_1;
	private MyListener ml;
	
	private File file;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInGUI frame = new LogInGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInGUI() {
		JButton btnNewButton = new JButton("등록");
		
		try {				
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		// 이 코드부분 이후로 생성되는 컴포넌트 객체는 윈도우ui 처럼 형성됨.
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ml = new MyListener();
		file = new File("C:\\Memoria\\" , "log.txt"); 
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메모리아 Mysql 로그인");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(98, 10, 224, 32);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setToolTipText("\r\n");
		txtId.setBounds(176, 98, 146, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 128, 146, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mysql ID");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(95, 101, 69, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mysql P/W");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(95, 131, 69, 15);
		panel.add(lblNewLabel_2);
		
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(85, 107, 47));
		btnNewButton.setBounds(98, 173, 224, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(ml);
		
		setLocationRelativeTo(null);
	}
	
	class MyListener implements ActionListener {
		
		@Override
		
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String path = "C:\\Memoria"; //폴더 경로
			File folder = new File(path);

			// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			if (!folder.exists()) {
				try{
				    folder.mkdir(); //폴더 생성합니다.
			        } 
			        catch(Exception e){
				    e.getStackTrace();
				}
			}
			if(txtId.getText().equals("") || textField_1.getText().equals("")) {
				// 공백일때 (아이디와 비번칸
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 공백 없이 입력해 주세요.", "등록 오류", JOptionPane.WARNING_MESSAGE);
			}
			else {
				 try {
					    OutputStream output = new FileOutputStream(file);
					    String str =txtId.getText() +"\n" + textField_1.getText();
					    byte[] by=str.getBytes();
					    output.write(by);
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 적용되었습니다. 프로그램을 다시 실행시켜 주세요.", "등록 완료", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "알수없는 오류", "등록 오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
