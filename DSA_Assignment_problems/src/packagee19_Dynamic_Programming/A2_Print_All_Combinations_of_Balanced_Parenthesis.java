package packagee19_Dynamic_Programming;

public class A2_Print_All_Combinations_of_Balanced_Parenthesis { // hreeew idi nene code chesina own ga 
	                // refer video upto tree diagram and code it on your own : - https://www.youtube.com/watch?v=s9fokUqJ76A
	
	
	// leetcode :- https://leetcode.com/problems/generate-parentheses/submissions/
	
	
	public static void printBalancedParantheses(int n, int cClose, int cOpen, String str) {
		
		if(cClose + cOpen == 2*n) {
			System.out.println(str);
			return;
		}
		
		if(cOpen > cClose) { // 
			//choice1 : include open
			if(cOpen < n) {
				printBalancedParantheses(n, cClose, cOpen+1, str+"(");
			}
			//choice2 : include close
			if(cClose < n) {
				printBalancedParantheses(n, cClose+1, cOpen, str+")");
			}
		}else if(cClose == cOpen) {
			if(cOpen < n) {
				printBalancedParantheses(n, cClose, cOpen+1, str+"(");
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		int n = 1;
		printBalancedParantheses(n, 0, 0, "");

	}

}
