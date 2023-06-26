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
		if(head == null) {
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
		if(head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	public static void printLL(Node head) {
		if(head == null) {
			System.out.println("Linked List is empty");
		}
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
	}
	
	public static void add(int idx, int data) {
		if(idx == 0) {
			addFirst(data);
			return;
		}
		Node temp = head;
		int i=0;
		while(i<idx-1) {
			temp = temp.next;
			i++;
		}
		
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}
	
	public static int removeFirst() {
		if(size == 0) {
			System.out.println("LinkedList is empty");
			return Integer.MIN_VALUE;
		}else if(size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		int val = head.data;
		head  = head.next;
		size--;
		return val;
	}
	
	public static int removeLast() {
		if(size == 0) {
			System.out.println("LinkedList is empty");
			return Integer.MIN_VALUE;
		}else if(size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		// reach to size-2
		Node temp = head;
		for(int i=0;i<size-2;i++) {
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
		for(int i=1;i<=idx;i++) {
			temp = temp.next;
		}
		int val = temp.data;
		return val;
	}
	
	public static int iterativeSearch(int data) {
		Node temp = head;
		int i=0;
		while(temp != null) {
			if(temp.data == data) {
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
		
		if(temp == null) {
			return -1;
		}
		
		if(temp.data == data) {
			return i;
		}else {
			return recursiveSearchUtil(data, temp.next, i+1);
		}
	}
	
	public static void reverseLL() {
		Node prev = null;
		Node curr = tail = head;
		Node next ;
		while(curr != null) {
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
		while(temp != null) {
			sz++;
			temp = temp.next;
		}
		
		if(n == sz) {
			int val = head.data;
			head = head.next; // remove First
			return val;
		}
		// nth node from last == (size-n+1)th node from first
		int idx = sz-n+1;
		Node prev = head;
		for(int i=1;i<=idx;i++) {
			prev = prev.next;
		}
		int val = prev.next.data;
		prev.next = prev.next.next;
		return val;
	}
	
	public static Node findMid(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static boolean isPalindrome() {
		
		if(head == null || head.next == null) {
			return true;
		}
		
		// step 1 : find mid
		Node midNode = findMid(head);
		//step 2 : reverse the half
		Node prev = null;
		Node curr = midNode;
		Node next ;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node right = prev; // right half head
		Node left = head;
		//step 3 logic
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			right = right.next;
			left = left.next;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		LL1 list = new LL1();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);

		System.out.println(list.isPalindrome());
		
	}

}
