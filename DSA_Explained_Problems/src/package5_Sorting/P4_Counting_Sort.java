package package5_Sorting;

import java.util.Arrays;

public class P4_Counting_Sort {
	
	public static void countingSort(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt(); 
		
		int[] count = new int[max+1];
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		
		int k = 0;
		for(int i=0;i<count.length;i++) {
			while(count[i] > 0) {
				arr[k] = i;
				count[i]--;
				k++;
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = { 4, 5, 1, 2, 3 };

		countingSort(arr);

		System.out.println(Arrays.toString(arr));

	}

}
