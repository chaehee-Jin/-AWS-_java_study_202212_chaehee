package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) { //2개의 스레드가 돌아가고 있음 

		try {
			Socket socket = new Socket("127.0.0.1", 9090);

			ClientRecive clientRecive = new ClientRecive(socket); // 동작을 받는것
			clientRecive.start();

			ClientSend clientSend = new ClientSend(socket);
			clientSend.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} //Json으로 데이터들이 왔다갔다함 

	}

}
