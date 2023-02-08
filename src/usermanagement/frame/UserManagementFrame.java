package usermanagement.frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.service.UserService;

public class UserManagementFrame extends JFrame {

	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;

	private List<JTextField> loginFields;
	private List<JTextField> registerFields;

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernamefield;
	private JTextField registerNamefield;
	private JTextField registerEmailfield;
	private JPasswordField registerPasswordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 9090);

					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다.", "접속실패", JOptionPane.ERROR_MESSAGE);
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
		try {
			inputStream = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));
			outputStream = socket.getOutputStream();
			writer = new PrintWriter(outputStream, true);
		} catch (IOException e1) {

			e1.printStackTrace();

		}
		gson = new Gson();

		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();

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

		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);

		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("Century", Font.PLAIN, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(88, 10, 215, 40);
		loginPanel.add(logoText);

		JLabel loginText = new JLabel("Login");
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
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText());

				UserService userService = UserService.getInstance();

				Map<String, String> response = userService.authorize(loginUser.toString());

				if (response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
			}
		});
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
				clearFields(loginFields);

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
		signinLink.setBounds(154, 406, 57, 32);
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
		registerUsernameLable.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		registerUsernameLable.setBounds(40, 104, 88, 15);
		registerPanel.add(registerUsernameLable);

		JLabel registerPasswordLable = new JLabel("Password");
		registerPasswordLable.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		registerPasswordLable.setBounds(40, 166, 57, 15);
		registerPanel.add(registerPasswordLable);

		JLabel registerNameLable = new JLabel("name");
		registerNameLable.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		registerNameLable.setBounds(40, 225, 57, 15);
		registerPanel.add(registerNameLable);

		registerUsernamefield = new JTextField();
		registerUsernamefield.setBounds(40, 129, 263, 27);
		registerPanel.add(registerUsernamefield);
		registerUsernamefield.setColumns(10);

		registerNamefield = new JTextField();
		registerNamefield.setBounds(40, 246, 263, 32);
		registerPanel.add(registerNamefield);
		registerNamefield.setColumns(10);

		JLabel registerEmailLable = new JLabel("email");
		registerEmailLable.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		registerEmailLable.setBounds(40, 288, 57, 15);
		registerPanel.add(registerEmailLable);

		registerEmailfield = new JTextField();
		registerEmailfield.setBounds(40, 313, 263, 32);
		registerPanel.add(registerEmailfield);
		registerEmailfield.setColumns(10);

		registerPasswordfield = new JPasswordField();
		registerPasswordfield.setBounds(40, 191, 263, 31);
		registerPanel.add(registerPasswordfield);

		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				// 선언만 한 것
				userJson.addProperty("username", registerUsernamefield.getText());
				userJson.addProperty("password", registerPasswordfield.getText());
				userJson.addProperty("name", registerNamefield.getText());
				userJson.addProperty("email", registerEmailfield.getText());

				RequestDto<String> requestDto = new RequestDto<String>("register", userJson.toString());

				writer.println(gson.toJson(requestDto));

				
				try {
					String response = reader.readLine();
					System.out.println("응답옴");
					//System.out.println(response);
					ResponseDto<?> responseDto  = gson.fromJson(response, ResponseDto.class);
					
					//System.out.println(gson.fromJson(response, ResponseDto.class));
					System.out.println(responseDto);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				

				// System.out.println(userJson.toString());

//				UserService userService = UserService.getInstance();
//				Map<String, String> response = userService.register(userJson.toString()); // 서버로 넘어감
//				// user service에서 리턴된 값이 들어옴, 에러가 있으면 에러를 띄워달라
//
//				if (response.containsKey("error")) {
//					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
//					return;
//					// 마우스 클릭 메소드가 실행중인데 밑에것을 실행하지 못하도록 리턴
//					// 공백이 하나도 없으면 회원가입 진행
//
//				}
//				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
//				mainCard.show(mainPanel, "loginPanel");
//				clearFields(registerFields);

			}
		});
		registerButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		registerButton.setBounds(35, 356, 293, 40);
		registerPanel.add(registerButton);

		loginFields.add(usernameField);
		loginFields.add(passwordField);

		registerFields.add(registerUsernamefield);
		registerFields.add(registerPasswordfield);
		registerFields.add(registerNamefield);
		registerFields.add(registerEmailfield);

	}

	private void clearFields(List<JTextField> textFields) {
		for (JTextField field : textFields) {
			if (field.getText().isEmpty()) { // 공백도 텍스트로 들어
				continue;
			}
			field.setText("");
		}
	}
}
