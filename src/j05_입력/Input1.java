package j05_입력;

//ctrl +shift +o =import 자동완성 , 변수명까지 완전히 완성되어야 쓸 수 있음 
//ctrl + space = 자동완성 
import java.util.Scanner;

public class Input1 {

	public static void main(String[] args) {
	
		String name = "진채희";
		Scanner scanner = new Scanner(System.in);
		
		int add1 = 0;
		int add2 = 0;
		int add3 = 0;
		int add4 = 0;
		int add5 = 0;
		
		//int inputNum = scanner.nextInt();
		//System.out.println("입력값:" + inputNum);
		//System.out.println("입력값: " + scanner.nextInt()); // 함수의 호출을 먼저 진행 (scanner.nextInt())
		System.out.print("입력1 : ");
		add1 = scanner.nextInt();
		System.out.print("입력2 : ");
		add2 = scanner.nextInt();
		System.out.print("입력3 : ");
		add3 = scanner.nextInt();
		System.out.print("입력4 : ");
		add4 = scanner.nextInt();
		System.out.print("입력5 : ");
		add5 = scanner.nextInt();

		
		//System.out.println("add1 : " + add1 );
		//System.out.pritnln("add2 : " + add2 );
		//System.out.println( "add3 : " + add3 );
		//System.out.prinltn( " add4 : " + add4);
		//System.out.println( " add5 : " + add5 );
		
		System.out.println("입력값: " + (add1 + add2 + add3 +add4 + add5 ));
		
		
		
	}

}
