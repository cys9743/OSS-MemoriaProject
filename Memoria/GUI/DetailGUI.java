package Memoria.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class DetailGUI {

	private JFrame frame;
	private JTextField textField_title;
	private JTextField textField_content;

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
	public DetailGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel label_path = new JLabel("C:\\ProgramFile\\test.txt");
		label_path.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_path.setBounds(22, 259, 244, 15);
		frame.getContentPane().add(label_path);
		
		JButton button_Add_File = new JButton("\uD30C\uC77C \uCD94\uAC00");
		button_Add_File.setFont(new Font("굴림", Font.BOLD, 12));
		button_Add_File.setBounds(283, 221, 92, 23);
		frame.getContentPane().add(button_Add_File);
		
		JButton button_delete_file = new JButton("\uD30C\uC77C \uC81C\uAC70");
		button_delete_file.setFont(new Font("굴림", Font.BOLD, 12));
		button_delete_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		comboBox_star.setBounds(283, 306, 156, 21);
		frame.getContentPane().add(comboBox_star);
		
		JComboBox comboBox_addContentYear = new JComboBox();
		comboBox_addContentYear.setBounds(12, 467, 57, 21);
		frame.getContentPane().add(comboBox_addContentYear);
		
		JComboBox comboBox_addContentMonth = new JComboBox();
		comboBox_addContentMonth.setBounds(112, 467, 57, 21);
		frame.getContentPane().add(comboBox_addContentMonth);
		
		JComboBox comboBox_addContentDay = new JComboBox();
		comboBox_addContentDay.setBounds(211, 467, 57, 21);
		frame.getContentPane().add(comboBox_addContentDay);
		
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
		
		JComboBox comboBox_deadLineDay = new JComboBox();
		comboBox_deadLineDay.setBounds(211, 523, 57, 21);
		frame.getContentPane().add(comboBox_deadLineDay);
		
		JLabel label_text_deadLineMonth = new JLabel("월");
		label_text_deadLineMonth.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_deadLineMonth.setBounds(181, 526, 19, 15);
		frame.getContentPane().add(label_text_deadLineMonth);
		
		JComboBox comboBox_deadLineMonth = new JComboBox();
		comboBox_deadLineMonth.setBounds(112, 523, 57, 21);
		frame.getContentPane().add(comboBox_deadLineMonth);
		
		JLabel label_text_deadLineYear = new JLabel("년");
		label_text_deadLineYear.setFont(new Font("새굴림", Font.PLAIN, 12));
		label_text_deadLineYear.setBounds(77, 527, 19, 15);
		frame.getContentPane().add(label_text_deadLineYear);
		
		JComboBox comboBox_deadLineYear = new JComboBox();
		comboBox_deadLineYear.setBounds(12, 523, 57, 21);
		frame.getContentPane().add(comboBox_deadLineYear);
		
		JLabel label_fileLine = new JLabel("");
		label_fileLine.setHorizontalAlignment(SwingConstants.CENTER);
		label_fileLine.setBorder(UIManager.getBorder("PasswordField.border"));
		label_fileLine.setBackground(Color.GREEN);
		label_fileLine.setBounds(12, 221, 257, 211);
		frame.getContentPane().add(label_fileLine);
	}
}
