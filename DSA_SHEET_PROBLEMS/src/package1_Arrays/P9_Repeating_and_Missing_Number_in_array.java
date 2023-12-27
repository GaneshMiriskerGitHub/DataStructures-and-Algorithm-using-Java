package package1_Arrays;

import java.util.Arrays;

public class P9_Repeating_and_Missing_Number_in_array {
	
	public static void repeatingAndMissing(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			int index = Math.abs(arr[i]);
			if(arr[index-1] < 0) {
				System.out.println("repeating = "+ index);
			}else {
				arr[index-1] = arr[index-1]*-1;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		int missing = -1;
		for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }
		
		System.out.println("missing = "+ missing);
		
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {3, 1, 2, 5, 3};
		
		repeatingAndMissing(arr);

	}

}
