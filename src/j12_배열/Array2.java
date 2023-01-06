package j12_배열;

public class Array2 {
	
	public static void printNames(String[] names) {
		for(int i=0; i< names.length; i++) {
			System.out.println("이름["+ (i+1)+"]:"+names[i]);
			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//들어갈 값이 정해져 있지 않을때, 값의 공간이 정확히 정해져 있을 때 
		//배열을 미리 만들어 놓고 나중에 변수를 넣음 
		String[] names = new String[3];
		names[0] = "진채희";
		names[1] = "임나영";
		names[2] = "김종환";
		
		// 매개변수를 사용할때 , 크기가 지정되지 않음 
	String[] names2 = new String[] {"이상현", "손지효", "이강웅"};

	//2번을 줄인것 , 어딘가에 넣지 않고 바로 배열, 크기가 지정되지 않아서 숫자를 사용하면 안된다 
	String[] names3 = {"김두영", "강대협", "이현수, 김재영"};

	
			printNames(names);
			printNames( new String[] {"이상현", "손지효", "이강웅"});
			printNames(names3);
		}
	}


