package package5_Sorting;

import java.util.Arrays;

public class P2_Selection_Sort {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectionSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			int minPos = i;
			for(int j=i+1;j<arr.length-1;j++) {
				if(arr[j]<arr[minPos]) {
					minPos = j;
				}
			}
			swap(arr, i, minPos);
		}
		
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 1, 2, 3 };
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
