package package2_strings;

public class PP12_All_Palindromes_in_String {

	public static int printLongestPalindromicSubstring(String s) {

		int n = s.length();
		if (s == "") {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			// Odd
			int l = i;
			int r = i;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				count++;
				l--;
				r++;
			}

			// Even
			l = i;
			r = i + 1;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				count++;
				l--;
				r++;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		System.out.println(printLongestPalindromicSubstring(str));

	}

}
