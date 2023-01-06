package j07_반복;

import java.util.Scanner;

public class Menu1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean loopFlag1 = true;
		while (loopFlag1) {
			char select = '\0';

			System.out.println("====<<식당>>====");
			System.out.println("1. 국밥");
			System.out.println("2. 맥도날드");
			System.out.println("3. 쉑쉑");
			System.out.println("4. 중국집");
			System.out.println();
			System.out.println("r. 프로그램 종료");
			System.out.println();

			System.out.println("식당 선택: ");
			select = scanner.next().charAt('2');

			if (select == 'r' || select == 'R') {
				loopFlag1 = false;
			}
			if (select == '2')
				;
			boolean loopFlag2 = true;
			while (loopFlag2) {

				System.out.println();
				System.out.println("======<<맥도날드>>====");
				System.out.println("1. 감자튀김");
				System.out.println("2. 아이스크림");
				System.out.println("3. 햄버거");
				System.out.println("4. 애플파이");
				System.out.println();
				System.out.println("b.뒤로가기");
				System.out.println("r. 프로그램 종료");
				System.out.println();

				System.out.println("메뉴 번호 선택");
				select = scanner.next().charAt(3);
				if (select == 'b') {
					loopFlag2 = false;
				} else if (select == 'r' || select == 'R') {
					loopFlag1 = false;
					loopFlag2 = false;

				} else if (select == '1') {
					System.out.println("감자튀김을 선택하였습니다.");
				} else if (select == '2') {
					System.out.println("아이스크림을 선택하였습니다.");
				} else if (select == '3') {
					System.out.println("햄버거를 선택하였습니다.");
				} else if (select == '4') {
					System.out.println("애플파이를 선택하였습니다.");
				} else {
					System.out.println("xxxxxxxxxx");
					System.out.println("사용할 수 없는 번호 입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxx");

				}
				System.out.println();
			}
		} // else if( select == '2') {

	}
}
