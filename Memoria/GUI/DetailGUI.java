package Memoria.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

public class DetailGUI {

	private JFrame frame;
	private JTextField textField_title;
	private JTextField textField_content;
	private JLabel label_path;
	private JButton button_Add_File;
	private JButton button_delete_file;
	private JFileChooser chooser; 
	private int returnChoice;
	private JTextField textField_addContentYear;
	private JTextField textField_deadLineYear;
	private JTextField textField_addContentMonth;
	private JTextField textField_deadLineMonth;
	private JTextField textField_addContentDay;
	private JTextField textField_deadLineDay;
	private JOptionPane op = new JOptionPane();
	
	MyListener ml = new MyListener();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailGUI window = new DetailGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	
	
	void show() {
		frame.setVisible(true);
	}
	void close() {
		frame.dispose();
	}
	public DetailGUI() {
		initialize();
	}
	void setLocationText(String fileLocation) { // 파일 경로를 입력받아 경로를 표시하는 라벨의 텍스트를 변경하는 메소드
		label_path.setText(fileLocation);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 612);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_title = new JLabel("\uC81C\uBAA9");
		label_title.setFont(new Font("굴림", Font.BOLD, 12));
		label_title.setBounds(12, 10, 57, 15);
		frame.getContentPane().add(label_title);
		
		textField_title = new JTextField();
		textField_title.setBounds(12, 35, 680, 21);
		frame.getContentPane().add(textField_title);
		textField_title.setColumns(10);
		
		JLabel label_content = new JLabel("\uB0B4\uC6A9");
		label_content.setFont(new Font("굴림", Font.BOLD, 12));
		label_content.setBounds(12, 66, 57, 15);
		frame.getContentPane().add(label_content);
		
		textField_content = new JTextField();
		textField_content.setColumns(10);
		textField_content.setBounds(12, 91, 680, 120);
		frame.getContentPane().add(textField_content);
		
		JLabel label_text_path = new JLabel("\uAD00\uB828 \uD30C\uC77C \uACBD\uB85C");
		label_text_path.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_path.setBounds(22, 234, 92, 15);
		frame.getContentPane().add(label_text_path);
		
		label_path = new JLabel("C:\\ProgramFile\\test.txt");
		label_path.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_path.setBounds(22, 259, 244, 15);
		frame.getContentPane().add(label_path);
		
		button_Add_File = new JButton("\uD30C\uC77C \uCD94\uAC00");
		button_Add_File.setFont(new Font("굴림", Font.BOLD, 12));
		button_Add_File.setBounds(283, 221, 92, 23);
		frame.getContentPane().add(button_Add_File);
		button_Add_File.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 파일추가 버튼 리스너
				returnChoice = chooser.showOpenDialog(null); // 다이얼로그 오픈 
				
				if(returnChoice == chooser.APPROVE_OPTION) {
					frame.dispose();
					label_path.setText(chooser.getSelectedFile().toString());
					frame.setVisible(true);
				}
				else if(returnChoice == chooser.CANCEL_OPTION) {
					System.out.println("테스트 메시지 : 취소");
				}
			}
		});
		button_delete_file = new JButton("\uD30C\uC77C \uC81C\uAC70");
		button_delete_file.setFont(new Font("굴림", Font.BOLD, 12));
		button_delete_file.addActionListener(new ActionListener() { // 파일제거 버튼 리스너
			public void actionPerformed(ActionEvent e) {
				label_path.setText("비어 있음");
			}
		});
		button_delete_file.setBounds(387, 221, 92, 23);
		frame.getContentPane().add(button_delete_file);
		
		JLabel label_text_fileKind = new JLabel("\uD30C\uC77C \uC885\uB958");
		label_text_fileKind.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_fileKind.setBounds(22, 284, 92, 15);
		frame.getContentPane().add(label_text_fileKind);
		
		JLabel label_text_lastModify = new JLabel("\uD30C\uC77C \uB9C8\uC9C0\uB9C9 \uC218\uC815 \uB0A0\uC9DC");
		label_text_lastModify.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_lastModify.setBounds(22, 384, 135, 15);
		frame.getContentPane().add(label_text_lastModify);
		
		JLabel label_text_star = new JLabel("\uC911\uC694\uB3C4");
		label_text_star.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_star.setBounds(283, 284, 135, 15);
		frame.getContentPane().add(label_text_star);
		
		JLabel label_text_fileSize = new JLabel("\uD30C\uC77C\uD06C\uAE30");
		label_text_fileSize.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_fileSize.setBounds(22, 334, 135, 15);
		frame.getContentPane().add(label_text_fileSize);
		
		JLabel label_fileKind = new JLabel(".txt");
		label_fileKind.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_fileKind.setBounds(22, 309, 51, 15);
		frame.getContentPane().add(label_fileKind);
		
		JLabel label_fileSize = new JLabel("5 KB");
		label_fileSize.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_fileSize.setBounds(22, 359, 244, 15);
		frame.getContentPane().add(label_fileSize);
		
		JLabel label_lastModify = new JLabel("2020\uB144 4\uC6D4 29\uC77C \uC624\uD6C4 01\uC2DC 35\uBD84");
		label_lastModify.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_lastModify.setBounds(22, 409, 210, 15);
		frame.getContentPane().add(label_lastModify);
		
		JLabel label_text_img = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		label_text_img.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_img.setBounds(547, 225, 92, 15);
		frame.getContentPane().add(label_text_img);
		
		JLabel label_img = new JLabel("\uC774\uBBF8\uC9C0");
		label_img.setBorder(UIManager.getBorder("PasswordField.border"));
		label_img.setHorizontalAlignment(SwingConstants.CENTER);
		label_img.setBackground(new Color(0, 255, 0));
		label_img.setBounds(464, 275, 228, 233);
		frame.getContentPane().add(label_img);
		
		JButton button_apply = new JButton("확인");
		button_apply.setFont(new Font("굴림", Font.BOLD, 12));
		button_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_apply.setBounds(607, 540, 85, 23);
		frame.getContentPane().add(button_apply);
		
		JButton button_cancel = new JButton("\uCDE8\uC18C");
		button_cancel.setFont(new Font("굴림", Font.BOLD, 12));
		button_cancel.setBounds(510, 540, 85, 23);
		frame.getContentPane().add(button_cancel);
		
		JLabel label_text_addContent = new JLabel("컨텐츠 등록 날짜");
		label_text_addContent.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_addContent.setBounds(12, 442, 135, 15);
		frame.getContentPane().add(label_text_addContent);
		
		JLabel label_text_deadLine = new JLabel("알림 마감 날짜");
		label_text_deadLine.setFont(new Font("굴림", Font.BOLD, 12));
		label_text_deadLine.setBounds(12, 498, 135, 15);
		frame.getContentPane().add(label_text_deadLine);
		
		JComboBox comboBox_star = new JComboBox();
		comboBox_star.setModel(new DefaultComboBoxModel(new String[] {"(0)", "☆ (1)", "★ (2)", "★☆ (3)", "★★ (4)", "★★☆ (5)", "★★★ (6)", "★★★☆ (7)", "★★★★ (8)", "★★★★☆ (9)", "★★★★★ (10)"}));
		comboBox_star.setBounds(283, 306, 156, 21);
		frame.getContentPane().add(comboBox_star);
		
		JLabel label_text_addContentYear = new JLabel("년");
		label_text_addContentYear.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_addContentYear.setBounds(77, 471, 19, 15);
		frame.getContentPane().add(label_text_addContentYear);
		
		JLabel label_text_addContentMonth = new JLabel("월");
		label_text_addContentMonth.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_addContentMonth.setBounds(181, 470, 19, 15);
		frame.getContentPane().add(label_text_addContentMonth);
		
		JLabel label_text_addContentDay = new JLabel("일");
		label_text_addContentDay.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_addContentDay.setBounds(280, 470, 19, 15);
		frame.getContentPane().add(label_text_addContentDay);
		
		JLabel label_text_deadLineDay = new JLabel("일");
		label_text_deadLineDay.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_deadLineDay.setBounds(280, 526, 19, 15);
		frame.getContentPane().add(label_text_deadLineDay);
		
		JLabel label_text_deadLineMonth = new JLabel("월");
		label_text_deadLineMonth.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_deadLineMonth.setBounds(181, 526, 19, 15);
		frame.getContentPane().add(label_text_deadLineMonth);
		
		JLabel label_text_deadLineYear = new JLabel("년");
		label_text_deadLineYear.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_deadLineYear.setBounds(77, 527, 19, 15);
		frame.getContentPane().add(label_text_deadLineYear);
		
		JLabel label_fileLine = new JLabel("");
		label_fileLine.setHorizontalAlignment(SwingConstants.CENTER);
		label_fileLine.setBorder(UIManager.getBorder("PasswordField.border"));
		label_fileLine.setBackground(Color.GREEN);
		label_fileLine.setBounds(12, 221, 257, 211);
		frame.getContentPane().add(label_fileLine);
		
		textField_addContentYear = new JTextField();
		textField_addContentYear.setBounds(12, 467, 57, 21);
		frame.getContentPane().add(textField_addContentYear);
		textField_addContentYear.addKeyListener(ml);
		
		textField_deadLineYear = new JTextField();
		textField_deadLineYear.setColumns(10);
		textField_deadLineYear.setBounds(12, 523, 57, 21);
		frame.getContentPane().add(textField_deadLineYear);
		textField_deadLineYear.addKeyListener(ml);
		
		textField_addContentMonth = new JTextField();
		textField_addContentMonth.setColumns(10);
		textField_addContentMonth.setBounds(112, 467, 57, 21);
		frame.getContentPane().add(textField_addContentMonth);
		textField_addContentMonth.addKeyListener(ml);

		textField_deadLineMonth = new JTextField();
		textField_deadLineMonth.setColumns(10);
		textField_deadLineMonth.setBounds(112, 523, 57, 21);
		frame.getContentPane().add(textField_deadLineMonth);
		textField_deadLineMonth.addKeyListener(ml);

		textField_addContentDay = new JTextField();
		textField_addContentDay.setColumns(10);
		textField_addContentDay.setBounds(212, 468, 57, 21);
		frame.getContentPane().add(textField_addContentDay);
		textField_addContentDay.addKeyListener(ml);

		textField_deadLineDay = new JTextField();
		textField_deadLineDay.setColumns(10);
		textField_deadLineDay.setBounds(212, 520, 57, 21);
		frame.getContentPane().add(textField_deadLineDay);
		textField_deadLineDay.addKeyListener(ml);

		// 파일 다이얼로그 세팅
		chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setCurrentDirectory(new File("/")); // 현재 사용 디렉터리 지정
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setDialogTitle("메모리아 파일 열기");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 또는 디렉터리 여는 chooser
	}
	
	class MyListener implements KeyListener{			//모든 리스너 클래스
		// 파일 다이얼로그 관련 필드
		JFileChooser chooser; 
		int returnChoice;
		
		@Override
		public void keyPressed(KeyEvent e) {
	
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyChar() > '9' || e.getKeyChar() == '-' || e.getKeyChar() == ' ') {
				e.consume();
			}
			if (e.getComponent() == textField_deadLineYear && ((JTextField)e.getSource()).getText().length() >= 4){			//년도 입력 4글자 및 숫자로 제한
				e.consume();
			}
			if (e.getComponent() == textField_deadLineMonth && ((JTextField)e.getSource()).getText().length() >= 2){			//월 입력 2글자 및 숫자로 제한
				e.consume();
				int n = Integer.parseInt(((JTextField)e.getSource()).getText());
				if(n > 12) {
					((JTextField)e.getSource()).setText("12");
				}
			}
			if (e.getComponent() == textField_deadLineDay && ((JTextField)e.getSource()).getText().length() >= 2){			//일 입력 2글자 및 숫자로 제한
				e.consume();
				int n = Integer.parseInt(((JTextField)e.getSource()).getText());
				if(n > 31 || ((JTextField)e.getSource()).getText().length() >= 2) {
					((JTextField)e.getSource()).setText("31");
				}
			}
			
			if (e.getComponent() == textField_addContentYear && ((JTextField)e.getSource()).getText().length() >= 4){			//년도 입력 4글자 및 숫자로 제한
				e.consume();
			}
			if (e.getComponent() == textField_addContentMonth && ((JTextField)e.getSource()).getText().length() >= 2){			//월 입력 2글자 및 숫자로 제한
				e.consume();
				int n = Integer.parseInt(((JTextField)e.getSource()).getText());
				if(n > 12) {
					((JTextField)e.getSource()).setText("12");
				}
			}
			if (e.getComponent() == textField_addContentDay && ((JTextField)e.getSource()).getText().length() >= 2){			//일 입력 2글자 및 숫자로 제한
				e.consume();
				int n = Integer.parseInt(((JTextField)e.getSource()).getText());
				if(n > 31 || ((JTextField)e.getSource()).getText().length() >= 2) {
					((JTextField)e.getSource()).setText("31");
				}
			}
		}
	}
}
