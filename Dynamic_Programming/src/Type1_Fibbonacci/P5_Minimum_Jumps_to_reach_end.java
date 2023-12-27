package Type1_Fibbonacci;

public class P5_Minimum_Jumps_to_reach_end {

	
	/*
	 *  1. find if it is possible to reach the end of the array
	 *  2. find minimum no.of steps to reach end of the array
	 */
	
	public static boolean isReachable(int[] arr) {
		
		int goal = arr.length-1;
		
		for(int i=arr.length-2;i>=0;i--) {
			if( arr[i]+i >= goal) {
				goal = i;
			}
		}
		
		return goal == 0;
	}
	
	
	// gfg submission
	static int minJumps(int[] arr) {
		// your code here
		int l = 0;
		int r = 0;
		int res = 0;
		while (r < arr.length - 1) {
			int farthest = 0;
			for (int i = l; i <= r; i++) {
				farthest = Math.max(farthest, i + arr[i]);
			}
			if (farthest == 0) {
				return -1;
			}
			l = r + 1;
			r = farthest;
			res += 1;
		}
		return res;
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, 1, 4};
		
		System.out.println(isReachable(arr));
		System.out.println(minJumps(arr));
	}

}
