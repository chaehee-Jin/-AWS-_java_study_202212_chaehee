package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import usermanagement.entity.User;

public class UserRepositoryArraytList {
	private List<User> userDataList;
	private static UserRepositoryArraytList instance;

	public static UserRepositoryArraytList getInstance() {
		if (instance == null) {
			instance = new UserRepositoryArraytList();

		}
		return instance;
	}

	private UserRepositoryArraytList() {
		userDataList = new ArrayList<>();
		userDataList.add(User.builder().username("aaa").password(BCrypt.hashpw("1234", BCrypt.gensalt())).name("김준일")
				.email("aaa@gmail.com").build());
	}

	public void saveUser(User user) {
		userDataList.add(user);

	}

	public User findUserByUsername(String username) {
		User user = null;
		for (User u : userDataList) {
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}

		}
		return user;
	}

	public User findUserByEmail(String email) {
		User user = null;
		for (User u : userDataList) {
			if (u.getEmail().equals(email)) {
				user = u;
				break;
			}

		}
		return user;
	}
}
