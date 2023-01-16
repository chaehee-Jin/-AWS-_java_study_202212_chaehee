package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("username", "aaa");
		dataMap.put("passowrd", "1234");
		dataMap.put("name", "김준일");
		dataMap.put("email", "aaa@naver.com");

		List<String> hobby = new ArrayList<>();
		hobby.add("골프");
		hobby.add("축구");
		hobby.add("농구");
		hobby.add("음악감상");
		// 가상의 임시객체를 사용 , 임시로 객체를 지정해서 사용, get을 사용하여 객체를 불러옴
		// 변수들이 object형으로 되어있다

		dataMap.put("hobbys", hobby);
		System.out.println(dataMap);

		List<String> list = (List<String>) dataMap.get("hobbys");
		System.out.println(list.get(0));

	}

}
