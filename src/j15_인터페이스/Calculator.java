package j15_인터페이스;

public interface Calculator {
	
	public int ERROR = -9999999;
	
	public double plus(double x, double y);
	public double minus(double x, double y );
	
	public default  double multiplication(double x, double y) {
		return x*y;
	}
	double division(double x, double y);
	

}
