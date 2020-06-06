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
		frame.setBounds(100, 100, 720, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_title = new JLabel("\uC81C\uBAA9");
		label_title.setFont(new Font("����", Font.BOLD, 12));
		label_title.setBounds(12, 10, 57, 15);
		frame.getContentPane().add(label_title);
		
		textField_title = new JTextField();
		textField_title.setBounds(12, 35, 680, 21);
		frame.getContentPane().add(textField_title);
		textField_title.setColumns(10);
		
		JLabel label_content = new JLabel("\uB0B4\uC6A9");
		label_content.setFont(new Font("����", Font.BOLD, 12));
		label_content.setBounds(12, 66, 57, 15);
		frame.getContentPane().add(label_content);
		
		textField_content = new JTextField();
		textField_content.setColumns(10);
		textField_content.setBounds(12, 91, 680, 120);
		frame.getContentPane().add(textField_content);
		
		JLabel label_text_path = new JLabel("\uAD00\uB828 \uD30C\uC77C \uACBD\uB85C");
		label_text_path.setFont(new Font("����", Font.BOLD, 12));
		label_text_path.setBounds(12, 242, 92, 15);
		frame.getContentPane().add(label_text_path);
		
		JLabel label_path = new JLabel("C:\\ProgramFile\\test.txt");
		label_path.setBounds(12, 267, 252, 15);
		frame.getContentPane().add(label_path);
		
		JButton button_Add_File = new JButton("\uD30C\uC77C \uCD94\uAC00");
		button_Add_File.setBounds(276, 242, 85, 23);
		frame.getContentPane().add(button_Add_File);
		
		JButton button_delete_file = new JButton("\uD30C\uC77C \uC81C\uAC70");
		button_delete_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_delete_file.setBounds(373, 242, 85, 23);
		frame.getContentPane().add(button_delete_file);
		
		JLabel label_text_fileKind = new JLabel("\uD30C\uC77C \uC885\uB958");
		label_text_fileKind.setFont(new Font("����", Font.BOLD, 12));
		label_text_fileKind.setBounds(12, 292, 92, 15);
		frame.getContentPane().add(label_text_fileKind);
		
		JLabel label_text_lastModify = new JLabel("\uD30C\uC77C \uB9C8\uC9C0\uB9C9 \uC218\uC815 \uB0A0\uC9DC");
		label_text_lastModify.setFont(new Font("����", Font.BOLD, 12));
		label_text_lastModify.setBounds(12, 392, 135, 15);
		frame.getContentPane().add(label_text_lastModify);
		
		JLabel label_text_star = new JLabel("\uC911\uC694\uB3C4");
		label_text_star.setFont(new Font("����", Font.BOLD, 12));
		label_text_star.setBounds(12, 442, 135, 15);
		frame.getContentPane().add(label_text_star);
		
		JLabel label_text_fileSize = new JLabel("\uD30C\uC77C\uD06C\uAE30");
		label_text_fileSize.setFont(new Font("����", Font.BOLD, 12));
		label_text_fileSize.setBounds(12, 342, 135, 15);
		frame.getContentPane().add(label_text_fileSize);
		
		JLabel label_fileKind = new JLabel(".txt");
		label_fileKind.setBounds(12, 317, 278, 15);
		frame.getContentPane().add(label_fileKind);
		
		JLabel label_fileSize = new JLabel("5 KB");
		label_fileSize.setBounds(12, 367, 278, 15);
		frame.getContentPane().add(label_fileSize);
		
		JLabel label_lastModify = new JLabel("2020\uB144 4\uC6D4 29\uC77C \uC624\uD6C4 01\uC2DC 35\uBD84");
		label_lastModify.setBounds(12, 417, 179, 15);
		frame.getContentPane().add(label_lastModify);
		
		JLabel label_star = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		label_star.setBounds(12, 467, 278, 15);
		frame.getContentPane().add(label_star);
		
		JLabel label_text_img = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		label_text_img.setFont(new Font("����", Font.BOLD, 12));
		label_text_img.setBounds(533, 246, 92, 15);
		frame.getContentPane().add(label_text_img);
		
		JLabel label_img = new JLabel("\uC774\uBBF8\uC9C0");
		label_img.setHorizontalAlignment(SwingConstants.CENTER);
		label_img.setBackground(new Color(0, 255, 0));
		label_img.setBounds(460, 275, 200, 200);
		frame.getContentPane().add(label_img);
		
		JButton button_apply = new JButton("\uC801\uC6A9");
		button_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_apply.setBounds(510, 498, 85, 23);
		frame.getContentPane().add(button_apply);
		
		JButton button_cancel = new JButton("\uCDE8\uC18C");
		button_cancel.setBounds(607, 498, 85, 23);
		frame.getContentPane().add(button_cancel);
	}
}
