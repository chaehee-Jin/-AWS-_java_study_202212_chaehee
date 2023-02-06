package j12_배열.복습;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String password;
}

public class Array2 {

	// 우리가 생성한 자료라서 new를 쓴다
	public static void main(String[] args) {
		User user1 = new User("aaa", "1234");
		User user2 = new User("bbb", "2222");
		User user3 = new User("ccc", "3333");

		User[] users = new User[] { new User("aaa", "1234"), new User("bbb", "2222"), new User("ccc", "3333")

		};
		// Integer[] integers = new Integer[] {10, 20, 30};
		// List <Integer> integerList = Arrays.asList(integers);
		// System.out.println("출력 >>> " + integerList);

		// int는 원래 있는 거라서 new를 안씀 
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int[] nums = new int[] { 10, 70, 30 };

		// 메소드 호출 가능
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i].getUsername());
		}
		// 포이치로 돌렸을 경우
		for (User u : users) {
			System.out.println(u);
		}
		List<User> userlist = Arrays.asList(users);
		System.out.println(userlist);
	}

}
