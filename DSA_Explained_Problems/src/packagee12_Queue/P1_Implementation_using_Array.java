package packagee12_Queue;

public class P1_Implementation_using_Array {
	
	static class Queue {
		
		static int[] arr;
		static int size;
		static int rear;
		
		public Queue(int n) {
			this.arr = new int[n];
			size = n;
			rear = -1;
		}
		
		public static boolean isEmpty() {
			return rear == -1;
		}
		
		public static void add(int data) {
			
			if(rear == size-1) {
				System.out.println("Queue is full");
				return;
			}
			
			rear += 1;
			arr[rear] = data;
		}
		
		public static int remove(int data) {
			
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			
			int front = arr[0];
			for(int i=0;i<size;i++) {
				arr[i] = arr[i+1];
			}
			return front;
			
		}
		
		public static int peek() {
			
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			
			return arr[0];
			
		}
		
	}

	public static void main(String[] args) {
		
		

	}

}
