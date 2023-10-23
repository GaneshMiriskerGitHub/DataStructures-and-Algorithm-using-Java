package packagee18_Graphs;

import java.util.ArrayList;

public class P9_Cycle_Detection_in_Directed_Graph { // learning resource:-
													// https://www.youtube.com/watch?v=GLxfoaZlRqs&t=61s
	// coded in gfg :-
	// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

	// Function to detect cycle in a directed graph.
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		boolean[] vis = new boolean[V];
		boolean[] stack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (vis[i] == false) {
				if (dfs(i, adj, vis, stack)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean dfs(int currVertx, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] stack) {
		vis[currVertx] = true;
		stack[currVertx] = true;

		for (Integer neighbour : adj.get(currVertx)) {
			if (vis[neighbour] == false) {
				if (dfs(neighbour, adj, vis, stack)) {
					return true;
				}
			} else if (stack[neighbour] == true) {
				return true;
			}
		}
		stack[currVertx] = false;

		return false;
	}

	public static void main(String[] args) {

	}

}
