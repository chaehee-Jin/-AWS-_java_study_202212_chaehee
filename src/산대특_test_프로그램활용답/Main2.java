package 산대특_test_프로그램활용답;

import java.util.Arrays;
// ArrayindexOutOfBoundsException은 메모리에 할당된 배열공간 크기를 벗어난 index 참조를 하였을 때 발생하는 오류이다
// score 사이즈도 함께 확인 해주면 해결할 수 있다

import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(new String[] { "강대협", "김수현", "진채희" });
		List<Integer> score = Arrays.asList(new Integer[] { 95, 80, 85 });

		System.out.println("[성적 정보]");
		for (int i = 0; i < names.size(); i++) {
			if (i < score.size()) {
				System.out.println("이름: " + names.get(i) + "점수: " + score.get(i));
			}

		}
	}
}
