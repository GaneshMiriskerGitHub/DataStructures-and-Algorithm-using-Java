package packagee18_Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PP16_Prims_Algorithm {
	
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
	
	static class Pair implements Comparable<Pair> {
		int v;
		int wt;
		
		public Pair(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair p) {
			return this.wt - p.wt;
		}
	}
	
	public static void primsAlgorithm(ArrayList<Edge> graph[]) {
		int V = graph.length;
		boolean[] vis = new boolean[V];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0));
		
		int finalMST = 0;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			
			if(!vis[curr.v]) {
				vis[curr.v] = true;
				finalMST += curr.wt;
				for(Edge neighbours: graph[curr.v]) {
					pq.add(new Pair(neighbours.des, neighbours.wt));
				}
			}
		}
		
		System.out.println("final cost of MST is  : " +finalMST);
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 0
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));

		// 1
		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));

		// 2
		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));

		// 3
		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));
	}

	public static void main(String[] args) {
		
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		primsAlgorithm(graph);

	}

}
