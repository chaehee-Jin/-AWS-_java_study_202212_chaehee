package j12_배열.di;

public class Test_A {

	private final Test_B tb;

	public Test_A(Test_B tb) { //필수 매개변수를 가지는 생성자 , final이 잡혔을 때 사용 
		this.tb = tb;
	}
	//public void setTb(Test_B tb){
	// this.tb = tb;
	//}
	

	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
		// Test_B tb = new Test_B();

		tb.testB1();

	}

	public void testA2() {
		System.out.println("테스트 A2 메소드 호출!! ");
		// Test_B tb = new Test_B();

		tb.testB1();

	}
}
