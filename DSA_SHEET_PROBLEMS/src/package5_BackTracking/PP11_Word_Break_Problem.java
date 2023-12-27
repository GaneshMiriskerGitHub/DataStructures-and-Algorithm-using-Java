package package5_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PP11_Word_Break_Problem { // https://www.youtube.com/watch?v=LmHWIsBQBU4
	
	  public static boolean wordBreakHelper(String A, ArrayList<String> B) { // level 1
	        if(A.isEmpty()) {
	            return true;
	        }
	        
	        for(int i=0;i<A.length();i++) {
	            String left = A.substring(0, i+1);
	            if(B.contains(left) && wordBreakHelper(A.substring(i+1), B)) {
	                return true;
	            }
	        }
	        
	        return false;
	    }
	
	public static void wordBreak(List<String> wordList, String sentences, String ans) { // level 2
		
		if(sentences.isEmpty()) {
			System.out.println(ans.substring(0, ans.length()-1));
			return;
		}
		
		for(int i=0;i<sentences.length();i++) {
			String left = sentences.substring(0, i+1);
			if(wordList.contains(left)) {
				String right = sentences.substring(i+1);
				wordBreak(wordList, right, ans+left+" ");
			}
		}
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordList = Arrays.asList("cats", "cat", "and", "sand", "dog");
	 
	        wordBreak(wordList, "catsanddog", "");
	 
	      

	}

}
