package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;




public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(9090); //서버소켓 하나생성 
			System.out.println("===<<<서버 실행>>>===");
			// while(true) {
			Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석
			// 연결버튼을 누를 때 까지 기다림
			// System.out.println(socket.getInetAddress() + "클라이언트가 연결되었습니다");
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true); // 클라이언트에 줄수 있는 통로를 하나 열어둠 
			out.println("join"); // 전송(join 이라는 텍스트 값을 )

			InputStream inputStream = socket.getInputStream(); // 받는 녀석 서버로 부터 데이터를 받는 통로를 연다
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			String welcomeMessage = in.readLine(); // 방금 클라인언트가 '님이 접속하였습니다' 값을 보냄 
			System.out.println(welcomeMessage); // 콘솔창 출력
			out.println(welcomeMessage); // 서버가 클라이언트에게 웰컴 메세지를 보냄 

			while (true) {
				in.readLine();

			}

			// }
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
