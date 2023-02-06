package usermanagement.service;

import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.RoleDtl;
import usermanagement.entity.User;
import usermanagement.repository.UserRepository;
import usermanagement.repository.UserRepositoryArraytList;

public class UserService {

	private UserRepository userrepository;
	private Gson gson;

	private static UserService instance;

	public static UserService getInstance() {

		if (instance == null) {
			instance = new UserService();
		}
		return instance;

	}

	private UserService() {
		userrepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();

	}

	public Map<String, String> register(String userJson) {
		// response: 응답
		Map<String, String> response = new HashMap<>();

		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for (Entry<String, String> userEntry : userMap.entrySet()) {
			// 공백인지 확인, 비어있는 맵에 에러인 키랑벨류를 넣음 
			if (userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백일수 없습니다");
				return response;
				// map을 사용한 이유는 반복을 돌리기 위해서

			}
		}

		User user = gson.fromJson(userJson, User.class);

		System.out.println("서비스에 넘어옴!! User 객체로 변환");
		System.out.println(user);

		if (duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 사용자 이름입니다.");
			return response;
		}
		if (duplicatedEmail(user.getEmail())) {
			response.put("error", "이미 가입된 이메일입니다.");
			return response;
			// 중복되면 않되니 중복이 되면 뒤로 넘어가지 않음 
		}
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후 ");
		System.out.println(user);

		// 중복이 걸리지 않으면 암호화
		// 암호화시킨 값을 user에 set
		// 값을 덮어씀 이때 saveUser 
		
//		String pw = BCrypt.hashpw("1234", BCrypt.gensalt());
//		System.out.println(pw);
//		System.out.println(BCrypt.checkpw("1234", pw));

		userrepository.saveUser(user);
		
		RoleDtl roleDtl = RoleDtl.builder()
				.roleId(3)
				.userId(user.getUserId())
				.build();
		
		userrepository.saveRoleDtl(roleDtl);
		
		response.put("ok", "회원 가입 성공 ");

		// if(dulicatedUsername(user.getUsername())) {
		return response;
	}

	private boolean duplicatedUsername(String username) {
		return userrepository.findUserByUsername(username) != null;

	}

	private boolean duplicatedEmail(String email) {
		return userrepository.findUserByEmail(email) != null;
	}

	public Map<String, String> authorize(String loginUserJson) {
		Map<String, String> loginUser = gson.fromJson(loginUserJson, Map.class);

		Map<String, String> response = new HashMap<>();
		for (Entry<String, String> entry : loginUser.entrySet()) {
			if (entry.getValue().isBlank()) {
				response.put("error", entry.getKey() + "은(는) 공백일 수가 없습니다");
				return response;

			}
		}
		String usernameAndEmail = loginUser.get("usernameAndEmail");
		User user = userrepository.findUserByUsername(usernameAndEmail);
		if (user == null) {
			user = userrepository.findUserByEmail(usernameAndEmail);
			if (user == null) {
				response.put("error", "사용자 정보를 확인해주세요");
				return response;
			}
		}
		if (!BCrypt.checkpw(loginUser.get("password"), user.getPassword())) {
			response.put("error", "사용자 정보를 확인해주세요");
			return response;

		}
		response.put("ok", user.getName() + "님 환영합니다");
		return response;

	}
}
