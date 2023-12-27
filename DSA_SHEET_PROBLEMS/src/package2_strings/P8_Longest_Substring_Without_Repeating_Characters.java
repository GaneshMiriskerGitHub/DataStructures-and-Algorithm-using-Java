package package2_strings;

import java.util.HashSet;
import java.util.Set;

public class P8_Longest_Substring_Without_Repeating_Characters {
	
	public static int longestSubStringWithoutRepeatingCharacters(String str) {
		
		Set<Character> set = new HashSet<>();
		
		int l = 0;
		int max_len = 0;
		for(int i=0;i<str.length();i++) {
			int r = i;
			char r_ch = str.charAt(r);
			while(set.contains(r_ch)) {
				char l_ch = str.charAt(l);
				set.remove(l_ch);
				l++;
			}
			set.add(r_ch);
			max_len = Math.max(max_len, r-l+1);
			
		}
		
		return max_len;
		
	}

	public static void main(String[] args) {
		
		String str = "abcabcbb";
		
		System.out.println(longestSubStringWithoutRepeatingCharacters(str));

	}

}
