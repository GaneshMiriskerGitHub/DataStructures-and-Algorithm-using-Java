package packagee18_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PP17_Cheapest_Flight  // did not pass all the test cases
	
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
	
	public static void createGraph(int[][] flights, ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<flights.length;i++) {
			int src = flights[i][0];
			int des = flights[i][1];
			int wt = flights[i][2];
			
			Edge e = new Edge(src, des, wt);
			graph[src].add(e);
		}
	}
	
	static class Info {
		int vertex;
		int cost;
		int stops;
		
		public Info(int vertex, int cost, int stops) {
			this.vertex = vertex;
			this.cost = cost;
			this.stops = stops;
		}
	}
	
	public static int cheapestFlight(ArrayList<Edge> graph[], int src, int des, int k) {
		
		int n = graph.length;
		int[] dist = new int[n];
		for(int i=0;i<n;i++) {
			if(i!=src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, 0));
		
		while(!q.isEmpty()) {
			Info curr = q.remove();
			if(curr.stops > k) {
				break;
			}
			
			for(int i=0;i<graph[curr.vertex].size();i++) {
				Edge e = graph[curr.vertex].get(i);
				int u = e.src;
				int v = e.des;
				int wt = e.wt;
				
				if(curr.cost + wt < dist[v] && curr.stops <= k) {
					dist[v] = curr.cost + wt;
					q.add(new Info(e.des, dist[v], curr.stops+1));
				}
			}
		}
		
		// the ask is for dist[des];
		if(dist[des] == Integer.MAX_VALUE) {
			return -1;
		}else {
			return dist[des];
		}
	}

	public static void main(String[] args) {
		
		int n = 4;
		int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
		
		int src=0;
		int des=3;
		int k=1;
		
		
		// solution
		ArrayList<Edge> graph[] = new ArrayList[n];
		
		createGraph(flights, graph);
		
		System.out.println(cheapestFlight(graph, src, des, k));

	}

}
