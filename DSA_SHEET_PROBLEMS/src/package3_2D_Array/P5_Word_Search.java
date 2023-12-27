package package3_2D_Array;

public class P5_Word_Search { // back tracking , or Graph DFS something
	
	public static boolean exist(char[][] board, String word) {
		
        
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(check(word, board, i, j, 0)) {
					return true;
				}
			}
		}
		
		return false;
		
    }
	
	public static boolean check(String word, char[][] board, int i, int j, int index) {
		
		if(index == word.length()) return true; // if entire word was found
		
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index) != board[i][j]) return false;
		
		char originalChar = board[i][j];
		board[i][j] = '*';
		
		boolean found = check(word, board, i+1, j, index+1) ||
				check(word, board, i-1, j, index+1) ||
				check(word, board, i, j+1, index+1) ||
				check(word, board, i, j-1, index+1);
		
		board[i][j] = originalChar;
		
		if(found == true) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {

		char[][] board = {
				{ 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		
		String word = "ABCCE";
		
		System.out.println(exist(board, word));

	}

}
