package j25_소켓.multiSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int Port = 9090;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(Port);
			System.out.println("서버를 실행합니다.");

			while (true) {
				Socket socket = serverSocket.accept();
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
