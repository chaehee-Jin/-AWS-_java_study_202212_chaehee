
public class Factory {

	private static Factory instance = new Factory();

	private Factory() {

	}

	public static Factory getInstnace() {
		return instance;
	}

}
