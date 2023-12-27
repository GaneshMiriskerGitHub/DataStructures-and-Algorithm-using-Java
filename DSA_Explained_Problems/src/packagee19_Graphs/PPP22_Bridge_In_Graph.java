 package packagee19_Graphs;

import java.util.ArrayList;

import packagee18_Graphs.PPP23_SCC_KosarajuAlgo.Edge;

public class PPP22_Bridge_In_Graph   // did not pass all the test cases
                                     // refer the below provided leetcode submission
                                     // it passed all test cases: solution:- always create adjList and then code it
	
	// Tarjan's Algorithm
	/*
	 * print the two nodes, where if edge between them is removed, results in creating more components of the graph
	 * 
	 * solution id dt[u] < low[v] 
	 * print u + " " + v
	 * 
	 * dt = discoverytime
	 * low = lowest discoverytime
	 */
	
	
	static class Edge {
		int src;
		int des;
		
		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}
	
	public static void printAriculationPoint(ArrayList<Edge> graph[]) {
		
		
		
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		
	}
	
	public static void dfs(ArrayList<Edge> graph[], int curr, int time, boolean[] vis, int[] dt, int[] low, int par) {
		
		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		
		for(Edge e : graph[curr]) {
			if(e.des == par) {
				continue;
			}else if(!vis[e.des]) {
				dfs(graph, e.des, time, vis, dt, low, curr);
				low[curr] = Math.min(low[curr], low[e.des]);
				if(dt[curr] < low[e.des]) {
					System.out.println("bridge is : "+curr+" ------- "+e.des);
				}
			}else {
				low[curr] = Math.min(low[curr], dt[e.des]); // this line will be explained in articulation point 
			}
		}
		
		
	}
	
	public static void printBridgeInGraph(ArrayList<Edge> graph[], int V) {
		
		// create discoverytime[] ,  lowerstDiscoveryTime[] array
		int[] dt = new int[V];
		int[] low = new int[V];
		
		// dfs
		int time = 0;
		boolean[] vis = new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(graph, i, time, vis, dt, low, -1);
			}
		}
		
	}
	
	/*
	 
	 class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        int[] dt = new int[n];
        int[] low = new int[n];
        int time = 0;
        boolean[] vis = new boolean[n];

        List<List<Integer>> result = new ArrayList<>();
        
        // Create an adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adjList, i, vis, dt, low, time, -1, result);
            }
        }

        return result;
    }

    public static void dfs(List<List<Integer>> adjList, int curr, boolean[] vis, int[] dt, int[] low, int time, int par, List<List<Integer>> result) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int next : adjList.get(curr)) {
            if (next == par) {
                continue;
            }
            if (!vis[next]) {
                dfs(adjList, next, vis, dt, low, time, curr, result);
                low[curr] = Math.min(low[curr], low[next]);
                if (dt[curr] < low[next]) {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(curr);
                    currList.add(next);
                    result.add(currList);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[next]);
            }
        }
    }
}
	 
	 */

	public static void main(String[] args) {
		
		int V = 6;

		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		printBridgeInGraph(graph, V);

	}

}
