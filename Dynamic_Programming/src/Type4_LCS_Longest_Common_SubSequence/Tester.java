package Type4_LCS_Longest_Common_SubSequence;

import java.util.Arrays;

public class Tester {
	
	public static int Lic(int[] arr) { // almost passed all test cases, just failed last test cases due to time limit exceeding
		
		int[] arr2 = Arrays.stream(arr).distinct().toArray();
		
		int[] arr1 = Arrays.copyOfRange(arr2, 0, arr2.length);
		
		Arrays.sort(arr2);
		
		return lcs(arr1, arr2);
		
	}
	
	public static int lcs(int[] arr1, int[] arr2) {
		
		
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					int choice1 = dp[i-1][j];
					int choice2 = dp[i][j-1];
					dp[i][j] = Math.max(choice1, choice2);
				}
				
			}
		}
		
		return dp[arr1.length][arr2.length];
	}


	public static void main(String[] args) {
		
		
		int[] arr = {50, 3, 10, 7, 40, 80};
		
		
		System.out.println(Lic(arr));
		
		
	}
}
 