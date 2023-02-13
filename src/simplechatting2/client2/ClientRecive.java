package simplechatting2.client2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import simplechatting2.dto2.JoinRespDto;
import simplechatting2.dto2.MessageRespDto;
import simplechatting2.dto2.RequestDto;
import simplechatting2.dto2.ResponseDto;

@RequiredArgsConstructor
public class ClientRecive extends Thread {

	private final Socket socket;
	private InputStream inputStream;
	private Gson gson;

	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			gson = new Gson();

			while (true) {
				String request = in.readLine();
				ResponseDto responseDto = gson.fromJson(request, ResponseDto.class);
				switch (responseDto.getResource()) {
				case "join":
					// if (responseDto.getStatus().equalsIgnoreCase("ok")) { // 문자열을 대소문자 구분하지 않겠다
					JoinRespDto joinRespDto = gson.fromJson(responseDto.getBody(), JoinRespDto.class);

					ChattingClient.getInstance().getContentView().append(joinRespDto.getWelcomeMessage() + "\n");
					ChattingClient.getInstance().getUserListModel().clear();
					ChattingClient.getInstance().getUserListModel().addAll(joinRespDto.getConnectedUsers());
					break;
				case "sendMessage":
					MessageRespDto messageRespDto = gson.fromJson(responseDto.getBody(), MessageRespDto.class);
					ChattingClient.getInstance().getContentView().append(messageRespDto.getMessageValue() + "\n");
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
