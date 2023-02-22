package simplechatting2.client2;

import java.awt.EventQueue;

import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import lombok.Data;
import lombok.Getter;
import simplechatting2.dto2.JoinReqDto;
import simplechatting2.dto2.MessageReqDto;
import simplechatting2.dto2.RequestDto;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class ChattingClient extends JFrame {
	private static ChattingClient instance;

	// 싱글톤 만들기
	public static ChattingClient getInstance() {
		if (instance == null) {
			instance = new ChattingClient();

		}
		return instance;
	}

	private Socket socket;
	private Gson gson;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList<String> userList;
	private DefaultListModel<String> userListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ChattingClient() {
		gson = new Gson();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(312, 10, 106, 21);
		contentPane.add(ipInput);
		ipInput.setColumns(10);

		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());

				try {
					socket = new Socket(ip, port); // 소켓 객체생성 , 클라이언트가 이 ip로 접속하겠다
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속", "접속성공",
							JOptionPane.INFORMATION_MESSAGE);

					connectButton.setEnabled(false);
					connectButton.removeMouseListener(this);

					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();

					username = JOptionPane.showInputDialog(null, "사용자 이름을 입력해 주세요", "이름입력",
							JOptionPane.INFORMATION_MESSAGE);

					JoinReqDto joinReqDto = new JoinReqDto(username);
					String j0inReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", j0inReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);

					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);

//					InputStream inputStream = socket.getInputStream();
//					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//					if (in.readLine().equals("join")) { // 조인이면 사용자의 이름을 받도록 유도
//						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요", JOptionPane.INFORMATION_MESSAGE);
//
//						OutputStream outputStream = socket.getOutputStream(); // 소켓이 서버에게 갈수있는 통로를 연다
//						PrintWriter out = new PrintWriter(outputStream, true); // 클라이언트가 서버에게 데이터를 줌
//						out.println(username);
//
////						String welcomeMessage = in.readLine(); // 변수를 담음
////						contentView.append(welcomeMessage); // 웹컴 메세지를 뿌려줌 여러개면 모든 클라이언트에게 다 보내야함
//
//					}
//					Thread thread = new Thread(() -> {
//						try {
//							InputStream input = socket.getInputStream();
//							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//
//							// 웰컴 메세지만 잘라서 보내줌
//							while (true) {
//								String message = reader.readLine();
//								if (message.startsWith("@welcome")) {
//									int tokenIndex = message.indexOf("/");
//									message = message.substring(tokenIndex + 1);
//									// 해당 문자열중에 해당 인덱스부터 문자열을 자르라는 의미
//								} else if (message.startsWith("@userList")) {
//									int tokenIndex = message.indexOf("/");
//									message = message.substring(tokenIndex + 1);
//									String[] usernames = message.split(",");
//									userListModel.clear();
//									for (String username : usernames) {
//										userListModel.addElement(username);
//									}
//									continue;
//								}
//								contentView.append(message + "\n");
//
//							}
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//
//					});

//				thread.start();

				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, "서버 접속 실패", "접속실패", JOptionPane.ERROR_MESSAGE);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(473, 9, 63, 23);
		contentPane.add(connectButton);

		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(420, 10, 52, 21);
		contentPane.add(portInput);
		portInput.setColumns(10);

		//메세지를 받는부분
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 7, 287, 234);
		contentPane.add(contentScroll);

		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);

		// 채팅 유저들을 보여주는 부분
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(312, 41, 224, 200);
		contentPane.add(userListScroll);

		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		userListScroll.setViewportView(userList);

		// 메세지를 보내는 부분 
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 254, 419, 68);
		contentPane.add(messageScroll);

		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}

			}
		});
		messageScroll.setViewportView(messageInput);

		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();

//						InputStream inputStream = socket.getInputStream();
//						BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//
//						String message = in.readLine();
//						contentView.append("\n" + message);
//						messageInput.setText("");

			}

		});
		sendButton.setBounds(439, 254, 97, 68);
		contentPane.add(sendButton);

	}

	private void sendRequest(String resource, String body) {
		OutputStream outputStream;

		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);

			RequestDto requestDto = new RequestDto(resource, body);

			out.println(gson.toJson(requestDto));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void sendMessage() {
		if (!messageInput.getText().isBlank()) {

			String toUser = userList.getSelectedIndex() == 0 ? "all" : userList.getSelectedValue();

			MessageReqDto messageReqDto = new MessageReqDto(toUser, username, messageInput.getText());

			sendRequest("sendMessage", gson.toJson(messageReqDto));
			// out.println(username + ":" + messageInput.getText());

			messageInput.setText("");

		}
	}

}
