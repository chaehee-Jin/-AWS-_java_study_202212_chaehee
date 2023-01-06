package j12_배열;

public class Array5 {

	public static void trnasferArray(int[] oldArray, int[] newArray) { // 새로운 Array에 기존의 oldArray를 계속 옮김 
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}

	}

	public static int[] addArrayLength(int[] array) { // 기존배열을 그대로 전달 + 1 = 새로운 배열을 만듬 
		int[] newArray = new int[array.length + 1]; // 배열 (기존 0배열, 새로운 배열 2개 생성)
		return newArray;

	}

	public static int[] addData(int[] array, int data) { // 배열과 새로 추가할 데이터를 받음 
		int[] newArray = addArrayLength(array); // 길이를 추가함 
		newArray[array.length] = data;
		return newArray;
	}

	public static void main(String[] arrgs) {
		int[] nums = new int[0];
		nums = addData(nums, 1);  //항상 데이터는 맨 끝에 들어감 
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		
	addData(nums, 1);
	for(int i =0; i< nums.length;) {
		System.out.println(nums[i]);
		
		
			
		}
		
	}

	}
