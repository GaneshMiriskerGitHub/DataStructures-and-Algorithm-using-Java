package package5_BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {
	private static String maxNumber;

	public static String maxNumberByKSwaps(String num, int k) {
		maxNumber = num;
		backtrack(num.toCharArray(), k);
		return maxNumber;
	}

	private static void backtrack(char[] arr, int k) {
		if (k == 0) {
			String currentNumber = new String(arr);
			if (currentNumber.compareTo(maxNumber) > 0) {
				maxNumber = currentNumber;
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					swap(arr, i, j);
					backtrack(arr, k - 1);
					swap(arr, i, j); // Backtrack to the original state
				}
			}
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		String num = "4551711527";
		int k = 3;
		String result = maxNumberByKSwaps(num, k);

		System.out.println(result); // Output: "54321"
	}
}
