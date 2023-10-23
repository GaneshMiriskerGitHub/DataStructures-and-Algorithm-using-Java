package package2_Arrays;

import java.util.Arrays;

public class P7_Maximum_SubArray_Sum {

	// for loop
	public static int maxSubarraySum1(int[] arr) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int currSum = 0;
				for (int k = i; k <= j; k++) {
					currSum += arr[k];
				}
				max = Math.max(max, currSum);
			}
		}

		return max;
	}

	// prefix
	public static int maxSubarraySum2(int[] arr) {

		int max = Integer.MIN_VALUE;
		
		int[] leftSum = new int[arr.length];
		leftSum[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			leftSum[i] = arr[i]+leftSum[i-1];
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int currSum = 0;
				currSum = i==0 ? leftSum[j] : leftSum[j] - leftSum[i-1];
				max = Math.max(max, currSum);
			}
		}

		return max;
	}
	
	// Kadane's
	public static int maxSubarraySum3(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		
		int currSum = 0;
		for(int i=0;i<arr.length;i++) {
			currSum+=arr[i];
			if(currSum<0) {
				currSum=0;
			}
			max = Math.max(max, currSum);
		}
		
		return max;
		
	}

	public static void main(String[] args) {

		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		System.out.println(maxSubarraySum1(arr));
		System.out.println(maxSubarraySum2(arr));
		System.out.println(maxSubarraySum3(arr));

	}

}
