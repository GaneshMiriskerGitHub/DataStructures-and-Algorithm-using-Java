package package8_BackTracking;

public class Tester {

	public static void printSol(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static boolean solveKnighTourCode(int[][] chess, int r, int c, int count, int[] xMoves, int[] yMoves) {
		
		if(count == 8*8) return true;
		
		for(int i=0;i<chess.length;i++) {
			if(isSafe(chess, r+xMoves[i], c+yMoves[i])) {
				chess[r+xMoves[i]][c+yMoves[i]] = count;
				if(solveKnighTourCode(chess, r+xMoves[i], c+yMoves[i], count+1, xMoves, yMoves)) {
					return true;
				}else {
					chess[r+xMoves[i]][c+yMoves[i]] = -1;
				}
			}
		}
		
		return false;
		
	} 
	
	public static boolean isSafe(int[][] chess, int row, int col) {
		if(row<0 || col<0 || row>chess.length-1 || col>chess.length-1 || chess[row][col] != -1) {
			return false;
		}
		
		return true;
	}
    

    public static void main(String[] args) {
        
    	int[][] chess = new int[8][8];
    	
    	int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
        
        for(int i=0;i<chess.length;i++) {
        	for(int j=0;j<chess[i].length;j++) {
        		chess[i][j] = -1;
        	}
        }
        
        chess[0][0] = 0;
    	
    	if(solveKnighTourCode(chess, 0, 0, 1, xMoves, yMoves)) {
    		printSol(chess);
    	}else {
    		System.out.println("false");
    	}
    	
    }
}
