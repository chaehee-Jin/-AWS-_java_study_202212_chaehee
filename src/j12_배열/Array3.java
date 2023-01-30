package j12_배열;

import java.util.Random;

public class Array3 {

	public static void main(String[] args) {
		Random random = new Random();
		int[] nums = new int[10];
		
//		for( int i= 0; i< nums.length; i++) {
//			nums[i] = i;
//			
//		}
		for(int i=0; i<nums.length; i++) {
			//while의 무한루프 
			while(true) {
				boolean findFlag = true;  
				int randomNum= random.nextInt(nums.length) + 1; //변수에 넣지않으면 위, 아래 두개가 다른값으로 나온다
				//1~10까지 렌덤하게 나와야해서 +1
				
				// 선형탐색
				for(int j=0; j < nums.length; j++) {  //0~9까지 반복 
					if(nums[j] == randomNum) {
						findFlag = false; //일치하지 않아야 다시 위로 올라가서 새로 렌덤한 값을 할당 
						break;
					}
				}
				
				if(findFlag == true) { //변수, 자료형이 분리형 
					nums[i] = randomNum; 
					break; // while의 무한루프를 멈추는 break
				}
			}
			
			}
		for(int i = 0; i<nums.length; i++){
		System.out.println(nums[i]);
	
		}
	}
}
