package Memoria.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame frame;
	private JTextField textField_searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1360, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_Calendar = new JPanel();
		panel_Calendar.setBounds(231, 0, 1113, 610);
		frame.getContentPane().add(panel_Calendar);
		panel_Calendar.setLayout(null);
		
		JLabel label_Sunday = new JLabel("\uC77C");
		label_Sunday.setForeground(Color.RED);
		label_Sunday.setFont(new Font("����", Font.BOLD, 17));
		label_Sunday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Sunday.setBackground(SystemColor.activeCaption);
		label_Sunday.setBounds(0, 0, 159, 26);
		label_Sunday.setOpaque(true); 
		panel_Calendar.add(label_Sunday);
		
		JLabel label_Monday = new JLabel("\uC6D4");
		label_Monday.setBackground(SystemColor.activeCaption);
		label_Monday.setFont(new Font("����", Font.BOLD, 17));
		label_Monday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Monday.setBounds(159, 0, 159, 26);
		panel_Calendar.add(label_Monday);
		
		JLabel label_Tuesday = new JLabel("\uD654");
		label_Tuesday.setBackground(SystemColor.activeCaption);
		label_Tuesday.setFont(new Font("����", Font.BOLD, 17));
		label_Tuesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tuesday.setBounds(318, 0, 159, 26);
		panel_Calendar.add(label_Tuesday);
		
		JLabel label_Wednesday = new JLabel("\uC218");
		label_Wednesday.setBackground(SystemColor.activeCaption);
		label_Wednesday.setFont(new Font("����", Font.BOLD, 17));
		label_Wednesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Wednesday.setBounds(477, 0, 159, 26);
		panel_Calendar.add(label_Wednesday);
		
		JLabel label_Thursday = new JLabel("\uBAA9");
		label_Thursday.setBackground(SystemColor.activeCaption);
		label_Thursday.setFont(new Font("����", Font.BOLD, 17));
		label_Thursday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Thursday.setBounds(636, 0, 159, 26);
		panel_Calendar.add(label_Thursday);
		
		JLabel label_Friday = new JLabel("\uAE08");
		label_Friday.setBackground(SystemColor.activeCaption);
		label_Friday.setFont(new Font("����", Font.BOLD, 17));
		label_Friday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Friday.setBounds(795, 0, 159, 26);
		panel_Calendar.add(label_Friday);
		
		JLabel label_Saturday = new JLabel("\uD1A0");
		label_Saturday.setBackground(SystemColor.activeCaption);
		label_Saturday.setForeground(SystemColor.textHighlight);
		label_Saturday.setFont(new Font("����", Font.BOLD, 17));
		label_Saturday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Saturday.setBounds(954, 0, 159, 26);
		panel_Calendar.add(label_Saturday);
		
		JLabel label_space_0_1 = new JLabel("n");
		label_space_0_1.setForeground(new Color(255, 51, 51));
		label_space_0_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_1.setBackground(new Color(255, 255, 255));
		label_space_0_1.setBounds(0, 26, 159, 97);
		panel_Calendar.add(label_space_0_1);
		
		JLabel label_space_0_2 = new JLabel("n");
		label_space_0_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_2.setBackground(Color.WHITE);
		label_space_0_2.setBounds(159, 26, 159, 97);
		panel_Calendar.add(label_space_0_2);
		
		JLabel label_space_0_3 = new JLabel("n");
		label_space_0_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_3.setBackground(Color.WHITE);
		label_space_0_3.setBounds(318, 26, 159, 97);
		panel_Calendar.add(label_space_0_3);
		
		JLabel label_space_0_4 = new JLabel("n");
		label_space_0_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_4.setBackground(Color.WHITE);
		label_space_0_4.setBounds(477, 26, 159, 97);
		panel_Calendar.add(label_space_0_4);
		
		JLabel label_space_0_5 = new JLabel("n");
		label_space_0_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_5.setBackground(Color.WHITE);
		label_space_0_5.setBounds(636, 26, 159, 97);
		panel_Calendar.add(label_space_0_5);
		
		JLabel label_space_0_6 = new JLabel("n");
		label_space_0_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_6.setBackground(Color.WHITE);
		label_space_0_6.setBounds(795, 26, 159, 97);
		panel_Calendar.add(label_space_0_6);
		
		JLabel label_space_0_7 = new JLabel("n");
		label_space_0_7.setForeground(new Color(102, 102, 102));
		label_space_0_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_0_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_0_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_0_7.setBackground(Color.WHITE);
		label_space_0_7.setBounds(954, 26, 159, 97);
		panel_Calendar.add(label_space_0_7);
		
		JLabel label_space_1_1 = new JLabel("n");
		label_space_1_1.setForeground(new Color(255, 51, 51));
		label_space_1_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_1.setBackground(Color.WHITE);
		label_space_1_1.setBounds(0, 123, 159, 97);
		panel_Calendar.add(label_space_1_1);
		
		JLabel label_space_1_2 = new JLabel("n");
		label_space_1_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_2.setBackground(Color.WHITE);
		label_space_1_2.setBounds(159, 123, 159, 97);
		panel_Calendar.add(label_space_1_2);
		
		JLabel label_space_1_3 = new JLabel("n");
		label_space_1_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_3.setBackground(Color.WHITE);
		label_space_1_3.setBounds(318, 123, 159, 97);
		panel_Calendar.add(label_space_1_3);
		
		JLabel label_space_1_4 = new JLabel("n");
		label_space_1_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_4.setBackground(Color.WHITE);
		label_space_1_4.setBounds(477, 123, 159, 97);
		panel_Calendar.add(label_space_1_4);
		
		JLabel label_space_1_5 = new JLabel("n");
		label_space_1_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_5.setBackground(Color.WHITE);
		label_space_1_5.setBounds(636, 123, 159, 97);
		panel_Calendar.add(label_space_1_5);
		
		JLabel label_space_1_6 = new JLabel("n");
		label_space_1_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_6.setBackground(Color.WHITE);
		label_space_1_6.setBounds(795, 123, 159, 97);
		panel_Calendar.add(label_space_1_6);
		
		JLabel label_space_1_7 = new JLabel("n");
		label_space_1_7.setForeground(new Color(102, 102, 102));
		label_space_1_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_1_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_1_7.setBackground(Color.WHITE);
		label_space_1_7.setBounds(954, 123, 159, 97);
		panel_Calendar.add(label_space_1_7);
		
		JLabel label_space_2_1 = new JLabel("n");
		label_space_2_1.setForeground(new Color(255, 51, 51));
		label_space_2_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_1.setBackground(Color.WHITE);
		label_space_2_1.setBounds(0, 220, 159, 97);
		panel_Calendar.add(label_space_2_1);
		
		JLabel label_space_2_2 = new JLabel("n");
		label_space_2_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_2.setBackground(Color.WHITE);
		label_space_2_2.setBounds(159, 220, 159, 97);
		panel_Calendar.add(label_space_2_2);
		
		JLabel label_space_2_3 = new JLabel("n");
		label_space_2_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_3.setBackground(Color.WHITE);
		label_space_2_3.setBounds(318, 220, 159, 97);
		panel_Calendar.add(label_space_2_3);
		
		JLabel label_space_2_4 = new JLabel("n");
		label_space_2_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_4.setBackground(Color.WHITE);
		label_space_2_4.setBounds(477, 220, 159, 97);
		panel_Calendar.add(label_space_2_4);
		
		JLabel label_space_2_5 = new JLabel("n");
		label_space_2_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_5.setBackground(Color.WHITE);
		label_space_2_5.setBounds(636, 220, 159, 97);
		panel_Calendar.add(label_space_2_5);
		
		JLabel label_space_2_6 = new JLabel("n");
		label_space_2_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_6.setBackground(Color.WHITE);
		label_space_2_6.setBounds(795, 220, 159, 97);
		panel_Calendar.add(label_space_2_6);
		
		JLabel label_space_2_7 = new JLabel("n");
		label_space_2_7.setForeground(new Color(102, 102, 102));
		label_space_2_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_2_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_2_7.setBackground(Color.WHITE);
		label_space_2_7.setBounds(954, 220, 159, 97);
		panel_Calendar.add(label_space_2_7);
		
		JLabel label_space_3_1 = new JLabel("n");
		label_space_3_1.setForeground(new Color(255, 51, 51));
		label_space_3_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_1.setBackground(Color.WHITE);
		label_space_3_1.setBounds(0, 317, 159, 97);
		panel_Calendar.add(label_space_3_1);
		
		JLabel label_space_3_2 = new JLabel("n");
		label_space_3_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_2.setBackground(Color.WHITE);
		label_space_3_2.setBounds(159, 317, 159, 97);
		panel_Calendar.add(label_space_3_2);
		
		JLabel label_space_3_3 = new JLabel("n");
		label_space_3_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_3.setBackground(Color.WHITE);
		label_space_3_3.setBounds(318, 317, 159, 97);
		panel_Calendar.add(label_space_3_3);
		
		JLabel label_space_3_4 = new JLabel("n");
		label_space_3_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_4.setBackground(Color.WHITE);
		label_space_3_4.setBounds(477, 317, 159, 97);
		panel_Calendar.add(label_space_3_4);
		
		JLabel label_space_3_5 = new JLabel("n");
		label_space_3_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_5.setBackground(Color.WHITE);
		label_space_3_5.setBounds(636, 317, 159, 97);
		panel_Calendar.add(label_space_3_5);
		
		JLabel label_space_3_6 = new JLabel("n");
		label_space_3_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_6.setBackground(Color.WHITE);
		label_space_3_6.setBounds(795, 317, 159, 97);
		panel_Calendar.add(label_space_3_6);
		
		JLabel label_space_3_7 = new JLabel("n");
		label_space_3_7.setForeground(new Color(102, 102, 102));
		label_space_3_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_3_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_3_7.setBackground(Color.WHITE);
		label_space_3_7.setBounds(954, 317, 159, 97);
		panel_Calendar.add(label_space_3_7);
		
		JLabel label_space_4_1 = new JLabel("n");
		label_space_4_1.setForeground(new Color(255, 51, 51));
		label_space_4_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_1.setBackground(Color.WHITE);
		label_space_4_1.setBounds(0, 414, 159, 97);
		panel_Calendar.add(label_space_4_1);
		
		JLabel label_space_4_2 = new JLabel("n");
		label_space_4_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_2.setBackground(Color.WHITE);
		label_space_4_2.setBounds(159, 414, 159, 97);
		panel_Calendar.add(label_space_4_2);
		
		JLabel label_space_4_3 = new JLabel("n");
		label_space_4_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_3.setBackground(Color.WHITE);
		label_space_4_3.setBounds(318, 414, 159, 97);
		panel_Calendar.add(label_space_4_3);
		
		JLabel label_space_4_4 = new JLabel("n");
		label_space_4_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_4.setBackground(Color.WHITE);
		label_space_4_4.setBounds(477, 414, 159, 97);
		panel_Calendar.add(label_space_4_4);
		
		JLabel label_space_4_5 = new JLabel("n");
		label_space_4_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_5.setBackground(Color.WHITE);
		label_space_4_5.setBounds(636, 414, 159, 97);
		panel_Calendar.add(label_space_4_5);
		
		JLabel label_space_4_6 = new JLabel("n");
		label_space_4_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_6.setBackground(Color.WHITE);
		label_space_4_6.setBounds(795, 414, 159, 97);
		panel_Calendar.add(label_space_4_6);
		
		JLabel label_space_4_7 = new JLabel("n");
		label_space_4_7.setForeground(new Color(102, 102, 102));
		label_space_4_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_4_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_4_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_4_7.setBackground(Color.WHITE);
		label_space_4_7.setBounds(954, 414, 159, 97);
		panel_Calendar.add(label_space_4_7);
		
		JLabel label_space_5_1 = new JLabel("n");
		label_space_5_1.setForeground(new Color(255, 51, 51));
		label_space_5_1.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_1.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_1.setBackground(Color.WHITE);
		label_space_5_1.setBounds(0, 511, 159, 97);
		panel_Calendar.add(label_space_5_1);
		
		JLabel label_space_5_2 = new JLabel("n");
		label_space_5_2.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_2.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_2.setBackground(Color.WHITE);
		label_space_5_2.setBounds(159, 511, 159, 97);
		panel_Calendar.add(label_space_5_2);
		
		JLabel label_space_5_3 = new JLabel("n");
		label_space_5_3.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_3.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_3.setBackground(Color.WHITE);
		label_space_5_3.setBounds(318, 511, 159, 97);
		panel_Calendar.add(label_space_5_3);
		
		JLabel label_space_5_4 = new JLabel("n");
		label_space_5_4.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_4.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_4.setBackground(Color.WHITE);
		label_space_5_4.setBounds(477, 511, 159, 97);
		panel_Calendar.add(label_space_5_4);
		
		JLabel label_space_5_5 = new JLabel("n");
		label_space_5_5.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_5.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_5.setBackground(Color.WHITE);
		label_space_5_5.setBounds(636, 511, 159, 97);
		panel_Calendar.add(label_space_5_5);
		
		JLabel label_space_5_6 = new JLabel("n");
		label_space_5_6.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_6.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_6.setBackground(Color.WHITE);
		label_space_5_6.setBounds(795, 511, 159, 97);
		panel_Calendar.add(label_space_5_6);
		
		JLabel label_space_5_7 = new JLabel("n");
		label_space_5_7.setForeground(new Color(102, 102, 102));
		label_space_5_7.setVerticalAlignment(SwingConstants.TOP);
		label_space_5_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_space_5_7.setFont(new Font("����", Font.PLAIN, 14));
		label_space_5_7.setBackground(Color.WHITE);
		label_space_5_7.setBounds(953, 521, 159, 97);
		panel_Calendar.add(label_space_5_7);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(0, 0, 232, 610);
		frame.getContentPane().add(panel_Search);
		panel_Search.setLayout(null);
		
		textField_searchField = new JTextField();
		textField_searchField.setBounds(0, 0, 232, 26);
		textField_searchField.setHorizontalAlignment(SwingConstants.CENTER);
		textField_searchField.setText("\uAC80\uC0C9..");
		textField_searchField.setToolTipText("");
		panel_Search.add(textField_searchField);
		textField_searchField.setColumns(10);
		
		JList list_searchlist = new JList();
		list_searchlist.setBounds(0, 25, 232, 585);
		panel_Search.add(list_searchlist);
		
		JScrollBar scrollBar_searchList = new JScrollBar();
		scrollBar_searchList.setBounds(215, 25, 17, 585);
		panel_Search.add(scrollBar_searchList);
		
		JPanel panel_South = new JPanel();
		panel_South.setBounds(0, 608, 1344, 100);
		frame.getContentPane().add(panel_South);
		panel_South.setLayout(null);
		
		JLabel label_filename = new JLabel("\uD30C\uC77C \uC774\uB984 :");
		label_filename.setBounds(12, 10, 307, 15);
		panel_South.add(label_filename);
		
		JLabel label_filetype = new JLabel("\uD30C\uC77C \uD615\uC2DD :");
		label_filetype.setBounds(12, 35, 307, 15);
		panel_South.add(label_filetype);
		
		JLabel label_filesize = new JLabel("\uD30C\uC77C \uD06C\uAE30 :");
		label_filesize.setBounds(12, 60, 307, 15);
		panel_South.add(label_filesize);
		
		JLabel label_Month = new JLabel("1\uC6D4");
		label_Month.setHorizontalAlignment(SwingConstants.CENTER);
		label_Month.setBounds(655, 31, 85, 23);
		panel_South.add(label_Month);
		
		JLabel label_Year = new JLabel("2020");
		label_Year.setFont(new Font("����", Font.PLAIN, 20));
		label_Year.setHorizontalAlignment(SwingConstants.CENTER);
		label_Year.setBounds(671, 10, 57, 25);
		panel_South.add(label_Year);
		
		JButton btn_Backward = new JButton("\uB4A4");
		btn_Backward.setBounds(574, 20, 51, 44);
		panel_South.add(btn_Backward);
		
		JButton btn_Forward = new JButton("\uC55E");
		btn_Forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Forward.setBounds(768, 20, 45, 44);
		panel_South.add(btn_Forward);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C(F)");
		menuBar.add(mnNewMenu);
		
		JMenuItem Filemenu_MenuItem = new JMenuItem("\uB4F1\uB85D(N)");
		mnNewMenu.add(Filemenu_MenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\uC124\uC815(S)");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC0C9\uC0C1\uC124\uC815(C)");
		mnNewMenu_1.add(mntmNewMenuItem_1);
	}
}
