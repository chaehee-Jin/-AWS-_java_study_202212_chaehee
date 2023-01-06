package j08_메소드;

public class Method2 {

	public static void main(String[] args) {
		method1(); // 함수 호출
		method2(100);
		method3(200, 300);
		
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(24));
		System.err.println();
	}
	// 매개변수: x, 반환: y
	// void는 실행이후 반환되는 값이 없음
	public static void method1() {
		System.out.println("단순 실행:");

	}
	// 매개변수: int 하나입력, 반환: x
	public static void method2(int num) {
		System.out.println("num: " + num);

	}// 매개변수: int 두개입력, 반환: x
	public static void method3(int num, int num2) {
		System.out.println("num: " + num);
		System.out.println("num2:"+ num2);
	}
	public static String method4() {
		return "데이터 반환";
	}
	public static String method5( int age) {
		return age  +"살";
	}
}
