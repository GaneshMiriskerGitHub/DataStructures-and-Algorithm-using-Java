package packagee14__BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

	static class BinaryTree {

		static int idx = -1;

		public static Node buildTree(int[] arr) {
			idx++;

			if (idx >= arr.length || arr[idx] == -1) {
				return null;
			}

			Node newNode = new Node(arr[idx]);
			newNode.left = buildTree(arr);
			newNode.right = buildTree(arr);

			return newNode;

		}

		public static void preOrderTraversal(Node root) {

			if (root == null) {
				return;
			}

			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}

		public static void levelOrderTraversal(Node root) {

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {
				Node curr = q.remove();
				if (curr == null) {
					System.out.println();
					if (q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}

				} else {

					System.out.print(curr.data + " ");

					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}

				}

			}

		}

		public static int height(Node root) {

			if (root == null) {
				return 0;
			}

			int lh = height(root.left);
			int rh = height(root.right);

			return Math.max(lh, rh) + 1;

		}

		public static int count(Node root) {
			if (root == null) {
				return 0;
			}

			int lc = count(root.left);
			int rc = count(root.right);

			return lc + rc + 1;
		}

		public static int sum(Node root) {
			if (root == null) {
				return 0;
			}

			int ls = sum(root.left);
			int rs = sum(root.right);

			return ls + rs + root.data;
		}

		public static int diameter(Node root) {

			if (root == null) {
				return 0;
			}

			int ld = diameter(root.left);
			int rd = diameter(root.right);

			int lh = height(root.left);
			int rh = height(root.right);

			int selfDiameter = lh + rh + 1;

			return selfDiameter;

		}

		public static boolean isIdentical(Node root1, Node root2) {

			if (root1 == null && root2 == null) {
				return true;
			}
			if (root1 == null || root2 == null || root1.data != root2.data) {
				return false;
			}

			if (!isIdentical(root1.left, root2.left)) {
				return false;
			}
			if (!isIdentical(root1.right, root2.right)) {
				return false;
			}

			return true;
		}

		public static boolean isSubTree(Node root, Node subRoot) {

			if (root == null) {
				return false;
			}

			if (root.data == subRoot.data) {
				if (isIdentical(root, subRoot)) {
					return true;
				} else {
					return false;
				}
			}

			boolean isSubTreeLeft = isIdentical(root.left, subRoot);
			boolean isSubTreeRight = isIdentical(root.right, subRoot);

			return isSubTreeLeft || isSubTreeRight;
		}

		static class Info {
			Node node;
			int hd;

			public Info(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		public static void topView(Node root) {
			Queue<Info> q = new LinkedList<>();

			Map<Integer, Node> map = new HashMap<>();

			int min = 0;
			int max = 0;

			q.add(new Info(root, 0));
			q.add(null);

			while (!q.isEmpty()) {
				Info curr = q.remove();

				if (curr == null) {
					if (q.isEmpty()) {
						break;
					} else {
						System.out.println();
						q.add(null);
					}
				} else {
					if (!map.containsKey(curr.hd)) {
						map.put(curr.hd, curr.node);
					}

					if (curr.node.left != null) {
						q.add(new Info(curr.node.left, curr.hd - 1));
						min = Math.min(min, curr.hd - 1);
					}
					if (curr.node.right != null) {
						q.add(new Info(curr.node.right, curr.hd + 1));
						max = Math.max(max, curr.hd + 1);
					}
				}

			}

			for (int i = min; i <= max; i++) {
				System.out.print(map.get(i).data + " ");
			}
		}

		public static boolean getPath(Node root, int data, ArrayList<Integer> path) {

			if (root == null) {
				return false;
			}

			path.add(root.data);

			if (root.data == data) {
				return true;
			}

			boolean foundLeft = getPath(root.left, data, path);
			boolean foundRight = getPath(root.right, data, path);

			if (foundLeft || foundRight) {
				return true;
			} else {
				path.remove(path.size() - 1);
				return false;
			}

		}
		
		public static void lowestCommonAncestor(Node root, int data1, int data2) {
			
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			
			getPath(root, data1, list1);
			getPath(root, data2, list2);
			
			int n = Math.max(list1.size(), list2.size());
			
			for(int i=1;i<n;i++) {
				if(list1.get(i) != list2.get(i)) {
					System.out.println(list1.get(i-1));
					return;
				}
			}
			
		}
		
		public static int sumTree(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			int leftSumTree = sumTree(root.left);
			int rightSumTree = sumTree(root.right);
			
			int leftNodeVal = 0;
			if(root.left != null) {
				leftNodeVal = root.left.data;
			}
			int rightNodeVal = 0;
			if(root.left != null) {
				rightNodeVal = root.right.data;
			}
			
			int currentRootData = root.data;
			
			root.data = leftNodeVal + rightNodeVal + leftSumTree + rightSumTree;
			
			return currentRootData;
			
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6 };

		Node rootNode = BinaryTree.buildTree(arr);

		BinaryTree.levelOrderTraversal(rootNode);

		int TreeLength = BinaryTree.height(rootNode);

		System.out.println(TreeLength);

		int count = BinaryTree.count(rootNode);

		System.out.println(count);

		int sum = BinaryTree.sum(rootNode);

		System.out.println(sum);

		int diameter = BinaryTree.diameter(rootNode);

		System.out.println(diameter);

		System.out.println("-------");

		BinaryTree.topView(rootNode);

	}

}
