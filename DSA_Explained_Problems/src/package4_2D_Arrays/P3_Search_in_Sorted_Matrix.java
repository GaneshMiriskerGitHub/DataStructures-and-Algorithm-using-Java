package package4_2D_Arrays;

public class P3_Search_in_Sorted_Matrix {

	public static boolean search(int[][] matrix, int target) {

		int n = matrix.length;

		int row = 0;
		int col = matrix[0].length - 1;
		while (row < n && col >= 0) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				col--;
			} else {
				row++;
			}
		}

		return false;
	}


	public static void main(String[] args) {

		int[][] mat = { { 1, 4, 5, 9 }, { 10, 13, 17, 21 }, { 27, 37, 38, 68 }, { 68, 69, 71, 74 } };

		int target = 4;

		System.out.println(search(mat, target));

	}

}
