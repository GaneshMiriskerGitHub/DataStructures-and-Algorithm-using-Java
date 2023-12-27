package package2_strings;

public class PP17_Longest_prefix_Suffix {
	
	// 1. Solved on leetcode - hard question
	// Resources :-
	// https://www.youtube.com/watch?v=JoF0Z7nVSrA

	
	public static int longesPrefixSufix(String s) {   // O(n+m)
		if(s.isEmpty()) return 0;
        // building lps[] values
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int i=1;
        int prevLPS = lps[0];
        while(i<s.length()) {
            if(s.charAt(i) == s.charAt(prevLPS)) {
                lps[i] = ++prevLPS;
                i++;
            }else if(prevLPS == 0) {
                lps[i] = 0;
                i++;
            }else{
                prevLPS = lps[prevLPS-1];
            } 
        }
        
        return lps[s.length()-1];
	}
	

	public static void main(String[] args) {
		
		String s = "abab";
		
		System.out.println(longesPrefixSufix(s));

	}

}
