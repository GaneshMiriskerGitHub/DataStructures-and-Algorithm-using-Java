package package5_BackTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class PP15_Hamilton_Cycle { // Graph

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}

	public static boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
		// code here
		

	}
	
	

	public static void main(String[] args) {

		int N = 4;
		int M = 4;
		int[][] Edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 2, 4 } };

		
		
		ArrayList<Edge>[] graph = new ArrayList[Edges.length + 1]; 
		
		HashSet<Integer> set = new HashSet<>();
		
		
	}

}
