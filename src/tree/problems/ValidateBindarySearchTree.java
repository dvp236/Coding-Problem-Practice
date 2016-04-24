package tree.problems;

/**
 * 
 * @author dharmik patel
 * Implement a function that checks weather the given 
 * binary search tree(BST) is valid or not.
 *
 */
public class ValidateBindarySearchTree {
	//To check weather the given tree is BST or not we 
	//need to confirm if the values on left subtree are smaller 
	//root and larger in right subtree recursively
	public static boolean validateBST(TreeNode root){
		
		return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	//Helper method 
	private static boolean validateBST(TreeNode node, int leftVal, int rightVal){
		if(node == null){
			return true;
		}
		//check if node value is greater than left node 
		//and less than right tree
		if(node.data <= leftVal || node.data >= rightVal){
			return false;
		}
		//recursively check for left and right subtree
		return (validateBST(node.left, leftVal, node.data) && validateBST(node.right,node.data,rightVal));
	}

}
