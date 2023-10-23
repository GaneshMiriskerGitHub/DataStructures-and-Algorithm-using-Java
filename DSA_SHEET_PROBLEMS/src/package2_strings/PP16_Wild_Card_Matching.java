package package2_strings;

public class PP16_Wild_Card_Matching { // DP

	public static boolean isValid(String s, String p) {

		int n = s.length();
		int m = p.length();

		boolean[][] dp = new boolean[n + 1][m + 1];

		dp[0][0] = true;
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = false;
		}

		for (int j = 1; j < m + 1; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// condition 1
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[s.length()][p.length()];
	}

	public static void main(String[] args) {

		String s = "baaabab";

		String p = "ba*a?";

		System.out.println(isValid(s, p));

	}

}
