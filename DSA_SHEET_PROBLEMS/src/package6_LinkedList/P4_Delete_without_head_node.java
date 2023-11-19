package package6_LinkedList;

public class P4_Delete_without_head_node {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// this below code is to move all greater elements to the right
	public static Node compute(Node head) {
		Node temp1 = head;
		Node temp2 = head;

		Node result = new Node(-1);
		Node newHead = result;
		while (temp1 != null) {
			boolean flagFound = false;
			temp2 = temp1;
			while (temp2 != null) {
				if (temp1.data < temp2.data) {
					flagFound = true;
					break;
				} else {
					temp2 = temp2.next;
				}
			}
			if (!flagFound) {
				newHead.next = new Node(temp1.data);
				newHead = newHead.next;
			} else {
				newHead.next = temp1.next;
				;
			}
			temp1 = temp1.next;
		}

		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
