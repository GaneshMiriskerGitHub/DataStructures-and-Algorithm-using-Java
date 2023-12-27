package package3_2D_Array;

public class P1_Zig_Zag_print_Array {
	
	public static void printZigZag(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		// in a matrix, total number of diagonals will be row+col-1
		for(int line=1;line<=row+col-1;line++) {
			
			// start_col
			int start_col = Math.max(0, line-row);
			
			int count = Math.min(row, Math.min(line, col-start_col));
			
			for(int j=0;j<count;j++) {
				System.out.print(matrix[Math.min(row, line)-j-1][start_col+j]+" ");
			}
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		
		int M[][] = {
	            { 1, 2, 3, 4 },     
	            { 5, 6, 7, 8 },
	            { 9, 10, 11, 12 },  
	            { 13, 14, 15, 16 },
	            { 17, 18, 19, 20 },
	        };
		
		printZigZag(M);
		
	}


}
