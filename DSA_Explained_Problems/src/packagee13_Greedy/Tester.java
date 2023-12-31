package packagee13_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Tester {
	
	public static void findMaximumActivities(int[] start, int[] end) {
		
		List<String> list = new LinkedList<>();
		
		int[][] activities = new int[start.length][3];
		
		for(int i=0;i<start.length;i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
		
		list.add("A"+activities[0][0]);
		
		int lastEnd = activities[0][2];
		for(int i=1;i<start.length;i++) {
			int currStart = activities[i][1];
			if(currStart >= lastEnd) {
				list.add("A"+activities[i][0]);
				lastEnd = activities[i][2];
			}
		}
		
		System.out.println(list);
	}

	public static void main(String[] args) {
		
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};
		
		findMaximumActivities(start, end);

	}

}
