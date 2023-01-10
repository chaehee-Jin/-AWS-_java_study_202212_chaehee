package j13_상속.casting;

public class Main {
	public static void main(String[] args) {
		View view = new UpdateView();
		view.show();
		
		
		Controller controller = new Controller(new MainView());
		controller.run();
		
		System.out.println("프로그램 종료");
		}
	}

