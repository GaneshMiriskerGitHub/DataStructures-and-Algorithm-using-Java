package Type1_Fibbonacci;

import java.util.Arrays;

public class P3_House_Robber { // submission link:-
								// https://leetcode.com/problems/house-robber/submissions/1116883543/

	// Recursion
	public static int maxRob(int[] arr, int i) { // point to be noted , the base cases here are supposed to be updated
													// exactly as mentioned below
		if (i < 0)
			return 0;
		if (i == 1) {
			return arr[0];
		}

		return Math.max(arr[i] + maxRob(arr, i - 2), maxRob(arr, i - 1));
	}

	// tabulation
	public static int maxRob(int[] arr) {

		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
		}

		return dp[dp.length - 1];
	}

	// leetcode
	public static int rob(int[] nums) {
        return maxVal(nums);
    }

    public static int maxVal(int[] arr) {
		
		int n = arr.length;
		if(n == 0) return 0;
		if(n == 1) return arr[0];
		if(n == 2) return Math.max(arr[0], arr[1]);
		
		int[] dp = new int[arr.length];

		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < dp.length; i++) {
			int include = arr[i] + dp[i - 2];
			int exclude = dp[i - 1];
			dp[i] = Math.max(include, exclude);
		}
		
		return dp[arr.length-1];

	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 1 };

		System.out.println(maxRob(arr, arr.length - 1)); // failed few test cases
		System.out.println(maxRob(arr)); // failed few test cases
		System.out.println(rob(arr)); // passed all test cases

		Arrays.copyOf(arr, arr.length - 1);

	}

}
