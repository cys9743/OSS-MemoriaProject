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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.Date;
public class PlannerGUI  {
	

	private JFrame frame;
	private String one;
	private String two;
	private JLabel first = new JLabel();
	private JLabel second = new JLabel();
	private JLabel[] label_contents;
	private Calendar cal;
	private final JPanel panel_main = new JPanel();
	private MyListener ml;
	private Database database;
	private DetailGUI detailGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannerGUI window = new PlannerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setContents(int index, String title, Color color){		
		System.out.println("index" + index + "title" + title);
		
		label_contents[index].setText(title);
		label_contents[index].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_contents[index].setOpaque(true);
		label_contents[index].setBackground(color);
		label_contents[index].setBounds(8, 70 + index * 35, 408, 25);
		label_contents[index].addMouseListener(ml);
		panel_main.add(label_contents[index]);
		
	}
	public void show() {
		frame.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	public PlannerGUI() {
		
		
		cal = Calendar.getInstance();
		database = new Database();
		detailGUI = new DetailGUI();
		label_contents = new JLabel[15];
		ml = new MyListener();
		for(int i = 0 ; i < label_contents.length; i ++) {
			label_contents[i] = new JLabel();
		}
		
		initialize();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int amPm = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int msec = cal.get(Calendar.MILLISECOND);
		String ampm=amPm==Calendar.AM? "AM":"PM";
		int day = cal.get(Calendar.DAY_OF_WEEK);
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

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setForeground(Color.GRAY);
		frame.setFont(new Font("Edwardian Script ITC", Font.BOLD | Font.ITALIC, 12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\63376930-\uBB3C-\uD22C\uBA85-\uD55C-\uC0C1\uD488-\uC6D0\uD65C\uD55C-\uD328\uD134\uBE44 -.jpg"));
		frame.setType(Type.UTILITY);
		frame.setTitle("Memoria_Planner");
		frame.setBounds(100, 100, 439, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_main);
		
		JLabel label_title = new JLabel("Daliy Plan");
		label_title.setForeground(Color.WHITE);
		label_title.setBackground(Color.WHITE);
		label_title.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		label_title.setBounds(152, 10, 105, 23);
		panel_main.add(label_title);
		
		JLabel label_sortBy = new JLabel("\uC815\uB82C");
		label_sortBy.setForeground(Color.WHITE);
		label_sortBy.setBounds(312, 37, 35, 15);
	
		panel_main.add(label_sortBy);
		
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
		list.setBounds(345, 34, 71, 19);
		panel_main.add(list);
		
		JLabel label_date = new JLabel(Integer.toString(cal.YEAR) + "." + Integer.toString(cal.MONTH) + " . " + Integer.toString(cal.DATE));
		label_date.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_date.setForeground(Color.WHITE);
		label_date.setBounds(174, 31, 71, 27);
		panel_main.add(label_date);
		second.setOpaque(true);
		second.setBackground(new Color(0,0,0,0));
		second.setBounds(85,170,300,50);
		second.setForeground(Color.black);
		first.setOpaque(true);
		first.setBackground(new Color(0,0,0,0));
		first.setBounds(60,120,320,50);
		first.setForeground(Color.black);
		one=(year+"."+month+"."+date);
		two=(ampm+ " " + hour + " : " + min + " : "+sec);
		label_date.setText("2020.6.29");
		
		JLabel label_time = new JLabel();
		label_time.setText(two);
		label_time.setForeground(Color.WHITE);
		label_time.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_time.setBounds(8, 40, 105, 27);
		panel_main.add(label_time);
		panel_main.setBackground(SystemColor.inactiveCaption);
		panel_main.setBounds(0, 0, 423, 561);
		panel_main.setLayout(null);
		
	}
	class MyListener extends MouseAdapter {
		JLabel label_event;
		public void mouseReleased(MouseEvent e) {
			if(e.getSource().getClass().equals(JLabel.class)) {
				
				label_event = (JLabel)e.getSource();
				database.getSeletedContentsInfo(label_event.getText());
				
				detailGUI.setComponents(database.getSeletedContentsInfo(label_event.getText()));
				System.out.println("테스트");
				detailGUI.show();
				
			}
		}
	}
}

