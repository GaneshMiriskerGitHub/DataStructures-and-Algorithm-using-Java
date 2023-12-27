package packagee10_LinkedLists;

import packagee10_LinkedLists.A3_Swapping_nodes_in_a_LinkedList.Node;

public class A4_Even_Odd_LinkedList {
	
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
		System.out.println();
	}
	
	public static Node evenOddLinkedList(Node head) {
		Node newHead = new Node(-1);
		Node newIterator = newHead;
		Node temp = head;
		while(temp != null) {
			if(temp.data % 2 == 0) {
				Node newNode = new Node(temp.data);
				newIterator.next = newNode;
				newIterator = newIterator.next;
			}
			temp = temp.next;
		}
		temp = head;
		
		while(temp != null) {
			if(temp.data % 2 != 0) {
				Node newNode = new Node(temp.data);
				newIterator.next = newNode;
				newIterator = newIterator.next;
			}
			temp = temp.next;
		}
		
		return newHead.next;
	}
	
	public static Node evenOddLinkedList1(Node head) {
		
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		
		
		
		
		Node iterator = head;
		// adding even nodes
		while(iterator != null) {
			if(iterator.data % 2 == 0) {
				temp.next = new Node(iterator.data);
				temp = temp.next;
			}
			iterator = iterator.next;
		}
		
		
		
		iterator = head;
		// adding odd value nodes
		while(iterator != null) {
			if(iterator.data % 2 == 1) {
				temp.next = new Node(iterator.data);
				temp = temp.next;
			}
			iterator = iterator.next;
		}
		
		return mergedLL.next;
		
	}

	public static void main(String[] args) {
		
		A4_Even_Odd_LinkedList list = new A4_Even_Odd_LinkedList();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
		System.out.println("before even odd :- ");
		list.printLL(head);
		System.out.println();
		
		System.out.println("after even odd :- ");
		Node newNode = list.evenOddLinkedList1(head);
		list.printLL(newNode);
		
		
	}

}
