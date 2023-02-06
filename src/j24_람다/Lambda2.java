package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda2 {

	public static void main(String[] args) {

		// 1. Runnable - run()
		Runnable a = () -> System.out.println("하나만 실행");
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		};
		a.run();
		a.run();
		b.run();

		// 2. Supplier<T> - T get()
		Supplier<LocalDate> c = () -> LocalDate.now();
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyy년 MM월 dd일"));

		};
		System.out.println(c.get());
		System.out.println(d.get());

		// 3. Consumer<T> - void accept(T t)
		// 리턴없이 받기만 함

		Consumer<String> e = name -> {
			System.out.println("이름: " + name);
			System.out.println("오늘 날짜: " + d.get());
		};
		e.accept("이종현");

		// 메소드 참조 표현식 ([인스턴스] :: [ 메소드명 또는 new ])
		Consumer<String> f = System.out::println;
		f.accept("출력");

		List<String> names = new ArrayList<>();
		names.add("김동민");
		names.add("김두영");
		names.add("장진원");
		names.add("조병철");

		Consumer<String> g = name -> System.out.println("이름: " + name + "님");
		names.forEach(g);
		// this = names
		// names.forEach(name -> System.out.println("이름: " + name + "님"));
		// forEach 대신 for문을 돌려도 가능함

//		default void forEach(Consumer<? super String> action) {
//			Object.requireNonNull(action);
//			for(String t: this) {
//				action.accept(t);
//	}	
//	}
		names.forEach(name -> {
			System.out.println("이름을 출력합니다");
			System.out.println("이름: " + name);
			System.out.println();
		});

		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", "aaa");
		userMap.put("password", "1234");

		// 맵에서 키랑 벨류를 한쌍씩 꺼내서 사용
		userMap.forEach((key, value) -> {
			System.out.println("key:" + key);
			System.out.println("value:" + value);
			System.out.println();
		});
		// 위에 방법을 사용하지 않는 다면 사용해야할 다른 방식
		for (Entry<String, String> entry : userMap.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println("vlaue:" + entry.getValue());
			System.out.println();
		}
		// 4. Function<T, R>
		Function<String, Integer> h = num -> Integer.parseInt(num); // apply
		// apply를 Integer로 변환하여 넣어줌

		int convertStrNum1 = h.apply("10000");
		int convertStrNum2 = h.apply("20000");

		System.out.println(convertStrNum1 + convertStrNum2);

		// 5. Predicate<T>
		// 두개의 조건중 고르고 싶을 때
		Predicate<String> p = str -> str.startsWith("김");
		Predicate<String> p2 = str -> str.startsWith("이");

		// 람다를 직접 넣는 방법
		Function<Predicate<String>, Boolean> function1 = predicate -> predicate.or(str -> str.startsWith(" 이"))
				.test("김준일");
		boolean rs = function1.apply(str -> str.startsWith("김"));
		System.out.println(rs);

		List<String> nameList = new ArrayList<>();
		nameList.add("김종환");
		nameList.add("고병수");
		nameList.add("김상현");
		nameList.add("김준경");

		// Stream은 일회성으로 쓰인다
		// forEach는 하나씩 꺼내는 작업임으로 Stream 사용시 다 꺼내져서 안에 들어있는것이 없어 오류가떴다
		// 필터를 적용하면 참인것들만 필터에 걸러지면서 가져오게됨 
		Stream<String> stream = nameList.stream().filter(name -> name.startsWith("김"));
		// 이렇게 하면 list를 stream으로 변환하고 forEach를 사용가능하게 만들었음
		
		//stream.forEach(name -> System.out.println(name));
		List<String> newList = stream.collect(Collectors.toList());
		System.out.println(newList);
		
		newList.forEach(str ->  System.out.println(str));
		
		System.out.println("---------------------------------------------------------------");
		
		// 조건을 더 주려면 밖으로 빼야한다
		nameList.stream()
		.filter(name -> name.startsWith("김"))
		.collect(Collectors.toList())
		.forEach(System.out :: println);
		// .forEach(name -> System.out.println(name));

	
		// System.out.println(p.test("김준일"));
		System.out.println(p.test("이현수") || p2.test("이현수"));
		// 위에 꺼랑 결과는 같지만 다른 방법
		System.out.println(p.or(p2).test("박준일)"));

	}

}
