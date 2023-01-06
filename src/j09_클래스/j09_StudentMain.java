package j09_클래스;

public class j09_StudentMain {

	public static void main(String[] args) {
	
		int a =0;
		System.out.println(a); //초기화를 안해주면 오류 
		
		j09_Student s1 = new j09_Student();
		j09_Student s2 = new j09_Student();
		
		j09_Student student1 = new j09_Student();
		j09_Student student2 = new j09_Student();
		
		System.out.println(student1);
		System.out.println(student2);
		
		s1.name ="진채희";
		s2.age = 24;
		
		s1.printInfo();
		s2.printInfo();
		

	}

}
