package j17_Static.스태틱.싱글톤;

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

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	

}
