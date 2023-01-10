package j15_인터페이스;

public class Main {

	public static void main(String[] args) {
		Equipment[] equipments = new Equipment[2];

		equipments[0] = new GeneralCalculator();
		equipments[1] = new Smartphone();

		Calculator calculator = new Computer();

		System.out.println("모든 장비 전원 키기");
		for (Equipment eq : equipments) {
			eq.powerOn();

		}
		System.out.println();
		System.out.println("모든 장비에서 10과 20을 더하기");
		for (Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.plus(10, 20);
			System.out.println("결과: " + result);
		}
		System.out.println();

		System.out.println("모든 장비에서 10과 2을 나누기");
		for (Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.division(10, 2);
			System.out.println("결과: " + result);
		}
		System.out.println();
		System.out.println("모든 장비 전원 끄기");
		for (Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
	}
}
