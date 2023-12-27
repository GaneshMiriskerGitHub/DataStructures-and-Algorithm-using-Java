package package2_Arrays;

import java.util.Arrays;

public class P4_Reverse_The_Array {

	public static void reverseArray(int[] arr) {

		int s = 0;
		int e = arr.length - 1;
		while (s < e) {
			int temp = arr[e];
			arr[e] = arr[s];
			arr[s] = temp;
			s++;
			e--;
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		
		reverseArray(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
