package Type3_Unbounded_Knapsack;

import java.util.Arrays;

public class P1_Unbounded_Knapsack { // same 0-1 knapsack , but at include scenario, instead of taking dp[i-1] we will take dp[i] because
	                                 // in unbounded knapsack the val can be taken infinite times

	// Tabulation
	public static int unboundedKnapsack(int[] val , int[] wt, int W) {
		
		int[][] dp = new int[val.length+1][W+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				
				if(wt[i-1] <= j) {
					int include = val[i-1] + dp[i][j-wt[i-1]];
					int exclude = dp[i-1][j];
					dp[i][j] = Math.max(include, exclude);
				}else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
				
			}
		}
		
		return dp[val.length][W];
		
	}

	public static void main(String[] args) {

		int[] val = { 15, 14, 10, 45, 30 };
		int[] wt = { 2, 5, 1, 3, 4 };

		int W = 7;

		System.out.println(unboundedKnapsack(val, wt, W));

	}

}
