package packagee12_Queue;

public class P3_Implemetation_of_Queue_using_LinkedList {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class Queue {
		
		static Node head;
		static Node tail;
		
		
		public static boolean isEmpty() {
			return head == null && tail == null;
		}
		
		public static void add(int data) {
			
			Node newNode = new Node(data);
			if(head == null) {
				head = tail = newNode;
				return;
			}
			tail.next = newNode;
			tail = newNode;
			
		}
		
		public static int remove(int data) {
			
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			
			int result = head.data;
			head = head.next;
			return result;
		}
		
		public static int peek() {
			
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			
			int result = head.data;
			return result;
			
		}
		
	}

	public static void main(String[] args) {
		
		

	}

}
