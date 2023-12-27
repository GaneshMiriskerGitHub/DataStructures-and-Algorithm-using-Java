package packagee10_LinkedList;


public class LL1 {

	static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static Node head;
	public static Node tail;
	public static int size;

	public static void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}

	public static void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public static void printLL(Node head) {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void add(int idx, int data) {
		if (idx == 0) {
			addFirst(data);
			return;
		}
		Node temp = head;
		int i = 0;
		while (i < idx - 1) {
			temp = temp.next;
			i++;
		}

		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}

	public static int removeFirst() {
		if (size == 0) {
			System.out.println("LinkedList is empty");
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}

	public static int removeLast() {
		if (size == 0) {
			System.out.println("LinkedList is empty");
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		// reach to size-2
		Node temp = head;
		for (int i = 0; i < size - 2; i++) {
			temp = temp.next;
		}
		int val = temp.next.data;
		temp.next = null;
		size--;
		tail = temp;
		return val;
	}

	public static int get(int idx) {
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		int val = temp.data;
		return val;
	}

	public static int iterativeSearch(int data) {
		Node temp = head;
		int i = 0;
		while (temp != null) {
			if (temp.data == data) {
				return i;
			}
			temp = temp.next;
			i++;
		}

		return -1;
	}

	public static int recursiveSearch(int data) {
		return recursiveSearchUtil(data, head, 0);
	}

	public static int recursiveSearchUtil(int data, Node temp, int i) {

		if (temp == null) {
			return -1;
		}

		if (temp.data == data) {
			return i;
		} else {
			return recursiveSearchUtil(data, temp.next, i + 1);
		}
	}

	public static void reverseLL() {
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public static int removeNthNode(int n) {
		int sz = 0;
		Node temp = head;
		while (temp != null) {
			sz++;
			temp = temp.next;
		}

		if (n == sz) {
			int val = head.data;
			head = head.next; // remove First
			return val;
		}
		// nth node from last == (size-n+1)th node from first
		int idx = sz - n + 1;
		Node prev = head;
		for (int i = 1; i <= idx; i++) {
			prev = prev.next;
		}
		int val = prev.next.data;
		prev.next = prev.next.next;
		return val;
	}

	public static Node findMid(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static boolean isPalindrome() {

		if (head == null || head.next == null) {
			return true;
		}

		// step 1 : find mid
		Node midNode = findMid(head);

		// step 2 : reverse the half
		Node prev = null;
		Node curr = midNode;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node right = prev; // right half head
		Node left = head;
		// step 3 logic
		while (right != null) {
			if (left.data != right.data) {
				return false;
			}
			right = right.next;
			left = left.next;
		}

		return true;

	}
	
	public static Node segregate(Node head) {
		// add your code here
		Node temp = head;
		int count0s = 0;
		int count1s = 0;
		int count2s = 0;
		while (temp != null) {
			if (temp.data == 0) {
				count0s++;
			} else if (temp.data == 1) {
				count1s++;
			} else if (temp.data == 2) {
				count2s++;
			}
			temp = temp.next;
		}

		Node result = new Node(-1);
		Node newHead = result;
		int i = 1;
		while (i <= count0s) {
			newHead.next = new Node(0);
			newHead = newHead.next;
			i++;
		}
		i = 1;
		while (i <= count1s) {
			newHead.next = new Node(1);
			newHead = newHead.next;
			i++;
		}
		i = 1;
		while (i <= count2s) {
			newHead.next = new Node(2);
			newHead = newHead.next;
			i++;
		}

		return result.next;
	}

	public static void main(String[] args) {

		LL1 list = new LL1(); // 12->15->10->11->5->6->2->3
		addLast(0);
		addLast(1);
		addLast(0);
		addLast(2);
		addLast(1);
		addLast(1);
		addLast(2);
		addLast(1);
		addLast(2);

		printLL(head);

		Node newHead = segregate(head);

		printLL(newHead);

	}

}
