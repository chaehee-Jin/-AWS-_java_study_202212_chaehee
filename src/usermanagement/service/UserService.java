package usermanagement.service;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

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
		Gson gson = new GsonBuilder(). setPrettyPrinting().create();

	}

	public Map<String, String >register(String userJson) {
		User user = gson.fromJson(userJson, User.class);
		
		if(dulicatedUsername(user.getUsername())) {
			
			
		}
		return null;
		
		

	}
	private boolean dulicatedUsername(String username) {
		return userrepository.findUserByUsername(username) == null;
		
	}

}
