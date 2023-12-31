package packagee11_Stacks;

import java.util.Arrays;
import java.util.Stack;

public class P8_Next_Greater_Element {

	public static int[] nextGreater(int[] arr) {
		Stack<Integer> st = new Stack<>();

		int[] res = new int[arr.length];

		st.push(arr.length - 1);
		res[arr.length - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			int curr = arr[i];

			while (!st.isEmpty() && curr >= arr[st.peek()]) {
				st.pop();
			}

			if (st.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = st.peek();
			}

			st.push(i);

		}

		return res;
	}

	public static int[] prevGreater(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];

		st.push(0);
		res[0] = -1;

		for (int i = 1; i < arr.length; i++) {

			int curr = arr[i];

			while (!st.isEmpty() && curr >= arr[st.peek()]) {
				st.pop();
			}

			if (st.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = st.peek();
			}

			st.push(i);

		}

		return res;
	}

	public static int[] nextSmaller(int[] arr) {
		Stack<Integer> st = new Stack<>();

		int[] res = new int[arr.length];

		st.push(arr.length - 1);
		res[arr.length - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			int curr = arr[i];

			while (!st.isEmpty() && curr <= arr[st.peek()]) {
				st.pop();
			}

			if (st.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = st.peek();
			}

			st.push(i);

		}

		return res;
	}

	public static int[] prevSmaller(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];

		st.push(0);
		res[0] = -1;

		for (int i = 1; i < arr.length; i++) {

			int curr = arr[i];

			while (!st.isEmpty() && curr <= arr[st.peek()]) {
				st.pop();
			}

			if (st.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = st.peek();
			}

			st.push(i);

		}

		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 6, 8, 0, 1, 3 };

//		int[] res = nextGreater(arr);

//		int[] res = prevGreater(arr);

//		int[] res = nextSmaller(arr);

		int[] res = prevSmaller(arr);

		System.out.println(Arrays.toString(res));

	}

}
