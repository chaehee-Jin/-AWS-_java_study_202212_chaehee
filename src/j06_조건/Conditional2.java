package j06_조건;

import java.util.Scanner;

public class Conditional2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	//	int a, b, c;
		//a = b = c = 0;
		
		int a = 0;
		int b = 0;
		int c = 0;
		int max = 0;
		int min = 0;
		
		System.out.print("정수 3개 입력");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+ min);
		
		max = a;
		min = a;
		
		if(b >max)max = b;
		if(c > max)max = c;
	
		
		if(b < min) min = b;
		if(c < min) min  =c;
	}
}
