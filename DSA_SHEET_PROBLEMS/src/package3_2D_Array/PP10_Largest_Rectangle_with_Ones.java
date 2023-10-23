package package3_2D_Array;

import java.util.Stack;

public class PP10_Largest_Rectangle_with_Ones { // MAY BE DYNAMIC PROGRAMMING
	
//	step 1:- https://www.youtube.com/watch?v=_RtghJnM1Qo
//	step 2:- https://www.youtube.com/watch?v=vhUxKxiconE
//	step 3:- https://www.youtube.com/watch?v=oaN9ibZKMpA&t=578s

	public static int maxHistogram(int[] heights) {

		int n = heights.length;

		int[] ns = new int[n];
		int[] ps = new int[n];

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				ps[i] = -1;
				st.add(i);
			} else {
				ps[i] = st.peek();
				st.add(i);
			}
		}
		st.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				ns[i] = n;
				st.add(i);
			} else {
				ns[i] = st.peek();
				st.add(i);
			}
		}

		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, ((ns[i] - ps[i] - 1) * heights[i]));
		}

		return maxArea;
	}

	public static int maxRectangle(int[][] arr) {

		int[] currRow = new int[arr[0].length];

		int maxArea = maxHistogram(currRow);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					currRow[j] += 1;
				} else {
					currRow[j] = 0;
				}
			}
			maxArea = Math.max(maxArea, maxHistogram(currRow));
		}

		return maxArea;

	}

	public static void main(String[] args) {

		int A[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };

		System.out.println(maxRectangle(A));

	}

}
