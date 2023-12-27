package packagee19_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PP17_Cheapest_Flight {// did not pass all the test cases

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
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < flights.length; i++) {
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
		for (int i = 0; i < n; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}

		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, 0));

		while (!q.isEmpty()) {
			Info curr = q.remove();
			if (curr.stops > k) {
				break;
			}

			for (int i = 0; i < graph[curr.vertex].size(); i++) {
				Edge e = graph[curr.vertex].get(i);
				int u = e.src;
				int v = e.des;
				int wt = e.wt;

				if (curr.cost + wt < dist[v] && curr.stops <= k) {
					dist[v] = curr.cost + wt;
					q.add(new Info(e.des, dist[v], curr.stops + 1));
				}
			}
		}

		// the ask is for dist[des];
		if (dist[des] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dist[des];
		}
	}

	// Working code : gfg submitted
	// learning resource :- neetcode website, video lecture + java code (cheapest flight with atmost k stops)
	public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
		// Code here

		// Step 1 : we will take a cost[] array which will store all the minimum cost
		// for each destination
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);

		cost[src] = 0; // initially, src-to-src cost will be obviously '0'

		// Step 2: we must calculate min till given src to each of its neighbour :
		// basically updating cost[] array for each neighbour from src
		for (int i = 0; i <= k; i++) { // running loop till k times , cause we want minimum cost within k stops

			int[] temp = Arrays.copyOf(cost, cost.length);
			// now calculate cost for each neighbour from src
			for (int j = 0; j < flights.length; j++) {
				int currSrc = flights[j][0];
				int currDes = flights[j][1];
				int currCost = flights[j][2];
				if (cost[currSrc] != Integer.MAX_VALUE && cost[currSrc] + currCost < temp[currDes]) {
					temp[currDes] = cost[currSrc] + currCost;
				}
			}
			cost = temp;
		}

		if (cost[dst] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return cost[dst];
		}
	}

	public static void main(String[] args) {

		int n = 4;
		int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };

		int src = 0;
		int des = 3;
		int k = 1;

		// solution
		ArrayList<Edge> graph[] = new ArrayList[n];

		createGraph(flights, graph);

		System.out.println(cheapestFlight(graph, src, des, k));

	}

}
