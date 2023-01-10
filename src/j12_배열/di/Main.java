package j12_배열.di;

public class Main {

	public static void main(String[] args) {
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
	
		Test_B tb = new Test_B(tc);
		Test_A ta = new Test_A(tb);
		
		//ta.setTb(tb);

		ta.testA1();
		ta.testA2();

	}

}
