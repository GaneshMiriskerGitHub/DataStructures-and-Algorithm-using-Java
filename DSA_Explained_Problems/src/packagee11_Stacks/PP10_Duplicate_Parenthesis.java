package packagee11_Stacks;

import java.util.Stack;

public class PP10_Duplicate_Parenthesis {
	
	public static boolean containsDuplicate(String str) {
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			
			if(ch != ')') {
				st.push(ch);
			}else {
				while(st.peek() != '(') {
					st.pop();
				}
			}
		}
		
		if(st.isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		
		String str = "((a+b)+((c+d)))";
		
		boolean result = containsDuplicate(str);
		
		System.out.println(result);

	}

}
