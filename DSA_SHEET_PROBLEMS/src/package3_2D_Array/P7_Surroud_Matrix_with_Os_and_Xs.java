package package3_2D_Array;

public class P7_Surroud_Matrix_with_Os_and_Xs {

	public static void solve(char[][] board) {

		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
					dfs(board, i, j);
				}
			}
		}

		// logic
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'T') {
					board[i][j] = 'O';
				}
			}
		}

	}

	public static void dfs(char[][] board, int i, int j) {

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
			return;
		}

		board[i][j] = 'T';

		dfs(board, i - 1, j);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
		dfs(board, i, j + 1);
	}

	public static void main(String[] args) {

		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("-------------");

		solve(board);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
