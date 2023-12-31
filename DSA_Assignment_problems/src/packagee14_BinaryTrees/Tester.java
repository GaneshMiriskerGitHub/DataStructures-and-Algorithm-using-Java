package packagee14_BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private Map<String, Integer> map;
	private List<TreeNode> list;

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		map = new HashMap<>();
		list = new ArrayList<>();
		preOrder(root);
		return list;
	}

	private String preOrder(TreeNode node) {
		if (node == null) {
			return "#";
		}

		String str = node.val + "," + preOrder(node.left) + "," + preOrder(node.right);

		// Update the count of the serialized subtree
		map.put(str, map.getOrDefault(str, 0) + 1);

		// If count becomes 2, this is the second occurrence of the subtree
		if (map.get(str) == 2) {
			list.add(node);
		}

		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
