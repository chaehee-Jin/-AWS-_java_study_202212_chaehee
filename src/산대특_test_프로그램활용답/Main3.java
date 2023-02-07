package 산대특_test_프로그램활용답;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//NullPointerException은 참조대상의 값이 NULL일 때 발생하는 예외이다.
//scanner.nextLine() 메소드 호출 시 scanner 변수가 null이기 때문에 scanner 변수에 Scanner 객체를 생성해서 대입해주어야한다.
public class Main3 {

	public static void main(String[] args) {

		Scanner scanner = null;
		scanner = new Scanner(System.in);
		List<String> names = new ArrayList<>();
//		names.add("장영실");
//		names.add("홍길동");
//		for (int i = 0; i < names.size(); i++) {
		for (int i = 0; i < 2; i++) {
			System.out.println("이름을 입력하세요");
			names.add(scanner.nextLine());

		}
		System.out.println(names);

	}

}
