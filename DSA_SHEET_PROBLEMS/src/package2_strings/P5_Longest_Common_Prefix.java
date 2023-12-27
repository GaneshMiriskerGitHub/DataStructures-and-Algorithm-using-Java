package package2_strings;

import java.util.Arrays;

public class P5_Longest_Common_Prefix {

	public static void printCommonPrefix(String[] arr) {
		Arrays.sort(arr);

		String str1 = arr[0];
		String str2 = arr[arr.length - 1];
		int n = Math.min(str1.length(), str2.length());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				sb.append(str1.charAt(i));
			}
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) {

		String[] arr = { "flower", "flow", "flight" };
		
		printCommonPrefix(arr);

	}

}
