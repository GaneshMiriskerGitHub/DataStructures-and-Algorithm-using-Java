package packagee19_Dynamic_Programming;

import java.util.Arrays;

public class Tester {

	public static int longestIncreasingPath(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] dp = new int[row][col];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dp[i][j] == -1) {
					dfs(row, col, i, j, matrix, dp, -1);
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		return max;

	}

	public static int dfs(int row, int col, int r, int c, int[][] matrix, int[][] dp, int preVal) {

		// check for all invalid scenarios
		if (r < 0 || c < 0 || r >= row || c >= col || matrix[r][c] <= preVal) {
			return 0;
		}

		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		int right = dfs(row, col, r, c + 1, matrix, dp, matrix[r][c]);
		int left = dfs(row, col, r, c - 1, matrix, dp, matrix[r][c]);
		int up = dfs(row, col, r - 1, c, matrix, dp, matrix[r][c]);
		int down = dfs(row, col, r + 1, c , matrix, dp, matrix[r][c]);

		int res = 1 + Math.max(Math.max(right, left), Math.max(up, down));

		dp[r][c] = res;

		return dp[r][c];

	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 3, 2, 3, 4 }, { 4, 5, 6, 7 }, };

		System.out.println(longestIncreasingPath(mat));
	}

}
