package Memoria.GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JCheckBox;

public class ContentsGUI {

	private JFrame frame;
	private JTextField textField_title;
	private JTextField textField_content;
	private JLabel label_path;
	private JLabel label_fileSize;
	private JLabel label_lastModify;
	private JLabel label_fileKind;
	private JButton button_open_filePath;
	private JButton button_cancel;
	private JFileChooser chooser; 
	private int returnChoice;
	private JTextField textField_addContentYear;
	private JTextField textField_deadLineYear;
	private JTextField textField_addContentMonth;
	private JTextField textField_deadLineMonth;
	private JTextField textField_addContentDay;
	private JTextField textField_deadLineDay;
	private JComboBox comboBox_star;
	private JOptionPane op_askRegisterContents;
	
	
	Database database;
	Contents contents;
	MyListener ml;
	MainGUI mainGUI;
	
	int selectYear;
	int selectMonth;
	int selectDayOfMonth;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentsGUI window = new ContentsGUI();
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
	
	void firstOpen() {
		textField_addContentYear.setText(selectYear+"");
		textField_addContentMonth.setText(selectMonth+"");
		textField_addContentDay.setText(selectDayOfMonth+"");
	}
	
	void show() {
		frame.setVisible(true);
	}
	void close() {
		frame.dispose();
	}
	public ContentsGUI() {
		initialize();
	}
	void setLocationText(String fileLocation) { // 파일 경로를 입력받아 경로를 표시하는 라벨의 텍스트를 변경하는 메소드
		label_path.setText(fileLocation);
	}
	Contents getContents(){			//콘텐츠 클래스를 반환하는 메소드
		return contents;
	}
	
	public void setComponents(ResultSet resultSet) {
			try {
				resultSet.next();
				textField_title.setText(resultSet.getString("TITLE"));
				textField_content.setText(resultSet.getString("TEXT"));
				comboBox_star.setSelectedIndex(Integer.parseInt(resultSet.getString("PRIORITY")) - 1);
				
				textField_addContentYear.setText(resultSet.getString("R_DATE").substring(0, 4));
				textField_addContentMonth.setText(resultSet.getString("R_DATE").substring(4, 6));
				textField_addContentDay.setText(resultSet.getString("R_DATE").substring(6, 8));
				
				textField_deadLineYear.setText(resultSet.getString("L_DATE").substring(0, 4));
				textField_deadLineMonth.setText(resultSet.getString("L_DATE").substring(4, 6));
				textField_deadLineDay.setText(resultSet.getString("L_DATE").substring(6, 8));
				
				setFileInfo(resultSet.getString("F_LINK"));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	boolean getVisible() {
		return this.frame.isVisible();
	}
	
	public void setFileInfo(String filepath) {
		System.out.println(filepath);
		int index;
		File myfile;
		String extension;
		SimpleDateFormat simpleDateFormat;
		Date lastmodifiedDate;

		String fileP = filepath.replaceFirst(":", ":/");
		label_path.setText(fileP);
		//확장자 라벨 설정
		index = filepath.lastIndexOf(".");
		extension = filepath.substring(index + 1);
		label_fileKind.setText(extension);
		//파일 크기 설정
		myfile = new File(filepath);
		label_fileSize.setText(Long.toString(myfile.length()) + " Bytes");
		//파일 수정 날짜 설정
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
		lastmodifiedDate = new Date(myfile.lastModified());
		simpleDateFormat.format(lastmodifiedDate);
		label_lastModify.setText(simpleDateFormat.format(lastmodifiedDate));
	
	}
	
	
	void InitComponents() {
		textField_title.setText("");
		textField_content.setText("");
		textField_addContentYear.setText("");
		textField_addContentMonth.setText("");
		textField_addContentDay.setText("");	
		textField_deadLineYear.setText("");
		textField_deadLineMonth.setText("");
		textField_deadLineDay.setText("");
		label_path.setText("비어있음");
		label_fileSize.setText("");
		label_fileKind.setText("");
		label_lastModify.setText("");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		button_open_filePath = new JButton("파일 열기");
		button_cancel = new JButton("취소");
		
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

		// 객체 생성
		ml = new MyListener();
		contents = new Contents();
		database = new Database();
				
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.setBounds(100, 100, 721, 612);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_title = new JLabel("\uC81C\uBAA9");
		label_title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_title.setBounds(12, 10, 57, 15);
		frame.getContentPane().add(label_title);
		
		
		textField_title = new JTextField();
		textField_title.setBackground(Color.WHITE);
		textField_title.setEditable(false);
		textField_title.setBounds(12, 35, 680, 21);
		frame.getContentPane().add(textField_title);
		textField_title.setColumns(10);
		
		JLabel label_content = new JLabel("\uB0B4\uC6A9");
		label_content.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_content.setBounds(12, 66, 57, 15);
		frame.getContentPane().add(label_content);
		
		textField_content = new JTextField();
		textField_content.setBackground(Color.WHITE);
		textField_content.setEditable(false);
		textField_content.setColumns(10);
		textField_content.setBounds(12, 91, 680, 120);
		frame.getContentPane().add(textField_content);
		
		JLabel label_text_path = new JLabel("\uAD00\uB828 \uD30C\uC77C \uACBD\uB85C");
		label_text_path.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_text_path.setBounds(22, 234, 103, 15);
		frame.getContentPane().add(label_text_path);
		
		label_path = new JLabel("비어있음");
		label_path.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_path.setBounds(22, 259, 244, 15);
		frame.getContentPane().add(label_path);
		
		
		button_open_filePath.setForeground(Color.WHITE);
		button_open_filePath.setBackground(new Color(85, 107, 4));
		button_open_filePath.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		button_open_filePath.setBounds(283, 221, 103, 23);
		frame.getContentPane().add(button_open_filePath);
		button_open_filePath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Desktop.getDesktop().open(new File(label_path.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		JLabel label_text_fileKind = new JLabel("\uD30C\uC77C \uC885\uB958");
		label_text_fileKind.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_text_fileKind.setBounds(22, 284, 92, 15);
		frame.getContentPane().add(label_text_fileKind);
		
		JLabel label_text_lastModify = new JLabel("\uD30C\uC77C \uB9C8\uC9C0\uB9C9 \uC218\uC815 \uB0A0\uC9DC");
		label_text_lastModify.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_text_lastModify.setBounds(22, 384, 156, 15);
		frame.getContentPane().add(label_text_lastModify);
		
		JLabel label_text_star = new JLabel("\uC911\uC694\uB3C4");
		label_text_star.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_text_star.setBounds(283, 284, 135, 15);
		frame.getContentPane().add(label_text_star);
		
		JLabel label_text_fileSize = new JLabel("\uD30C\uC77C\uD06C\uAE30");
		label_text_fileSize.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_text_fileSize.setBounds(22, 334, 135, 15);
		frame.getContentPane().add(label_text_fileSize);
		
		label_fileKind = new JLabel("");
		label_fileKind.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_fileKind.setBounds(22, 309, 51, 15);
		frame.getContentPane().add(label_fileKind);
		
		label_fileSize = new JLabel("");
		label_fileSize.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_fileSize.setBounds(22, 359, 244, 15);
		frame.getContentPane().add(label_fileSize);
		
		label_lastModify = new JLabel("");
		label_lastModify.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_lastModify.setBounds(22, 409, 210, 15);
		frame.getContentPane().add(label_lastModify);
		button_cancel.setForeground(Color.WHITE);
		button_cancel.setBackground(new Color(85, 107, 4));
		

		button_cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		button_cancel.setBounds(607, 540, 85, 23);
		button_cancel.addActionListener(ml);
		frame.getContentPane().add(button_cancel);
		
		JLabel label_text_addContent = new JLabel("컨텐츠 등록 날짜");
		label_text_addContent.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_text_addContent.setBounds(12, 442, 135, 15);
		frame.getContentPane().add(label_text_addContent);
		
		JLabel label_text_deadLine = new JLabel("알림 마감 날짜");
		label_text_deadLine.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_text_deadLine.setBounds(12, 498, 135, 15);
		frame.getContentPane().add(label_text_deadLine);
		
		comboBox_star = new JComboBox();
		comboBox_star.setEnabled(false);
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
		textField_addContentYear.setEditable(false);
		textField_addContentYear.setBounds(12, 467, 57, 21);
		frame.getContentPane().add(textField_addContentYear);
		
		textField_deadLineYear = new JTextField();
		textField_deadLineYear.setEditable(false);
		textField_deadLineYear.setColumns(10);
		textField_deadLineYear.setBounds(12, 523, 57, 21);
		frame.getContentPane().add(textField_deadLineYear);
		
		textField_addContentMonth = new JTextField();
		textField_addContentMonth.setEditable(false);
		textField_addContentMonth.setColumns(10);
		textField_addContentMonth.setBounds(112, 467, 57, 21);
		frame.getContentPane().add(textField_addContentMonth);

		textField_deadLineMonth = new JTextField();
		textField_deadLineMonth.setEditable(false);
		textField_deadLineMonth.setColumns(10);
		textField_deadLineMonth.setBounds(112, 523, 57, 21);
		frame.getContentPane().add(textField_deadLineMonth);

		textField_addContentDay = new JTextField();
		textField_addContentDay.setEditable(false);
		textField_addContentDay.setColumns(10);
		textField_addContentDay.setBounds(212, 468, 57, 21);
		frame.getContentPane().add(textField_addContentDay);

		textField_deadLineDay = new JTextField();
		textField_deadLineDay.setEditable(false);
		textField_deadLineDay.setColumns(10);
		textField_deadLineDay.setBounds(212, 520, 57, 21);
		frame.getContentPane().add(textField_deadLineDay);
		
		// 옵션 펜
		op_askRegisterContents = new JOptionPane();
		op_askRegisterContents.setBackground(Color.white);
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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

	}
	class Contents{ 		//콘텐츠의 내용을 담는 클래스
		private String title;
		private String text;
		private int priority;
		private String registerDate;
		private String lastDate;
		private String fileLink;
		
		public void setContents(){ 			// DetailGUI의 컴포넌트에서 값을 파싱하는 메소드 
			this.title = textField_title.getText();
			this.text = textField_content.getText();
			this.priority = comboBox_star.getItemCount()-1;
			this.registerDate = textField_addContentYear.getText()+textField_addContentMonth.getText()+textField_addContentDay.getText();	
			this.lastDate = textField_deadLineYear.getText()+textField_deadLineMonth.getText()+textField_deadLineDay.getText();
			this.fileLink = label_path.getText();
		}
		
		public String getTitle() {
			return title;
		}
		public String getText() {
			return text;
		}
		public int getPriority() {
			return priority;
		}
		public String getRegisterDate() {
			return registerDate;
		}
		public String getLastDate() {
			return lastDate;
		}
		public String getFileLink() {
			return fileLink;
		}
		
	}

	
	class MyListener extends MouseAdapter implements KeyListener, ActionListener{			//모든 리스너 클래스
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
		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(button_cancel)) {		//취소버튼 누를경우
				frame.dispose();
			}
		}
		
		
		public void mouseCliked(MouseEvent e) {
		
		}
	}
}
