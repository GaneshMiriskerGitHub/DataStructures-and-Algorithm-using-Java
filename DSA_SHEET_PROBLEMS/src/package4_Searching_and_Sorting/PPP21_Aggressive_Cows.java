package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PPP21_Aggressive_Cows {
	
	// problem statement:- 
	/*
	 * given an array, and noOfCows, 
	 * place the the cows at anyposition in the array, 
	 * you will be able to know distance between each cow and cow
	 * you need to place all the cows in array, in such a way that,
	 * take min distance found between two cows, in all scenarios(placements)
	 * now from all the scenarios , max of all is the answers
	 */
	
	// this is related to pattern of binary search algorithm
	
	public static int largestMinimumDistance(int[] arr, int noOfCows) {
		
		Arrays.sort(arr);
		
		int low = 1; // worst answer
		int high = arr[arr.length-1]-arr[0]; // worst answer
		
		int res = 0;
		
		while(low<=high) {
			
			int mid = (low+high)/2;
			
			if(canPlaceCows(arr, noOfCows, mid)) {
				res = mid;
				low=mid+1;
			}else {
				high = mid-1;
			}
			
		}
		
		return res;
		
	}
	
	public static boolean canPlaceCows(int[] arr, int noOfCows, int mid) {
		
		int previousCowPosition = arr[0];
		int noOfCowsPlaceTillNow = 1;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-previousCowPosition >= mid) {
				previousCowPosition = arr[i];
				noOfCowsPlaceTillNow++;
			}
			if(noOfCowsPlaceTillNow >= noOfCows) {
				return true;
			}
		}
		
		
		return false;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, 8, 9};
		
		int noOfCows = 3;
		
		System.out.println(largestMinimumDistance(arr, noOfCows));

	}

	

}
