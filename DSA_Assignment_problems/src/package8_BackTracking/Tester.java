package package8_BackTracking;

import java.util.ArrayList;

public class Tester {

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		ArrayList<String> result = new ArrayList<>();

		findWays(m, n, result, 0, 0, "");

		return result;
	}

	public static  String findWays(int[][] m, int n, ArrayList<String> result, int row, int col, String path) {

		if (row == m.length - 1 && col == m[row].length - 1) {
			return path;
		}
		
		ArrayList<String> res = new ArrayList<>();

		if (isSafe(m, row, col)) {

			m[row][col] = 0;
			// right
			res.add(findWays(m, n, result, row, col + 1, path + "R"));   

			// left
			res.add(findWays(m, n, result, row, col - 1, path + "L"));

			// up
			res.add(findWays(m, n, result, row - 1, col, path + "U"));

			res.add(findWays(m, n, result, row + 1, col, path + "D"));
			
			;
			
			m[row][col] = 1;
			
			

		}
		
		return "-1";

	}

	public static boolean isSafe(int[][] m, int row, int col) {
		if (row < 0 || col < 0 || row == m.length || col == m[row].length || m[row][col] == 0) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		int n = 4;
		int m = 4;
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int[][] sol = new int[n][m];

		ArrayList<String> list = findPath(maze, n);
		
		for(String ele: list) {
			System.out.println(ele);
		}

	}

}
