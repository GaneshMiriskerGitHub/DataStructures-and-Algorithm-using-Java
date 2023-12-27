package package8_BackTracking;

public class P4_N_Queens_basic {
	
	public static void nQueens(char[][] board, int row) {
		
		if(row == board.length) {
			printBoard(board);
			return;
		}
		
		for(int j=0;j<board.length;j++) {
			board[row][j] = 'Q';
			nQueens(board, row+1);
			board[row][j] = '.';
		}
	}
	
	public static void printBoard(char[][] board) {
		System.out.println("---- answer ----");
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void fillDots(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = '.';
			}
		}
	}
	

	public static void main(String[] args) {
		
		// 
		int n = 2;
		char[][] board = new char[n][n];
		fillDots(board);
		
		int rowTobeStarted = 0;
		nQueens(board, rowTobeStarted);

	}

}
