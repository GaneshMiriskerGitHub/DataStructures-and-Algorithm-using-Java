package packagee14_BinaryTrees;


public class A2_Mirror_of_Tree {
	
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
	
	public static void invertBinaryTree(Node root) { // check out leetcode too
		
		if(root == null) {
			return;
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
		
	}
	
	public static void printAllNodes(Node root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		printAllNodes(root.left);
		printAllNodes(root.right);
		
	}
	

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        printAllNodes(root);System.out.println();
        invertBinaryTree(root);
        printAllNodes(root);

	}

}
