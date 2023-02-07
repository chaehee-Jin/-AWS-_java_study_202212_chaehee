package 산대특_test_프로그램응용답;

public class School {
	private static School instance = null;
	private String schoolName;

	private School() {}

	public static School getInstance() {
		if (instance == null) {
			instance = new School();

		}
		return instance;

	}

}
