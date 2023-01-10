package j12_배열;

public class j12_UserMain {
	// 객체 지향 언어
	public static void main(String[] args) {
		j12_User[] users = new j12_User[0];
		j12_User[] users2 = new j12_User[100];

		j12_UserRepository userRepository = new j12_UserRepository(users);
		j12_UserRepository userRepository2 = new j12_UserRepository(users2);
		j12_UserService service = new j12_UserService(userRepository); // 객체생성
		service.run(); // 메소드 호출
		service.stop();
		

		System.out.println("코드 수정했습니다.");
		System.out.println("코드 수정했습니다.");

	}

}
