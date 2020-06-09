package Memoria.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MainGUI {
	
	private JFrame frame;
	private JTextField textField_searchField;
	Calendar cal = Calendar.getInstance();

	JPanel panel_Calendar = new JPanel();
	
	JLabel[][] label_space = new JLabel[6][7];

	
	int calYear = cal.get(Calendar.YEAR); 			//오늘의 년도 설정
	int calMonth = cal.get(Calendar.MONTH)+1;			//오늘의 달 설정 (+1 해줘야함)
	int calDay = cal.get(Calendar.DAY_OF_MONTH);			// 오늘의 일 설정
	int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);			//오늘의 요일
	final int calLastDate[] = {31,28,31,30,31,30,31,31,30,31,30,31};			//0~11 (1~12) 월 의 마지막 일 
	
	
	
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
	
	public void setToday(){				// 오늘의 날짜 설정하는 메소드
		calYear = cal.get(Calendar.YEAR); 
		calMonth = cal.get(Calendar.MONTH)+1;
		calDay = cal.get(Calendar.DAY_OF_MONTH);
	}
	
	private int startDateOfMonth(Calendar cal) {		// 1일이 시작하는 위치 구하는 메소드
		
		int StartingPoint = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;	//캘린더의 특정 날짜가 무슨요일인지와 몇일인지만 알면 그 달의 시작 요일을 알 수 있다.
		
		return StartingPoint;			//0~6까지의 숫자로 일월화수목금토  순서로 시작 요일을 알려준다.
	}

	public void showCal() {			//캘린더를 표시해주는 메소드
		switch(startDateOfMonth(cal))			//시작요일을 구하는 메소드
		{
		case 0:							//시작 요일이 일요일일 경우
		{
			int i =1;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])			//해당하는 달의 최대 일까지 반복
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))			//'일' 의 값이 0 혹은 음수일경우 빈칸으로 변경
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		case 1:							//시작 요일이 월요일일 경우
		{
			int i =0;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
			
		case 2:							//시작 요일이 화요일일 경우
		{
			int i =-1;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		case 3:							//시작 요일이 수요일일 경우
		{
			int i =-2;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		case 4:							//시작 요일이 목요일일 경우
		{
			int i =-3;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		case 5:							//시작 요일이 금요일일 경우
		{
			int i =-4;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						i++;
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		case 6:							//시작 요일이 토요일일 경우
		{
			int i =-5;
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++) {
					if(i<= calLastDate[calMonth-1])
					{
						label_space[w][h].setText(i+"");
						if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))
						{
							label_space[w][h].setText("");
						}
					}	
				}
			}
			break;
		}
		
		
		

		
		}
		
		
	}
	
	public MainGUI() {
		initialize();
		showCal();
	}

	private void initialize() {
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
				
		Calendar time = Calendar.getInstance();
		       
		String format_time1 = format1.format(time.getTime());
		String format_time2 = format2.format(time.getTime());
		        
		System.out.println(format_time1);
		System.out.println(format_time2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1360, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel_Calendar.setBounds(231, 0, 1113, 610);
		frame.getContentPane().add(panel_Calendar);
		panel_Calendar.setLayout(null);
		
		JLabel label_Sunday = new JLabel("일");
		label_Sunday.setBorder(new LineBorder(Color.GRAY));
		label_Sunday.setForeground(Color.RED);
		label_Sunday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Sunday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Sunday.setBackground(SystemColor.activeCaption);
		label_Sunday.setBounds(0, 0, 159, 26);
		label_Sunday.setOpaque(true); 
		panel_Calendar.add(label_Sunday);
		
		JLabel label_Monday = new JLabel("\uC6D4");
		label_Monday.setOpaque(true);
		label_Monday.setBorder(new LineBorder(Color.GRAY));
		label_Monday.setBackground(SystemColor.activeCaption);
		label_Monday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Monday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Monday.setBounds(159, 0, 159, 26);
		panel_Calendar.add(label_Monday);
		
		JLabel label_Tuesday = new JLabel("\uD654");
		label_Tuesday.setOpaque(true);
		label_Tuesday.setBorder(new LineBorder(Color.GRAY));
		label_Tuesday.setBackground(SystemColor.activeCaption);
		label_Tuesday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Tuesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tuesday.setBounds(318, 0, 159, 26);
		panel_Calendar.add(label_Tuesday);
		
		JLabel label_Wednesday = new JLabel("\uC218");
		label_Wednesday.setOpaque(true);
		label_Wednesday.setBorder(new LineBorder(Color.GRAY));
		label_Wednesday.setBackground(SystemColor.activeCaption);
		label_Wednesday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Wednesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Wednesday.setBounds(477, 0, 159, 26);
		panel_Calendar.add(label_Wednesday);
		
		JLabel label_Thursday = new JLabel("\uBAA9");
		label_Thursday.setOpaque(true);
		label_Thursday.setBorder(new LineBorder(Color.GRAY));
		label_Thursday.setBackground(SystemColor.activeCaption);
		label_Thursday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Thursday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Thursday.setBounds(636, 0, 159, 26);
		panel_Calendar.add(label_Thursday);
		
		JLabel label_Friday = new JLabel("\uAE08");
		label_Friday.setOpaque(true);
		label_Friday.setBorder(new LineBorder(Color.GRAY));
		label_Friday.setBackground(SystemColor.activeCaption);
		label_Friday.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		label_Friday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Friday.setBounds(795, 0, 159, 26);
		panel_Calendar.add(label_Friday);
		
		JLabel lbld = new JLabel("토");
		lbld.setOpaque(true);
		lbld.setBorder(new LineBorder(Color.GRAY));
		lbld.setBackground(SystemColor.activeCaption);
		lbld.setForeground(SystemColor.textHighlight);
		lbld.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 17));
		lbld.setHorizontalAlignment(SwingConstants.CENTER);
		lbld.setBounds(954, 0, 159, 26);
		panel_Calendar.add(lbld);
		
		for (int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				label_space[i][j] = new JLabel("");			//맨위의 필드에서 생성해준 라벨들을 여기서 초기화 (안하면 에러뜸)
			}
		}
		
		label_space[0][0].setOpaque(true);
		label_space[0][0].setBorder(new LineBorder(Color.GRAY));
		label_space[0][0].setForeground(new Color(255, 51, 51));
		label_space[0][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][0].setBackground(new Color(255, 255, 255));
		label_space[0][0].setBounds(0, 26, 159, 97);
		panel_Calendar.add(label_space[0][0]);
		
		label_space[0][1].setOpaque(true);
		label_space[0][1].setBorder(new LineBorder(Color.GRAY));
		label_space[0][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][1].setBackground(Color.WHITE);
		label_space[0][1].setBounds(159, 26, 159, 97);
		panel_Calendar.add(label_space[0][1]);
		
		label_space[0][2].setOpaque(true);
		label_space[0][2].setBorder(new LineBorder(Color.GRAY));
		label_space[0][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][2].setBackground(Color.WHITE);
		label_space[0][2].setBounds(318, 26, 159, 97);
		panel_Calendar.add(label_space[0][2]);		

		label_space[0][3].setOpaque(true);
		label_space[0][3].setBorder(new LineBorder(Color.GRAY));
		label_space[0][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][3].setBackground(Color.WHITE);
		label_space[0][3].setBounds(477, 26, 159, 97);
		panel_Calendar.add(label_space[0][3]);

		label_space[0][4].setOpaque(true);
		label_space[0][4].setBorder(new LineBorder(Color.GRAY));
		label_space[0][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][4].setBackground(Color.WHITE);
		label_space[0][4].setBounds(636, 26, 159, 97);
		panel_Calendar.add(label_space[0][4]);

		label_space[0][5].setOpaque(true);
		label_space[0][5].setBorder(new LineBorder(Color.GRAY));
		label_space[0][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][5].setBackground(Color.WHITE);
		label_space[0][5].setBounds(795, 26, 159, 97);
		panel_Calendar.add(label_space[0][5]);

		label_space[0][6].setOpaque(true);
		label_space[0][6].setBorder(new LineBorder(Color.GRAY));
		label_space[0][6].setForeground(new Color(102, 102, 102));
		label_space[0][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[0][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[0][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[0][6].setBackground(Color.WHITE);
		label_space[0][6].setBounds(954, 26, 159, 97);
		panel_Calendar.add(label_space[0][6]);

		label_space[1][0].setOpaque(true);
		label_space[1][0].setBorder(new LineBorder(Color.GRAY));
		label_space[1][0].setForeground(new Color(255, 51, 51));
		label_space[1][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][0].setBackground(Color.WHITE);
		label_space[1][0].setBounds(0, 123, 159, 97);
		panel_Calendar.add(label_space[1][0]);

		label_space[1][1].setOpaque(true);
		label_space[1][1].setBorder(new LineBorder(Color.GRAY));
		label_space[1][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][1].setBackground(Color.WHITE);
		label_space[1][1].setBounds(159, 123, 159, 97);
		panel_Calendar.add(label_space[1][1]);

		label_space[1][2].setOpaque(true);
		label_space[1][2].setBorder(new LineBorder(Color.GRAY));
		label_space[1][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][2].setBackground(Color.WHITE);
		label_space[1][2].setBounds(318, 123, 159, 97);
		panel_Calendar.add(label_space[1][2]);

		label_space[1][3].setOpaque(true);
		label_space[1][3].setBorder(new LineBorder(Color.GRAY));
		label_space[1][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][3].setBackground(Color.WHITE);
		label_space[1][3].setBounds(477, 123, 159, 97);
		panel_Calendar.add(label_space[1][3]);

		label_space[1][4].setOpaque(true);
		label_space[1][4].setBorder(new LineBorder(Color.GRAY));
		label_space[1][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][4].setBackground(Color.WHITE);
		label_space[1][4].setBounds(636, 123, 159, 97);
		panel_Calendar.add(label_space[1][4]);
		

		label_space[1][5].setOpaque(true);
		label_space[1][5].setBorder(new LineBorder(Color.GRAY));
		label_space[1][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][5].setBackground(Color.WHITE);
		label_space[1][5].setBounds(795, 123, 159, 97);
		panel_Calendar.add(label_space[1][5]);

		label_space[1][6].setOpaque(true);
		label_space[1][6].setBorder(new LineBorder(Color.GRAY));
		label_space[1][6].setForeground(new Color(102, 102, 102));
		label_space[1][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[1][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[1][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[1][6].setBackground(Color.WHITE);
		label_space[1][6].setBounds(954, 123, 159, 97);
		panel_Calendar.add(label_space[1][6]);

		label_space[2][0].setOpaque(true);
		label_space[2][0].setBorder(new LineBorder(Color.GRAY));
		label_space[2][0].setForeground(new Color(255, 51, 51));
		label_space[2][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][0].setBackground(Color.WHITE);
		label_space[2][0].setBounds(0, 220, 159, 97);
		panel_Calendar.add(label_space[2][0]);

		label_space[2][1].setOpaque(true);
		label_space[2][1].setBorder(new LineBorder(Color.GRAY));
		label_space[2][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][1].setBackground(Color.WHITE);
		label_space[2][1].setBounds(159, 220, 159, 97);
		panel_Calendar.add(label_space[2][1]);

		label_space[2][2].setOpaque(true);
		label_space[2][2].setBorder(new LineBorder(Color.GRAY));
		label_space[2][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][2].setBackground(Color.WHITE);
		label_space[2][2].setBounds(318, 220, 159, 97);
		panel_Calendar.add(label_space[2][2]);

		label_space[2][3].setOpaque(true);
		label_space[2][3].setBorder(new LineBorder(Color.GRAY));
		label_space[2][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][3].setBackground(Color.WHITE);
		label_space[2][3].setBounds(477, 220, 159, 97);
		panel_Calendar.add(label_space[2][3]);

		label_space[2][4].setOpaque(true);
		label_space[2][4].setBorder(new LineBorder(Color.GRAY));
		label_space[2][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][4].setBackground(Color.WHITE);
		label_space[2][4].setBounds(636, 220, 159, 97);
		panel_Calendar.add(label_space[2][4]);

		label_space[2][5].setOpaque(true);
		label_space[2][5].setBorder(new LineBorder(Color.GRAY));
		label_space[2][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][5].setBackground(Color.WHITE);
		label_space[2][5].setBounds(795, 220, 159, 97);
		panel_Calendar.add(label_space[2][5]);
	

		label_space[2][6].setOpaque(true);
		label_space[2][6].setBorder(new LineBorder(Color.GRAY));
		label_space[2][6].setForeground(new Color(102, 102, 102));
		label_space[2][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[2][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[2][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[2][6].setBackground(Color.WHITE);
		label_space[2][6].setBounds(954, 220, 159, 97);
		panel_Calendar.add(label_space[2][6]);

		label_space[3][0].setOpaque(true);
		label_space[3][0].setBorder(new LineBorder(Color.GRAY));
		label_space[3][0].setForeground(new Color(255, 51, 51));
		label_space[3][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][0].setBackground(Color.WHITE);
		label_space[3][0].setBounds(0, 317, 159, 97);
		panel_Calendar.add(label_space[3][0]);

		label_space[3][1].setOpaque(true);
		label_space[3][1].setBorder(new LineBorder(Color.GRAY));
		label_space[3][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][1].setBackground(Color.WHITE);
		label_space[3][1].setBounds(159, 317, 159, 97);
		panel_Calendar.add(label_space[3][1]);

		label_space[3][2].setOpaque(true);
		label_space[3][2].setBorder(new LineBorder(Color.GRAY));
		label_space[3][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][2].setBackground(Color.WHITE);
		label_space[3][2].setBounds(318, 317, 159, 97);
		panel_Calendar.add(label_space[3][2]);

		label_space[3][3].setOpaque(true);
		label_space[3][3].setBorder(new LineBorder(Color.GRAY));
		label_space[3][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][3].setBackground(Color.WHITE);
		label_space[3][3].setBounds(477, 317, 159, 97);
		panel_Calendar.add(label_space[3][3]);

		label_space[3][4].setOpaque(true);
		label_space[3][4].setBorder(new LineBorder(Color.GRAY));
		label_space[3][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][4].setBackground(Color.WHITE);
		label_space[3][4].setBounds(636, 317, 159, 97);
		panel_Calendar.add(label_space[3][4]);

		label_space[3][5].setOpaque(true);
		label_space[3][5].setBorder(new LineBorder(Color.GRAY));
		label_space[3][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][5].setBackground(Color.WHITE);
		label_space[3][5].setBounds(795, 317, 159, 97);
		panel_Calendar.add(label_space[3][5]);

		label_space[3][6].setOpaque(true);
		label_space[3][6].setBorder(new LineBorder(Color.GRAY));
		label_space[3][6].setForeground(new Color(102, 102, 102));
		label_space[3][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[3][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[3][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[3][6].setBackground(Color.WHITE);
		label_space[3][6].setBounds(954, 317, 159, 97);
		panel_Calendar.add(label_space[3][6]);

		label_space[4][0].setOpaque(true);
		label_space[4][0].setBorder(new LineBorder(Color.GRAY));
		label_space[4][0].setForeground(new Color(255, 51, 51));
		label_space[4][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][0].setBackground(Color.WHITE);
		label_space[4][0].setBounds(0, 414, 159, 97);
		panel_Calendar.add(label_space[4][0]);

		label_space[4][1].setOpaque(true);
		label_space[4][1].setBorder(new LineBorder(Color.GRAY));
		label_space[4][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][1].setBackground(Color.WHITE);
		label_space[4][1].setBounds(159, 414, 159, 97);
		panel_Calendar.add(label_space[4][1]);

		label_space[4][2].setOpaque(true);
		label_space[4][2].setBorder(new LineBorder(Color.GRAY));
		label_space[4][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][2].setBackground(Color.WHITE);
		label_space[4][2].setBounds(318, 414, 159, 97);
		panel_Calendar.add(label_space[4][2]);

		label_space[4][3].setOpaque(true);
		label_space[4][3].setBorder(new LineBorder(Color.GRAY));
		label_space[4][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][3].setBackground(Color.WHITE);
		label_space[4][3].setBounds(477, 414, 159, 97);
		panel_Calendar.add(label_space[4][3]);

		label_space[4][4].setOpaque(true);
		label_space[4][4].setBorder(new LineBorder(Color.GRAY));
		label_space[4][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][4].setBackground(Color.WHITE);
		label_space[4][4].setBounds(636, 414, 159, 97);
		panel_Calendar.add(label_space[4][4]);

		label_space[4][5].setOpaque(true);
		label_space[4][5].setBorder(new LineBorder(Color.GRAY));
		label_space[4][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][5].setBackground(Color.WHITE);
		label_space[4][5].setBounds(795, 414, 159, 97);
		panel_Calendar.add(label_space[4][5]);

		label_space[4][6].setOpaque(true);
		label_space[4][6].setBorder(new LineBorder(Color.GRAY));
		label_space[4][6].setForeground(new Color(102, 102, 102));
		label_space[4][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[4][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[4][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[4][6].setBackground(Color.WHITE);
		label_space[4][6].setBounds(954, 414, 159, 97);
		panel_Calendar.add(label_space[4][6]);

		label_space[5][0].setOpaque(true);
		label_space[5][0].setBorder(new LineBorder(Color.GRAY));
		label_space[5][0].setForeground(new Color(255, 51, 51));
		label_space[5][0].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][0].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][0].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][0].setBackground(Color.WHITE);
		label_space[5][0].setBounds(0, 511, 159, 97);
		panel_Calendar.add(label_space[5][0]);

		label_space[5][1].setOpaque(true);
		label_space[5][1].setBorder(new LineBorder(Color.GRAY));
		label_space[5][1].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][1].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][1].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][1].setBackground(Color.WHITE);
		label_space[5][1].setBounds(159, 511, 159, 97);
		panel_Calendar.add(label_space[5][1]);

		label_space[5][2].setOpaque(true);
		label_space[5][2].setBorder(new LineBorder(Color.GRAY));
		label_space[5][2].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][2].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][2].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][2].setBackground(Color.WHITE);
		label_space[5][2].setBounds(318, 511, 159, 97);
		panel_Calendar.add(label_space[5][2]);

		label_space[5][3].setOpaque(true);
		label_space[5][3].setBorder(new LineBorder(Color.GRAY));
		label_space[5][3].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][3].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][3].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][3].setBackground(Color.WHITE);
		label_space[5][3].setBounds(477, 511, 159, 97);
		panel_Calendar.add(label_space[5][3]);

		label_space[5][4].setOpaque(true);
		label_space[5][4].setBorder(new LineBorder(Color.GRAY));
		label_space[5][4].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][4].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][4].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][4].setBackground(Color.WHITE);
		label_space[5][4].setBounds(636, 511, 159, 97);
		panel_Calendar.add(label_space[5][4]);

		label_space[5][5].setOpaque(true);
		label_space[5][5].setBorder(new LineBorder(Color.GRAY));
		label_space[5][5].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][5].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][5].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][5].setBackground(Color.WHITE);
		label_space[5][5].setBounds(795, 511, 159, 97);
		panel_Calendar.add(label_space[5][5]);

		label_space[5][6].setOpaque(true);
		label_space[5][6].setBorder(new LineBorder(Color.GRAY));
		label_space[5][6].setForeground(new Color(102, 102, 102));
		label_space[5][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][6].setBackground(Color.WHITE);
		label_space[5][6].setBounds(953, 521, 159, 97);
		panel_Calendar.add(label_space[5][6]);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(0, 0, 232, 610);
		frame.getContentPane().add(panel_Search);
		panel_Search.setLayout(null);
		
		textField_searchField = new JTextField();
		textField_searchField.setBorder(new LineBorder(Color.GRAY));
		textField_searchField.setBounds(0, 0, 231, 26);
		textField_searchField.setHorizontalAlignment(SwingConstants.CENTER);
		textField_searchField.setText("\uAC80\uC0C9..");
		textField_searchField.setToolTipText("");
		panel_Search.add(textField_searchField);
		textField_searchField.setColumns(10);
		
		JList list_searchlist = new JList();
		list_searchlist.setBorder(new LineBorder(Color.GRAY));
		list_searchlist.setBounds(0, 25, 231, 585);
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
		
		JLabel label_Month = new JLabel(calMonth+"월");
		label_Month.setHorizontalAlignment(SwingConstants.CENTER);
		label_Month.setBounds(655, 31, 85, 23);
		panel_South.add(label_Month);
		
		JLabel label_Year = new JLabel("2020");
		label_Year.setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 20));
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
