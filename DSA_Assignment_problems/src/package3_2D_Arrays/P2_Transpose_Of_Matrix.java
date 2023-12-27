package package3_2D_Arrays;

public class P2_Transpose_Of_Matrix {

	// method 1 : taking new atrix and storing transpose data
	public static void transposeOfMatrix1(int[][] matrix) {
		int[][] transposeMat = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				transposeMat[j][i] = matrix[i][j];
			}
		}

		for (int i = 0; i < transposeMat.length; i++) {
			for (int j = 0; j < transposeMat[0].length; j++) {
				System.out.print(transposeMat[i][j] + " ");
			}
			System.out.println();
		}

	}

	// method 2 : converting the original matrix itself into transpose
	public static void transposeOfMatrix2(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}


		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		int A[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };

		transposeOfMatrix2(A);

	}

}
