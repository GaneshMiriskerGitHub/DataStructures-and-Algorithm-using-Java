package package5_Sorting;

import java.util.Arrays;

public class P5_Merge_Sort {
	
	public static void mergeSort(int[] arr, int s, int e) {
		
		if(s>=e) return;
		
		int m = s+(e-s)/2;
		
		mergeSort(arr, s, m);
		mergeSort(arr, m+1, e);
		
		merge(arr, s, m, e);
	}
	
	public static void merge(int[] arr, int s, int m, int e) {
		int[] temp = new int[e-s+1];
		
		int i=s;
		int j=m+1;
		int k=0;
		while(i<=m && j<=e) {
			if(arr[i]<arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		
		while(i<=m) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		
		while(j<=e) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		for(k=0;k<temp.length;k++) {
			arr[s] = temp[k];
			s++;
		}
		
		
	}

	public static void main(String[] args) {
		
		int[] arr = { 4, 5, 1, 2, 3 };
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}

}
