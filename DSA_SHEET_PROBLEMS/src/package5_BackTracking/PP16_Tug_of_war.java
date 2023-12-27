package package5_BackTracking;

import java.util.ArrayList;

public class PP16_Tug_of_war { // DP
	
	static int min_dist = Integer.MAX_VALUE;
	
	public static void findMinimumInTugOfWar(int[] arr) {
		
		findMinimumInTugOfWarUtil(arr, 0, 0, 0, new ArrayList<>(), new ArrayList<>());
		
//		System.out.println(min_dist);
		
	}
	
	public static void findMinimumInTugOfWarUtil(int[] arr, int i, int set1Sum, int set2Sum, ArrayList<Integer> set1, ArrayList<Integer> set2) {
		
		if(i==arr.length) {
			if(min_dist > Math.abs(set2Sum-set1Sum)) {
				min_dist = Math.abs(set2Sum-set1Sum);
			}
			return;
		}
		
		if(set1.size() < ((arr.length+1)/2)) {
			set1.add(arr[i]);
			findMinimumInTugOfWarUtil(arr, i+1, set1Sum+arr[i], set2Sum, set1, set2);
			set1.remove(set1.size()-1);
		}
		
		if(set2.size() < ((arr.length+1)/2)) {
			set2.add(arr[i]);
			findMinimumInTugOfWarUtil(arr, i+1, set1Sum, set2Sum+arr[i], set1, set2);
			set2.remove(set2.size()-1);
		}
		
		
		
	}

	public static void main(String[] args) {

		int arr[] = { 3,3,6,4,8,8 };
		
		findMinimumInTugOfWar(arr);
		
		System.out.println(min_dist);

	}

}
