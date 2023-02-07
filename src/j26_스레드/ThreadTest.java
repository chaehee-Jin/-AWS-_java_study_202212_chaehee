package j26_스레드;

public class ThreadTest {

	public static void main(String[] args) { // 스레드는 우선순위가 다 동일하다 그래서 무작위하게 출력된다
		// 숫자가 클수록 우선순위가 높다

		LoopThread loopThread1 = new LoopThread("김상현");
		LoopThread loopThread2 = new LoopThread("강대협");
		LoopThread loopThread3 = new LoopThread("손지호");
		LoopThread loopThread4 = new LoopThread("김재영");

		System.out.println(loopThread1.getPriority());
		System.out.println(loopThread2.getPriority());
		System.out.println(loopThread3.getPriority());
		System.out.println(loopThread4.getPriority());

		loopThread1.start();
		loopThread2.start();
		loopThread3.start();
		loopThread4.start();

	}

}
