package package4_2D_Arrays;

public class P3_Search_in_Sorted_Matrix {

	public static void search(int[][] matrix, int target) {
		
		int n = matrix.length;
		
		int row=0;
		int col = matrix[0].length-1;
		while(row < n && col >=0) {
			if(target == matrix[row][col]) {
				System.out.println("fount at matrix "+row+", "+col);
				return;
			}else if(target < matrix[row][col]) {
				col--;
			}else {
				row++;
			}
		}
		
		System.out.println(-1);
	}

	public static void main(String[] args) {

		int[][] mat = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 },
						{ 32, 33, 39, 50 } };

		int target = 40;

		search(mat, target);

	}

}
