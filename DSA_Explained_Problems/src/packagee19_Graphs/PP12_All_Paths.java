package packagee19_Graphs;

import java.util.ArrayList;

public class PP12_All_Paths {

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}

	/*
	 * exmaple of how edges data:-
	 * 
	 * int[][] edges = { _u _v {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4} };
	 * 
	 * 
	 */

	public int possible_paths(int[][] edges, int n, int s, int d) {
		if (s == d) {
			return 1;
		}
		// Code here
		int V = n;
		ArrayList<ArrayList<Edge>> adjList = new ArrayList(V);

		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			adjList.get(src).add(new Edge(src, des));
		}

		// actual code
		boolean[] vis = new boolean[V];
		int count = dfs(adjList, s, d, vis);

		return count;
	}

	public static int dfs(ArrayList<ArrayList<Edge>> adjList, int src, int des, boolean[] vis) {
		if (src == des) {
			return 1;
		}
		vis[src] = true;
		int count = 0;
		for (Edge neighbour : adjList.get(src)) {
			if (!vis[neighbour.des]) {
				count += dfs(adjList, neighbour.des, des, vis);
			}
		}

		vis[src] = false;

		return count;
	}

	static int dfs(ArrayList<ArrayList<Integer>> graph, int src, int des, String path, boolean[] vis) {

		vis[src] = true;

		if (src == des) {
			path += des;
			return 1;
		}

		int count = 0;
		for (Integer e : graph.get(src)) {
			if (!vis[e]) {
				count+=dfs(graph, e, des, path, vis);
			}
		}

		vis[src] = false;

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
