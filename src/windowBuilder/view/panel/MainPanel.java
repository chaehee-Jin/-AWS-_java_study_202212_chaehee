package windowBuilder.view.panel;

import java.awt.CardLayout;

import javax.swing.JPanel;

import lombok.Data;

@Data

public class MainPanel extends InitPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout mainCard;

	private static MainPanel instance;

	public static MainPanel getInstance() {
		if (instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}

	public MainPanel() {
		mainCard = new CardLayout();
		//setSize(600, 500);
		setLayout(mainCard);
		//setBorder(null);

//		LoginPanel loginpanel = new LoginPanel();
//		add(loginpanel, "loginPanel");
//
//		RegisterPanel registerPanel = new RegisterPanel();
//		add(registerPanel, "registerPanel");
		}
	
	public void init() {
		LoginPanel loginpanel = new LoginPanel();
		add(loginpanel, "loginPanel");

		RegisterPanel registerPanel = new RegisterPanel();
		add(registerPanel, "registerPanel");
	}

}
