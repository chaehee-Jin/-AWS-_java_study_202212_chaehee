package j25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString.Output;

public class SocketServer extends Thread {

	static List<SocketServer> clientList = new ArrayList<>(); //소켓서버들을 담아두는 공간 , 소켓들이 들어있는 리스트=  담당자 배정
	private static Socket socket; //멤버변수
	private InputStream inputStream;
	private OutputStream outputStream;

	private static int autoIncrement = 1;
	private String name;

	//생성자 호출
	public SocketServer(Socket socket) {
		this.socket = socket;
		name = "user" + autoIncrement++; // 유저를 임시로 만들었음 , 자동추가되도록
		clientList.add(this);

	}

	@Override
	public void run() {
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("IP:" + socket.getInetAddress());

		try {
			inputStream = socket.getInputStream(); //메서지가 서버쪽으로 들어올때 사용
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			SendToAll(name + "님이 접속하였습니다."); //브로드케스팅, 모든 클라이언트한테 동시에 메세지를 보냄 

			while (true) {
				String message = reader.readLine();//메세지가 들어올때까지 기다림
				if (message == null) { // 널이 들어올수 없음 , 널이 들어왔다는 것은 통신이 끊겼다는 것을 의미 
					break;
				}
				SendToAll(message); 

			}

//			String message = null;
//			boolean loginFlag = false;
//
//			while ((message = reader.readLine()) != null) {
//				if (name == null) {
//					name = message;
//					System.out.println("\n서버에" + name + "님이 접속하였습니다.");
//					// 메세지가 여러줄이 들어왔을 때 다음반복 실행
//
//				}
//				for (SocketServer s : clientList) {
//					try {
//						outputStream = s.socket.getOutputStream();// 반복을 통해서 모든 소켓에 다뿌림
//						writer = new PrintWriter(outputStream, true);
//						if (!loginFlag) {
//							writer.println("\n" + s.name + "님이 접속하였습니다.");
//							loginFlag = true;
//							continue;
//						}
//						writer.println("\n" + s.name + ":" + message);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close(); //Stream은 데이터가 흘러가는 통로
				outputStream.close();
				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void SendToAll(String message) throws IOException {
		for (SocketServer socketServer : clientList) { //클라이언트리스트에서 소켓서버를 하나 꺼냄 , 담당자를 하나 부름 
			outputStream = socketServer.socket.getOutputStream(); // 아웃풋할 준비해!!
			PrintWriter writer = new PrintWriter(outputStream, true);
			writer.println(name + ":" + message); // name은 자기자신 , 방금전에 생성될때 배정받은 담당자, 전역변수에 들어있음 , 방금들어온 대상
			//각각의 담당자에게 반복을 돌리면서 전달 , 모든 대상에게 메세지를 보냄 

		}
	}
}
