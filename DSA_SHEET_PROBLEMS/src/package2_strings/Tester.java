package package2_strings;

import java.util.HashMap;
import java.util.Map;

public class Tester {

	public static void search(String str, String pattern) {

		int hashValuePattern = hashValue(pattern);
		
		for(int i=0;i<str.length()-pattern.length()+1 ;i++) {
			String currStr = str.substring(i, i+pattern.length());
			int hashValueCurrStr = hashValue(currStr);
			if(hashValueCurrStr == hashValuePattern) {
				System.out.println(i);
			}
		}
		
	}
	
	public static int hashValue(String s) {
		int i=0;
		int hashValue = 1;
		int pow = 0;
		while(i<s.length()) {
			char ch = s.charAt(i);
			hashValue += (int) (ch*Math.pow(10, pow+1));
			i++;
		}
		return hashValue;
	}

	public static void main(String[] args) {

		String str = "this is a text";
		String pattern = "is a t";
		
		search(str, pattern);

	}

}
