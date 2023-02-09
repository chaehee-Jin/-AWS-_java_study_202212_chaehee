package usermanagement.server.controller;

import java.util.Map;

import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;
import usermanagement.service.UserService;

public class AccountController {

	private static AccountController instance;
	private UserService userService;

	private AccountController() {
		userService = UserService.getInstance();
	}

	public static AccountController getInstance() {
		// synchronized (instance) { // 동기화 = synchronized 이것을 걸어주지 않으면 다른 스레드도 함께 들어옴
		// 동시에 접근을 하면 무엇이 나왔는지 데이터가 꼬이게됨
		if (instance == null) {
			instance = new AccountController();
		}
		return instance;
	}

	public ResponseDto<?> register(String userJson) { // 바디가 제이쓴으로 들어옴
		Map<String, String> resultMap = userService.register(userJson);
		if(resultMap.containsKey("error")) {
			return new ResponseDto<String>("error", resultMap.get("error"));
		}

		return new ResponseDto<String>("ok", resultMap.get("ok"));

	}

}
