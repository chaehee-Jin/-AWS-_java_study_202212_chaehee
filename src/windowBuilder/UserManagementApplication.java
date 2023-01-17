package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowBuilder.view.frame.MainFrame;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class UserManagementApplication  {

//	private CardLayout mainCard;
//	private JPanel MainPanel;

	/**
	 * Launch the application.
	 */
	//익명클래스
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true); // setVisible이 true이면 보인다 false이면 보이지 않는다
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		EventQueue.invokeLater(runnable);
	}

	/**
	 * Create the frame.
	 */
//	//생성자 
//	public UserManagementApplication() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //  앱솔루트로 설정하면 생성한거 이동하고 크기 조정가능 
//		setBounds(100, 100, 600, 500);
//		
//		
//		mainCard = new CardLayout();
//		
//		MainPanel = new JPanel();
//		MainPanel.setLayout(mainCard);
//		MainPanel.setBorder(null);
//
//		setContentPane(MainPanel);
//		MainPanel.setLayout(new CardLayout(0, 0)); //카드레이아웃은 쌓인 화면들 중 내가 보고싶은 화면을 제일위로 올리는 것 , 따로 객체 생성 필요
//		
//	}

}
