package Type4_LCS_Longest_Common_SubSequence;

import java.util.Arrays;

public class Tester {

	public static void editDistance(String str1, String str2) {
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		dp[0][0] = 0;
		for(int i=1;i<dp.length;i++) {
			dp[i][0] = i;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][1] = i;
		}
		int min_op = Integer.MIN_VALUE;
		// logic
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					// add
					int add = dp[i-1][j]+1;
					// remove
					int remove = dp[i][j-1]+1;
					// replace
					int replace = dp[i-1][j-1] + 1;
					dp[i][j] = Math.min(Math.min(add, remove), replace);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}

	public static void main(String[] args) {
		
		String str1 = "cat";
		String str2 = "cut";

		editDistance(str1, str2);
	}
}
