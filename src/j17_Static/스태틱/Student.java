package j17_Static.스태틱;

public class Student {

	private static final int CODE = 20230000;
	// 자동 증가
	private static int ai = 1; // auto_increment

	private int studentCode;
	private String name;

	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;

	}
	public static int getAutoIncrement() {
		System.out.println("현재 AI:"+ ai);
		//System.out.println("학생이름: "+ name); name은 생성이 되어야만 쓸수있음 하지만 static메소드는 생성되지 않아도 쓸수 있음 
		return ai;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	

}
