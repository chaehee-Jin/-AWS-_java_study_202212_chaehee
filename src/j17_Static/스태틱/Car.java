package j17_Static.스태틱;

import java.time.LocalDateTime;

public class Car {
	private static final int Now_YEAR = LocalDateTime.now().getYear();
	private static String CODE = "KIA-"+ Now_YEAR+  "-";
	private static int ai = 1;

	
	private String serialCode; // KIA- 2023-0000
	private String modelName;
//	private String kumho;
//	private String hundai;
//	private String kia;


//	public Car(int serialCode) {
//		serialCode = Code + ai;
//		ai++;
//	}

	public Car(String modelName) {
//       modelName = kumho;
//       modelName = hundai;
//       modelName = kia;
		
		serialCode = CODE + String.format("%4d", ai);
		ai++;
		this.modelName = modelName;
		

	}

	static int getAutoIncrement() {
		return ai;

	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}

}
