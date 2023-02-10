package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.net.SocketOptions;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;

	private String username;

	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
	}

	@Override
	public void run() {
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true); // 클라이언트에 줄수 있는 통로를 하나 열어둠
			out.println("join"); // 전송(join 이라는 텍스트 값을 )

			inputStream = socket.getInputStream(); // 받는 녀석 서버로 부터 데이터를 받는 통로를 연다
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			username = in.readLine(); // 방금 클라인언트가 '님이 접속하였습니다' 값을 보냄
			System.out.println(username + "님이 접속하였습니다"); // 콘솔창 출력

			String userListStr = "";

			for (int i = 0; i < socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if (i < socketList.size() - 1) {
					userListStr += ",";

				}
			}

			for (ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다");
				out.println("@userList/" + userListStr);
			}

			while (true) {
				String message = in.readLine();
				for (ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9090); // 서버소켓 하나생성
			System.out.println("===<<<서버 실행>>>===");
			List<Socket> socketList = new ArrayList<>();

			while (true) {
				Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석

				ConnectedSocket connectedSocket = new ConnectedSocket(socket);

				connectedSocket.start();
				// 연결버튼을 누를 때 까지 기다림
				// System.out.println(socket.getInetAddress() + "클라이언트가 연결되었습니다");
				// socketList.add(socket);

				// Thread thread = new Thread(() -> {

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
			System.out.println("===<<<서버 종료>>>===");
		}
	}

}
