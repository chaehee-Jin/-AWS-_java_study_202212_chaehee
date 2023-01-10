package j13_상속;

public class KiaCar extends Car {

	public KiaCar() {
		super();// super의 생성자 호출 , 부모의생성자를 호출 
		
		System.out.println("자식");
	
		
	}
	@Override
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage); // 주소가 다름 그래서 같은 이름을 쓸수 있는 것 
	}
	
}
