package Type3_Unbounded_Knapsack;

/*
 * Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
 */

public class P3_Coin_Change {
	
	// submission link:- https://practice.geeksforgeeks.org/problems/coin-change2448/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

	public static int noOfWays(int[] coins, int sum) { // same unbounded knapsack copy paste but we store both include + exclude

		int[][] dp = new int[coins.length + 1][sum + 1];

		for (int i = 0; i < dp.length; i++) { // no coins and no target
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (j >= coins[i - 1]) {
					int include = dp[i][j - coins[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = include + exclude;
				} else {
					int exclude = dp[i - 1][j];
					dp[i][j] = exclude;
				}
			}
		}

		return dp[coins.length][sum];

	}

	public static void main(String[] args) {

		int[] coins = { 1, 2, 3 };
		int sum = 4;

		System.out.println(noOfWays(coins, sum));

	}

}
