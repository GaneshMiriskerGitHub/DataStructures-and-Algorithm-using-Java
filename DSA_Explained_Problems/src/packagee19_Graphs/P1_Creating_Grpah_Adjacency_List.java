package packagee19_Graphs;

import java.util.ArrayList;

public class P1_Creating_Grpah_Adjacency_List {
	
	/*
	 * 1. There will be an array
	 * 2. Each Cell in the array will store a List<Edges>
	 * 3. Edge - src, des, wt
	 */
	
	static class Edge {
		int src;
		int des;
		int wt;
		
		public Edge(int src, int des, int wt) {
			this.src = src;
			this.des = des;
			this.wt  = wt;
		}
	}
	
	

	public static void main(String[] args) {
		
		ArrayList<Edge>[] graph = new ArrayList[4];
		
		for(int i=0;i<5;i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 0
		graph[0].add(new Edge(0, 1, 5));
		
		// 1
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));
		
		// 2
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 2));
		
		// 3
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));
		
		// 4
		graph[4].add(new Edge(4, 2, 2));
		
		
		

	}

}
