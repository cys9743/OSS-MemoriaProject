package Memoria.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
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
import java.awt.Rectangle;

public class SelectedPlanGUI extends JFrame {
	
	// 컴포넌트 선언
	private JPanel mainPanel;
	private JLabel label_selected_date;
	private JLabel[] label_contents = new JLabel[15];
	private Database database;
	private MyListener ml;
	
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
		mainPanel.add(label_contents[index]);
	}
	
	
	// SelectePlanGUI의 컴포넌트를 모두 지우는 메
	public void removeContents() {
		mainPanel.removeAll();
	}
	
	// SelectePlanGUI 초기화
	public SelectedPlanGUI() {


		setLocationRelativeTo(null);
		setBounds(new Rectangle(400, 700, 445, 600));
		getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setToolTipText("");
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 429, 561);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		


	}
	
	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().getClass().equals(JLabel.class)) {
				
			}
			
		}
		
	}
}
