package package3_2D_Array;

import java.util.Arrays;

public class P2_Set_Matrix_Zeroes {

	public static void setMatrixZeroes(int[][] matrix) {

		boolean firstRow = false;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 0) {

					matrix[0][col] = 0;

					if(row==0) {
						firstRow = true;
					}else {
						matrix[row][0] = 0;
					}

				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// check if 0th column should be zero
		if (matrix[0][0] == 0) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (firstRow == true) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

	}

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

		setMatrixZeroes(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

}
