package packagee18_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import packagee18_Graphs.P2_bfs.Edge;

public class P3_dfs {

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

	static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 0
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));
		// 1
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		// 2
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));
		// 3
		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		graph[3].add(new Edge(3, 5, 1));
		// 4
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
		graph[4].add(new Edge(4, 5, 1));
		// 5
		graph[5].add(new Edge(5, 3, 1));
		graph[5].add(new Edge(5, 4, 1));
		graph[5].add(new Edge(5, 6, 1));
		// 6
		graph[6].add(new Edge(6, 5, 1));

	}

	public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {

		System.out.print(curr + " ");
		vis[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (vis[e.des] == false) {
				dfs(graph, e.des, vis);
			}
		}

	}

	public static void main(String[] args) {

		int V = 7;
		ArrayList<Edge>[] graph = new ArrayList[V];

		createGraph(graph);
		boolean[] vis = new boolean[V];
		Edge e = new Edge(0, 0, 0);
		dfs(graph, 0, vis);

	}

}
