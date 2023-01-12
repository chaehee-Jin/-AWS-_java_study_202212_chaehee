package j01_출력;

import j17_Static.스태틱.싱글톤.KIA;

public class HelloJava {
		// TODO Auto-generated method stub
		
		// 주석: 코드 내부에 메모를 할 때 사용함 
		// 컴파일 시에 무시됨
		// tab 들여쓰기
		// 한 줄 주석 
		/*
		  *  여러줄 주석
		  */
		/**
		 *    클래스, 메소드 등의 정보를 설명하기 위한 주석 
		 */
	// 프로그램의 시작점
		public static void main(String[] args) {
			System.out.println("Hello, Java!!"); // 한줄의 문자열을 출력후 끝에 줄바꿈을 해라
			System.out.println("이름: 진채희");
			System.out.println("주소: 창원시 진해구 용원동 ");	
			System.out.println("연락처: 010-9442-0688");
			System.out.println("수업: AWS기반 공공빅데이터 활용 웹개발자 양성");
			
			System.out.println();
			
			KIA.getInstance().printCompanyName();
			
		}
		

	}


