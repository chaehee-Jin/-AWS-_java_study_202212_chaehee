package j06_조건;

import java.util.Scanner;

public class Switch1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
				int score = 0;
				System.out.println("점수입력");
				score = scanner.nextInt();
		
				if(score <0 ||score >100) {
					score = 0;
				}
				switch(score / 10) {
				case 10 :
				case 9 :
					System.out.println("A학점");
					break;
				case 8 :
					System.out.println("B학점");
					break;
				case 7 :
					System.out.println("C학점");
					break;
				case 6 :
					System.out.println("D학점");
					break;
				default :
				System.out.println("F학점");
		}
		
		
		
		String  select = "B선택";
		
		switch (select ) {
			case "A선택":
				System.out.println("PC(A)를 연결합니다.");
				break;
			case "B선택":
				System.out.println("PC(B)를 연결합니다.");
				break;
			case "C선택":
				System.out.println("PC(C)를 연결합니다.");
				break;
			case "D선택":
				System.out.println("PC(D)를 연결합니다.");
				default:
					System.out.println("else와 같은 역할");
					
		}

	}

}
