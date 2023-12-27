package package5_BackTracking;

public class P4_Find_longest_Path { // same like rat in maze problem
	
	
	public static boolean isSafe(int[][] grid, int r, int c) {
		if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[r].length - 1 || grid[r][c] == 0) {
			return false;
		}
		return true;
	}

	public static boolean findLongestPathUtil(int[][] grid, int r, int c, int n, int m, int count,
			boolean[][] visited) {

		if (r == n && c == m) {
			System.out.println(count);
			return true;
		}

		if (isSafe(grid, r, c) && !visited[r][c]) {
			visited[r][c] = true;
			// up
			if (findLongestPathUtil(grid, r - 1, c, n, m, count + 1, visited)) {
				return true;
			}
			// down
			if (findLongestPathUtil(grid, r + 1, c, n, m, count + 1, visited)) {
				return true;
			}
			// right
			if (findLongestPathUtil(grid, r, c + 1, n, m, count + 1, visited)) {
				return true;
			}
			// left
			if (findLongestPathUtil(grid, r, c - 1, n, m, count + 1, visited)) {
				return true;
			}
			visited[r][c] = false;
			return false;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		boolean[][] visited = new boolean[mat.length][mat[0].length];
		// find longest path with source (0, 0) and
		// destination (1, 7)
		findLongestPathUtil(mat, 0, 0, 1, 7, 1, visited);

	}

}
