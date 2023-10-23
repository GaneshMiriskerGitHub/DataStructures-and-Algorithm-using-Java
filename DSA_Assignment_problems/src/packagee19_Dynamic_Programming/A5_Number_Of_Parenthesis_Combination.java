package packagee19_Dynamic_Programming;

public class A5_Number_Of_Parenthesis_Combination { // copy paste catalan's number code
	
	
	 
	public static int noOfParanthsis(int N) {
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<dp.length;i++) {
			for(int j = 0;j<i;j++)
			dp[i] += dp[j]*dp[i-(j+1)];
		}
		
		return dp[N];
	}

	public static void main(String[] args) {
		
		int N = 4;
		
		System.out.println(noOfParanthsis(N));

	}

}
