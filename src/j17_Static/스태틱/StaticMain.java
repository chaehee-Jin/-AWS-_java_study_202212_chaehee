package j17_Static.스태틱;

public class StaticMain {

	public static void main(String[] args) {

		//객체생성이 되지 않았는데 메소드 사용가능 
		System.out.println("출력1:" + TestA.getNum());
		System.out.println();

		TestA.setNum(100);
		System.out.println("출력2:" + TestA.getNum());
	}

}
