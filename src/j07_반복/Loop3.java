package j07_반복;

import java.util.Scanner;

public class Loop3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int count = 0;
		int add = 0;
		int total = 0;

		System.out.print("반복횟수: ");
		count = scanner.nextInt();

		for (int i = 0; i < count; i++) {
			System.out.println(i + 1 + "번 반복");
			System.out.print("a: ");
			a = scanner.nextInt();
			System.out.print("b: ");
			b = scanner.nextInt();

			add = a + b;
			System.out.println(i + 1 + "번 합: " + add + "|n");

			total += add;
			System.out.println();
		}
		System.out.println("총합: " + total);
	}

}
