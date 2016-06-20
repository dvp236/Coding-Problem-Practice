package tree.problems;

/**
 * 
 * @author dharmik patel
 * Calculate the difference at OddLevel and Even Levels in binary tree
 * For ex: For tree like one below
 *            5
		    /   \
		   2     6
		 /  \     \  
		1    4     8
		    /     / \ 
		   3     7   9  
 *
 * The difference will be : (5+1+4+8) - (2+6+3+7+9)
 *
 */
public class OddEvenLevelDifference {
	//Call This method recursively
	public static int getDifference(TreeNode node){
		if(node == null){
			return 0;
		}
		
		return node.data - getDifference(node.left) - getDifference(node.right);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(3);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		System.out.println(getDifference(root));
		
	}
}
