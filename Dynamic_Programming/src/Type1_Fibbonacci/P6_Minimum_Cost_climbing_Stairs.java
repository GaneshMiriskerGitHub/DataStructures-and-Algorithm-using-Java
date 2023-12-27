package Type1_Fibbonacci;

import java.util.Arrays;

public class P6_Minimum_Cost_climbing_Stairs {
	
	public static int minCost(int[] arr) {
		
		return Math.min(minCostHelper(arr, 0), minCostHelper(arr, 1));
		
	}
	
	public static int minCostHelper(int[] arr, int i) {
		if(i >= arr.length) {
			return 0;
		}
		if(i == arr.length-1) {
			return arr[i];
		}
		if(i == arr.length-2) {
			return Math.min(arr[i], arr[i]+arr[i+1]);
		}
		
		
		
		return Math.min(arr[i]+minCostHelper(arr, i+1), arr[i]+minCostHelper(arr, i+2));
	}
	
	
	
	// learning resource :- https://www.youtube.com/watch?v=OoGswqFU-zs
	// passed all test cases in leetcode 
	
	public static int minCostTab(int[] arr) {
		
		int n = arr.length;
		
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i] +  Math.min(arr[i-1], arr[i-2]); // fibonacci copy paste with slight modification arr[i] + Math...
		}
		
		System.out.println(Arrays.toString(arr));
		
		return Math.min(arr[n-1], arr[n-2]);
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,100,1,1,1,100,1,1,100,1};
		
		System.out.println(minCost(arr));
		
		System.out.println(minCostTab(arr));
	}

}
