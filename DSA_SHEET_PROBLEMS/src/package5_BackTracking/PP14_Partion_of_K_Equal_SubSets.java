package package5_BackTracking;

import java.util.Arrays;

public class PP14_Partion_of_K_Equal_SubSets { 
	
	public static boolean partitionKEqualSubSet(int[] nums, int k) {
		
		int sum = Arrays.stream(nums).sum();
		int maxNum = Arrays.stream(nums).max().getAsInt();
		
		if(sum%2!=0) return false;
		
		if(k>nums.length || maxNum > sum/k) return false;
		
		int target = sum/k;
		
		boolean[] vis = new boolean[nums.length];
		
		boolean isPossible = partition(nums, vis, k, target,0, 0);
		
		return isPossible;
	}
	
	public static boolean partition(int[] arr, boolean[] vis, int k, int target,int currSum, int idx) {
		
		if(k==0) return true;
		if(currSum > target) return false;
		if(currSum == target) {
			return partition(arr, vis, k-1, target, 0, 0);
		}
		
		for(int i=idx;i<arr.length;i++) {
			
			if(!vis[i]) {
				vis[i] = true;
				if(partition(arr, vis, k, target, currSum+arr[i], idx+1)) {
					return true;
				}
				vis[i] = false;
			}
			
		}
		
		return false;
		
	}
	

	public static void main(String[] args) {
		
		int[] nums = {12,1,2,3,18,2,5,2,11,1};
        int k = 4;
        boolean isPossible = partitionKEqualSubSet(nums, k);
        
        System.out.println(isPossible);

	}

}
