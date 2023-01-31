package j22_익명클래스.복습;

import j22_익명클래스.Calculator;

public class Main {
	
	public static void main(String[] args) {
		Calculator c2 = new Calculator()  {
			@Override
			public int calc(int x, int y) {
				return x - y;
			}
		};
		
		System.out.println(c2.calc(200, 100));

		// 익명 클래스를 한 줄로 줄인것 : 람다식
		Calculator c3 = (x, y) -> x * y;
		System.out.println(c3.calc(20, 3));

	}

}
