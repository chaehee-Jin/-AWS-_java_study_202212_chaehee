package j12_배열;

public class j12_User {

	// Entity(정보를 담는다)

	private String username; // 사용자 이름
	private String password; // 비밀번호
	private String name; // 성명
	private String email; // 이메일

	public j12_User() { // ctrl +space = 
		

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

	public String getUsername() {
		return username;
	}

	public  void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
