package usermanagement.server.controller;


import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;


public class AccountController {

	private static AccountController instance;

	private AccountController() {}
	
	public static AccountController getInstance() {
	synchronized (instance) { // 동기화 = synchronized 이것을 걸어주지 않으면 다른 스레드도 함께 들어옴 
		//동시에 접근을 하면 무엇이 나왔는지 데이터가 꼬이게됨 
		if(instance == null) {
			instance= new AccountController();
	}
	}
		return instance;
	}

	public ResponseDto<?> register(User user) { // 바디가 제이쓴으로 들어옴 
		
		
		
		return new ResponseDto<String>("ok","회원가입 성공");

	}

}
