package j07_반복;

import java.util.Scanner;

public class While2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String select = null;
		//while 문안에 true를 넣으면 무한반복
		while (true) {
			System.out.println("x입력시 멈춤: ");
			select = scanner.nextLine();

			// 문자열 비교시 equals
			if (select.equals("X") || select.equals("X")) {
				System.out.println("프로그램을 멈춥니다.");
				break;

			}
			System.out.println("계속 실행");
		}
		System.out.println("프로그램 종료됨");

	}

}
