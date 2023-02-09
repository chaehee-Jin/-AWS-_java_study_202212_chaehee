package usermanagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserManagementServerApplication implements Runnable {

	private final static int Port = 9090;
	private ServerSocket serverSocket;

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(Port);
			System.out.println("=======<<서버 실행>>=======");

			socketConnection();

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}

				System.out.println("========<<서버 종료>>=======");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private void socketConnection() throws IOException {
		while (true) {
			Socket socket = serverSocket.accept(); // 무한반복 , 소켓 생성 
			SocketServer socketServer = new SocketServer(socket); // 연결이되면 다음으로 넘어감 
			socketServer.start(); //socketServer가 스레드라는 의미
		}
	}

	public static void main(String[] args) {
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();

	}

}
