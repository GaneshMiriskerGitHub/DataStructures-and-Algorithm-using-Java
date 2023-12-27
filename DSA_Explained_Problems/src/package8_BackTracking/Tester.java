package package8_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

	public static boolean isSafe(String[][] board, int row, int col) {
		//vertically up
		for(int i=row-1;i>=0;i--) {
			if(board[i][col] == "Q") {
				return false;
			}
		}
		
		// diagonal left up
		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
			if(board[i][j] == "Q") {
				return false;
			}
		}
		
		// diagonal right up
		for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++) {
			if(board[i][j] == "Q") {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
	public static List<List<String>> addBoardToList(String[][] chess) {
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			String str = "";
			for(int j=0;j<4;j++) {
				str+=chess[i][j];
			}
			list.add(str);
		}
		
		List<List<String>> result = new ArrayList<>(); 
		result.add(list);
		return result;
	}
	
	public static void nQueens(String[][] chess, int row, List<List<String>> result) {
		
		if(row == chess.length) {
			result.addAll(addBoardToList(chess));
			return;
		}
		
		for(int i=0;i<chess.length;i++) {
			if(isSafe(chess, row, i)) {
				chess[row][i] = "Q";
				nQueens(chess, row+1, result);
				chess[row][i] = ".";
			}
		}
		
	}

	public static void main(String[] args) {

		int n = 1;

		String[][] chess = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = ".";
			}
		}

		List<List<String>> result = new ArrayList<>();
		
		nQueens(chess, 0, result);
		
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		

	}
	
	

}
