package package4_Searching_and_Sorting;

import java.util.Collections;

public class PPP22_Minimum_Pages_Alocation { // learning:- https://www.youtube.com/watch?v=BSihvQCh9-I
												// coding :-
												// https://www.geeksforgeeks.org/allocate-minimum-number-pages/

	public static int findPages(int[] A, int N, int M) {
		// Your code here

		if (N < M)
			return -1;

		int low = maxOf(A);
		int high = sumOf(A);

		int res = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (ok(A, M, mid)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return res;

	}

	public static boolean ok(int[] arr, int noOfStudents, int barrier) {
		int countOfStudents = 1;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum > barrier) {
				countOfStudents++;
				currSum = arr[i];
			}
		}

		if (countOfStudents <= noOfStudents) {
			return true;
		} else {
			return false;
		}
	}

	public static int maxOf(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int ele : arr)
			max = Math.max(max, ele);
		return max;
	}

	public static int sumOf(int[] arr) {
		int sum = 0;
		for (int ele : arr)
			sum += ele;
		return sum;
	}

}
