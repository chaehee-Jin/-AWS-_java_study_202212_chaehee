package j13_상속;

public class ExtendsMain {

	public static void main(String[] args) {

		KiaCar kiacar = new KiaCar();
		kiacar.setPrice(30000000);
	
		System.out.println(kiacar);
		
		System.out.println(kiacar.getPrice());
		System.out.println(kiacar.discountPrice(20));
		
	
		

	}

}
