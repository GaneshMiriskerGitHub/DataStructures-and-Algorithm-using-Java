package package8_Greedy;

import java.util.Arrays;

public class P3_Minimsum_of_numbers {

	public static String removeZeroes(String str) {
		int i = 0;
		while (i < str.length() && str.charAt(i) == '0') {
			i++;
		}
		return str.substring(i);
	}

	public static void printMinimumSum(int[] arr) {

		Arrays.sort(arr);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		boolean flag = true;

		for (int ele : arr) {
			if (flag == true) {
				sb1.append(ele);
				flag = false;
			} else {
				sb2.append(ele);
				flag = true;
			}
		}

		String str1 = sb1.toString();
		String str2 = sb2.toString();

		str1 = removeZeroes(str1);
		str2 = removeZeroes(str2);
		
		
//		System.out.println(str1);
//		System.out.println(str2);
		
		
		System.out.println(Long.parseLong(str1)+Long.parseLong(str2));

	}

	public static void main(String[] args) {

		int[] arr = { 6, 8, 4, 5, 2, 3 };

		printMinimumSum(arr);

	}

}
