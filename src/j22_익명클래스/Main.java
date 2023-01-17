package j22_익명클래스;

public class Main {

	public static void main(String[] args) {

		Calculator c1 = new Addition();
		System.out.println(c1.calc(10, 20));
//////////////////////////////////////////////////////////////////
		Calculator c2 = new Calculator() {

			@Override //구현을 했음 
			public int calc(int x, int y) {
				return x - y;

			}
		}; //구현된 클래스 객체 , 임시적으로 파일로 저장된 것은 아님 
		//객체생성은 할 수 있음 , 클래스인데 클래스 이름이 없으니 익명클래스 
		System.out.println(c2.calc(200, 100));

	}

}
