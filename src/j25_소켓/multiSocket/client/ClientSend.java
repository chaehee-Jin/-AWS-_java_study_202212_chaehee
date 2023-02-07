package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientSend extends Thread {

	private final Socket socket;

	@Override
	public void run() {
		try {
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			Scanner scanner = new Scanner(System.in);

			while (true) {
				if(Client.name == null) {
					Client.name = scanner.nextLine();
					writer.println(scanner.nextLine());
					continue;
					
				}
//				System.out.println("메세지 입력:");
//				writer.println(scanner.nextLine());

			}
		} catch (IOException e) {
			e.printStackTrace();
			
			// 결론: Json을 안쓰면 안됨 

		}
	}

}
