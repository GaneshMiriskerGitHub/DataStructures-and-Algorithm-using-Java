package package2_strings;

public class PP11_Longest_Palindromic_Substring {
	
	public static void printLongestPalindromicSubstring(String str) {
		
		int len = str.length();
		String res = "";
		int max_len = 0;
		
		for(int i=0;i<len;i++) {
			
			int l = i;
			int r = i;
			
			// odd scenario
			while(l>=0 && r<len && str.charAt(l) == str.charAt(r)) {
				if(r-l+1 > max_len) {
					max_len = r-l+1;
					res = str.substring(l, r+1);
				}
				l--;
				r++;
			}
			
			l=i;
			r=i+1;
			
			// even scenario
			while(l>=0 && r<len && str.charAt(l) == str.charAt(r)) {
				if(r-l+1 > max_len) {
					max_len = r-l+1;
					res = str.substring(l, r+1);
				}
				l--;
				r++;
			}
			
		}
		
		System.out.println(res);
		
	}

	public static void main(String[] args) {
		
		String str = "babad";
		
		printLongestPalindromicSubstring(str);

	}

}
