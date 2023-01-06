package j12_배열;

import java.util.Scanner;

public class j12_UserService {

	private Scanner scanner; //생성되지 않아도 할당 

	public j12_UserService() {
		scanner = new Scanner(System.in);
	}

	public void run() {
		boolean loopFalg = true;
		char select = '\0';

		while (loopFalg) {
			showMainMenu();
			select =inputSelect("메인");
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
		char select = scanner.next().charAt(0);//문자열에 쓸수 있는 메소드 , 첫번째글자만 잘라서 char자료로 뽑아줌
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

	private boolean mainMenu(char select) {
		boolean flag = true;
		if (isExit(select)) {
			flag = false;
		} else {
			if (select == '1') {
			} else if (select == '2') {
			} else if (select == '3') {
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

	private String getSelectedErrorMessage() {
		return "###<<잘못된 입력입니다. 다시 입력하세요. >>###";
	}

}
