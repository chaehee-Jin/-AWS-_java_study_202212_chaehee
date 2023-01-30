package 산대특_test_프로그래밍언어활용;

abstract class Program {
	public abstract void develop();
}

class Java extends Program {

	@Override
	public void develop() {
		System.out.println("자바 프로그램을 개발합니다");

	}

	public void garbageCollection() {
		System.out.println("메모리를 정리합니다");
	}

}

class C extends Program {

	@Override
	public void develop() {
		System.out.println("C 프로그램을 시작합니다");

	}

	public void defineStructure() {
		System.out.println("구조체를 정의합니다");
	}

}

public abstract class Casting {

	public static void main(String[] args) {
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();

		for (int i = 0; i < programs.length; i++) {
			programs[i].develop();
			if (programs[i].getClass() == Java.class) {
				Java java = (Java) programs[i];
				java.garbageCollection();

			} else if (programs[i].getClass() == C.class) {

				C c = (C) programs[i];
				c.defineStructure();

			}

		}
	}

}
