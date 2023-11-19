package packagee18_Graphs;

import java.util.ArrayList;

public class Tester {

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
		
		for(int i=0;i<graph.length;i++) {
			if(hasCycle(graph, i, vis, -1)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static boolean hasCycle(ArrayList<Edge>[] graph, int src, boolean[] vis, int par) {
		
		vis[src] = true;
		
	
		
		for(Edge e: graph[src]) {
			if(!vis[e.des] && hasCycle(graph, e.des, vis, par)) {
				return true;
			}else if(vis[e.des] && par != src) {
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
