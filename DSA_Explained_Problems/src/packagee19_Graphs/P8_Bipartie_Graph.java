package packagee19_Graphs;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P8_Bipartie_Graph {

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}

	public static void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));

	}

	/*
	 * color the graph in such a way that, no adjacent vertex in the graph has same
	 * color, so you need to pick two colors ex:- 0 & 1 initailly -1 means not
	 * colored
	 */

	/*
	 * Note: 1. graph without cycle is always a bipartite 2. graph with cycle and
	 * cycle length is even is bipartite
	 */

	public static boolean isBipartite(ArrayList<Edge>[] graph) {

		Queue<Integer> q = new LinkedList<>();
		// q.add(0);

		int[] color = new int[graph.length];
		Arrays.fill(color, -1);

		for (int i = 0; i < graph.length; i++) {

			if (color[i] == -1) {
				color[i] = 0;
				q.add(i);
				while (!q.isEmpty()) {
					int curr = q.remove();
					for (Edge e : graph[curr]) {
						if (color[e.des] == -1) {
							int nextColor = color[curr] == 0 ? 1 : 0;
							color[e.des] = nextColor;
							q.add(e.des);
						} else {
							if (color[curr] == color[e.des]) {
								return false;
							}
						}
					}
				}
			}

		}

		return true;

	}

	// gfg submission
	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		Queue<Integer> q = new LinkedList<>();
		// q.add(0);
		int[] color = new int[V];
		Arrays.fill(color, -1);

		for (int i = 0; i < V; i++) {

			if (color[i] == -1) {
				color[i] = 0;
				q.add(i); // added q.add(vertex) here
				while (!q.isEmpty()) {
					int curr = q.remove();
					for (Integer e : adj.get(curr)) {
						if (color[e] == -1) {
							int nextColor = color[curr] == 0 ? 1 : 0;
							color[e] = nextColor;
							q.add(e);
						} else {
							if (color[curr] == color[e]) {
								return false;
							}
						}
					}
				}
			}

		}

		return true;
	}

	public static void main(String[] args) {

		int V = 5;

		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph);

		System.out.println(isBipartite(graph));

	}

}
