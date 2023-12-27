package package2_strings;

public class P9_Longest_Repeating_Character_Replacement {
	
	public static int maxCount(int[] count) {
		int max = Integer.MIN_VALUE;
		for(int ele: count) max = Math.max(max, ele);
		return max;
	}
	
	public static int longestCharReplmnt(String str, int k) {
		
		int[] count = new int[26];
		
		int l=0;
		int max_len = 0;
		// sliding window
		for(int i=0;i<str.length();i++) {
			int r = i;
			count[str.charAt(r)-'A']++;
			int currLen = r-l+1;
			if(currLen - maxCount(count) <= k) {
				max_len = Math.max(max_len , currLen);
			}else {
				count[str.charAt(r)-'A']--;
				l++;
			}
		}
		
		return max_len;
		
	}

	public static void main(String[] args) {
		
		String str = "ABABBA";
		
		int k = 2;
		
		System.out.println(longestCharReplmnt(str, k));

	}

}
