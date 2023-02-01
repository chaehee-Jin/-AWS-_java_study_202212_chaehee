package 산대특_test_프로그래밍언어응용;

//	private static Factory instance = new Factory();
//
//	private Factory() {
//
//	}
//
//	public static Factory getInstnace() {
//		return instance;
//	}
class Factory {

	private String factoryName;

	private Factory() {
	};

	private static Factory instance = null;

	public static Factory getInstance() {

		if (instance == null) {

			instance = new Factory();

		}

		return instance;

	}

}

//	private static Factory instnace = null;
//	private String factoryName;
//	private Factory() {}
//	
//	public static Factory getInFactory() {
//		if(instnace == null) {
//			
//		}
//		return instnace;
//		
//	}
//
//}
