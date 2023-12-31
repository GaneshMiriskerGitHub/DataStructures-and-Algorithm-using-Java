package packagee14_BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A4_Find_All_Duplicate_Subtrees {

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

	public static void printAllNodes(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		printAllNodes(root.left);
		printAllNodes(root.right);

	}

	static HashMap<String, Integer> map;
	static List<Node> list;

	public static String inOrder(Node root) {

		if (root == null) {
			return "#";
		}

		String str = root.data +","+inOrder(root.left)+","+inOrder(root.right); // will take each substring

		map.put(str, map.getOrDefault(str, 0)+1); // add count for each substring
		
		if(map.get(str) == 2) { // if duplicate is present
			list.add(root);
		}

		return str;
	}

	public static List<Node> printAllDuplicatesInTree(Node root) {
		map = new HashMap<>();
		list = new ArrayList<>();
		inOrder(root);
		return list;
	}

	public static void main(String[] args) {

		Node root = null;
		root = new Node(1);
		root.left = new Node(4);
		root.right = new Node(3);
		root.left.left = new Node(3);
		root.right.left = new Node(4);
		root.right.left.left = new Node(3);
		root.right.right = new Node(3);
		List<Node> ans = printAllDuplicatesInTree(root);

		for(Node ele: ans) {
			System.out.println(ele.data);
		}
	}

}
