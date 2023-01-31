package 산대특_test_프로그래밍언어응용;

public class Factory {

//	private static Factory instance = new Factory();
//
//	private Factory() {
//
//	}
//
//	public static Factory getInstnace() {
//		return instance;
//	}
	
	private static Factory instnace = null;
	private String factoryName;
	private Factory() {}
	
	public static Factory getInFactory() {
		if(instnace == null) {
			
		}
		return instnace;
		
	}

}
