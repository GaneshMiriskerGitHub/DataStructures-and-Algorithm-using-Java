package package6_LinkedList;

import package6_LinkedList.P2_LinkedList_Cycle.Node;

public class PP26_subTract_a_LinkedList {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			Node next = null;
		}
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
	
	static Node subtractLinkedLists(Node l1, Node l2)
    {
        // code here
        Node temp1 = l1;
        String s1 = "";
        while(temp1 != null) {
            s1 = s1+temp1.data;
            temp1 = temp1.next;
        }
        
        Node temp2 = l2;
        String s2 = "";
        while(temp2 != null) {
            s2 = s2+temp2.data;
            temp2 = temp2.next;
        }
        
        Integer n1 = Integer.parseInt(s1);
        Integer n2 = Integer.parseInt(s2);
        
        int difference = Math.abs(n1-n2);
        
        String s3 = difference+"";
        
        Node resultNode = new Node(-1);
        Node temp = resultNode;
        for(int i=0;i<s3.length();i++) {
            Node newNode  = new Node(Integer.parseInt(s3.charAt(i)+""));
            temp.next = newNode;
            temp = temp.next;
        }
        
        return resultNode.next;
    }
	

	public static void main(String[] args) {
	    // Example usage
	    Node l1 = new Node(1);
	    l1.next = new Node(0);
	    l1.next.next = new Node(0);
	    l1.next.next.next = new Node(0);

	    Node l2 = new Node(9);
	    l2.next = new Node(8);

	    System.out.print("Number 1: ");
	    printLL(l1);

	    System.out.print("Number 2: ");
	    printLL(l2);

	    Node result = subtractLinkedLists(l1, l2);

	    System.out.print("Result: ");
	    printLL(result);
	}

}
