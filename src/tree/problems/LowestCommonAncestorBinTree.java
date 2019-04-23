package tree.problems;

public class LowestCommonAncestorBinTree {
	public static int LCA(TreeNode root, int x, int y) {
		TreeNode LCA = LCANode(root, x, y);
		if (LCA == null) {
			throw new IllegalArgumentException("no such node");
		}
		return LCA.data;
	}

	public static TreeNode LCANode(TreeNode root, int x, int y) {
		if (root == null) return null;
		
		if (root.data == x || root.data == y) 
			return root;
		
		TreeNode left, right;
		left = LCANode(root.left, x, y);
		right = LCANode(root.right, x, y);
		
		if (left != null && right != null)
			return root;
		return (left == null ? right : left);
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(13);
		
		root.left.right.left = new TreeNode(2);
		root.left.right.right = new TreeNode(4);
		
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(LCA(root,2,262));
		
	}
}
