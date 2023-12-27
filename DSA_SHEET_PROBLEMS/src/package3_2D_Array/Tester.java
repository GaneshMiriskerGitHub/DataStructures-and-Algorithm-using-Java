package package3_2D_Array;

import java.util.Arrays;
import java.util.Stack;

public class Tester { // Next smaller element

	public static void maxRectangleHistogram(int[] arr) {

		int[] ns = new int[arr.length];
		int[] ps = new int[arr.length];

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			int currEle = arr[i];
			while (!st.isEmpty() && arr[st.peek()] >= currEle) {
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

		for (int i = arr.length - 1; i >= 0; i--) {
			int currEle = arr[i];
			while (!st.isEmpty() && arr[st.peek()] >= currEle) {
				st.pop();
			}

			if (st.isEmpty()) {
				ns[i] = -1;
				st.add(i);
			} else {
				ns[i] = st.peek();
				st.add(i);
			}

		}

		System.out.println(Arrays.toString(ps));
		System.out.println(Arrays.toString(ns));

		int maxArea = 0;
		int width = 1;
		for (int i = 0; i < arr.length; i++) {
			int currArea = (ns[i] - ps[i] - 1) * arr[i];
			maxArea = Math.max(maxArea, currArea);
		}

		System.out.println(maxArea);

	}

	public static void main(String[] args) {

		int[] arr = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };

		maxRectangleHistogram(arr);
	}

}
