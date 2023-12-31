package packagee11_Stacks;

import java.util.Stack;

public class P3_Decode_a_String {

	// learning resource :- https://www.youtube.com/watch?v=qB0zZpBJlh8

	// own code with chatgpt reference
	public static String decode(String str) {

		Stack<Object> st = new Stack<>();

		for (char c : str.toCharArray()) {

			if (c != ']') {
				st.push(c);
			} else {

				String currVal = "";
				while (!st.isEmpty() && st.peek() instanceof Character && (char) st.peek() != '[') {
					currVal = st.pop() + currVal;
				}
				st.pop();

				// find the number
				StringBuilder number = new StringBuilder();
				while (!st.isEmpty() && st.peek() instanceof Character && Character.isDigit((char) st.peek())) {
					number.insert(0, st.pop());
				}

				int count = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
				StringBuilder currValrepeated = new StringBuilder("");
				for (int i = 0; i < count; i++) {
					currValrepeated.append(currVal);
				}

//				st.push(currValrepeated.toString());
				// Push each character of the repeated string onto the stack
				for (char ch : currValrepeated.toString().toCharArray()) {
					st.push(ch);
				}
			}

		}

		StringBuilder result = new StringBuilder("");
		for (Object obj : st) {

			if (obj instanceof Character) {
				result.append((char) obj);
			} else if (obj instanceof String) {
				result.append((String) obj);
			}

		}

		return result.toString();
	}

	// chatgpt code
	public static String decodeString(String s) {
		Stack<Object> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c != ']') {
				stack.push(c);
			} else {
				StringBuilder subStr = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() instanceof Character && (char) stack.peek() != '[') {
					subStr.insert(0, stack.pop());
				}
				stack.pop(); // Pop the '['

				StringBuilder multiplier = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() instanceof Character
						&& Character.isDigit((char) stack.peek())) {
					multiplier.insert(0, stack.pop());
				}

				int count = multiplier.length() > 0 ? Integer.parseInt(multiplier.toString()) : 1;

				// Push each character of the repeated string onto the stack
				for (int i = 0; i < count; i++) {
					for (char ch : subStr.toString().toCharArray()) {
						stack.push(ch);
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}

		return result.toString();
	}

	public static void main(String[] args) {

//		String encodedStr = "3[ab2[cv]]";
		String encodedStr = "100[leetcode]";

		String decodedStr = decodeString(encodedStr);

		System.out.println(decodedStr);

	}

}
