package 산대특_test_프로그램활용답;

class Car {

	private String company;
	private String model;
	private String color;

	public Car(String company, String model, String color) {
		this.company = company;
		this.color = color;
		this.model = model;

	}
//}
//
// class transport {
//	public static void mian(String[] args) {
//		Car car = new Car("현대자동차", "그랜저", "화이트");
//		System.out.println(car);
//
//	}

//	private String company;
//	private String model;
//	private String color;
//
//	@Override
//	public String toString() {
//
//		return "[자동차 정보]" + "\ncompany: " + company + "\nmodel: " + model + "\ncolor: " + color;
//
//	}
	@Override
	public String toString() {
		return "[자동차 정보] 제조사: " + "\ncompany:" + company + "\nmodel:" + model + "\ncolor:" + color;
	}

}

public class Main5 {
	public static void main(String[] args) {
		Car car = new Car("현대자동차", "그랜저", "화이트");
		System.out.println(car);
	}
}
