package j04_연산자;

public class Operation6 {

	public static void main(String[] args) {
		
		/*
		 *  시험 성적을 학점으로 계산하는 프로그램
		 *  정수 자료형 score변수 선언
		 *  88점으로 초기화
		 *  
		 *  문자자료형 grade변수 선언 
		 *  조건
		 *  score가 0점보다 작거나 100점보다 크면 X를 출력
		 *  score가 90 ~ 100점이면 A학점
		 *  score가 80 ~ 89점이면 B학점
		 *  score가 70 ~ 79점이면 C학점
		 *  score가 60 ~ 69점이면 D학점
		 *  score가 0 ~ 59점이면 F학점
		 *  
		 */
		
		int score = 99;
		int plus;
		//System.out.println("점수(88) : B학점");
		
		//char grade = score < 0 || score > 100 ? 'X' 
       //				: (score > 90) ||(score <100)? 'A'
      //				: (score > 80) ||(score <89)? 'B'
    //				:(score> 70) ||(score < 79)? 'C'
    //				: (score >60) ||(score < 69)?'D' : 'F';
		
		
		
			String grade = score < 0 || score > 100 ? "X"
								: score > 95 ? "A+"
								: score > 89 ?  "A"
							    : score > 85 ?  "B+"
								: score > 79 ? "B"
							    : score > 75 ? "C+"
								: score > 69 ?  "C"
								: score > 65 ?  "D+"
								: score > 59 ? "D"
								: "F";
							
				System.out.println( "점수 (" + score + "): " +  grade + "학점");
				
				System.out.println();
				
				
				
				
				
				char aa = (plus = score %  10) > 5 ? '+' : '\0';
				
				char grade1 = score < 0 || score > 100 ? 'X'
					
						: score > 89 ?  'A'
						: score > 79 ? 'B'
						: score > 69 ?  'C'
						: score > 59 ? 'D'
						: 'F';
						
						System.out.println("점수("+ score + "): " + grade1 + aa+ "학점");
				
						
						// char plus = score > 100 || score < 60 ? '\0' : score % 10 > 4 || score ==100 ? '+' : '\0';
		
		
		
		
		
		
		
		
		
		

	}

}
