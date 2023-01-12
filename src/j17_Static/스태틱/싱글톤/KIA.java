package j17_Static.스태틱.싱글톤;

public class KIA {

	private static KIA instance = null;

	private KIA() {}
	
	public static KIA getInstance() {
		if (instance == null) {
			instance = new KIA(); //생성해서 넣는다 , 한번만 생성 그 이후로는 생성하지 않음 

		}
		return instance;
	}

	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
}
