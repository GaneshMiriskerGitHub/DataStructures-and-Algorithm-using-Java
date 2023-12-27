package Type2_0_1_KnapSack;

/*
 * find no of subsets are there which can form Given Value
 */

public class P5_Count_of_SubSet_Sum { // copy paste but dp[i][j] = include + exclude

	// Tabulation
	public static int maxValTabulation(int[] val, int[] wt, int W) {

		int[][] dp = new int[val.length + 1][W + 1];
		
		for (int i = 0; i < dp.length; i++) { 
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {

				if (wt[i - 1] <= j) {
					int include = dp[i - 1][j - wt[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = include + exclude;
				} else {
					int exclude = dp[i - 1][j];
					dp[i][j] = exclude;
				}

			}
		}

		return dp[val.length][W];

	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 3, 2, 1};

		int Value = 3;

		System.out.println(maxValTabulation(arr, arr, Value));
	}

}
