package windowBuilder.view.frame;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import windowBuilder.view.panel.MainPanel;

public class MainFrame extends JFrame {

	// private CardLayout mainCard;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 생성자
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 앱솔루트로 설정하면 생성한거 이동하고 크기 조정가능
		setBounds(100, 100, 600, 500);

		MainPanel mainPanel = MainPanel.getInstance();
		mainPanel.init();
		//mainPanel.getMainCard();

		setContentPane(mainPanel);
//			mainCard = new CardLayout();
//			
//			MainPanel = new JPanel();
//			MainPanel.setLayout(mainCard);
//			MainPanel.setBorder(null);

		// MainPanel.setLayout(new CardLayout(0, 0)); //카드레이아웃은 쌓인 화면들 중 내가 보고싶은 화면을
		// 제일위로 올리는 것 , 따로 객체 생성 필요

	}

}
