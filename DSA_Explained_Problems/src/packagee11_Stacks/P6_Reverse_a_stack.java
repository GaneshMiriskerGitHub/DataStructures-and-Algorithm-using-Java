package packagee11_Stacks;

import java.util.Stack;

public class P6_Reverse_a_stack {

	public static void reverseStack(Stack<Integer> st) {
		
		if(st.isEmpty()) {
			return;
		}

		int top = st.pop();
		reverseStack(st);
		pushAtBottom(st, top);
	}

	public static void pushAtBottom(Stack<Integer> st, int data) {

		if (st.isEmpty()) {
			st.push(data);
			return;
		}

		int curr = st.pop();

		pushAtBottom(st, data);

		st.push(curr);
	}

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);

		System.out.println(st);

		reverseStack(st);
		
		System.out.println(st);

	}

}
