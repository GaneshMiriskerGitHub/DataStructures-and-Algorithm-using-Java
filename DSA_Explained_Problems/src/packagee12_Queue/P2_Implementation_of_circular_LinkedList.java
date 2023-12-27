package packagee12_Queue;

public class P2_Implementation_of_circular_LinkedList { // same like previous
														// we already have Rear pointer, now adding front pointer

	static class Queue {

		static int[] arr;
		static int size;
		static int rear;
		static int front;

		public Queue(int n) {
			this.arr = new int[n];
			size = n;
			rear = -1;
			front = -1;
		}

		public static boolean isEmpty() {
			return rear == -1 && front == -1;
		}
		
		public static boolean isFull() {
			return (rear+1)%size == front;
		}

		public static void add(int data) {

			if (isFull()) {
				System.out.println("Queue is full");
				return;
			}
			
			if(front == -1) {
				front = 0;
			}

			rear = (rear+1)%size;
			arr[rear] = data;
		}

		public static int remove(int data) {

			if (isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}

			int result = arr[front];
			
			
			if(rear == front) {
				rear = front = -1;
			}else {
				front = (front+1)%size;
			}
			
			return result;

		}

		public static int peek() {

			if (isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}

			return arr[front];

		}

	}

	public static void main(String[] args) {

	}

}
