package j07_반복;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String name = "진채희";
		// 0번에 있는 인덱스를 케릭터로 가져와라, 문자를 입력받고 이문자를 잘라다가 케릭터로 쓰는 것
		System.out.println(name.charAt(0));

		boolean loopFlag1 = true;
		while (loopFlag1) {
			char select = '\0';

			System.out.println("======<<식당 메뉴>>======");
			System.out.println("1. 김밥천국");
			System.out.println("2. 탄탄면");
			System.out.println("3. 홍대개미");
			System.out.println("4. 밥엔밥");
			System.out.println("==================");
			System.out.println("q.프로그램 종료");
			System.out.println("==================");

			System.out.println("식당 선택: ");
			select = scanner.next().charAt(0);

			if (select == 'q' || select == 'Q') {
				loopFlag1 = false;
			} else if (select == '1') {
				boolean loopFlag2 = true;
				while (loopFlag2) {

					System.out.println();
					System.out.println("======<<김밥 천국 >>======");
					System.out.println("1. 라면");
					System.out.println("2. 돌솥비빔밥");
					System.out.println("3. 오므라이스");
					System.out.println("4. 김치볶음밥");
					System.out.println("==================");
					System.out.println("b.뒤로가기");
					System.out.println("q.프로그램 종료");
					System.out.println("==================");

					System.out.println("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					if (select == 'b') {
						loopFlag2 = false;
						// break;, 안에만 break를 걸면 바깥 쪽은 break가 걸리지 않음
					} else if (select == 'q' || select == '0') {
						loopFlag1 = false;
						loopFlag2 = false;

					} else if (select == '1') {
						System.out.println("라면을 선택했습니다.");
					} else if (select == '2') {
						System.out.println("돌솥비빔밥을 선택했습니다.");
					} else {
						System.out.println();
						System.out.println("xxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요");
						System.out.println("xxxxxxxxxxxx");
					}
					System.out.println();
				}
			} else if (select == '2') {
			} else if (select == '3') {
			} else if (select == '4') {
			} else {
				System.out.println("xxxxxxxxxxx");
				System.out.println("사용할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요");
				System.out.println("xxxxxxxxxxxx");

			}
			System.out.println();

		}
		System.out.println("프로그램 정상 종료");
	}

}
