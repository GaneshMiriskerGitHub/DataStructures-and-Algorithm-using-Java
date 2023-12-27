package Type4_LCS_Longest_Common_SubSequence;

public class P4_Edit_Distance {

	// submission link:-
	// https://practice.geeksforgeeks.org/problems/edit-distance3702/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

	public static int minOperations(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// add
					int addOp = 1 + dp[i][j - 1];
					// delete
					int deleteOp = 1 + dp[i - 1][j];
					// replace
					int replaceOp = 1 + dp[i - 1][j - 1];

					dp[i][j] = Math.min(addOp, Math.min(replaceOp, deleteOp));
				}
			}
		}

		return dp[word1.length()][word2.length()];

	}

	public static void main(String[] args) {

		String word1 = "intention";
		String word2 = "execution";

		System.out.println(minOperations(word1, word2));

	}

}
