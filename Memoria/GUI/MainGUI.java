package Memoria.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

public class MainGUI {
	
	private JFrame frame;
	private JTextField textField_searchField;
	
	Calendar cal = Calendar.getInstance();

	JPanel panel_Calendar = new JPanel();
	
	JLabel[][] label_space = new JLabel[6][7];
	private JLabel[] label_contentsTitle = new JLabel[100]; // 캘린더에 표시될 콘텐츠 라벨의 최대개수
	
	MyListener ml = new MyListener();
	MyContentsListener cl = new MyContentsListener();
	KeyListener kl = new KeyListener();
	
	DetailGUI detailGUI;
	
	Font f1 = new Font("HY헤드라인M",Font.PLAIN, 13);		//캘린더 날짜 (숫자) 폰트
	
	int calYear; 			//표시할 년도 설정
	int calMonth;			//표시할 달 설정 (+1 해줘야함)
	int calDay;			//표시할 일 설정
	int calDayOfWeek;			//표시할 요일
	final int calLastDate[] = {31,28,31,30,31,30,31,31,30,31,30,31};			//0~11 (1~12) 월 의 마지막 일 
	
	int todayYear = cal.get(Calendar.YEAR);
	int todayMonth = cal.get(Calendar.MONTH)+1;
	int todayDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	int todayDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	JButton btn_today = new JButton("Today");
	
	JButton btn_Backward = new JButton(cal.get(Calendar.MONTH)+"월");	
	JButton btn_Forward = new JButton((cal.get(Calendar.MONTH)+1+1)+"월");
	JLabel label_Month = new JLabel((cal.get(Calendar.MONTH)+1)+"월");
	
	JMenuItem mntmNewMenuItem_open;
	JMenuItem mntmNewMenuItem_register2;
	JMenuItem mntmNewMenuItem_fix;
	JMenuItem mntmNewMenuItem_remove;
	
	JPopupMenu popupMenuLabel = new JPopupMenu();
	JPopupMenu popupMenuComponents = new JPopupMenu();
	
	JLabel label_Year = new JLabel("2020");
	JList list_searchlist = new JList();
	JMenuItem mntm_clear = new JMenuItem("모든 컨탠츠 초기화(A)");
	DefaultListModel listModel = new DefaultListModel();
	Database database;				// 데이터베이스
	String tempTitle;		// 사용자가 클릭한 컨텐츠의 이름을 임시저장하는 변수

	public static void main(String[] args) {			//////메인 메소드
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
					if(window.detailGUI.getVisible()) {
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	public void setContentsToCalendar(String title, int index, int h){   	// 켈린더 라벨에 콘텐츠 라벨을 부착하는 메소드
			int location = label_space[h/7][h%7].getComponentCount() * 25;
            if(label_space[h/7][h%7].getText() != "" && label_space[h/7][h%7].getComponentCount() < 3) {         //만약 캘린더에 라벨에 숫자가 표시되어있지 않으면 실행안함
            System.out.println(label_space[h/7][h%7].getComponentCount());
			label_contentsTitle[index] = new JLabel(title);
            label_contentsTitle[index].setBounds(10,10 + location, 135, 17);
			label_contentsTitle[index].setOpaque(true);
			label_space[h/7][h%7].add(label_contentsTitle[index]);
			label_contentsTitle[index].addMouseListener(ml);

			}
	}
	public int installContents(ResultSet resultSet) {		// 이번달에 표시할 수 있는 컨텐츠들을 가져와서 주기에 따라 캘린더에 컨텐츠를 표시하는 메소드
		int labelIndex = 0;
		int r_date = 0;
		int l_date = 0;
		int extraDate = 0;
		int resultDay = 0;
		String todaydate = "";
		int w = 0;
		int h = -1;
		int cnt = 0;
		String title = "";
		
		try {
			while(resultSet.next()) {	
				cnt = 0;
				extraDate = 0;
				title = resultSet.getString("TITLE");
				r_date = Integer.valueOf(resultSet.getString("R_DATE"));
				l_date = Integer.valueOf(resultSet.getString("L_DATE"));
				
				if(calMonth <= 10)								
					todaydate = String.valueOf(todayYear) + "0" + String.valueOf(calMonth);
				else
					todaydate = todaydate = String.valueOf(todayYear) + String.valueOf(calMonth);
				
					for (int i = calMonth ; i > Integer.valueOf(String.valueOf(r_date).substring(4, 6)); i--) {   // 만약 불러온 컨텐츠의 등록날짜가 지난 달에 속한다면 그 날짜와의 차이를 구한다.
						extraDate += (100 - calLastDate[i]);	// 여기서의 extraDate는 등록된 컨텐츠의 등록된 시점부터 해당하는 달의 마지막 날짜를 각각 100에서 빼서 더한 값이다.
					}
					resultDay = (r_date - ((Integer.valueOf(todaydate) * 100 - extraDate)) - 1);  // resultDay = 콘텐츠에 등록일수와 이번달 1일의 차이값 
					extraDate = (l_date - Integer.valueOf(todaydate) * 100); // 여기서의 extraDate는 이번달의 등록된 콘텐츠에 대한 마감일 D-day이다.
	
					while( resultDay <= calLastDate[calMonth] && extraDate > 0 ) {			// 이번달의 마지막 날 까지 resultDay를 증가시킨다.
						cnt++;
						if(resultDay >= 0 ) {
							h = startDateOfMonth(cal) + resultDay;			//이번 달의 시작일과 resultDay를 더해서 GUI에 표시할 콘텐츠의 등록일을 구한다.
							if(cnt == 1 || cnt == 8 || cnt == 16 || (cnt % 30) == 0 && resultDay != 0) { 	// 콘텐츠 등록날로부터 기억 주기 (당일, 7일 후, 8일 후, 이후 30일 지날때마다 쭉..)가 되면
                                if(label_space[h/7][h%7].getComponentCount() < 3) {
                                    setContentsToCalendar(title, labelIndex, h);              // 컨텐츠 라벨을 캘린더 라벨에 배치하는 메소드
                                    if(cnt == 1) { 		// 라벨이 처음 표기된 경우
                                    	System.out.println("색깔 레드");
                                        label_contentsTitle[labelIndex].setBackground(Color.RED);
                                    }
                                    else if((extraDate - resultDay) < 0) // 마지막으로 표기된 라벨이 마지막이 되었을 경우
                                        label_contentsTitle[labelIndex].setBackground(Color.BLUE);
                                    else // 등록일과 마감일 사이의 경우
                                    {
                                        if(label_contentsTitle[labelIndex] != null)
                                        label_contentsTitle[labelIndex].setBackground(Color.GRAY);
                                    }
                                }
                                else if(label_space[h/7][h%7].getComponentCount() == 3){            // 부착할 라벨이 이미 3개의 컴포넌트를 갖고 있는 경우 (더보기)라벨을 부착 
                                        label_contentsTitle[labelIndex] = new JLabel("더보기");
                                        label_contentsTitle[labelIndex].setBounds(2, 80, 155, 15);
                                        label_contentsTitle[labelIndex].setOpaque(true);
                                        label_contentsTitle[labelIndex].setBorder(new LineBorder(new Color(105, 105, 105)));
                                        label_contentsTitle[labelIndex].setHorizontalAlignment(SwingConstants.CENTER);
                                        label_space[h/7][h%7].add(label_contentsTitle[labelIndex]);
                                        label_contentsTitle[labelIndex].addMouseListener(ml);
                                        setContentsTitle(title);
								}
								labelIndex ++;
							}
							extraDate--;
							h++;
						}
						resultDay++;	
					}
					labelIndex++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return labelIndex;
	}
	

	public void setToday(){				// 오늘의 날짜 설정하는 메소드
		calYear = cal.get(Calendar.YEAR); 
		calMonth = cal.get(Calendar.MONTH)+1;
		calDay = cal.get(Calendar.DAY_OF_MONTH);
		calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	}
	
	private int startDateOfMonth(Calendar cal) {		// 1일이 시작하는 위치 구하는 메소드
		
		int StartingPoint = (cal.get(Calendar.DAY_OF_WEEK)+7-cal.get(Calendar.DAY_OF_MONTH)%7)%7;	//캘린더의 특정 날짜가 무슨요일인지와 몇일인지만 알면 그 달의 시작 요일을 알 수 있다.
		
		return StartingPoint;			//0~6까지의 숫자로 일월화수목금토  순서로 시작 요일을 알려준다.
	}
	
	public void setCal(int i) {			//캘린더에 날짜(dayOfMonth)를 표시해주는 메소드
		for(int w=0; w<6 ; w++){
			for(int h=0; h<7;h++) {
				if(i<= calLastDate[calMonth-1]){		//해당하는 달의 최대 일까지 반복
					label_space[w][h].setText(i+"");
					label_space[w][h].setFont(f1);
					i++;
				}
				if (label_space[w][h].getText().equals("0") || label_space[w][h].getText().contains("-"))			//'일' 의 값이 0 혹은 음수일경우 빈칸으로 변경{
					label_space[w][h].setText("");
			}
		}	
	}
	
	public void showToday() {			//버튼을 누를경우 월, 년도를 이동해서 오늘을 표시해주는 메소드
		Calendar cal = Calendar.getInstance();
		showCal(cal);
		btn_Backward.setText(todayMonth-1+"월");
		btn_Forward.setText((todayMonth+1)+"월");
		label_Month.setText(todayMonth+"월");
		label_Year.setText(todayYear+"");
		for(int w=0; w<6 ; w++){
			for(int h=0; h<7;h++){
				if(label_space[w][h].getText().equals(todayDayOfMonth+"")){	
					label_space[w][h].setOpaque(true);
					label_space[w][h].setBackground(new Color(255, 255, 180));
				}
			}	
		}
	}
	
	public void showToday_auto() {
		if(label_Month.getText().equals(todayMonth+"월") && label_Year.getText().equals(todayYear+"")) {
			for(int w=0; w<6 ; w++){
				for(int h=0; h<7;h++){
					if(label_space[w][h].getText().equals(todayDayOfMonth+"")){	
						label_space[w][h].setOpaque(true);
						label_space[w][h].setBackground(new Color(255, 255, 180));
					}
				}	
			}
		}
	}
	public void showCal(Calendar cal) {			//캘린더에 어디에 날짜를 표시할지 정해주는 메소드
		getList();
		switch(startDateOfMonth(cal))			//시작요일을 구하는 메소드
		{
			case 0:							//시작 요일이 일요일일 경우
				setCal(1);
				break;		
			case 1:			//시작 요일이 월요일일 경우		
				setCal(0);
				break;
			case 2:							//시작 요일이 화요일일 경우
				setCal(-1);
				break;
			case 3:							//시작 요일이 수요일일 경우
				setCal(-2);
				break;
			case 4:							//시작 요일이 목요일일 경우
				setCal(-3);
				break;
			case 5:							//시작 요일이 금요일일 경우
				setCal(-4);
				break;
			case 6:							//시작 요일이 토요일일 경우
				setCal(-5);
				break;
		}
		disableCal();
		showToday_auto();
	}
	
	public void disableCal() {			//캘린더에 날짜들을 비활성화, 활성화 시키는 메소드
		for(int i=0; i<6 ; i++) {
			for(int j=0; j<7 ; j++) {
				if(label_space[i][j].getText().isEmpty()) {
					label_space[i][j].setBackground(new Color(200,200,200));
					label_space[i][j].setOpaque(true);
					label_space[i][j].disable();
				}
				else {
					label_space[i][j].setBackground(Color.WHITE);
					label_space[i][j].setOpaque(false);
					label_space[i][j].enable();
				}
			}
		}
	}
	
	public void clearCal(){				//캘린더의 일자 표시 초기화 시키는 메소드
		for (int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				label_space[i][j].setText("");
				
				label_space[i][j].removeAll();    	// 등록된 컨텐츠를 없애는 명령
			}
		}
	}
	
	public void nextMonth(){			//다음 달로 변경하는 메소드
		try {
			calMonth++;
			cal.set(Calendar.MONTH, calMonth-1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			clearCal();
			showCal(cal);
			installContents(database.getContentsResultSet(calYear, calMonth)); 
			btn_Backward.setText(calMonth-1+"월");
			btn_Forward.setText((calMonth+1)+"월");
			label_Month.setText(calMonth+"월");
			if(label_Month.getText().equals("1월")) { 		//년도가 넘어가기전 12월과 1월에 13월 혹은 0 월이 표기되던 문제 해결
				btn_Forward.setText("2월"); 
				btn_Backward.setText("12월");
			}
			if(label_Month.getText().equals("12월")) { 
				btn_Forward.setText("1월"); 
				btn_Backward.setText("11월");
			}
			
		} catch(Exception e){			//'월' 값이 13 이상으로 올라갈경우 예외(오류)발생 이를 인식하여 년도를 넘기고 '월'값을 변경
			calMonth = 1;
			cal.set(Calendar.MONTH, calMonth-1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			clearCal();
			showCal(cal);
			installContents(database.getContentsResultSet(calYear, calMonth)); 
			label_Month.setText(calMonth+"월");
			calYear++;
			label_Year.setText(calYear+"");
			cal.set(Calendar.YEAR, calYear);
			
			if(label_Month.getText().equals("1월")) { 	//년도가 넘어가기전 12월과 1월에 13월 혹은 0 월이 표기되던 문제 해결
				btn_Forward.setText("2월"); 
				btn_Backward.setText("12월");
			}
			if(label_Month.getText().equals("12월")) { 
				btn_Forward.setText("1월"); 
				btn_Backward.setText("11월");
			}
		}
		disableCal();
		showToday_auto();
	}
	
	public void previousMonth(){			//전 달로 변경하는 메소드
		if(cal.get(Calendar.MONTH) < 1){		//(위와 다르게 0까지는 예외(오류)가 발생하지 않기때문에 if 문으로 대체) '월' 값이 0이 된경우 (실제로 표기되는 calMonth 값은 -1이 되게 된다.)를 인식하여 년도를 변경하고 '월' 값을 변경함
			calYear--;
			calMonth = 12;
			cal.set(Calendar.MONTH, calMonth-1);
			cal.set(Calendar.YEAR, calYear);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			clearCal();
			showCal(cal);
			installContents(database.getContentsResultSet(calYear, calMonth)); 
			label_Month.setText(calMonth+"월");
			label_Year.setText(calYear+"");
			
			if(label_Month.getText().equals("1월")) { 
				btn_Forward.setText("2월"); 
				btn_Backward.setText("12월");
			}
			if(label_Month.getText().equals("12월")) { 
				btn_Forward.setText("1월"); 
				btn_Backward.setText("11월");
			}
		}
		else {
			calMonth--;
			cal.set(Calendar.MONTH, calMonth-1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			clearCal();
			showCal(cal);
			installContents(database.getContentsResultSet(calYear, calMonth)); 
			btn_Backward.setText(calMonth-1+"월");
			btn_Forward.setText((calMonth+1)+"월");
			label_Month.setText(calMonth+"월");
			
			if(label_Month.getText().equals("1월")) { 
				btn_Forward.setText("2월"); 
				btn_Backward.setText("12월");
			}
			if(label_Month.getText().equals("12월")) { 
				btn_Forward.setText("1월"); 
				btn_Backward.setText("11월");
			}
		}
		disableCal();
		showToday_auto();
	}
	
	public JPopupMenu getPopupMenu(String type){ // 팝업메뉴 객체를 반환하는 메소드
		
		if(type.equals("label_components"))
			return popupMenuComponents;
		else
			return popupMenuLabel;
	}
	// 사용자가 클릭한 컨텐츠의 이름을 임시저장하는 메소드
	public void setContentsTitle(String tempTitle){
		this.tempTitle = tempTitle;
	}
	// 사용자가 클릭한 컨텐츠의 이름을 반환하는 메소드
	public String getContentsTitle() {
		return tempTitle;
	}	
	public MainGUI() { // 생성자
		detailGUI = new DetailGUI();
		database = new Database(); // 데이터베이스 객체생성
		
		initialize();
		showCal(cal);
		installContents(database.getContentsResultSet(todayYear, calMonth)); 
		getList();
	}
	
	public void getList() {			//불러온 db에서 title을 불러와서 리스트에 출력해주는 메소드
		database.list_dbTitle.clear();
		listModel.clear();
		database.searchTitle();
		for(int i =0 ; i<database.list_dbTitle.size();i++) {
			listModel.addElement(database.list_dbTitle.get(i));
		}
		list_searchlist.setModel(listModel);			//searchList에 listModel을 설정
	}
	
	public void checkList() {			//검색을 해서 리스트에 표현해주는 메소드
		list_searchlist.removeAll();
		DefaultListModel dm = new DefaultListModel();
		dm.clear();
		for(int i =0 ; i<database.list_dbTitle.size();i++) {
			if(listModel.get(i).toString().contains(textField_searchField.getText()) && !(listModel.get(i).toString().isEmpty())) {		//리스트모델에있는 리스트들이 검색 텍스트필드에있는 문자가 포함될경우 그리고 텍스트필드가 빈칸이 아닐경우
				dm.addElement(database.list_dbTitle.get(i));							//데이터 베이스에서 가져온 제목들을 가져와서 리스트모델에 넣어준다.
			}
		}
		list_searchlist.setModel(dm);				//리스트의 모델을 설정해준다
		if(textField_searchField.getText().isEmpty()) getList();		//만약 검색 텍스트 필드가 비어있을경우 모든 리스트를 불러온다.
	}
	
	private void initialize() {
		setToday();
		list_searchlist.setBorder(new LineBorder(new Color(105, 105, 105)));

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
		panel_Calendar.setBorder(new LineBorder(new Color(128, 128, 128)));
		
		
		
		panel_Calendar.setBounds(231, 0, 1113, 609);
		frame.getContentPane().add(panel_Calendar);
		panel_Calendar.setLayout(null);
		panel_Calendar.addMouseListener(ml);
		
		JLabel label_Sunday = new JLabel("일");
		label_Sunday.setBorder(new LineBorder(Color.GRAY));
		label_Sunday.setForeground(Color.RED);
		label_Sunday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Sunday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Sunday.setBackground(SystemColor.activeCaption);
		label_Sunday.setBounds(0, 0, 159, 26);
		label_Sunday.setOpaque(true); 
		panel_Calendar.add(label_Sunday);
		
		JLabel label_Monday = new JLabel("\uC6D4");
		label_Monday.setOpaque(true);
		label_Monday.setBorder(new LineBorder(Color.GRAY));
		label_Monday.setBackground(SystemColor.activeCaption);
		label_Monday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Monday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Monday.setBounds(159, 0, 159, 26);
		panel_Calendar.add(label_Monday);
		
		JLabel label_Tuesday = new JLabel("\uD654");
		label_Tuesday.setOpaque(true);
		label_Tuesday.setBorder(new LineBorder(Color.GRAY));
		label_Tuesday.setBackground(SystemColor.activeCaption);
		label_Tuesday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Tuesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tuesday.setBounds(318, 0, 159, 26);
		panel_Calendar.add(label_Tuesday);
		
		JLabel label_Wednesday = new JLabel("\uC218");
		label_Wednesday.setOpaque(true);
		label_Wednesday.setBorder(new LineBorder(Color.GRAY));
		label_Wednesday.setBackground(SystemColor.activeCaption);
		label_Wednesday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Wednesday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Wednesday.setBounds(477, 0, 159, 26);
		panel_Calendar.add(label_Wednesday);
		
		JLabel label_Thursday = new JLabel("\uBAA9");
		label_Thursday.setOpaque(true);
		label_Thursday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Thursday.setBorder(new LineBorder(Color.GRAY));
		label_Thursday.setBackground(SystemColor.activeCaption);
		label_Thursday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Thursday.setBounds(636, 0, 159, 26);
		panel_Calendar.add(label_Thursday);
		
		JLabel label_Friday = new JLabel("\uAE08");
		label_Friday.setOpaque(true);
		label_Friday.setFont(new Font("HY중고딕", Font.BOLD, 15));
		label_Friday.setBorder(new LineBorder(Color.GRAY));
		label_Friday.setBackground(SystemColor.activeCaption);
		label_Friday.setHorizontalAlignment(SwingConstants.CENTER);
		label_Friday.setBounds(795, 0, 159, 26);
		panel_Calendar.add(label_Friday);
		
		JLabel lbld = new JLabel("토");
		lbld.setOpaque(true);
		lbld.setFont(new Font("HY중고딕", Font.BOLD, 15));
		lbld.setBorder(new LineBorder(Color.GRAY));
		lbld.setBackground(SystemColor.activeCaption);
		lbld.setForeground(SystemColor.textHighlight);
		lbld.setHorizontalAlignment(SwingConstants.CENTER);
		lbld.setBounds(954, 0, 159, 26);
		panel_Calendar.add(lbld);
		
		for (int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				label_space[i][j] = new JLabel("");			//맨위의 필드에서 생성해준 라벨들을 여기서 초기화 (안하면 에러뜸)
				label_space[i][j].addMouseListener(ml);
				label_space[i][j].setLayout(null);
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
		label_space[0][6].setForeground(SystemColor.textHighlight);
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
		label_space[1][6].setForeground(SystemColor.textHighlight);
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
		label_space[2][6].setForeground(SystemColor.textHighlight);
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
		label_space[3][6].setForeground(SystemColor.textHighlight);
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
		label_space[4][6].setForeground(SystemColor.textHighlight);
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
		label_space[5][6].setForeground(SystemColor.textHighlight);
		label_space[5][6].setVerticalAlignment(SwingConstants.TOP);
		label_space[5][6].setHorizontalAlignment(SwingConstants.LEFT);
		label_space[5][6].setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 14));
		label_space[5][6].setBackground(Color.WHITE);
		label_space[5][6].setBounds(954, 511, 159, 97);
		panel_Calendar.add(label_space[5][6]);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBorder(new LineBorder(new Color(105, 105, 105)));
		panel_Search.setBounds(0, 49, 232, 560);
		frame.getContentPane().add(panel_Search);
		panel_Search.setLayout(new GridLayout(0, 1, 0, 0));
	
		
		list_searchlist.setVisibleRowCount(12);

		panel_Search.add(list_searchlist);
		
		JPanel panel_South = new JPanel();
		panel_South.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_South.setBounds(0, 609, 1345, 98);
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
		label_Month.setFont(new Font("굴림", Font.BOLD, 16));
		

		label_Month.setHorizontalAlignment(SwingConstants.CENTER);
		label_Month.setBounds(655, 31, 85, 23);
		panel_South.add(label_Month);
		
		label_Year.setFont(new Font("占쏙옙占쏙옙", Font.PLAIN, 20));
		label_Year.setHorizontalAlignment(SwingConstants.CENTER);
		label_Year.setBounds(671, 10, 57, 25);
		panel_South.add(label_Year);
		btn_Backward.setBackground(new Color(255, 192, 203));
		

		btn_Backward.setBounds(574, 20, 69, 44);
		panel_South.add(btn_Backward);
		btn_Backward.addActionListener(ml);
		btn_Forward.setBackground(new Color(135, 206, 235));
		
		btn_Forward.addActionListener(ml);
		btn_Forward.setBounds(752, 20, 68, 44);
		panel_South.add(btn_Forward);
		btn_today.setBackground(new Color(255, 248, 220));
		
	
		btn_today.setBounds(665, 67, 69, 23);
		panel_South.add(btn_today);
		
		textField_searchField = new JTextField();
		textField_searchField.setText("");
		textField_searchField.setFocusTraversalPolicyProvider(true);
		textField_searchField.setIgnoreRepaint(true);
		textField_searchField.setBounds(0, 0, 232, 26);
		frame.getContentPane().add(textField_searchField);
		textField_searchField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_searchField.setHorizontalAlignment(SwingConstants.CENTER);
		textField_searchField.setToolTipText("");
		textField_searchField.setColumns(10);
		textField_searchField.addKeyListener(kl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(105, 105, 105)));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름 순", "등록일 순", "마감일 순", "중요도 순"}));
		comboBox.setBounds(0, 24, 232, 26);
		frame.getContentPane().add(comboBox);
		btn_today.addActionListener(ml);
		
		//Main 메뉴바 컴포넌트
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C(F)"); // 파일 메뉴
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_open = new JMenuItem("\uB4F1\uB85D(N)"); // 등록 메뉴아이템
		mntmNewMenuItem_open.addActionListener(ml);
		mnNewMenu.add(mntmNewMenuItem_open);
		
		JMenu mnNewMenu_1 = new JMenu("\uC124\uC815(S)"); // 설정 메뉴
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmSetcolor = new JMenuItem("\uC0C9\uC0C1\uC124\uC815(C)"); // 색상변경 메뉴아이템
		mnNewMenu_1.add(mntmSetcolor);
		
		mnNewMenu_1.add(mntm_clear);
		mntm_clear.addActionListener(ml);
		
		
		// 팝업 메뉴 컴포넌트
		
		mntmNewMenuItem_register2 = new JMenuItem("\uB4F1\uB85D(N)"); // 등록 메뉴아이템
		mntmNewMenuItem_register2.addActionListener(ml);
		
		mntmNewMenuItem_fix = new JMenuItem("수정(F)"); // 수정 메뉴아이템
		mntmNewMenuItem_fix.addActionListener(ml);
		
		mntmNewMenuItem_remove = new JMenuItem("삭제(R)"); // 삭제 메뉴아이템
		mntmNewMenuItem_remove.addActionListener(ml);
		
		popupMenuComponents.add(mntmNewMenuItem_remove);
		popupMenuComponents.add(mntmNewMenuItem_fix);
		
		popupMenuLabel.add(mntmNewMenuItem_register2);
		//JMenuItem 
	}
	class MyContentsListener extends MouseAdapter{
		
		
		public void mouseRelased (MouseEvent e) {
			
			if(e.isPopupTrigger()) {
				System.out.println("아아");
				getPopupMenu("label_components").show(panel_Calendar, e.getX() + e.getComponent().getX() ,
						e.getY() + e.getComponent().getY());
			};

		}
	}
	
	class KeyListener extends KeyAdapter{	
		public void keyReleased(KeyEvent e) {		//키보드 키를 눌렀다가 땟을때 실행됨
			if(e.getSource().equals(textField_searchField)) {
				checkList();
			}
		}
	}
	
	class MyListener extends MouseAdapter implements ActionListener{			//모든 리스너 클래스
		// 파일 다이얼로그 관련 필드
		JLabel event;
		JFileChooser chooser; 
		
		int returnChoice;

		//MyListener 생성자
		MyListener(){
			// 파일 다이얼로그 세팅
			chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			chooser.setCurrentDirectory(new File("/")); // 현재 사용 디렉터리 지정
			chooser.setAcceptAllFileFilterUsed(true);
			chooser.setDialogTitle("메모리아 파일 열기");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 또는 디렉터리 여는 chooser
		}
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(btn_Forward)) nextMonth();
			if(e.getSource().equals(btn_Backward)) previousMonth();	
			if(e.getSource().equals(btn_today)) showToday();
			if(e.getSource().equals(mntm_clear)) {
				database.clearContents();
				getList();
			}
			if(e.getSource().equals(mntmNewMenuItem_open)) {// || mntmN
				returnChoice = chooser.showOpenDialog(null); // 다이얼로그 오픈 
				
				if(returnChoice == chooser.APPROVE_OPTION) { // 파일을 제대로 열었을 시
					detailGUI.close();
					detailGUI.show();
				}
			}
			if(e.getSource().equals(mntmNewMenuItem_register2)){ // 팝업 메뉴에서 등록 버튼 눌렀을 시
				detailGUI.InitComponents();
				detailGUI.show();
				detailGUI.firstOpen();
			}
			if(e.getSource().equals(mntmNewMenuItem_fix)){ // 팝업 메뉴에서 수정 버튼 눌렀을 시
				detailGUI.setComponents(
						database.getSeletedContentsInfo(event.getText()));
				detailGUI.show();
			}
			if(e.getSource().equals(mntmNewMenuItem_remove)){ // 팝업 메뉴에서 제거 버튼 눌렀을 시
				database.removeContents(getContentsTitle());
			}
		}
		public void mouseReleased (MouseEvent e) { // 마우스가 눌렸다가 때어질때 발생하는 리스너 ((라벨))
			System.out.println("22");
            
            if(e.getComponent().getClass().equals(JLabel.class)) {
                event = (JLabel)e.getSource();
                if(event.getText().equals("더보기")) {    
                    System.out.println("테스트");
                }
                
            }
            
            
			if(e.isPopupTrigger()) {// 만약 우클릭(팝업트리거 발동)을 했다면 프레임에 해당 좌표에 팝업메뉴 호출
				
				if(e.getComponent().getClass().equals(JLabel.class)) {  // 라벨 우클릭
					event = (JLabel)e.getSource();
					System.out.println(event.getParent().getClass().getName());
					if(event.getText().equals("") == false  &&  event.getParent().getClass().getName().equals("javax.swing.JPanel")) { // 만약 클릭한 라벨의 텍스트 값이 널값이 아니라면 인식
						getPopupMenu("label").show(panel_Calendar, e.getX() + e.getComponent().getX() ,
								e.getY() + e.getComponent().getY());
						detailGUI.selectYear = calYear;
						detailGUI.selectMonth = calMonth;
						detailGUI.selectDayOfMonth = Integer.parseInt(event.getText());
					}
					else if(event.getText().equals("") == false)	// (우)클릭한 라벨이 컨텐츠일 경우
					{
						getPopupMenu("label_components").show(panel_Calendar, event.getParent().getX() + e.getX()  + e.getComponent().getX(),
								e.getY() + event.getParent().getY() + e.getComponent().getY());
						setContentsTitle(event.getText()); // 임시로 우측클릭한 라벨의 title을 저장하기 위한 메소드.
						
					} 
				}
			}
		}
		public void mouseCliked(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
	}
}


