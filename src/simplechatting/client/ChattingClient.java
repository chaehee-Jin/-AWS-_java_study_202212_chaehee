package simplechatting.client;

import java.awt.EventQueue;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
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

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextField usernameInput;
	private 	JTextArea contentView;

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ipInput = new JTextField();
		ipInput.setBounds(312, 10, 106, 21);
		contentPane.add(ipInput);
		ipInput.setColumns(10);

		JButton connectButton = new JButton("연결\r\n");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());

				try {
					socket = new Socket(ip, port); //소켓 객체생성 , 클라이언트가 이 ip로 접속하겠다
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속", "접속성공",
							JOptionPane.INFORMATION_MESSAGE);

					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					if (in.readLine().equals("join")) { // 조인이면 사용자의 이름을 받도록 유도
						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요", JOptionPane.INFORMATION_MESSAGE);

						OutputStream outputStream = socket.getOutputStream(); // 소켓이 서버에게 갈수있는 통로를 연다
						PrintWriter out = new PrintWriter(outputStream, true); // 클라이언트가 서버에게 데이터를 줌 
						out.println(username + "님이 접속하였습니다");

						String welcomeMessage = in.readLine(); // 변수를 담음
						contentView.append(welcomeMessage); // 웹컴 메세지를 뿌려줌 여러개면 모든 클라이언트에게 다 보내야함 

					}

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
		portInput.setBounds(420, 10, 52, 21);
		contentPane.add(portInput);
		portInput.setColumns(10);

		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 7, 287, 234);
		contentPane.add(contentScroll);

		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);

		usernameInput = new JTextField();
		usernameInput.setBounds(311, 41, 225, 200);
		contentPane.add(usernameInput);
		usernameInput.setColumns(10);

		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 254, 419, 68);
		contentPane.add(messageScroll);

		JTextArea messageInput = new JTextArea();
		messageScroll.setViewportView(messageInput);

		JButton sendButton = new JButton("전송\r\n");
		sendButton.setBounds(439, 254, 97, 68);
		contentPane.add(sendButton);
	}
}
