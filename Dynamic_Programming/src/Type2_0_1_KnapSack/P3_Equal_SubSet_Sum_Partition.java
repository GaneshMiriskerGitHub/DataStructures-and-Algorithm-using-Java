package Type2_0_1_KnapSack;

import java.util.Arrays;

/*
 * is it possible to divide the array in a way that both is same target value
 */

public class P3_Equal_SubSet_Sum_Partition { // https://www.youtube.com/watch?v=dJmyfFC3-3A
	   
	                                         // Previous solution copy paste

	public static boolean canPartition(int[] nums) {

		int sum = Arrays.stream(nums).sum();

		if (sum % 2 != 0) { // if entire array total is odd then obviosly not possible
			return false;
		}

		int target = sum / 2;

		return subSetSum(nums, target); // Previous solution copy paste

	}

	public static boolean subSetSum(int[] nums, int target) {

		boolean[][] dp = new boolean[nums.length][target + 1];

		for (int i = 0; i < nums.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 0; i < target + 1; i++) {
			if (nums[0] == i) {
				dp[0][i] = true;
			}
		}

		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j < target + 1; j++) {
				if (nums[i] <= j) { // if current element is greater than the target
					int currTarget = j;
					int currEle = nums[i];
					boolean include = dp[i - 1][currTarget - currEle]; // after including the element is it possible
																		// previosuly ?
					boolean exclude = dp[i - 1][j]; // if excluded then was the same target achived previously ?
					dp[i][j] = include || exclude;
				} else {
					boolean exclude = dp[i - 1][j];
					dp[i][j] = exclude;
				}
			}
		}

		return dp[nums.length - 1][target];

	}

	public static void main(String[] args) {

		int[] arr2 = { 2, 2, 1, 1 };
		System.out.println(canPartition(arr2));

	}

}
