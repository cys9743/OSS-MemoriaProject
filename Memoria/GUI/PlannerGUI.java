package Memoria.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class PlannerGUI {

	private JFrame frmMemoriaplanner;

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
		frmMemoriaplanner = new JFrame();
		frmMemoriaplanner.getContentPane().setBackground(Color.DARK_GRAY);
		frmMemoriaplanner.getContentPane().setForeground(Color.DARK_GRAY);
		frmMemoriaplanner.setForeground(Color.GRAY);
		frmMemoriaplanner.setFont(new Font("Edwardian Script ITC", Font.BOLD | Font.ITALIC, 12));
		frmMemoriaplanner.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\63376930-\uBB3C-\uD22C\uBA85-\uD55C-\uC0C1\uD488-\uC6D0\uD65C\uD55C-\uD328\uD134\uBE44 -.jpg"));
		frmMemoriaplanner.setType(Type.UTILITY);
		frmMemoriaplanner.setTitle("Memoria_Planner");
		frmMemoriaplanner.setBounds(100, 100, 400, 530);
		frmMemoriaplanner.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMemoriaplanner.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Daliy Plan");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(155, 10, 81, 23);
		frmMemoriaplanner.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC815\uB82C");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(269, 37, 24, 15);
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
	}
}
