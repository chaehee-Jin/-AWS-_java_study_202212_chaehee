package j09_클래스;

public class j09_StudentAA {
	
	String username = "aaa";
	String password = "1234";
	String name = "진채희";
	String email = "aaa@gmail.com";
	
	j09_StudentAA(){
		System.out.println("생성완료");
	}
	
	void printInfo() {
		System.out.println("유저 이름: " + username);
		System.out.println("패스워드: " + password);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
	}
}
