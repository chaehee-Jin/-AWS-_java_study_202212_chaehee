package j04_연산자;

public class Operation5 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		int result = num1 > num2 ? num1 * -1 : num2 *-1;
		
		System.out.println(result);
		
		int num = 79; //num이라는 변수 
		
		int result2 = num / 90 == 1 ? 90 
						: num / 80 == 1 ? 80
						: num / 70 == 1 ? 70 : 0;
		// 참이 아니므로 연산자가 계속 다음항으로 넘어감 
		// 줄을 바꿀때 항상 연산자가 앞에 있도록 끊어주어야 함, 삼항은 ;을 기준으로 끊어주기 
		//줄을 바꾸어 주었을 경우 두번 들여쓰기를 해야한다
		
		System.out.println(result2);
		
	
		

	}

}
