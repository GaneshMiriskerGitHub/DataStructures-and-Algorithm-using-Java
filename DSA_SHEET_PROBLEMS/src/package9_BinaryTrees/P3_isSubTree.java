package package9_BinaryTrees;

public class P3_isSubTree {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(root.val == subRoot.val && isIdentical(root, subRoot)) {
            return true;
        }

        boolean leftSubTreeValid = isSubtree(root.left, subRoot);
        boolean rightSubTreeValid = isSubtree(root.right, subRoot);

        return leftSubTreeValid || rightSubTreeValid;
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        if(!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
