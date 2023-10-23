package packagee18_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PP13_Dijkstras_Algorithm {
	
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
		for(int i=0;i<graph.length;i++) {
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
	
	static class Pair implements Comparable<Pair>{
		int n;
		int path;
		
		public Pair(int n, int path) {
			this.n = n;
			this.path = path;
		}

		@Override
		public int compareTo(Pair p) {
			return this.path - p.path;
		}
	}
	
	public static void dijkstras(ArrayList<Edge> graph[], int src) {
		int[] dist = new int[graph.length]; // use to store all src to ith vertex distance
		
		// initially give default to all vertex that, src to them is infinity
		for(int i=0;i<graph.length;i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0)); // initially i know from src to src
		
		boolean[] vis = new boolean[graph.length];
		// now calculating for src to other vertexes
		// performing bfs
		while(!pq.isEmpty()) {
			Pair p = pq.remove();
			if(!vis[p.n]) {  // this is vis[p.src] : in this line i realized i also need a vis[]
				vis[p.n] = true;
				for(Edge neighbour : graph[p.n]) {
					int u = neighbour.src;
					int v = neighbour.des;
					int wt = neighbour.wt;
					if(dist[u]+wt < dist[v]) {
						dist[v] = dist[u]+wt;
						pq.add(new Pair(v, dist[v]));
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
		dijkstras(graph, src);

	}

}
