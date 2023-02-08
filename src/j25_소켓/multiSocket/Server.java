package j25_소켓.multiSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int Port = 9090;

	public static void main(String[] args) {
		try {
			// 서버소켓은 소켓통신을 위해 내장되어있음 
			ServerSocket serverSocket = new ServerSocket(Port);
			System.out.println("서버를 실행합니다.");

			while (true) {
				// 클라이언트의 연결을 기다림
				Socket socket = serverSocket.accept();
				// 클라이언트가 연결이 되면 소켓 객체를 하나 생성한다, 하나의 소켓은 하나의 클라이언트
				SocketServer socketServer = new SocketServer(socket);// 클라이언트 하나생길때 마다 스레드도 하나씩 생긴다
				socketServer.start(); // 무한루프, 스레드 실행
				// 다시 돌아가면 접속을 기다린다
				// 클라이언트가 들어오면 담당자가 바뀐다고 생각

			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			System.out.println("서버를 종료합니다.");
		}

	}

}
