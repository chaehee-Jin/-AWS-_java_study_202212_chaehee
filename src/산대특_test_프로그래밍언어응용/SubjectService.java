package 산대특_test_프로그래밍언어응용;

import java.util.Arrays;
import java.util.List;

public class SubjectService {

	private List<String> subjects;

	public SubjectService(List<String> subjects) {
		this.subjects = subjects;
	}

	public void showSubjects() {
		int length = 4;
		for (int i = 0; i < length; i++) {
			System.out.println(subjects.get(i));

			try {
				throw new NullPointerException();

			} catch (NullPointerException e) {
				System.out.println("빈 값을 처리함 ");

			}

		}
	}

}

//public class Main {
//	public static void main(String[] args) {
//		List<String> subjects = Arrays.asList(new String[] { "C", "Java", "Python" });
//		SubjectService subjectService = new SubjectService(subjects);
//		subjectService.showSubjects();
//
//	}

//}
