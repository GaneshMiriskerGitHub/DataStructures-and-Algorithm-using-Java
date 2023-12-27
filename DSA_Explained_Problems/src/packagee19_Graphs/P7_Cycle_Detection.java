package packagee19_Graphs;

import java.util.ArrayList;

import packagee19_Graphs.P4_Has_Path.Edge;

public class P7_Cycle_Detection { // https://www.youtube.com/watch?v=UPfUFoWjk5w
	                               // better code is solved in gfg :- https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 0
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));

		// 1
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		// 2
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));

		// 3
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));

		// 4
		graph[4].add(new Edge(4, 3));
	}

	public static boolean detectCycle(ArrayList<Edge>[] graph) {
		boolean[] vis = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			if (vis[i] == false) {
				if (detectCycleUtil(graph, vis, i, -1)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
		vis[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);

			if (!vis[e.des]) {
				if (detectCycleUtil(graph, vis, e.des, curr)) {
					return true;
				}
			}
			else if (vis[e.des] && e.des != par) {
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {

		int V = 7;
		ArrayList<Edge>[] graph = new ArrayList[V];

		createGraph(graph);

		System.out.println(detectCycle(graph));

	}

}
