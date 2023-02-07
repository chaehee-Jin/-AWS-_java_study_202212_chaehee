package 산대특_test_프로그램활용답;

import java.util.ArrayList;
import java.util.List;

import j15_인터페이스.Calculator;

interface Wifi {
	public void connected();
}

class SmartPhone implements Wifi {

	@Override
	public void connected() {
		System.out.println("스마트폰을 와이파이에 연결합니다");

	}

	public void call() {
		System.out.println("상대방에게 음성통화를 연결합니다");

	}
}

class Laptop implements Wifi{

	@Override
	public void connected() {
		System.out.println("노트북을 와이파이에 연결합니다");

	}

	public void onSavingMode() {
		System.out.println("절전 모드를 활성화합니다");
	}
}


//}
//
//class Equipment {
//	public static void main(String[] args) {
//		List<Wifi> devices = new ArrayList<>();
//		devices.add(new SmartPhone());
//		devices.add(new Laptop());
//
//		for (Wifi device : devices) {
//			Deque[] devices1 = new Deque[2];
//			devices1[0] = (Deque) new SmartPhone();
//			devices1[1] = (Deque) new Laptop();
//
//			if (devices1[0].getClass() == Equipment.class) {
//				SmartPhone sp = (SmartPhone) devices1[0];
//
//			} else if (devices1[1].getClass() == Laptop.class) {
//
//				Laptop lp = (Laptop) devices1[1];
//
//			}
//
//		}
//
//	}
// 선생님 정답 
public class Main4 {
	public static void main(String[] args) {
		List<Wifi> devices = new ArrayList<>();
		devices.add(new SmartPhone());
		devices.add(new Laptop());

		for (Wifi device : devices) {
			device.connected();
			if (device.getClass() == SmartPhone.class) {
				SmartPhone smartPhone = (SmartPhone) devices;
				smartPhone.call();
			}else if(device.getClass() == Laptop.class) {
				Laptop laptop = (Laptop) device;
				laptop.onSavingMode();
				
				

			}
		}

	}

}
