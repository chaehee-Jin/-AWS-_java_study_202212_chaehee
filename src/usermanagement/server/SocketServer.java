package usermanagement.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;
import usermanagement.server.controller.AccountController;

public class SocketServer extends Thread {

	private static List<SocketServer> SocketServerList = new ArrayList<>();

	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;

	public SocketServer(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		SocketServerList.add(this);
	}

	@Override
	public void run() {
		try {
			reciveRequest();
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + ":" + socket.getPort() + "클라이언트와 접속이 끊어졌습니다");
		}

	}

	private void reciveRequest() throws IOException {
		inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		while (true) {
			String request = reader.readLine();
			if (request == null) {
				throw new ConnectException();
			}
			RequestMapping(request);
		}
	}

	// 리소스를 매핑하는 부분
	private void RequestMapping(String request) throws IOException {
		
		RequestDto<?> requestDto = gson.fromJson(request, RequestDto.class);
		// System.out.println(requestDto);
		String resource = requestDto.getResource();
		switch (resource) {
		case "register":
			User user = gson.fromJson((String)requestDto.getBody(), User.class);
			
			ResponseDto<?> responseDto = AccountController.getInstance().register(user);	
			sendResponse(responseDto);
			
			

			break;
		default:
			System.out.println("해당 요청은 처리할 수 없습니다.(404)");
			break;
		}

	}
	private void sendResponse(ResponseDto<?> responseDto) throws IOException{
		String response = gson.toJson(responseDto);
		outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream, true);
		writer.println(response);
		writer.flush();
	
}
}
