package packagee11_Stacks;

import java.util.Stack;

public class P5_Reverse_a_string_using_Stack {
	
	public static String reverseString(String str) {
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			st.push(str.charAt(i));
		}
		
		StringBuilder result = new StringBuilder("");
		while(!st.isEmpty()) {
			result.append(st.pop());
		}
		
		return result.toString();
		
	}

	public static void main(String[] args) {
		
		String str = "acbd";
		
		String newStr = reverseString(str);
		
		System.out.println(newStr);

	}

}
