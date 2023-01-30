
public class Main {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();

		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.sub(200, 100));

	}
	
	
	// 활용 2번 답
	//  ArrayIndexOutOfBoundsException은 메모리에 할당된 배열공간 크기를 벗어난 인딕스를 참조했을 때 발생하는 오류이다.
	// 해당 리스트의 공간의 크기는 3개이지만 메소드에서 length의 길이가 4로 설정되어있어, 4개의 공간을 참조하게 된다.
	// 따라서 length의 길이를 3으로 설정하면 된다.  

}
