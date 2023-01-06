package j09_클래스;

public class j09_Student {
	
	String name = "진";
	int age = 100;
	
	//기본 생성자
	j09_Student(){ 
		System.out.println("생성됨!!");
		
	}
	void printInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: " +age);
		
	}

}
