package package1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P7_NextPermutation {
	
	public static void nextPermutation(int[] arr) {
		
		// Step 1 : find pivot from right to left
		int pivot = -1;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i] < arr[i+1]) {
				pivot = i;
				break;
			}
		}
		System.out.println(pivot);
		if(pivot == -1) {
			reverse(arr, 0, arr.length-1);
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		// logic
		// for ith ele who is the immediate grater from right
		int j=arr.length-1;
		for(;j>=pivot+1;j--) {
			if(arr[j] > arr[pivot]) {
				break;
			}
		}
		
		swap(arr, pivot, j);
		
		reverse(arr, pivot+1, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void reverse(int[] arr, int s, int e) {
	    while (s < e) {
	        swap(arr, s, e);
	        s++;
	        e--;
	    }
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		
		nextPermutation(arr);

	}

}
