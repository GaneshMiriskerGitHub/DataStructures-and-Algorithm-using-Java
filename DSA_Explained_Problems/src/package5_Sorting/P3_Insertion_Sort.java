package package5_Sorting;

import java.util.Arrays;

public class P3_Insertion_Sort {
	
	// learn 1 :- apna college
	// learn 2   :- https://www.youtube.com/watch?v=wWhAhp6PIuQ

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length-1;i++) {
			int tempValueOfCurrEle = arr[i];
			int j=i-1;  // left part will be from 0 to i-1;
			while(j>=0 && tempValueOfCurrEle < arr[j]) {
				arr[j+1] = arr[j];   // moving/shifting all elements to right side
				j--;
			}
			// after shifting all elements to right side // 1 place will be empty , here we will store temp value
			arr[j+1] = tempValueOfCurrEle;		
		}
		
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 1, 2, 3 };

		insertionSort(arr);

		System.out.println(Arrays.toString(arr));

	}

}
