package packagee10_LinkedList;

import packagee10_LinkedList.LL1.Node;

public class Tester {

	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static Node head;
	static Node tail;
	static int sz;
	
	public static void addFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			sz++;
			return;
		}
		newNode.next = head;
		head = newNode;
		sz++;
	}
	
	public static void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			sz++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		sz++;
	}
	
	public static void printLL(Node head) {
		if(head == null) {
			System.out.println("list is empty");
		}else {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
		}
	}
	
	public static void add(int idx, int data) {
		if(idx == 0) {
			addFirst(data);
			sz++;
			return;
		}
		if(idx == sz) {
			addLast(data);
			sz++;
			return;
		}
		int i = 0;
		Node temp = head;
		while(i<idx-1) {
			temp = temp.next;
			i++;
		}
		
		Node newNode = new Node(data);
		
		newNode.next = temp.next;
		temp.next = newNode;
		sz++;
	}
	
	public static int removeFirst() {
		if(head == null) {
			System.out.println("list is empty");
		}
		if(sz == 1) {
			head = tail = null;
			return Integer.MAX_VALUE;
		}
		int val = head.data;
		head = head.next;
		sz--;
		return val;
	}
	
	public static int removeLast() {
		if(head == null) {
			System.out.println("list is empty");
		}
		if(sz == 1) {
			head = tail = null;
			return Integer.MAX_VALUE;
		}
		
		Node temp = head;
		int i = 0;
		while(i<sz-2) {
			temp = temp.next;
			i++;
		}
		
		int val = temp.data;
		temp.next = null;
		
		tail = temp;
		sz--;
		
		return val;
	}
	
	public static void reverseLL() {
		
		Node prev = null;
		Node curr = head ;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
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
		
		Node midNode = findMid(head);
		
		Node prev = null;
		Node curr = midNode;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node left = head;
		Node right = prev;
		
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tester ll = new Tester();
		
//		ll.addFirst(1);
//		ll.addLast(4);
//		
//		ll.add(1, 2);
//		ll.add(2, 3);
//		
//		ll.printLL(head);
		
	
		
//		
//		ll.reverseLL();System.out.println();
//		
//		ll.printLL(head);
		
		System.out.println(ll.isPalindrome());

	}

}
