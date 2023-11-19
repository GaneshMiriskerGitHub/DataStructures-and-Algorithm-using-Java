package packagee1Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) { // very important step
				continue; // Skip duplicates
			}

			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				if (nums[l] + nums[r] == 0 - nums[i]) {
					List<Integer> result = new ArrayList<>();
					result.add(nums[i]);
					result.add(nums[l]);
					result.add(nums[r]);
					list.add(result);
					while (l < r && nums[l] == nums[l + 1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r - 1]) {
						r--;
					}
					l++;
					r--;
				} else if (nums[l] + nums[r] < 0 - nums[i]) {
					l++;
				} else {
					r--;
				}
			}

		}
		System.out.println(list);

		return list;

	}
	
	public static void lipiKosamCoding() {
		String str = "yyny";

		int ithIteration = 0;
		int minPenalityValue = Integer.MAX_VALUE;
		
		for (int i = 0; i < str.length(); i++) {

			int penality = 0;

			// left side part
			for (int lf = 0; lf <= i - 1; lf++) {
				char ch = str.charAt(lf);
				if (ch == 'n') {
					penality++;
				}
			}

			// right side part
			for (int j = i; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (ch == 'y') {
					penality++;
				}
			}
			
			if (penality <= minPenalityValue) {
				minPenalityValue = penality;
				ithIteration = i;
			}

		}

		System.out.println(ithIteration);
	}
	
	public static boolean search(int[][] matrix, int target) {
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j] == target) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {

		

	}

}
