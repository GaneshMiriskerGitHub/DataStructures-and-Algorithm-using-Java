package package6_LinkedList;

import java.util.HashSet;

public class P5_Remove_Duplicates_from_Unsorted_LinkedList {
	
	static class Node {
        int val;
        Node next;
 
        public Node(int val) { this.val = val; }
    }

	static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
	
	public static void removeDuplicate(Node head) {
		
		Node newHead = new Node(-1);
		Node temp = newHead;
		HashSet<Integer> hs = new HashSet<>();
		Node curr = head;
		
		while(curr != null) {
			if(!hs.contains(curr.val)) {
				hs.add(curr.val);
				temp.next = curr;
				temp = temp.next;
				curr = curr.next;
			}else {
				temp.next = curr.next; // when skipping the curr node, we must also keep updating the temp pointer as well so we st add this line.
				curr = curr.next;
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		/* The constructed linked list is:
        10->12->11->11->12->11->10*/
       Node start = new Node(10);
       start.next = new Node(12);
       start.next.next = new Node(11);
       start.next.next.next = new Node(11);
       start.next.next.next.next = new Node(11);
       start.next.next.next.next.next = new Node(12);
       start.next.next.next.next.next.next = new Node(11);
       start.next.next.next.next.next.next.next = new Node(10);

       System.out.println(
           "Linked list before removing duplicates :");
       printList(start);

       removeDuplicate(start);

       System.out.println(
           "\nLinked list after removing duplicates :");
       printList(start);

	}

}
