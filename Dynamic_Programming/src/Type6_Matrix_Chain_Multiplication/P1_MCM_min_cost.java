package Type6_Matrix_Chain_Multiplication;

import java.util.Arrays;

public class P1_MCM_min_cost {

	public static int minCost(int[] arr, int i, int j) {

		if (i == j)
			return 0; // just one array

		int ans = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int cost1 = minCost(arr, i, k);
			int cost2 = minCost(arr, k + 1, j);
			int cost3 = arr[i - 1] * arr[k] * arr[j];
			int finalCost = cost1 + cost2 + cost3;
			ans = Math.min(ans, finalCost);
		}

		return ans;

	}

	// Memoization
	public static int minCostMemo(int[] arr, int i, int j, int[][] memo) {

		if (i == j)
			return 0; // just one array
		
		if(memo[i][j] != -1) {
			return memo[i][j];
		}
		
		int ans = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int cost1 = minCostMemo(arr, i, k, memo);
			int cost2 = minCostMemo(arr, k + 1, j, memo);
			int cost3 = arr[i - 1] * arr[k] * arr[j];
			int finalCost = cost1 + cost2 + cost3;
			ans = Math.min(ans, finalCost);
		}
		
		memo[i][j] = ans;

		return memo[i][j];

	}
	
	// Tabulation
	public static int mcmTab(int[] arr) {
		
		int[][] dp = new int[arr.length][arr.length];
		
		// in initial step : all the diagonal result will be zero
		for(int i=0;i<arr.length;i++) {
			dp[i][i] = 0;
		}
		// first row and first col is also filled with zero : due to starting from 0; 
		for(int i=0;i<dp.length;i++) {dp[0][i] =0; dp[i][0] = 0; }
		
		int n = arr.length;
		for(int len=2;len<=arr.length-1;len++) {
			for(int i=1;i<=n-len;i++) {
				int j = i+len-1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int cost1 = dp[i][k];
					int cost2 = dp[k+1][j];
					int cost3 = arr[i-1]*arr[k]*arr[j];
					int finalCost = cost1+cost2+cost3;
					dp[i][j] = Math.min(dp[i][j], finalCost);
				}
			}
		}
		
		
		return dp[1][n-1];
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 3 };

		System.out.println(minCost(arr, 1, arr.length - 1));
		
		int[][] memo = new int[arr.length][arr.length];
		for(int i=0;i<memo.length;i++) Arrays.fill(memo[i], -1);
		System.out.println(minCostMemo(arr, 1, arr.length-1, memo));
		
		System.out.println(mcmTab(arr));

	}

}
