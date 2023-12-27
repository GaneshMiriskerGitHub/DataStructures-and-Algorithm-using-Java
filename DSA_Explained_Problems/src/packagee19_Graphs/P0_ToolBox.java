package packagee19_Graphs;

import java.util.ArrayList;

public class P0_ToolBox {

	static class Edge {
		int src;
		int des;
		int wt;

		public Edge(int src, int des, int wt) {
			this.src = src;
			this.des = des;
			this.wt = wt;
		}
	}

	/*
	 * edges = 
	 * { 
	 * {src, des, wt},
	 * {src, des, wt},
	 * {src, des, wt} 
	 * }
	 */
	static ArrayList<Edge>[] spanningTree(int V, int E, int edges[][]) {
		// Code Here.
		ArrayList<Edge>[] graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			int wt = edges[i][2];
			graph[src].add(new Edge(src, des, wt));
			graph[des].add(new Edge(des, src, wt));
		}

		return graph;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
