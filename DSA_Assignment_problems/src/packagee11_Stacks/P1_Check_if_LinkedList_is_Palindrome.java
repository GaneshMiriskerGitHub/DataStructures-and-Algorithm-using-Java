package packagee11_Stacks;

import java.util.Stack;

public class P1_Check_if_LinkedList_is_Palindrome {
	
	static class Node {
		
		int data;
		Node ptr;
		
		public Node(int data) {
			this.data = data;
			this.ptr = null;
		}
	}
	
	public static boolean isPalindrome(Node head) {
		
		// Step 1 : add all values in stack
		Node temp = head;
		Stack<Integer> st = new Stack<>();
		while(temp != null) {
			st.push(temp.data);
			temp = temp.ptr;
		}
		
		// Step 2 :
		// now check all elements in stack are matching with head node's chain
		// reason: while comparing, stack gives poped values which will be in reverse
		Node curr = head;
		while(curr != null) {
			if(curr.data != st.peek()) {
				return false;
			}
			
			curr = curr.ptr;
			st.pop();
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);
		one.ptr = two;
		two.ptr = three;
		three.ptr = four;
		four.ptr = five;
		five.ptr = six;
		six.ptr = seven;
		boolean condition = isPalindrome(one);
		System.out.println("Palindrome :" + condition);


	}

}
