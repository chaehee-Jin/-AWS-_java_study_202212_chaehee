package simplechatting2.server2;
// 인아웃풋 대신 제이쓴을 사용하기??

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

import com.google.gson.Gson;

import lombok.Data;
import simplechatting2.dto2.JoinReqDto;
import simplechatting2.dto2.JoinRespDto;
import simplechatting2.dto2.MessageReqDto;
import simplechatting2.dto2.MessageRespDto;
import simplechatting2.dto2.RequestDto;
import simplechatting2.dto2.ResponseDto;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;

	private String username;

	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
	}

	@Override
	public void run() {
		try {

			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			gson = new Gson();

			while (true) {
				String request = in.readLine();// requestDto(Json) 제이쓴 형태로들어옴
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);

				switch (requestDto.getResource()) {
				case "join":
					JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
					username = joinReqDto.getUsername();
					// 서버가 조인해라고 안함 , 원래만든것은 서버가 조인하라고 요청
					List<String> connectedUsers = new ArrayList<>();
					for (ConnectedSocket connectedSocket : socketList) {
						connectedUsers.add(connectedSocket.getUsername());

					}
					JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다", connectedUsers);
					sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
					break;
				case "sendMessage":
					MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);

					if (messageReqDto.getToUser().equalsIgnoreCase("all")) {
						String message = messageReqDto.getFromUser() + "[전체]:" + messageReqDto.getMessageValue();
						MessageRespDto messageRespDto = new MessageRespDto(message);
						sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));

					} else {
						String message = messageReqDto.getFromUser() + "[" + messageReqDto.getToUser() + "]:"
								+ messageReqDto.getMessageValue();
						MessageRespDto messageRespDto = new MessageRespDto(message);
						sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto),
								messageReqDto.getToUser());
					}

//					Runnable sendAll = () -> { // 모두에게 메세지를 보내는 것
//
//					};
//					Runnable sendTo = () -> {
//
//					};

					break;

				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	private void sendToAll(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for (ConnectedSocket connectedSocket : socketList) {
			OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);

			out.println(gson.toJson(responseDto));
		}
	}

	private void sendToUser(String resource, String status, String body, String toUser) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for (ConnectedSocket connectedSocket : socketList) {
			if (connectedSocket.getUsername().equals(toUser) || connectedSocket.getUsername().equals(username)) {
				OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true);

				out.println(gson.toJson(responseDto));

			}
		}
	}
}

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("===<<<서버 실행>>>===");
			List<Socket> socketList = new ArrayList<>();

			while (true) {
				Socket socket = serverSocket.accept();

				ConnectedSocket connectedSocket = new ConnectedSocket(socket);

				connectedSocket.start();

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
