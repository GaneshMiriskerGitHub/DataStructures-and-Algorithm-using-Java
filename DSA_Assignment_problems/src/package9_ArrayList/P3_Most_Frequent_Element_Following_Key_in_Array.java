package package9_ArrayList;

import java.util.HashMap;
import java.util.Map;

public class P3_Most_Frequent_Element_Following_Key_in_Array {
	
	// submission link:- https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/submissions/1127933892/

	public static int mostFrequent(int[] nums, int key) {

		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] == key) {
				map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
			}
		}
		
		int maxCount = Integer.MIN_VALUE;
		int ans = 0;
		for(Integer ele : map.keySet()) {
			if(maxCount < map.get(ele)) {
				maxCount = map.get(ele);
				ans = ele;
			}
		}
		
		
		return ans;
		
	}

	public static void main(String[] args) {

		int[] arr = { 2,1000,2,1000,2,3 };
		int key = 2;
		
		System.out.println(mostFrequent(arr, key));

	}

}
