package package9_ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P2_Lonely_Elements_in_ArrayList {
	
	// submission link:- https://leetcode.com/problems/monotonic-array/description/

	public static List<Integer> findLonely(int[] nums) {

		// list to return at the end of the code
		List<Integer> list = new ArrayList<>();

		// a map to store the count of each ele from the nums array
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : nums) {
			if (map.containsKey(ele)) {
				int count = map.get(ele);
				map.put(ele, count + 1);
			} else {
				map.put(ele, 1);
			}
		}

		// validations
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) <= 1) { // count should be only once
				if (!map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) { // should not contain , previous
																						// value and next value
					list.add(nums[i]); // then we are good to go to add it in our list
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		
		

	}

}
