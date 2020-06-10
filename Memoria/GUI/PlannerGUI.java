package Memoria.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
public class PlannerGUI {
	

	private JFrame frmMemoriaplanner;
	private String one;
	private String two;
	private JLabel first = new JLabel();
	private JLabel second = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannerGUI window = new PlannerGUI();
					window.frmMemoriaplanner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public PlannerGUI() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Calendar t=Calendar.getInstance();
		int year = t.get(Calendar.YEAR);
		int month = t.get(Calendar.MONTH)+1;
		int date = t.get(Calendar.DATE);
		int amPm = t.get(Calendar.AM_PM);
		int hour = t.get(Calendar.HOUR);
		int min = t.get(Calendar.MINUTE);
		int sec = t.get(Calendar.SECOND);
		int msec = t.get(Calendar.MILLISECOND);
		String ampm=amPm==Calendar.AM? "AM":"PM";
		int day = t.get(Calendar.DAY_OF_WEEK);
		String sday = null;
		switch(day) {
		case 1:
			sday="Sun";
			break;
		case 2:
		    sday="Mon";
		    break;
		case 3:
			sday="Tues";
			break;
		case 4:
			sday="Wednes";
		    break;
		case 5:
			sday="Thurs";
	        break;
		case 6:
			sday="Fri";
	        break;
		case 7:
			sday="Satur";
	        break;
		}
			try {
				Thread.sleep(100);
			} catch(Exception e) {}


		frmMemoriaplanner = new JFrame();
		frmMemoriaplanner.getContentPane().setBackground(Color.DARK_GRAY);
		frmMemoriaplanner.getContentPane().setForeground(Color.DARK_GRAY);
		frmMemoriaplanner.setForeground(Color.GRAY);
		frmMemoriaplanner.setFont(new Font("Edwardian Script ITC", Font.BOLD | Font.ITALIC, 12));
		frmMemoriaplanner.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\63376930-\uBB3C-\uD22C\uBA85-\uD55C-\uC0C1\uD488-\uC6D0\uD65C\uD55C-\uD328\uD134\uBE44 -.jpg"));
		frmMemoriaplanner.setType(Type.UTILITY);
		frmMemoriaplanner.setTitle("Memoria_Planner");
		frmMemoriaplanner.setBounds(100, 100, 400, 530);
		frmMemoriaplanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMemoriaplanner.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Daliy Plan");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(155, 10, 81, 23);
		frmMemoriaplanner.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC815\uB82C");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(269, 37, 35, 15);
		frmMemoriaplanner.getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uB0B4\uC6A9 ");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(8, 73, 368, 23);
		frmMemoriaplanner.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uC624\uD508\uC18C\uC2A4 \uD504\uB85C\uC81D\uD2B8 \uACFC\uC81C");
		chckbxNewCheckBox_1.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_1.setBounds(8, 98, 368, 23);
		frmMemoriaplanner.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_1.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_1_1.setBounds(8, 123, 368, 23);
		frmMemoriaplanner.getContentPane().add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_2.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_1_2.setBounds(8, 148, 368, 23);
		frmMemoriaplanner.getContentPane().add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_3.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_1_3.setBounds(8, 173, 368, 23);
		frmMemoriaplanner.getContentPane().add(chckbxNewCheckBox_1_3);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\uC911\uC694\uB3C4", "\uC774\uB984", "\uB4F1\uB85D\uC77C\uC790"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		list.setBounds(305, 34, 71, 19);
		frmMemoriaplanner.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setToolTipText("");
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBounds(42, 34, 71, 19);
		frmMemoriaplanner.getContentPane().add(list_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(8, 37, 35, 15);
		frmMemoriaplanner.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(237, 433, 139, 27);
		frmMemoriaplanner.getContentPane().add(lblNewLabel_2);
		second.setOpaque(true);
		second.setBackground(new Color(0,0,0,0));
		second.setBounds(85,170,300,50);
		second.setForeground(Color.black);
		first.setOpaque(true);
		first.setBackground(new Color(0,0,0,0));
		first.setBounds(60,120,320,50);
		first.setForeground(Color.black);
		one=(year+"."+month+"."+date+" "+sday+"day");
		two=(ampm+" "+hour+"시"+min+"분"+sec+"초");
		lblNewLabel_2.setText(one);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setText(two);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("HY그래픽M", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(267, 454, 105, 27);
		frmMemoriaplanner.getContentPane().add(lblNewLabel_2_1);
	}


}

