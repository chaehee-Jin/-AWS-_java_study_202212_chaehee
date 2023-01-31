package j24_람다;

public class Lambda1 {

	public static void main(String[] args) {
		Instrument instrument = new Instrument() {

			@Override
			public String play(String instrument) {

				return instrument + "을 연주합니다";
			}
		};

		// 람다를 사용할 수 있는 인터페이스: 추상메소드를 딱 하나 가진 메소드
		// 딱 하나의 메소드만 가지고 있음
		Instrument instrument2 = (String itm) -> { // 화살표 함수
			return itm + "을 연주합니다";

		};
		// 매개변수의 자료형을 생략할 수 있다
		// 매개변수의 이름을 바꿀수 있다.
		Instrument instrument3 = (String itm) -> { // 화살표 함수
			return itm + "을 연주합니다";

		};
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다
		Instrument instrument4 = (String itm) -> { // 화살표 함수
			return itm + "을 연주합니다";
		};
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다
		// 이때 리턴자료형이 정해져있으면 리턴값으로 사용이 된다
		// 람다에서 중관호를 생략했다는 것은 무조건 리턴을 생략해야 한다는 의미이다

		Instrument instrument5 = itm -> itm + "을 연주합니다"; // 화살표 함수

		int result = 10 + 20;
		Instrument instrument6 = itm -> itm + "을 연주합니다" + result;

		System.out.println(instrument2.play("피아노"));

		String playText = instrument.play("드럼");
		System.out.println(playText);
		/*
		 * 람다의 장점: 
		 * 1. 람다를 사용하면 람다를 정의하고 호출하는 생성부분이 메인 메소드안에 존재할 경우 메인 메소드안에서 사용하는 지역변수까지도
		 * 람다식에서 사용가능하다 
		 * 단 전역에서 같은 이름의 매개변수는 사용이 불가능하다
		 * 
		 * 2. 간결해진다
		 * 
		 * 3. 익명클래스와 동일하다, 한번만 정의해서 쓴다
		 *단 익명클래스와 다른점은 익명클래스는 메소드를 여러개 정의해서 사용할 수 있다 
		 *
		 * 
		 * 
		 * 
		 */

	}

}
