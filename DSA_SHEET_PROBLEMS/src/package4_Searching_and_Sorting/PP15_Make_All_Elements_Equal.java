package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PP15_Make_All_Elements_Equal { // https://www.youtube.com/watch?v=Wo168YDPwzk
	
	public static void printNumberOfOperations(int[] arr) {
		
		Arrays.sort(arr);
		
		int s=0;
		int e=arr.length-1;
		
		int noOfOperations = 0;
		
		while(s<=e) {
			noOfOperations = noOfOperations + (arr[e]-arr[s]);
			e--;
			s++;
		}
		
		System.out.println(noOfOperations);
	}
	
	public static void costOfArrayEqualElements(int[] arr) { // my own solution
		Arrays.sort(arr);
		int s=0;
		int e=arr.length-1;
		int mid = s+(e-s)/2;
		
		int optimalValue = 0;
		if(arr.length % 2 == 0) {
			optimalValue = (arr[mid]+arr[mid+1])/2;
		}else {
			optimalValue = arr[mid];
		}
		
		int cost=0;
		while(s<=e) {
			cost+=Math.abs(optimalValue-arr[s]);
			cost+=Math.abs(optimalValue-arr[e]);
			s++;
			e--;
		}
		
		System.out.println(cost);
	}

	public static void main(String[] args) {
		
		int[] arr = {4, 6};
		
		printNumberOfOperations(arr);
		
		costOfArrayEqualElements(arr);

	}

}
