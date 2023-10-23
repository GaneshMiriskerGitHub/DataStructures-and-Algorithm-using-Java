package package2_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PPP21_Booye_More_Algorithm { // Resource :- https://www.youtube.com/watch?v=hXqRLILcC1k
// for code refer the gfg website and do dry run, i still did not figured out how to convert the concept to code
	
	public static void boyerMoore(String text, String pattern) {
		int t = text.length();
		int p = pattern.length();
		// Step :1 find bad Match Table;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < p; i++) {
			char ch = pattern.charAt(i);
			set.add(ch);
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p; i++) {
			char ch = pattern.charAt(i);
			int value = Math.max(1, p - i - 1);
			map.put(ch, value);
		}
		map.put('*', p);

		System.out.println(map.values());

		int l = 0;
		int r = 0;
		while(l<t-p) {
			r = l + pattern.length();
			String currStr = text.substring(l, r);
			int j = p - 1;
			while (j >= 0 && currStr.charAt(j) == pattern.charAt(j)) {
				j--;
			}
			if (j < 0) {
				System.out.println("pattern found at index = " + l);
				l++;
			} else {
				l++;
			}
		}
	}

	public static void main(String[] args) {

		String text = "This is a text";
		String pattern = "text";

		boyerMoore(text, pattern);
	}

}
