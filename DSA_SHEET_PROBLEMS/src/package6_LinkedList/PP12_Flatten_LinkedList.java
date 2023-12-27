package package6_LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class PP12_Flatten_LinkedList { // to be solved later
	
	// resource : - gfg and youtube:- https://www.youtube.com/watch?v=kvCYxPKpPGg

	static Node head;

	static class Node {

		int data;
		Node next, child;

		Node(int d) {
			data = d;
			next = child = null;
		}
	}

	// A utility function to create a linked list with n nodes. The data
	// of nodes is taken from arr[]. All child pointers are set as NULL
	public static Node createList(int arr[], int n) {
		Node node = null;
		Node p = null;

		int i;
		for (i = 0; i < n; ++i) {
			if (node == null) {
				node = p = new Node(arr[i]);
			} else {
				p.next = new Node(arr[i]);
				p = p.next;
			}
			p.next = p.child = null;
		}
		return node;
	}

	// A utility function to print all nodes of a linked list
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public static Node createList() {
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		int arr3[] = new int[] { 17, 6 };
		int arr4[] = new int[] { 9, 8 };
		int arr5[] = new int[] { 19, 15 };
		int arr6[] = new int[] { 2 };
		int arr7[] = new int[] { 16 };
		int arr8[] = new int[] { 3 };

		/* create 8 linked lists */
		Node head1 = createList(arr1, arr1.length);
		Node head2 = createList(arr2, arr2.length);
		Node head3 = createList(arr3, arr3.length);
		Node head4 = createList(arr4, arr4.length);
		Node head5 = createList(arr5, arr5.length);
		Node head6 = createList(arr6, arr6.length);
		Node head7 = createList(arr7, arr7.length);
		Node head8 = createList(arr8, arr8.length);

		/* modify child pointers to create the list shown above */
		head1.child = head2;
		head1.next.next.next.child = head3;
		head3.child = head4;
		head4.child = head5;
		head2.next.child = head6;
		head2.next.next.child = head7;
		head7.child = head8;

		/*
		 * Return head pointer of first linked list. Note that all nodes are reachable
		 * from head1
		 */
		return head1;
	}

	/* The main function that flattens a multilevel linked list */
	public static void flattenList(Node node) {
		
		Queue<Node> q = new LinkedList<>();
		
		Node curr = node;
		while(curr != null) {
			
			if(curr.child != null) {
				q.add(curr.child);
			}
			
			if(curr.next == null) {
				curr.next = q.poll();
			}
			
			curr = curr.next;
			
		}
		
	}

	public static void main(String[] args) {

		Node head = createList();
		flattenList(head);
		printList(head);
	}

}
