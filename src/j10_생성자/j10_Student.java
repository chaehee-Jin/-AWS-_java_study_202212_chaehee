package j10_생성자;

public class j10_Student {
	String name;
	int age;
	
	j10_Student(){
		System.out.println("기본 생성자 호출");
		
	}
		 j10_Student(int age){
			 System.out.println("학생의 나이: "+ age);
		
		 }
		 j10_Student(String name){
			 System.out.println("학생의 이름: " + name);
		 }
		  j10_Student(String name, int age){
			this.name = name;
			this.age = age;
		
		
		
	}
		   void printInfo() {
		   System.out.println("학생이름: "+ name);
		   System.out.println("학생나이: "+ age);
		   }
}
