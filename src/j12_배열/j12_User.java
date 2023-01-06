package j12_배열;

public class j12_User {
	
	//Entity(정보를 담는다)

	private String username; // 사용자 이름 
	private String password;  // 비밀번호
	private String name;       //성명
	private String email;      // 이메일 
	
	public j12_User() {  //ctrl +space = 기본생성자
		
		
	}
     // alt+shif+s 
	public j12_User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		
	}
	@Override
	public String toString() {
		return "j12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	

}
