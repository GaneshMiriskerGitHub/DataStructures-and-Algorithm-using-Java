package package1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PP20_Merge_Overlapping_Intervals {

	public static int[][] mergeOverlapping(int[][] arr) {

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		ArrayList<int[]> list = new ArrayList<>();

		int start = arr[0][0];
		int end = arr[0][1];
		for (int i = 1; i < arr.length; i++) {
			if (end >= arr[i][0]) {
				end = Math.max(end, arr[i][1]);
			} else {
				list.add(new int[] { start, end });
				start = arr[i][0];
				end = arr[i][1];
			}
		}
		list.add(new int[] { start, end });

		return list.toArray(new int[0][]);

	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };

		mergeOverlapping(arr);

	}

}
