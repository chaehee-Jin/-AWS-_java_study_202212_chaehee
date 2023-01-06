package j07_반복;

public class Star1 {

	// 별 찍기
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print('*');
			}
			System.out.println();

		} // 별 거꾸로 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		// 별 오른쪽부터 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {

				System.out.print(" ");
			}

			for (int f = 0; f < i + 1; f++) {
				System.out.print("*");
			}
			System.out.println();

		} //별 오른쪽부터 거꾸로 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			for (int f = 0; f < 10 - i; f++) {
				System.out.print(" ");

			}
			System.out.println();

		}// 별 트리 만들기
		for(int i= 0; i < 10; i++) {
			for(int j = 0; j < 10-i-1; j++) {
				System.out.print(" ");
			}
			for(int f= 0; f <i *2+1; f++) {
				System.out.print("*");
			}
			
			System.out.println(" ");
		}
		//별다이아몬드 만들기
		for(int i=0; i< 10; i++) {
			for (int f=0; f<i+1; f++ ) {

				System.out.print(" ");
			}
			for(int f=0; f<18-(2*i+1); f++) {
				System.out.print("*");
				
			}
			System.out.println(" ");
		}

		
		}	
}
		
	


