package packagee10_LinkedLists;

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
			head=tail=newNode;
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
			head=tail=newNode;
			sz++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		sz++;
	}
	
	public static void printLL(Node head) {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void add(int data, int idx) {
		if(idx == 0) {
			addFirst(data);
			return;
		}
		// reach tem till idx-1;
		Node temp = head;
		int i=1;
		while(i<=idx-1) {
			temp = temp.next;
			i++;
		}
		System.out.println(temp.data);
		
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
		sz++;
	}
	
	
	public static int removeFirst() {
		if(sz == 0) {
			System.out.println("Empty!");
			return Integer.MIN_VALUE;
		}else if(sz == 1) {
			head = tail = null;
		}
		
		int val = head.data;
		head = head.next;
		return val;
	}
	
	public static int removeLast(int data) {
		if(sz == 0) {
			System.out.println("Empty!");
			return Integer.MIN_VALUE;
		}else if(sz == 1) {
			head = tail = null;
		}
		
		int val = tail.data;
		tail = tail.next;
		return val;
	}
	
	public static int iterativeSearch(Node head, int data) {
		if(head.data == data) {
			return 0;
		}
		Node temp = head;
		int i=0;
		while(i<sz) {
			if(temp.data == data) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		
		return -1;
	}
	
	public static int recursiveSearch(Node head, int data) {
		Node temp = head;
		return recursiveSearchHelper(data, 0, temp);
		
	}
	
	public static int recursiveSearchHelper(int data, int idx, Node temp) {
		if(idx == sz) return -1;
		
		if(temp.data == data) return idx;
		
		return recursiveSearchHelper(data, idx+1, temp.next);
	}
	
	public static void reverseList(Node head) {
		
		Node prev = null;
		Node curr = head;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
	}
	
	public static int removeNthNodeFromEnd(Node head, int idx) { 
		if(idx > sz) {
			System.out.println("not possible");
			return Integer.MAX_VALUE;
		}
		if(sz == idx) {
			return removeFirst();
		}
		if(sz-1-idx <= 0) {
			System.out.println("not possible");
			return Integer.MAX_VALUE;
		}
		Node prev = head;           
		int i=0;
		while(i<sz-1-idx) {
			prev = prev.next;
			i++;
		}
		
		int val = prev.next.data;
		Node temp = prev.next.next;
		prev.next = temp;
		sz--;
		return val;
	}
	
	public static Node getMid(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static boolean isPalindrome(Node head) {
		
		Node midNode = getMid(head);
		
		Node prev = null;
		Node curr = midNode;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node right = prev;
		Node left = head;
		
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		
		return true;
	}
	
	public static boolean cycleExists(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeCycle(Node head) {
		boolean cycle = cycleExists(head);
		if(!cycle) {
			System.out.println("cycle does not exist");
			return;
		}
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		
		slow = head;
		Node prev = null;
		while(slow != fast) {
			slow = slow.next;
			prev = fast;
			fast = fast.next;
		}
		
		prev.next = null;
	}
	
	public static Node mergeSortLL(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		// find mid
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node midNode = slow;
		
		Node rightList = midNode.next;
		Node leftList = head;
		midNode.next = null;
		
		Node left = mergeSortLL(rightList);
		Node right = mergeSortLL(leftList);
		
		return merge(left, right);
	}
	
	public static Node merge(Node left, Node right) {
		
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		
		while(left != null && right != null) {
			if(left.data < right.data) {
				temp.next = left;
				left = left.next;
			}else {
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}
		
		while(left != null) {
			temp.next = left;
			left = left.next;
			temp = temp.next;
		}
		
		while(right != null) {
			temp.next = right;
			right = right.next;
			temp = temp.next;
		}
		
		return mergedLL.next;
	}
	
	public static Node zigzag(Node head) {
		
		// find mid
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// reverse the right half
		Node midNode = slow;
		Node leftHead = head;
		Node rightHead = midNode.next;
		midNode.next = null;
		
		Node prev = null;
		Node curr = rightHead;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node RightHead = prev;
		
		// merge to zig zag
		boolean flag = false;
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		while(RightHead != null && leftHead != null) {
			if(flag) {
				temp.next = RightHead;
				RightHead = RightHead.next;
				temp = temp.next;
				flag = false;
			}else {
				temp.next = leftHead;
				leftHead = leftHead.next;
				temp = temp.next;
				flag = true;
			}
		}
		
		while(RightHead != null ) {
			temp.next = RightHead;
			RightHead = RightHead.next;
			temp = temp.next;
		}
		
		while(leftHead != null) {
			temp.next = leftHead;
			leftHead = leftHead.next;
			temp = temp.next;
		}
		
		return mergedLL.next;
		
	}

	public static void main(String[] args) {

		addLast(1);
		addLast(2);
		addLast(3);
		addLast(4);
		addLast(5);
		
				
		printLL(head);
		
		Node zigzag = zigzag(head);
		
		printLL(zigzag);

	}

}
