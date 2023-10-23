package package3_2D_Array;

import java.util.Arrays;

public class P4_Rotated_Matrix {
	
	// my solution
	public static void rotateMatrix(int[][] matrix) { // solution:- take transpose first and reverse the column
		int row = matrix.length;
        int col = matrix[0].length; 
        
        int[][] rotated = new int[col][row];
        
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0;i<row;i++){
            int s=0;
            int e=matrix.length-1;
            while(s<e) {
            	int temp = matrix[i][s];
            	matrix[i][s] = matrix[i][e];
            	matrix[i][e] = temp;
            	s++;
            	e--;
            }
        }
        
        for(int i=0;i<row;i++) {
        	System.out.println(Arrays.toString(matrix[i]));
        }
        
	}
	
	public static void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] rotated = new int[col][row];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                rotated[j][row-i-1] = matrix[i][j];
            }
        }

        //print rotated matrix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = rotated[i][j];
            }
        }

    }

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		
		rotateMatrix(matrix);
	}

}
