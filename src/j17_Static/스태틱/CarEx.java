package j17_Static.스태틱;

public class CarEx {

	public static void main(String[] args) {
		
		
		Car[] cars = new Car[3];
		cars[0] = new Car("kia");
		cars[1]= new Car("hundai");
		cars[2]= new Car("kumho");
		
//		for(int i=0; i<cars.length; i++) {
//			System.out.println(cars[i]);
//			System.out.println();
//		}
		
		for(Car c : cars) {
			System.out.println(c);
			
		}
		System.out.println(Car.getAutoIncrement());

	}

}
