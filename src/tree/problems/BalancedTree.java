package tree.problems;
/**
 * 
 * @author dharmik
 * Implement a function to check if a binary tree is Balanced.
 * Balanced Tree is a tree such that height of two subtree of
 * any node never differ by more than one.
 * 
 */
public class BalancedTree {
	
	public boolean isBalancedTree(TreeNode root){
		//if root is null we return true
		//this is mostly act as base case for recursive calls
		if(root == null){
			return true;
		}
		
		//get heightDiff on height of each SubTree
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		//if height diffrence is greater than limit 
		//return false
		if(heightDiff > 1){
			return false;
		}
		else{
			//else will go deeper in each subtree
			//to make sure than each node has subtree with height difference less or equal to 1 
			return isBalancedTree(root.left) && isBalancedTree(root.right);
		}
	}
	
	//helper method to get the height of binary tree
	private int getHeight(TreeNode root){
		//base case
		//return 0 for single node
		if(root == null){
			return 0;
		}
		
		//else return the maximum of two subtree's and add 1 of parent node.
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
