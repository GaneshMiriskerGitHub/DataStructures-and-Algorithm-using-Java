package packagee19_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PP11_Course_Schedule_2 { // PP10 copy paste, but i don't know how to convert 2D matrix to adjList

	
	// leetcode submission, uses kahn's algorithm of topological sorting
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// Step1 : convert to ArrayList<ArrayList<Integer>> adj =
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int prereq = prerequisites[i][1];
			int course = prerequisites[i][0];
			adj.get(prereq).add(course);
		}

		// Calculate in degree
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (Integer e : adj.get(i)) {
				inDegree[e]++;
			}
		}

		// add all the vertices in Queue were inDegree is == 0
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		int index = 0;
		int[] ans = new int[numCourses];
		while (!q.isEmpty()) {

			int curr = q.remove();
			ans[index] = curr;
			index++;
			for (Integer e : adj.get(curr)) {
				inDegree[e]--;
				if (inDegree[e] == 0) {
					q.add(e);
				}
			}

		}

		if (index == numCourses) {
			return ans;
		} else {
			return new int[0]; // Return an empty array to indicate failure
		}

	}

	public static void main(String[] args) { // solve this later,

		// TODO Auto-generated method stub

	}

}
