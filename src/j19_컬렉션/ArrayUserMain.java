package j19_컬렉션;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String name;
}

public class ArrayUserMain {

	public static void main(String[] args) {

		User[] userArray = { new User("aaa", "김종환"), 
				new User("bbb", "고병수"), 
				new User("ccc", "손민재"),
				new User("ddd", "황창욱.")

		};
		List<User> userList = Arrays.asList(userArray);

		String searchUsername = "aaa";
		User user = searchUser(userList, searchUsername);
		
		if(user == null) {
			System.out.println("검색실패!!");
			System.out.println("존재하지 않는 계정입니다");
			
		}else {
			System.out.println("검색 성공");
			System.out.println(searchUsername + "계정의 회원 이름은" + user.getName() + "입니다");
		}

		/*
		 * 검색성공 aaa 계정의 회원 이름은 김종환입니다 검색 실패: 존재하지 않는 계정입니다
		 */

//		System.out.println(userList);
//
//		for (User u : userArray) {
//			if (u.getName().equals(searchUsername)) {
//				return;
//
//			}
//			System.out.println("검색 실패: 존재하지 않는 계정입니다.");

		}

	private static User searchUser(List<User> userList, String username) {
		User user = null;
		
		for(User u: userList) { //User을 계속꺼내서 같은지 확인 , 주소 비교
			if(user.getUsername().equals(username)) {
				user= u;
				break;
			}
		}
		return user; //반복이 다 끝나고 return 하면 비교가 안되니  null로 찍힘 
		//찾지 못한다면 null
}


}
