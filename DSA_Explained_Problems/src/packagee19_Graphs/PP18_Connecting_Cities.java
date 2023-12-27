package packagee19_Graphs;

import java.util.PriorityQueue;

public class PP18_Connecting_Cities {
	
	static class Edge implements Comparable<Edge> {
		int src;
		int des;
		int wt;
		
		public Edge(int src, int des, int wt) {
			this.src = src;
			this.des = des;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}
	
	public static int mst(int[][] cities) {
		
		boolean[] vis = new boolean[cities.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, cities[0][0]));
		
		int finalCost = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.remove();
			if(!vis[curr.des]) {
				
				vis[curr.des] = true;
				finalCost += curr.wt;
				for(int i=0;i<cities[curr.des].length;i++) {
					if(cities[curr.des][i] != 0) {
						pq.add(new Edge(curr.des, i, cities[curr.des][i] ));
					}
				}
				
			}
		}
		
		return finalCost;
	}

	public static void main(String[] args) {
		
		int[][] cities = {{0, 1, 2, 3, 4},
				          {1, 0, 5, 0, 7},
				          {2, 5, 0, 6, 0},
				          {3, 0, 6, 0, 0},
				          {4, 7, 0, 0, 0}};
		
		
		System.out.println(mst(cities));
	}

}
