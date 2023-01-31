package j12_배열.복습;


public class Array1 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;

//		int[] nums = new int[5];
//		nums[0] = 10;
//		nums[1] = 20;
//		nums[2] = 30;
//		nums[3] = 40;
//		nums[4] = 50;

		// 처음 초기화 할때만 사용가능
		int[] nums = {10, 20, 30, 40, 50};
		// 배열에서 0번 인덱스
		System.out.println(new int[]{10, 20, 30, 40, 50}[0]);
		// 위에랑은 다른 배열
		System.out.println(new int[] {10, 70, 30, 40, 50}[1]);
	}

}
