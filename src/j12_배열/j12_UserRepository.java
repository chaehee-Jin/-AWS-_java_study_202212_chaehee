package j12_배열;

//저장소 , 데이터 관리
public class j12_UserRepository {

	private j12_User[] userTable;

	public j12_UserRepository(j12_User[] userTable) {
		this.userTable = userTable;
	}

	public j12_User[] getUserTable() { // 외부에서 가지고오기 위해서 Getter필요(Private이기때문)
		return userTable;
	}

	public void saveUser(j12_User user) {
		extendArrayOne(); // 새로운 공간 1개 확장
		userTable[userTable.length - 1] = user; // 마지막 받는 크기가 4니까 3이 되기 위해 -1

	}

	private void extendArray(int length) { // 무조건 1개씩 늘어나는 구조 하지만 여러개 늘어나는 구조로 확장시켜줘야함
		j12_User[] newArray = new j12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void extendArrayOne() { // 하나씩만 늘어나는 구조
		j12_User[] newArray = new j12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray); // userTable 을 new Array로 옮겨라
		userTable = newArray;
	}

	private void transferDataToNewArray(j12_User[] oldArray, j12_User[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}

	}

	public j12_User findUsername(String username) {
		j12_User user = null;
		
		
		
		for (j12_User u : userTable) {
			if (u == null) { // 항상 객체는  null 체크 해주어야함 
				continue;
			}
			else if (u.getUsername().equals(username)) {// 등록과 조회에 사용가능 
				user = u;
				break;
			
					
				}
		}
		
		return user;
	}

	
}
