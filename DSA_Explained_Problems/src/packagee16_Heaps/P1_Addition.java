package packagee16_Heaps;

import java.util.ArrayList;

public class P1_Addition {

	/*
	 * Step 1 : first add at the last index of the array
	 * 
	 * Step 2 : format the heap while loop code
	 * 
	 * Note : if currNode = i then currNode.left = 2i+1 currNode.right = 2i+2
	 * 
	 * if currNode.subNode (this can be left or right) = i then root of that is =
	 * (i-1)/2
	 * 
	 * 
	 * solution: so as long as the newly added data is smaller than the root, swap
	 * methoed code should run
	 * 
	 */

	public static class Heap { // Minimum heap Data Structure

		ArrayList<Integer> arr = new ArrayList<>();

		public void add(int data) {

			arr.add(data);

			int IdxVal = arr.size() - 1;
			int parIdx = (IdxVal - 1) / 2;

			// reformating heap DataStructure // in this minimum value should be the root
			// node
			while (arr.get(IdxVal) < arr.get(parIdx)) { // ">" for maximum heap Data structure

				int temp = arr.get(IdxVal);
				arr.set(IdxVal, arr.get(parIdx));
				arr.set(parIdx, temp);

				IdxVal = parIdx;
				parIdx = (IdxVal - 1) / 2;

			}

		}

		public int peek() {
			return arr.get(0);
		}

		public int remove() { // to remove the root which is the minimum value in the whole array

			// Step 1: swap fist and last index elements in the array
			int temp = arr.get(0);
			arr.set(0, arr.get(arr.size() - 1));
			arr.set(arr.size() - 1, temp);

			// Step 2: remove last
			int data = arr.remove(arr.size() - 1);

			// format data
			heapFormatCode(0);
			return data;
		}

		public boolean isEmpty() {

			return arr.size() == 0;

		}

		public void heapFormatCode(int i) {

			int minIdx = i;
			int leftIdx = 2 * i + 1;
			int rightIdx = 2 * i + 2;

			// verifying if the left and right index are inbound in the arr
			if (leftIdx < arr.size() && leftIdx < arr.get(minIdx)) { // ">" for maximum heap Data structure
				minIdx = leftIdx;
			}

			if (rightIdx < arr.size() && rightIdx < arr.get(minIdx)) { // ">" for maximum heap Data structure
				minIdx = rightIdx;
			}

			if (minIdx != i) {

				int temp = arr.get(i);
				arr.set(i, arr.get(minIdx));
				arr.set(minIdx, temp);

				heapFormatCode(minIdx);

			}

		}

	}

	public static void main(String[] args) {

		Heap h = new Heap();

		h.add(0);
		h.add(3);
		h.add(2);
		h.add(8);

		while (!h.isEmpty()) {
			System.out.println(h.peek());
			h.remove();
		}

	}

}
