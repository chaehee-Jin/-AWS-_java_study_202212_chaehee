package j24_람다;

@FunctionalInterface // 함수형 인터페이스, 람다를 의미
public interface Instrument {

	public String play(String instrument);
	
	public default void testPrint() {// 디폴트 메소드는 몇개라도 상관없음 
		System.out.println("테스트");
	}

}
