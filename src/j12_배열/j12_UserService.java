package j12_배열;

import java.util.Scanner;

public class j12_UserService {

	private Scanner scanner; // 생성되지 않아도 할당
	private j12_UserRepository userRepository;

//Public j12_UserService(){
	public j12_UserService(j12_UserRepository userRepository) {
		scanner = new Scanner(System.in); // 바꿔줄 일이 없음
		this.userRepository = userRepository;
	}

	public void run() {
		boolean loopFalg = true;
		char select = '\0';

		while (loopFalg) {
			showMainMenu();
			select = inputSelect("메인");
			loopFalg = mainMenu(select); // false 면 종료, run이 멈춘다

		}
	}

	public void stop() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");

	}

	private char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0);// 문자열에 쓸수 있는 메소드 , 첫번째글자만 잘라서 char자료로 뽑아줌
		scanner.nextLine(); // 생성되어야지 할당
		return select;
	}
	private void showMainMenu() {
		System.out.println("=====<<메인메뉴>>=====");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자 이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정  ");
		System.out.println("====================");
		System.out.println("q. 프로그램 종료");
		System.out.println();

	}
	private void showUser() {
		j12_User[] users = userRepository.getUserTable();
		//j12_User user = null;

		System.out.println("========<<회원 전체 조회>>=======");
		
		for(j12_User user: users) {
			System.out.println(users.toString());
		}

		//users = verifyUsername();

//		if (users == null) {
//			System.out.println("존재하지 않는 사용자이름 입니다.");
//			return;
//		}
		
		System.out.println("=====================");

	}
	private void registerUser() {
		j12_User user = new j12_User();

		System.out.println("=========<<회원 등록>>========");
		System.out.print("사용자 이름: ");
		user.setUsername(scanner.nextLine());

		System.out.print("비밀번호 : ");
		user.setUsername(scanner.nextLine());

		System.out.print("성명: ");
		user.setUsername(scanner.nextLine());

		System.out.print("이메일: ");
		user.setUsername(scanner.nextLine());

		userRepository.saveUser(user);
//@
	}
	private void findUser() {
		j12_User user = new j12_User();
		String username = null;

		System.out.println("=========<<사용자 이름으로 회원조회>>===========");
		System.out.print("사용자 이름: ");
		username = scanner.nextLine();

		user = userRepository.findUsername(username);
		if (user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		}

	public void ChangeUser() {
		System.out.println("수정할 사용자의 이름을 입력하세요: ");
		System.out.println();

		// j12_User user
		System.out.println("해당 사용자의 이름은 존재하지 않는 사용자이름입니다.");
		System.out.println("=========<<수정메뉴>>======");
		System.out.println("사용자 이름: ");

		System.out.println("=========================");
		System.out.print("비밀번호 변경: ");

	}

	

	
	private j12_User verifyUsername() {
		String username = null;
		System.out.println("사용자 이름: ");
		username = scanner.nextLine();

		return userRepository.findUsername(username);
	}

	
	

	private void UpdataUser() {
		j12_User user = verifyUsername();
		if (user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}

		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showupdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
	}

	private void showupdateMenu(j12_User user) {
		System.out.println("=======<<수정메뉴>>=====");
		System.out.println("사용자 이름: " + user.getUsername());
		System.out.println("======================");
		System.out.println("1.비밀번호 변경");
		System.out.println("2. 이름변경");
		System.out.println("3. 이메일 변경");
		System.out.println("=====================");
		System.out.println("b. 뒤로가기");

	}

	private void updatePassword(j12_User user) {
		String oldPassword = null;
		String newPassword = null;
		String confirmPassword = null;

		System.out.println("===========<<비밀번호 변경>>======");
		System.out.print("기존 비밀번호 입력: ");
		oldPassword = scanner.nextLine();

		if (comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.print("새로운 비밀번호 입력: ");
		newPassword = scanner.nextLine();
		System.out.println("새로운 비밀번호 확인: ");
		confirmPassword = scanner.nextLine();

		if (comparePassword(newPassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 서로 일치하지 않습니다");
			return;
		}
		user.setPassword(newPassword);
		System.out.println("비밀번호 변경완료.");

//		j12_User user = null;
//		String username = null;
//		boolean loopFlag = true;
//		char sellect = '\0';
//		System.out.println("========<<회원 정보 수정>>========");
//		System.out.print("수정할 사용자의 이름을 입력하세요");
//		scanner.nextLine();

	}

	private boolean comparePassword(String password, String oldPassword) {

		return false;
	}

	private boolean mainMenu(char select) {
		boolean flag = true;
		if (isExit(select)) {
			flag = false;
		} else {
			if (select == '1') {
				showUser();
			} else if (select == '2') {
				registerUser();
			} else if (select == '3') {
				findUser();
			} else if (select == '4') {

			} else {
				System.out.println(getSelectedErrorMessage());
			}

		}
		System.out.println();
		return flag;
	}

	private boolean isExit(char select) {

		return select == 'q' || select == 'Q';

	}

	private boolean isback(char select) {

		return select == 'b' || select == 'B';

	}

	private String getSelectedErrorMessage() {
		return "###<<잘못된 입력입니다. 다시 입력하세요. >>###";
	}

	private boolean updateMenu(j12_User user, char select) {
		boolean flag = true;
		if (isback(select)) {
			flag = false;

		} else {
			if (select == '1') {
				updatePassword(user);
			} else if (select == '2') {

			} else if (select == '3') {

			} else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		return false;

	}

}
