package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			System.out.println("서버에 접속 성공!!");

			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream); // inputstreamreader을 가공하여서 그것을 버터스트림리더에 넣음 
			BufferedReader reader = new BufferedReader(streamReader);
			//인풋스트림은 단순히 데이터를 가지고 있는것
			// 한바이트씩 읽음 
			// while을 돌려서 한글자씩 나오는 것을 올려줌 
			// BufferedREader을 사용하면 while을 사용할 필요없이 Buffer의 공간에 하나씩 정리하여서 한꺼번에 들고옴 
			System.out.println(reader.readLine());
			

		} catch (UnknownHostException e) { // 아이피를 잡지 못했을 때

			e.printStackTrace();
		} catch (IOException e) { // 인터넷 접속문제발생

			e.printStackTrace();
		}

	}

}
