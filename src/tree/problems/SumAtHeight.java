package tree.problems;

import java.util.ArrayList;

/**
 * 
 * @author dharmik patel
 * Calculate sum of all nodes at height n.
 * For example n=1 then its root node. for n=2,
 * sum will be root.left+root.right
 * 
 */

public class SumAtHeight {
	
	public static void sumAtLevel(TreeNode root, int n){
		//create an arraylist that has all the nodes at height N
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		getNodes(list,root, n-1);
		int r=0;
		for(TreeNode node:list){
			r+=node.data;
		}
		System.out.println("sum "+r);
	}
	private static void getNodes(ArrayList<TreeNode> list, TreeNode node,int n){
		if(n==0){
			list.add(node);
		}else{
			if(node.left !=null) getNodes(list, node.left, n-1);
			if(node.right !=null) getNodes(list,node.right,n-1);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
		sumAtLevel(root, 3);
	}
}
