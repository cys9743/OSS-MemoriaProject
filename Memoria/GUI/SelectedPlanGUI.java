package Memoria.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class SelectedPlanGUI extends JFrame {
	
	// 컴포넌트 선언
	private JPanel mainPanel;
	private JLabel label_selected_date;
	private JLabel[] label_contents = new JLabel[15];
	private Database database;
	private MyListener ml;
	private DetailGUI detailGUI;
	private ContentsGUI contentsGUI;
	private JPopupMenu popupMenuComponents;
	private JMenuItem mntmNewMenuItem_fix;

	
	
	public void setDate(String date) {
		label_selected_date = new JLabel(date);
		label_selected_date.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		mainPanel.add(label_selected_date);
		label_selected_date.setBounds(150, 10, 140, 23);
	}
	
	
	// GUI에 콘텐츠를 표기하는 메소드
	public void setContents(int index, String title, Color color){
		if(index > 2)
			index--;
		label_contents[index] = new JLabel(title);
		label_contents[index].setBackground(color);
		label_contents[index].setOpaque(true);
		label_contents[index].setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		label_contents[index].setForeground(Color.white);
		label_contents[index].setBounds(40, 70 +(index * 40), 350, 35);
		label_contents[index].addMouseListener(ml);
		mainPanel.add(label_contents[index]);
	}
	
	
	// SelectePlanGUI의 컴포넌트를 모두 지우는 메
	public void removeContents() {
		mainPanel.removeAll();
	}
	
	// SelectePlanGUI 초기화
	public SelectedPlanGUI() {

		database = new Database();
		contentsGUI = new ContentsGUI();
		detailGUI = new DetailGUI();
		ml = new MyListener();
		
		setLocationRelativeTo(null);
		setBounds(new Rectangle(400, 700, 445, 600));
		getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setToolTipText("");
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 429, 561);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		popupMenuComponents = new JPopupMenu();
		mntmNewMenuItem_fix = new JMenuItem("수정(F)"); // 수정 메뉴아이템
		mntmNewMenuItem_fix.addActionListener(ml);
		popupMenuComponents.add(mntmNewMenuItem_fix);


	}
	class MyListener extends MouseAdapter implements ActionListener {
		JLabel label_event;
		
		public void mouseReleased(MouseEvent e) {
			if(e.isPopupTrigger()) {// 만약 우클릭(팝업트리거 발동)을 했다면 프레임에 해당 좌표에 팝업메뉴 호출	
				if(e.getComponent().getClass().equals(JLabel.class)) {  // 라벨 우클릭
					JLabel event = (JLabel)e.getSource();
					if(event.getText().equals("") == false  &&  event.getParent().getClass().getName().equals("javax.swing.JPanel")) { // 만약 클릭한 라벨의 텍스트 값이 널값이 아니라면 인식
						label_event = (JLabel)e.getSource();
						popupMenuComponents.show(mainPanel, e.getX() + e.getComponent().getX() ,
								e.getY() + e.getComponent().getY());
					} 
				}
			}
			else if(e.getSource().getClass().equals(JLabel.class)) {
				label_event = (JLabel)e.getSource();
				contentsGUI.setComponents(database.getSeletedContentsInfo(label_event.getText()));
				contentsGUI.show();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(mntmNewMenuItem_fix)){ // 팝업 메뉴에서 수정 버튼 눌렀을 시
				System.out.println(label_event.getName());
				detailGUI.setComponents(
						database.getSeletedContentsInfo(label_event.getText()));
				detailGUI.show();
			}
		}
		
		
	}
}
