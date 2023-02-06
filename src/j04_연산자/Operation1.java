package j04_연산자;

public class Operation1 {

	public static void main(String[] args) {
		int add = 1 + 2;
		int sub = 10 - 5;
		int mul = 10* 2;
		int div = 10 / 4; // 정수와 정수를 나누었을 때는 몫을 구함, 실수와 정수, 실수와 실수는 소수점까지 나옴 
		int remainder = 10 % 5;
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(remainder);
		
		//삼항 연산자 
		System.out.println(remainder == 0 ? "5의 배수이다" : "5의 배수가 아니다");
		
		// 단항, 이항, 삼항 
		// 대표적으로 많이쓰는 것은 대입 연산, 산술연산, 비교연산자, 논리 연산자, 증감 연산자, 복합 대입연산자
		// 삼항 연산자는 조건을 주고 참, 거짓 
		
	}

}
