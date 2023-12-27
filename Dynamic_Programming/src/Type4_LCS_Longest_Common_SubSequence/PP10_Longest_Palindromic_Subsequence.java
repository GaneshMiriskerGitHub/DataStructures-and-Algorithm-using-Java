package Type4_LCS_Longest_Common_SubSequence;

public class PP10_Longest_Palindromic_Subsequence {

	/*
	 * 1. palindrome in the sense, isn't it something like reverse also represents
	 * the same ? 2. so can we not say that LPS of a String is nothing but, LCS of
	 * the same string and reverse of the same string isn't it
	 */

	// Tabulation
	public static int maxSubSequenceTabulation(String str1, String str2) {

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int choice1 = dp[i - 1][j];
					int choice2 = dp[i][j - 1];
					dp[i][j] = Math.max(choice1, choice2);
				}
			}
		}

		return dp[str1.length()][str2.length()];

	}

	public static void main(String[] args) {

		String str1 = "bbbab";

		String revStr = new StringBuilder(str1).reverse().toString();

		System.out.println(maxSubSequenceTabulation(str1, revStr));

	}

}
