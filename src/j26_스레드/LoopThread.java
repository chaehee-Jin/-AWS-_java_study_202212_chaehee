package j26_스레드;

public class LoopThread extends Thread {
	// 스레드자체를 객체로 커스텀하기 위해 상속

	private String threadName;

	public LoopThread(String threadName) {
		this.threadName = threadName; // 스레드는 런어블이라는 것과 항상 같이간다
		// 런어블에는 런메소드가 들어가있다, 실행을 목적으로 하는 메소드
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(threadName + ":" + i);
			try {
				Thread.sleep(1000); // 1초 자는것
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
