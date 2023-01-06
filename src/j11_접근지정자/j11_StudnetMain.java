package j11_접근지정자;

import j11_접근지정자.default1.j11_StudentDefault;

public class j11_StudnetMain {

	public static void main(String[] args) {

		j11_Student s1 = new j11_Student();
		//s1.name = "진채희";
		s1.printInfo(); //메소드, 은행원
		//은행원에게 보여달라고 요청 
		j11_StudentDefault s2 = new j11_StudentDefault();
		//s2.name = "진채희";

		//System.out.println("이름: "+ s2.name); 
		System.out.println("이름:" + s2.getName());
	}
	
}
