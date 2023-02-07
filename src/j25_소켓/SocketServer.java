package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

	public static final int Port = 9090;

	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();

		try {

			ServerSocket serverSocket = new ServerSocket(Port);
			while (true) {
				System.out.println("클라이언트가 접속을 기다리는 중입니다.");
				Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다림 , 접속을 해야지 돌아감
				// 서버는 사용자가 사용을 종료할 때까지 무한루프로 계속돌아야함
				// 소켓하나가 클라이언트 하나랑 같음
				clients.add(socket);

				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				OutputStream outputStream = socket.getOutputStream(); // 문자열을 전송할때 사용
				PrintWriter out = new PrintWriter(outputStream, true); // 버터기능까지 탑재한것이 printwriter
				out.println("__서버에 접속한 것을 환영합니다."); 
				// 클라인언트에서 전송된것을 받을수 있어야함 

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
