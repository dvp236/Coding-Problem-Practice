package tree.problems;

import java.util.ArrayList;
import java.util.Collections;

import edu.princeton.cs.algs4.Queue;
class Result {
    public int val;
}
public class MaxSumPathBinTree {
	TreeNode root;
	int max_incl = 0;
	public int maxSumPathFromRoot() {
		return maxSumPath(root);
	}
	public int maxSumPath(TreeNode node) {
		if (node == null) return 0;
		
		return Math.max(maxSumPath(node.left), maxSumPath(node.right)) + node.data;
	}
	
	public int maxSumNodeToNode() {
		//int res = 0;
		ArrayList<Integer> resA = new ArrayList<>();
		resA.add(0);
		Result res = new Result();
		res.val = 0;
		maxSumNodeToNode(root, res);
		return res.val;
	}
	
	private int maxSumNodeToNode(TreeNode node, Result res) {
		if (node == null) return 0;
		int l = maxSumNodeToNode(node.left, res);
		int r = maxSumNodeToNode(node.right, res);
		int max_now = Math.max(Math.max(l,r ) + node.data, node.data);
		
		int max_top = Math.max(l+r+node.data, max_now);
		res.val = Math.max(res.val, max_top);
		//resA.set(0, res);
		return max_now;
	}
	
	
	public void getPath(int data) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean haspath = hasPath(root, arr, data);
		if (haspath) {
			//System.out.println(arr);
			for(Integer p : arr) {
				System.out.print(p+"->");
			}
		}
		
	}
	private boolean hasPath(TreeNode node, ArrayList<Integer> arr, int data) {
		if (node == null) return false;
		if (node.data == data) {
			arr.add(node.data);
			return true;
		}
		boolean path = hasPath(node.left, arr, data) || hasPath(node.right, arr, data);
		if (path) {
			arr.add(node.data);
			return true;
		}
		return false;
	}
	
	public void printTree() {
		Queue<TreeNode> q = new Queue<TreeNode>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			TreeNode node = q.dequeue();
			if (node == null) continue;
			q.enqueue(node.left);
			q.enqueue(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	
 
  
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(-11);
		
		root.left.right.left = new TreeNode(2);
		root.left.right.right = new TreeNode(0);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(1);
		
		MaxSumPathBinTree tree = new MaxSumPathBinTree();
		tree.root = root;
		tree.printTree();
		System.out.println(" ");
		//System.out.println(tree.maxSumPathFromRoot());
		System.out.println(tree.maxSumNodeToNode());
		//System.out.println(tree.findMaxSum());
	}

}
