package package4_2D_Arrays;

public class P2_Diagonal_Sum {
	
	public static void printDiagonalSum(int[][] matrix) {
		
		int n = matrix.length;
		
		if(n%2==0) {
			
		}
		
		// diagonal 1
		int d1Sum = 0;
		for(int i=0;i<matrix.length;i++) {
			d1Sum+=matrix[i][i];
		}
		
		// diagonal 2
		for(int i=0;i<matrix.length;i++) {
			d1Sum+=matrix[i][n-i-1];
		}
		
		if(n%2==0) {
			System.out.println(d1Sum);
		}else {
			System.out.println(d1Sum-matrix[n/2][n/2]);
		}
		
	}

	public static void main(String[] args) {
		
		 int [][]a = { { 1, 1, 1, 1, 1 },
				       { 1, 1, 1, 1, 1 }, 
				       { 1, 1, 1, 1, 1 },
				       { 1, 1, 1, 1, 1 },
				       { 1, 1, 1, 1, 1 }  };
		 
		 printDiagonalSum(a);
	}

}
