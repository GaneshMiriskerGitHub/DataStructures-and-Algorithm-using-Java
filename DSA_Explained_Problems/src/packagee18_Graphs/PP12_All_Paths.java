package packagee18_Graphs;

import java.util.ArrayList;

public class PP12_All_Paths {

	static class Edge {
        int src;
        int des;
    
        public Edge(int src, int des) {
            this.src=src;
            this.des=des;
        }
    }



    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        if(s==d){
            return 1;
        }
        // Code here 
        int V = n;
        ArrayList<ArrayList<Edge>> adjList = new ArrayList(V);
        
        for(int i=0;i<V;i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            adjList.get(src).add(new Edge(src, des));
        }
        
        // actual code
        boolean[] vis = new boolean[V];
        int count = dfs(adjList, s, d, vis);
        
        return count;
    }
    
    public static int dfs(ArrayList<ArrayList<Edge>> adjList, int src, int des, boolean[] vis) {
        if(src == des) {
            return 1;
        }
        vis[src] = true;
        int count=0;
        for(Edge neighbour : adjList.get(src)) {
            if(!vis[neighbour.des]){
                count += dfs(adjList, neighbour.des, des, vis);
            }
        }
        
        vis[src] = false;
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
