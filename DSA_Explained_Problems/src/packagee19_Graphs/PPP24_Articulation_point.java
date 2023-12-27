package packagee19_Graphs;

import java.util.ArrayList;


public class PPP24_Articulation_point {

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			this.src = src;
			this.des = des;
		}
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


	public static void printArticulationPoint(ArrayList<Edge> graph[], int V) 

		

	}

	public static void main(String[] args) {

		int V = 6;

		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);

		printArticulationPoint(graph, V);

	}

}
