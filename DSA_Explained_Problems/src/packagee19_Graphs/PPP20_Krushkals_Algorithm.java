package packagee19_Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class PPP20_Krushkals_Algorithm {

	static class Edge implements Comparable<Edge> {
		int src;
		int des;
		int wt;

		public Edge(int s, int d, int w) {
			this.src = s;
			this.des = d;
			this.wt = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}

	public static void createGraph(ArrayList<Edge> edges) {
		// edges
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(0, 2, 15));
		edges.add(new Edge(0, 3, 30));
		edges.add(new Edge(1, 3, 40));
		edges.add(new Edge(2, 5, 50));
	}

	public static int findParent(int n, int[] parent) {
		if (n == parent[n]) {
			return n;
		}

		return findParent(parent[n], parent);
	}

	public static void union(int a, int b, int[] parent, int[] rank) {
		int parentOfA = findParent(a, parent);
		int parentOfB = findParent(b, parent);

		if (rank[parentOfA] == rank[parentOfB]) {
			parent[parentOfB] = parentOfA; // basically making A as parent: par[B] = A;
			rank[parentOfA]++; // rank of A ++;
		} else if (rank[parentOfA] > rank[parentOfB]) {
			parent[parentOfB] = parentOfA;
		} else {
			parent[parentOfA] = parentOfB;
		}
	}

	public static int krushkal(ArrayList<Edge> edges, int V, int[] parent, int[] rank) {
		// because this is a greedy thing , first step is to sort the edges based on wt/cost
		Collections.sort(edges);
		int mstAns = 0;
		
		int count = 0; int i=0;
		while(count<V-1) { // V-1 because, in MST graph will be like, still connected to each other with minimum edges and the minimum edges possible will always be one less than no.of vertices
			               // if 2 vertices then no.of edges must be 1 in MST
			               // if 3 vertives then no.of edges must be 2 in MST
			               // So, always for V vertices no.of edges must be V-1 in MST 
			Edge e = edges.get(i);
			int parA = findParent(e.src, parent);
			int parB = findParent(e.des, parent);
			
			// if both par's are equal 
			// then it already means that these vertices are already connected, 
			// so we calculate only for those scenarios where, par A and par B are not equal,
			// and we are going to end up getting mst ans, 
			// because the sorting is already done in asc order of weights

			if(parA != parB) {  
				union(e.src, e.des, parent, rank);
				mstAns += e.wt;
				count++;
			}
			
			i++;
		}
		
		return mstAns;
	}

	public static void main(String[] args) {

		int n = 7;

		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int[] rank = new int[n];

		int V = 4;
		ArrayList<Edge> edges = new ArrayList<>();
		createGraph(edges);
		
		System.out.println(krushkal(edges, V, parent, rank));
	}

}
