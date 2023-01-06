package j12_배열;

public class Array4 {

	public static void main(String[] args) {
		
		j12_User[] users = new j12_User[3]; 
		
		j12_User[] users2 = new j12_User[] {
				users[0] = new j12_User("aaa", "1234", "진채희", "aaa@naver.com"),
				users[1] = new j12_User("bbb", "1234", "이종현", "bbb@naver.com"),
				users[2] = new j12_User("ccc", "1234" , "김종환", "ccc@naver.com")
				
		};
		
		j12_User[] user3 = {
				users[0] = new j12_User("aaa", "1234", "진채희", "aaa@naver.com"),
				users[1] = new j12_User("bbb", "1234", "이종현", "bbb@naver.com"),
				users[2] = new j12_User("ccc", "1234" , "김종환", "ccc@naver.com"),
				
		};
		
		users[0] = new j12_User("aaa", "1234", "진채희", "aaa@naver.com");
		users[1] = new j12_User("bbb", "1234", "이종현", "bbb@naver.com");
		users[2] = new j12_User("ccc", "1234" , "김종환", "ccc@naver.com");
		
		for(int i=0; i< users.length; i++) {
			System.out.println(users[i].toString());
		}
		
		

	}

}
