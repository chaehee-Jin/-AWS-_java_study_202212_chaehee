package usermanagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserManagementFrame extends JFrame {

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernamefield;
	private JTextField registerPasswordfield;
	private JTextField registerNamefield;
	private JTextField registerEmailfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		
		
		mainPanel.add(loginPanel, "name_21446221268900");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("Century", Font.PLAIN, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(88, 10, 215, 40);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login\r\n");
		loginText.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 22));
		loginText.setForeground(new Color(0, 0, 0));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(124, 60, 125, 40);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setBounds(42, 145, 293, 27);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 200, 293, 31);
		loginPanel.add(passwordField);
		
		JLabel usernameLable = new JLabel("Username or email");
		usernameLable.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		usernameLable.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLable.setBounds(42, 120, 110, 15);
		loginPanel.add(usernameLable);
		
		JLabel PasswordLable = new JLabel("Password");
		PasswordLable.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		PasswordLable.setBounds(52, 182, 57, 15);
		loginPanel.add(PasswordLable);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		loginButton.setBounds(42, 271, 293, 40);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		signupDesc.setBounds(69, 341, 132, 40);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				
			}
		});
		signupLink.setForeground(new Color(0, 0, 255));
		signupLink.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		signupLink.setBounds(213, 351, 66, 20);
		loginPanel.add(signupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(0, 0, 255));
		forgotPasswordLink.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		forgotPasswordLink.setBounds(118, 387, 161, 15);
		loginPanel.add(forgotPasswordLink);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
			}
		});
		signinLink.setForeground(new Color(0, 0, 160));
		signinLink.setBounds(135, 419, 57, 32);
		registerPanel.add(signinLink);
		
		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("Century", Font.PLAIN, 20));
		registerLogoText.setBounds(88, 10, 215, 40);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setForeground(Color.BLACK);
		registerText.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 22));
		registerText.setBounds(124, 60, 125, 40);
		registerPanel.add(registerText);
		
		JLabel registerUsernameLable = new JLabel("Username");
		registerUsernameLable.setBounds(40, 104, 88, 15);
		registerPanel.add(registerUsernameLable);
		
		JLabel registerPasswordLable = new JLabel("Password");
		registerPasswordLable.setBounds(40, 166, 57, 15);
		registerPanel.add(registerPasswordLable);
		
		JLabel registerNameLable = new JLabel("name");
		registerNameLable.setBounds(40, 225, 57, 15);
		registerPanel.add(registerNameLable);
		
		registerUsernamefield = new JTextField();
		registerUsernamefield.setBounds(35, 129, 268, 27);
		registerPanel.add(registerUsernamefield);
		registerUsernamefield.setColumns(10);
		
		registerPasswordfield = new JTextField();
		registerPasswordfield.setBounds(37, 185, 259, 27);
		registerPanel.add(registerPasswordfield);
		registerPasswordfield.setColumns(10);
		
		registerNamefield = new JTextField();
		registerNamefield.setBounds(40, 246, 263, 32);
		registerPanel.add(registerNamefield);
		registerNamefield.setColumns(10);
		
		JLabel registerEmailLable = new JLabel("email");
		registerEmailLable.setBounds(40, 288, 57, 15);
		registerPanel.add(registerEmailLable);
		
		registerEmailfield = new JTextField();
		registerEmailfield.setBounds(40, 313, 263, 32);
		registerPanel.add(registerEmailfield);
		registerEmailfield.setColumns(10);
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		registerButton.setBounds(35, 356, 293, 40);
		registerPanel.add(registerButton);
	}
}
