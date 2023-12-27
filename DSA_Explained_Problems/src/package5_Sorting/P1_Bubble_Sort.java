package package5_Sorting;

import java.util.Arrays;

public class P1_Bubble_Sort {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(int[] arr) {
		
		boolean swapped = false;
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 1, 2, 3 };
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
