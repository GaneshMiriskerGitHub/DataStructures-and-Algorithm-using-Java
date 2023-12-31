package packagee15_BST;

public class Tester {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static Node delete(Node root, int val) {
		if (val < root.data) {
			root.left = delete(root.left, val);
		} else if (root.data > val) {
			root.right = delete(root.right, val);
		} else {
			//
			if (root.left == null && root.right == null) {
				return null;
			}
			//
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			//
			Node IS = findInOrderSuccessor(root.right); // finding min value on right side
			root.data = IS.data;
			root.right = delete(root.right, IS.data);

		}

		return root;
	}

	public static Node findInOrderSuccessor(Node root) {
		if (root.left == null) {
			return root;
		}
		return findInOrderSuccessor(root.left);
	}

	static class Info {
		boolean isBST;
		int size;
		int max;
		int min;

		public Info(boolean isBST, int size, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.max = max;
			this.min = min;
		}
	}

	public static Info largestBST_in_BT(Node root) {
		if(root == null) {
			return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		if(root.left == null && root.right == null) {
			return new Info(true, 1, root.data, root.data);
		}
		
		Info leftInfo = largestBST_in_BT(root.left);
		Info rightInfo = largestBST_in_BT(root.right);
		
		boolean isBST = leftInfo.isBST && rightInfo.isBST;
		int size = Math.max(leftInfo.size, rightInfo.size) + 1;
		int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
		int max = Math.min(root.data, Math.max(leftInfo.max, rightInfo.max));
		
		if(root.data <= leftInfo.max && root.data >= rightInfo.min) {
			return new Info(false, size, min, max);
		}
		
		if(leftInfo.isBST && rightInfo.isBST) {
			return new Info(true, size, min, max);
		}
		
		return new Info(false, size, min, max);
	}

	public static void main(String[] args) {
		
		

	}

}
