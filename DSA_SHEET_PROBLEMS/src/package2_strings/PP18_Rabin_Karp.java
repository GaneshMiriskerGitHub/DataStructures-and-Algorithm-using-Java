package package2_strings;

import java.util.LinkedList;
import java.util.List;

// learned from 
// youtube : Abdul Bari
// Dry runned gfg Rabin Karp code
// may be battified needed : specifically : why n-m ? : i know why but don't know why it is "<= n-m"

public class PP18_Rabin_Karp { 

	public final static int d = 256;

	public static void Rabin_Karp(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		int p = 0;
		int t = 0;
		int h = 1;
		// calculating pow(256, m-1)%101;
		h = (int) (Math.pow(256, m-1)%101);
		
		// hasVal of first m characters in text
		for(int i=0;i<m;i++) {
			p = (256*p+pattern.charAt(i)%101);
			t = (256*t+text.charAt(i)%101);
		}
		
		// sliding over the complete text
		for(int i=0;i<=n-m;i++) {
			// if currWindowHas == PatternHashValue
			if(p==t) {
				// if same value : check for each character
				int j=0;
				for(j=0;j<m;j++) {
					if(pattern.charAt(j) != text.charAt(i+j)) {
						j = -1;
						break;
					}
				}
				
				if(j != -1) {
					System.out.println("pattern found at index = "+i);
				}
			}else { // move to next window : update the current hashval for text
				if(i<n-m) {
					int previous = text.charAt(i)*h;
					int nextVal = text.charAt(i+m);
					
					t = ((t-previous)*256 + nextVal)%101;
				}
				// if t gets updated to a -ve value , manually add a +ve value
				if(t<0) {
					t = (t+101);
				}
			}
		}
		
	}
	
	// Solution 2 : idi na sontha code, bokkalo algorithm yevadra kanipettindi, thokkalo code rasaru, 
	//              refer the below code idi ey final and fix
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
			hashValue += (int) (ch*Math.pow(10, pow));
			i++;
			pow++;
		}
		return hashValue;
	}
		

	public static void main(String[] args) {

		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		
		Rabin_Karp(text, pattern);
		
		search(text, pattern);

	}

}
