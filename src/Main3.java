import java.util.ArrayList;
import java.util.List;

class Student {
	
	private int StudentCode;
	private String studentName;
	
	public Student(int StudentCode, String studentName) {
		this.StudentCode = StudentCode;
		this.studentName = studentName;
		
	}
	public void showStudent() {
		System.out.println("학번"+ StudentCode +"," + "이름: " + studentName);
	}
}
		
		public class Main3{
		public static void main(String[] args) {
				List<Student> students =new ArrayList<>();
				students.add(new Student(1001, "홍길동"));
				students.add(new Student(1002, "강철수"));
				students.add(new Student(1003, "김영희"));
				
				for(Student student : students) {
					student.showStudent();
				}
		
		
		
	}
}

		
		
		

