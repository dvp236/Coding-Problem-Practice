package tree.problems;

public class LowestCommonAncestor {

	TreeNode root;
	public void insert(int data) {
		root = put(root, data);
	}
	
	private TreeNode put(TreeNode x, int data) {
		if (x == null) return new TreeNode(data);
		if (data > x.data) 
			x.right = put(x.right, data);
		else if (data < x.data) 
			x.left = put(x.left, data);
		return x;
	}
	
	public void printinOrder() {
		printhelp(root);
	}
	private void printhelp(TreeNode node) {
		if (node == null) return;
		printhelp(node.left);
		System.out.print(node.data+" ");
		printhelp(node.right);
	}
	
	
	public int LCA(int x, int y) {
		return LCA(root, x, y).data;
	}
	
	private TreeNode LCA(TreeNode node, int x, int y) {
		if (node == null) return null;
		// if both values higher than lca lies in right subtree
		if (x > node.data && y > node.data) {
			return LCA(node.right, x, y);
		} else if (x < node.data && y < node.data) {
			//if both values are smaller than root then lca lies in left subtree
			return LCA(node.left, x, y);
		} else
			//if one of them is bigger than root and one is lesser than root is theior lca--
			//or if node.data == x || node.data == y
			return node;
		
	}
	public static void main(String[] args) {
		
		LowestCommonAncestor p = new LowestCommonAncestor();
		p.insert(5);
		p.insert(3);
		p.insert(1);
		p.insert(7);
		p.insert(6);
		p.insert(0);
		p.insert(2);
		p.insert(8);
		p.insert(9);
		p.printinOrder();
		System.out.println();
		System.out.println(p.LCA(3, 7));
		System.out.println(p.LCA(2, 3));
		System.out.println(p.LCA(0, 9));
		System.out.println(p.LCA(6, 9));

	}
	
	

}
