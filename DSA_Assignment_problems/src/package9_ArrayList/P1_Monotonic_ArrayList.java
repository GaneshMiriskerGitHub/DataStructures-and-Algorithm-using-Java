package package9_ArrayList;

import java.util.Arrays;
import java.util.Comparator;

/*
 * an array is monotonic if it is in asc or desc in order
 */

public class P1_Monotonic_ArrayList {
	
	// submission link:- https://leetcode.com/problems/monotonic-array/

	public static boolean isMonotonic(int[] nums) {

		int n = nums.length;

		boolean ans1 = true;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				ans1 = false;
			}
		}

		boolean ans2 = true;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				ans2 = false;
			}
		}

		return ans1 || ans2;

	}

	public static void main(String[] args) {

	}

}
