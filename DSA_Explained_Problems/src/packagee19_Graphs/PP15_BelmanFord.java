package packagee19_Graphs;

import java.util.ArrayList;
import java.util.Arrays;

import packagee19_Graphs.PP13_Dijkstras_Algorithm.Edge;

public class PP15_BelmanFord {

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

	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 0
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		// 1
		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));

		// 2
		graph[2].add(new Edge(2, 4, 3));

		// 3
		graph[3].add(new Edge(3, 5, 1));

		// 4
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}
	
	/*
	 * This is same like Dijkstra's Algorithm, 
	 * we will be finding shortest path from given source to all nodes
	 * but this algorithm works when weighted graph has -ve values
	 * 
	 * Note: this algorithm has more time complexity compared to Dijkstra's
	 * so whenever graph has +ve weights use Dijkstra's Algorithm
	 * and when graph has -ve weights use BellmanFord Algorithm
	 */
	public static void bellmanFord(ArrayList<Edge> graph[], int src) {
		
		int V = graph.length;
		
		int[] dist = new int[V];
		
		for(int i=0;i<V;i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		
		for(int i=0;i<V-1;i++) {
			
			for(int j=0;j<V;j++) {
				for(Edge neighbour : graph[j]) {
					int u = neighbour.src;
					int v = neighbour.des;
					int wt = neighbour.wt;
					
					if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt ;
					}
				}
			}
			
		}
		
		Arrays.stream(dist).forEach(System.out::println);
		
	}

	public static void main(String[] args) {
		
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		int src = 0;
		bellmanFord(graph, src);

	}

}
