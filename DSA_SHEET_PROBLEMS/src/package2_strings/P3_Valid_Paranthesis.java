package package2_strings;

import java.util.Stack;

public class P3_Valid_Paranthesis {
	
	public static boolean isValidParenthesis(String str) {
		
		Stack<Character> st = new Stack<>();
		st.add(str.charAt(0));
		for(int i=1;i<str.length();i++) {
			char ch = str.charAt(i);
			
			if(ch == ')' || ch == ']' || ch == '}') {
				if(st.isEmpty()) {
					return false;
				}
				int st_ch = st.peek();
				if(st_ch == '(' && ch == ')' 
						|| st_ch == '[' && ch == ']' 
						|| st_ch == '{' && ch == '}' ) {
					st.pop();
					continue;
				}else {
					return false;
				}
			}else {
				st.push(ch);
			}
			
		}
		
		return st.isEmpty();
	}

	public static void main(String[] args) {
		
		String str = "()[]{))";
		
		System.out.println(isValidParenthesis(str));

	}

}
